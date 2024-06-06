/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import java.time.LocalDateTime;
import usuarios.Cliente;
import viajes.IViaje.EstadosViajes;

/**
 *
 * @author Usuario
 */
public class ClienteThread extends Thread{
  private Cliente cliente;
  private RecursoCompartido rc;
  private int cantViajes;
  private static final String[] zonas = {"Peligrosa", "Sin asfaltar", "Estandar", "Larga distancia", "Turistico"};
  
  public ClienteThread(Cliente cliente, RecursoCompartido rc, int cantviajes)
  {
      this.cliente = cliente;
      this.rc = rc;
      this.cantViajes = cantviajes;
  }
    
   @Override
   public void run()
   {
       while(cantViajes>0 && rc.simulacionIsActiva())
       {
          
          try{
                Util.espera();
                rc.pedirViaje(cliente, zonas[Util.rand(4)], Util.rand(0,1), "Transporte", 
                         Util.rand(0,1),Util.rand(1,14),Util.rand(4000), LocalDateTime.now());

                Util.espera();
                rc.pagarViaje(cliente);
                this.cantViajes--;
                
          }catch(Exception e){
              System.out.println(e.getClass().getName());
            }
        }
       rc.subCliente(cliente);
   }
    
}
