/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import java.io.Serializable;

/**
 *Clase encargada de almacenar los parametros de la simulacion
 * */
public class ParametrosSimulacion implements Serializable{
   private int cantClientes;
   private int cantMaxViajeCliente; 
   private int cantChoferTemporario;
   private int cantChoferContratado;
   private int cantChoferPermanente; 
   private int cantMaxViajeChofer;
   private int cantAutos; 
   private int cantMotos;  
   private int cantCombis;   
   
   public ParametrosSimulacion(){}

   
   public int CantChoferes()
   {
       return cantChoferTemporario+cantChoferContratado+cantChoferPermanente;
   }
    public int getCantClientes() {
        return cantClientes;
    }

    public void setCantClientes(int cantClientes) {
        this.cantClientes = cantClientes;
    }

    public int getCantMaxViajeCliente() {
        return cantMaxViajeCliente;
    }

    public void setCantMaxViajeCliente(int cantMaxViajeCliente) {
        this.cantMaxViajeCliente = cantMaxViajeCliente;
    }

    public int getCantChoferTemporario() {
        return cantChoferTemporario;
    }

    public void setCantChoferTemporario(int cantChoferTemporario) {
        this.cantChoferTemporario = cantChoferTemporario;
    }

    public int getCantChoferContratado() {
        return cantChoferContratado;
    }

    public void setCantChoferContratado(int cantChoferContratado) {
        this.cantChoferContratado = cantChoferContratado;
    }

    public int getCantChoferPermanente() {
        return cantChoferPermanente;
    }

    public void setCantChoferPermanente(int cantChoferPermanente) {
        this.cantChoferPermanente = cantChoferPermanente;
    }

    public int getCantMaxViajeChofer() {
        return cantMaxViajeChofer;
    }

    public void setCantMaxViajeChofer(int cantMaxViajeChofer) {
        this.cantMaxViajeChofer = cantMaxViajeChofer;
    }

    public int getCantAutos() {
        return cantAutos;
    }

    public void setCantAutos(int cantAutos) {
        this.cantAutos = cantAutos;
    }

    public int getCantMotos() {
        return cantMotos;
    }

    public void setCantMotos(int cantMotos) {
        this.cantMotos = cantMotos;
    }

    public int getCantCombis() {
        return cantCombis;
    }

    public void setCantCombis(int cantCombis) {
        this.cantCombis = cantCombis;
    }
   
   
   
}
