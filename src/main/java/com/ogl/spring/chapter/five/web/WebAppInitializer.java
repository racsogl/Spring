package com.ogl.spring.chapter.five.web;

import com.ogl.spring.chapter.five.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Solo funciona en un servidor compatible con Servlet 3.0
 * AbstractAnnotationConfigDispatcherServletInitializer carga tanto
 * - DispatcherServlet
 * que debe cargar los beans que contengan componentes web como controladores, solucionadores
 * de vistas y asignaciones de controlador.
 * - ContextLoaderListener
 * que carga los demas Bean de la aplicacion
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    // Le pedimos a DispatcherServlet que cargue su contexto de aplicacion con los beans definidos
    // en la clase de configuracion
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    /**
     * Identifica una o varias rutas al DispatcherServlet al que se va a asignar
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
