package com.ogl.spring.five.web.controller;

import com.ogl.spring.five.dao.SpitterRepository;
import com.ogl.spring.five.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }


    // mostramos los datos de Spitter en la pagina de profile
//    @PostMapping(value = "/register")
//    public String processRegistration(Spitter spitter) {
//        System.out.println("********************************************");
//        spitterRepository.save(spitter);
//        System.out.println("********************************************");
//        return "profile";
//    }

    /*
   Si no se proporciona un atribute a @PathVariable, asume que el nombre del marcador
   de posición es el mismo que el del parametro del método
//    */
//    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
//    public String showSpitterProfile(@ModelAttribute Spitter spitter, Model model) {
//
//        //Spitter spitter = spitterRepository.findByUserName(userName);
//        model.addAttribute(spitter);
//        return "profile";
//    }

    // redireccionamos y /spitter/nombre de usuario, mostramos los datos del usuario xq los volvemos a recuperar
    // grabamos el registro y recuperamos
    @PostMapping(value = "/register")
    public String processRegistration(@Valid Spitter spitter, Errors errors) {

        if (errors.hasErrors()) {
            return "registerForm";
        }
        System.out.println("********************************************");
        spitterRepository.save(spitter);
        System.out.println("********************************************");
        return "redirect:/spitter/" + spitter.getUserName();
    }

    /*
   Si no se proporciona un atribute a @PathVariable, asume que el nombre del marcador
   de posición es el mismo que el del parametro del método
    */
    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public String showSpitterProfile( //@PathVariable("userName")
                                      @PathVariable String userName, Model model) {
        Spitter spitter = spitterRepository.findByUserName(userName);
        model.addAttribute(spitter);
        return "profile";
    }



    @RequestMapping(value = "/register2", method = RequestMethod.GET)
    public String showRegistrationForm2() {
        return "registerForm";
    }

    // redireccionamos y /spitter/nombre de usuario, mostramos los datos del usuario xq los volvemos a recuperar
    // grabamos el registro y recuperamos
    @PostMapping(value = "/register2")
    public String processRegistration2(@ModelAttribute("spitter") Spitter spitter,
                                        RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("spitter", spitter);
        redirectAttributes.addFlashAttribute("message","Added successfully.");

        return "redirect:/spitter/register2/" + spitter.getUserName();
    }

    @RequestMapping(value = "/register2/{userName}", method = RequestMethod.GET)
    public String showSpitterProfile2(@ModelAttribute("spitter") Spitter spitter) {
        System.out.println("*********/register2/{userName}");
        return "profile";
    }

    @RequestMapping(value = "/register3", method = RequestMethod.GET)
    public String showRegistrationForm3() {
        return "registerForm";
    }

    @PostMapping(value = "/register3")
    public ModelAndView redirectWithUsingRedirectPrefix(Spitter spitter, ModelMap model) {
        model.addAttribute("atributo", "valor");
        return new ModelAndView("redirect:/spitter/register3/" + spitter.getUserName(), model);
    }

    @RequestMapping(value = "/register3/{userName}", method = RequestMethod.GET)
    public String showSpitterProfile2(Model model) {
        System.out.println("*********/register3/{userName}");
        return "profile";
    }

}
