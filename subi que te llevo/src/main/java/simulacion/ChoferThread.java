/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import choferes.Chofer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ChoferThread extends Thread{
    private RecursoCompartido rc;
    private int cantViajes;
    private Chofer chofer;
    
     public ChoferThread(Chofer chofer,RecursoCompartido rc,int cantviajes)
    {
        this.chofer = chofer;
        this.rc = rc;
        this.cantViajes = cantviajes;
    }
    
     
@Override
public void run()
{
    while(rc.simulacionIsActiva() && cantViajes>0)
    {
        rc.tomarViaje(chofer);
    
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ChoferThread.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        rc.finalizarViaje(chofer);
        cantViajes--;
    }
    rc.subChofer(chofer);
}
}
