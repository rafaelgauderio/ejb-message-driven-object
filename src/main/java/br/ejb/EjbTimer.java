package br.ejb;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author Rafael de Luca
 */
@Stateless
public class EjbTimer {
    //executing each 15 seconds
    @Schedule(second = "*/15", minute = "*", hour="*")
    public void methodSecond () {
         System.out.println("Executing method second: " + new java.util.Date());
    }
    
    @Schedule(second = "*/20", minute="*", hour="*", dayOfWeek="Tue")
    public void methodDayOfWeek () {
        System.out.println("\tExecuting method day of the week: " + new java.util.Date().getTime());
    }
}
