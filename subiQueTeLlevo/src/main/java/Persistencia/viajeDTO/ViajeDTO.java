package Persistencia.viajeDTO;


import viajes.IViaje;
import viajes.IViaje.EstadosViajes;

import java.io.Serializable;
import java.time.LocalDateTime;

import Persistencia.choferDTO.ChoferDTO;
import Persistencia.usuarioDTO.ClienteDTO;
import Persistencia.vehiculoDTO.VehiculoDTO;

public class ViajeDTO implements Serializable {
    private ChoferDTO chofer;
    private VehiculoDTO vehiculo;
    private PedidoDTO pedido;
    private double distancia;
    private IViaje.EstadosViajes estado;
    private int calificacionChofer;

    public ViajeDTO() {
    }

    public ViajeDTO(ChoferDTO chofer, VehiculoDTO vehiculo, PedidoDTO pedido, double distancia, EstadosViajes estado,
			int calificacionChofer) {
		this.chofer = chofer;
		this.vehiculo = vehiculo;
		this.pedido = pedido;
		this.distancia = distancia;
		this.estado = estado;
		this.calificacionChofer = calificacionChofer;
	}



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
