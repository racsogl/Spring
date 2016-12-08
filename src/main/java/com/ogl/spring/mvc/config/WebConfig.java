package com.ogl.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // Habilita Spring MVC.
@ComponentScan("com.ogl.web.controller") // Habilita análisis de componentes
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

    // Configura procesamiento de contenido estatico
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // le pedimos a DispatcherServlet que dirija las solicitudes de recursos estáticos al
        // servlet predeterminado del contenedor del servlet y que no las procese personalmente
        configurer.enable();
    }

}
