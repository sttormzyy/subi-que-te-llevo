package Persistencia;


import viajes.IViaje;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ViajeDTO implements Serializable {
    private ChoferDTO chofer;
    private VehiculoDTO vehiculo;
    private PedidoDTO pedido;
    private double distancia;
    private IViaje.EstadosViajes estado;
    private int calificacionChofer;
    private static double costoBase=1000;

    public ViajeDTO() {}

    public ChoferDTO getChofer() {
        return chofer;
    }

    public void setChofer(ChoferDTO chofer) {
        this.chofer = chofer;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public PedidoDTO getPedidoDTO() {
        return pedido;
    }

    public void setPedidoDTO(PedidoDTO pedido) {
        this.pedido = pedido;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public IViaje.EstadosViajes getEstado() {
        return estado;
    }

    public void setEstado(IViaje.EstadosViajes estado) {
        this.estado = estado;
    }

    public int getCalificacionChofer() {
        return calificacionChofer;
    }

    public void setCalificacionChofer(int calificacionChofer) {
        this.calificacionChofer = calificacionChofer;
    }

    public static double getCostoBase() {
        return costoBase;
    }

    public static void setCostoBase(double costoBase) {
        ViajeDTO.costoBase = costoBase;
    }

    public void setCantPax(int cantPax) {
        pedido.setCantPax(cantPax);
    }

    public int getCantPax() {
        return pedido.getCantPax();
    }

    public void setMascota(int mascota) {
        pedido.setMascota(mascota);
    }

    public int getMascota() {
        return pedido.getMascota();
    }

    public void setEquipaje(int equipaje) {
        pedido.setEquipaje(equipaje);
    }

    public int getEquipaje() {
        return pedido.getEquipaje();
    }

    public void setZona(String zona) {
        pedido.setZona(zona);
    }

    public String getZona() {
        return pedido.getZona();
    }

    public void setClienteDTO(ClienteDTO cliente) {
        pedido.setClienteDTO(cliente);
    }

}
