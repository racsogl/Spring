package com.ogl.web.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.StandardCharsets;

@Configuration
@EnableWebMvc // Habilita Spring MVC.
@ComponentScan({"com.ogl.web.controller", "com.ogl.web.exception"}) // Habilita análisis de componentes
public class WebConfig extends WebMvcConfigurerAdapter {

    // Solucionador de vista
    @Bean
    public ViewResolver viewResolver() {
        // configuración vistas JSP
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        return messageSource;
    }

//    carga propiedades sin necesidad de reiniciar
//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
////        messageSource.setBasename("file:///etc/mensajes/messages");  // sistema de archivos
//        messageSource.setBasename("classpath:****");  // ruta de clases
//        messageSource.setCacheSeconds(10);
//        return messageSource;
//   }

    // Configura procesamiento de contenido estatico
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // le pedimos a DispatcherServlet que dirija las solicitudes de recursos estáticos al
        // servlet predeterminado del contenedor del servlet y que no las procese personalmente
        configurer.enable();
    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

}
