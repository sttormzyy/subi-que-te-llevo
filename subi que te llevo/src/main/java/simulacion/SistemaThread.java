/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

/**
 *
 * @author Usuario
 */
public class SistemaThread extends Thread{
   private RecursoCompartido rc;
   
    
    public SistemaThread(RecursoCompartido rc)
    {
        this.rc = rc;
    }
    
    @Override
    public void run()
    {
        while(rc.simulacionIsActiva())
        {
            rc.asignarVehiculo();
        }
    }
}
