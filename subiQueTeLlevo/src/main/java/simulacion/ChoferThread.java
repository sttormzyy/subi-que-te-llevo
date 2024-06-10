/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import choferes.Chofer;


/**
 * Clase encargada de representar el comportamiento de un chofer de la empresa
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
    
     
     /**
      * Define el comportamiento del hilo del chofer respecto al recurso compartido<br>
      * Este puede ser tomar o finalizar un viaje
      */
@Override
public void run()
{
    while(rc.getUsuarioActivo() || (cantViajes>0 && rc.hayClientes()))
    {
        Util.espera();
        rc.tomarViaje(chofer, cantViajes);
    
        Util.espera();
        rc.finalizarViaje(chofer, cantViajes);
        cantViajes--;
    }
    rc.subChofer(chofer);
}
}
