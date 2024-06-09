/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import choferes.Chofer;
import usuarios.Cliente;
import vehiculos.Vehiculo;

/**
 * Clase encargada de almacenar la informacion necesaria para que el recurso compartido comunique eventos a sus observers
 */
public class EventoSimulacion {
    private String mensaje;
    private Chofer chofer;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private TipoEvento tipo;
    
    public static enum TipoEvento {
        CLIENTE, CHOFER, SISTEMA
    };
    
    public EventoSimulacion(String mensaje, Cliente cliente, Chofer chofer, Vehiculo vehiculo, TipoEvento tipo)
    {
        this.mensaje = mensaje;
        this.cliente = cliente;
        this.chofer = chofer;
        this.vehiculo = vehiculo;
        this.tipo = tipo;
    }
    
    public Chofer getChofer()
    {
        return chofer;
    }
    
    public Cliente getCliente()
    {
        return cliente;
    }
    
    public Vehiculo getVehiculo()
    {
        return vehiculo;
    }
    
    public TipoEvento getTipo(){
        return this.tipo;
    }
    
    public String getMensaje()
    {
        return mensaje;
    }
}
