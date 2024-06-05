/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import choferes.Chofer;

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
        EventoSimulacion evento;
        while(rc.simulacionIsActiva() && cantViajes>0)
        {
            rc.tomarViaje(chofer);
            rc.finalizarViaje(chofer);
            cantViajes--;
        }
        rc.subChofer();

    }
}
