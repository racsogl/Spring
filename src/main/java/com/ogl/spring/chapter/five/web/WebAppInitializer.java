package com.ogl.spring.chapter.five.web;

import com.ogl.spring.chapter.five.config.RootConfig;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

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

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.setInitParameter("spring.profiles.default", "local");
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        WebApplicationContext context = super.createRootApplicationContext();
        ((ConfigurableEnvironment)context.getEnvironment()).setActiveProfiles("dev");
        return context;
    }
}
