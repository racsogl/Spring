package com.ogl.spring.chapter.five.web.controller;

import com.ogl.spring.chapter.five.dao.SpittleRepository;
import com.ogl.spring.chapter.five.entity.Spittle;
import com.ogl.spring.chapter.five.web.form.SpittleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    /**
     * @param max   ID máximo de cualquier Spittle que deba devolverse
     * @param count número de objetos a devolver2
     * @return
     */
    @RequestMapping(method = RequestMethod.GET) // , value = "LOL"
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {

        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/model", method = RequestMethod.GET)
    public String spittles(Model model) {
        // es un mapa que se entrega a la vista para poder representar los datos\
        // al no poner clave se deduce que es spittleList
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "model"; //nombre de la jsp
    }

    @RequestMapping(method = RequestMethod.GET, value = "/map")
    public String spittles(Map model) {
        // se puede utilizar map en vez de Model
        model.put("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "mapvista"; //nombre de la jsp
    }

    // Aunque funciona no es adecuado de una perspectiva orientada a recursos
    // Como regla general no se deben utilizar parametros de consulta para
    // identificar un recurso
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(
            @RequestParam("spittle_id") long spittleId, Model model) {
        model.addAttribute(new Spittle("Spittle", new Date()));
        return "param/spittle";
    }

    /*
    Si no se proporciona un atribute a @PathVariable, asume que el nombre del marcador
    de posición es el mismo que el del parametro del método
     */

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") Long spittleId,
            Model model) {
        model.addAttribute(spittleRepository.findById(spittleId));
        return "param/spittle";
    }

  @RequestMapping(method= RequestMethod.POST)
  public String saveSpittle(SpittleForm form, Model model) throws Exception {
    spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
        form.getLongitude(), form.getLatitude()));
    return "redirect:/spittles";
  }

}
