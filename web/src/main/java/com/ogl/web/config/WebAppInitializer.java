package com.ogl.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * En lugar de web.xml, usamos java para configurar el DispatcherServlet.
 * <p>
 * Necesario especificación servlet 3.0 y Spring 3.1.
 * <p>
 * Cualquier clase que extienda AbstractAnnotationConfigDispatcherServletInitializer se utilizará automáticamente
 * para configurar DispatcherServlet y el contexto de aplicaciones de Spring en el contexto del servlet de la
 * aplicación.
 * <p>
 * Cuando se inicia DispatcherServlet, crea un contexto de aplicaciones de Spring y lo carga con los bean declarados
 * en los archivos o clases de configuración que ha recibido. Controladores, solucionadores de vistas y asignaciones
 * de controlador.
 * <p>
 * Con el método getServletConfigClasses() le pedimos que cargue su contexto de aplicación con los bean definidos
 * en la clase de configuración.
 * <p>
 * En las aplicaciones Web suele haber otro contexto de aplicaciones, creado por ContextLoaderListener, que carga
 * los demás bean de la aplicación. Componentes de nivel intermedio y de nivel de datos que controlan la parte de
 * servidor de la aplicación.
 * <p>
 * Entre bastidores AbstractAnnotationConfigDispatcherServletInitializer crea tanto el contexto de DispatcherServlet
 * como el de ContextLoaderListener.
 * <p>
 * Las clases devueltas por getServletConfigClasses() definiran los bean del contexto de la aplicación de DispatcherServlet
 * y getRootConfigClasses() definiran los bean del contexto de aplicación ContextLoaderListener.
 * <p>
 * Este fichero se puede utilizar conjuntamente con web.xml
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }


    /*
     * Identifica una o varias rutas al DispatcherServlet al que se va a asignar.
     * En este caso / para indicar que el el servlet predeterminado de la aplicación procesara todas las solicitudes.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        super.onStartup(servletContext);
//        servletContext.setInitParameter("spring.profiles.default", "local");
//    }
//
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        WebApplicationContext context = super.createRootApplicationContext();
//        ((ConfigurableEnvironment) context.getEnvironment()).setActiveProfiles("dev");
//        return context;
//    }
}
