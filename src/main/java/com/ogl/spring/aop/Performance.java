package com.ogl.spring.aop;

/**
 * Representa cualquier tipo de actuación en directo, ya sea una obra de teatro, película
 * concierto.
 *
 * Expresion de punto de corte (Define el donde)
 * execution(* com.ogl.spring.aop.Performance.perform(..))
 *
 * execution( Se desencadena tras la ejecución del metodo
 * * devuelve cualquier tipo
 * com.ogl.spring.aop.Performance tipo al que pertenece el método
 * perform el método
 * (..) Aceptar cualquier argumento, e indica que el punto de cruce debe seleccionar cualquier método perform
 * con independencia de la lista de argumentos
 *
 *
 * limitamos la coincidencia
 * execution(* com.ogl.spring.aop.Performance.perform(..)) && within(com.ogl.spring.aop.*)
 *
 * && operador de combinación
 * && within(com.ogl.spring.aop.*) Cuando el metodod se invoca desde cualquier clase del paquete aop
 *
 * podemos utilizar || o !
 *
 * Aparte de los designadores Spring añade un designador bean() que permite identificar bean por sus ID
 * dentro de una expresión de punto de corte.
 *
 * bean() acepta ID o nombre de bean y limita el efecto de punto de corte a bean
 * execution(* com.ogl.spring.aop.Performance.perform()) and bean('woodstock')
 *
 * o negarlo todos los beans menos woodstock
 * execution(* com.ogl.spring.aop.Performance.perform()) and !bean('woodstock')
 *
 *
 */
public interface Performance {
    void perform();
}
