/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

/**
 *Clase encargada de simular el comportamiento del sistema, cumpliendo tareas tales como asignar vehiculos a los viajes de la simulacion
 */
public class SistemaThread extends Thread{
   private RecursoCompartido rc;
   
    
    public SistemaThread(RecursoCompartido rc)
    {
        this.rc = rc;
    }
 
    /**
      * Define el comportamiento del hilo del ssitema respecto al recurso compartido<br>
      * Este puede ser asignar vehiculo a un viaje solicitado
      */
@Override
public void run()
{
    while(rc.simulacionIsActiva())
    {
        Util.espera();
        rc.asignarVehiculo();
    }
}


          
}
