package com.ogl.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Consejo de controlador.
 * <p>
 * Puede tener tres tipos de métodos definidos:
 * <p>
 * ExceptionHandler
 * <p>
 * InitBinder
 * <p>
 * ModelAttribute
 * <p>
 * Que se aplican globalmente a todos los métodos antotados con @RequesMapping
 * de todos los controladores de la aplicación.
 */
@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handlerIllegalArgumentException() {
        return "/error/opps";
    }


}
