/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import java.util.Random;
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
  private Random random = new Random();
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
                Thread.sleep(2000);
                rc.pedirViaje(cliente, zonas[random.nextInt(4)], random.nextInt(0,1), "Transporte", 
                         random.nextInt(0,1),random.nextInt(1,10),random.nextDouble(2000), LocalDateTime.now());

                Thread.sleep(2000);
                rc.pagarViaje(cliente);
                this.cantViajes--;
                
          }catch(Exception e){
              System.out.println(e.getClass().getName());
            }
        }
       rc.subCliente(cliente);
   }
    
}
