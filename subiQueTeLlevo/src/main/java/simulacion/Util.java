/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Util {

    public static final Random r = new Random();

    public static void espera(int milisegundos)
    {
	try
	{
	    Thread.sleep(milisegundos);
	} catch (InterruptedException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static void espera()
    {
	Util.espera(1000+r.nextInt(6000));
    }
 
    public static int rand(int limite)
    {
        return r.nextInt(limite);
    }
    
    public static int rand(int limiteInf,int limiteSup)
    {
        return limiteInf + r.nextInt(limiteSup - limiteInf);
    }
}
