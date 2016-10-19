package com.ogl.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * El público es importante pero no esencial para una actuación.
 * Es una preocupación distinta.
 * Por eso lo definimos como Aspecto
 *
 * @After El método de consejo se invoca después de que el método aconsejado devuelva o genere una excepción
 * @AfterReturning El método de consejo se invoca después de que el método aconsejado devuelva un resultado
 * @AfterThrowing El método de consejo se invoca después de que el método aconsejado devuelva una excepción
 * @Around El método de consejo encapsula el método aconsejado
 * @Before El método de consejo se invoca antes de invocar el método aconsejado
 *
 *
 */
@Aspect // indicamos que no es un pojo sino un aspecto
public class Audience {

    // Definimos un punto de corte
    @Pointcut("execution(** com.ogl.spring.aop.Performance.perform(..))")
    public void performance() {}
/*
    //@Before("execution(** com.ogl.spring.aop.Performance.perform(..))") // Antes de la actuación
    @Before("performance()") // punto de cofte definido
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    //@Before("execution(** com.ogl.spring.aop.Performance.perform(..))") // Antes de la actuación
    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking Seats");
    }

//    @AfterReturning("execution(** com.ogl.spring.aop.Performance.perform(..))") // Despues de la actuación
    @AfterReturning("performance()")
    public void aplause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

//    @AfterThrowing("execution(** com.ogl.spring.aop.Performance.perform(..))") // Despues de una mala actuación
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
    */

    /**
     *
     * @param proceedingJoinPoint indica como invocar al metodo aconsejado desde el consejo
     * El método de consejo hará todo lo que que necesite hacer y cuando esté listo
     * para pasar el control al método aconsejado, invocará al método aconsejado.
     */
    @Around("performance()") // Método de consejo alrededor
    public void watchPerformance(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking Seats");
            proceedingJoinPoint.proceed(); // si no invocamos proceed se bloqueará el acceso al método invocado
            // podemos hacerlo para implementar logica de reintento en el metodo aconsejado

            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }
}
