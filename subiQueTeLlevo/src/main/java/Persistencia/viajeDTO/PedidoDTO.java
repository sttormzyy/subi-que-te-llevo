package Persistencia.viajeDTO;

import java.io.Serializable;

import Persistencia.LocalDateTimeDTO;
import Persistencia.usuarioDTO.ClienteDTO;

public class PedidoDTO implements Serializable {
    private LocalDateTimeDTO fechaDTO;
    private ClienteDTO cliente;
    private String zona;
    private int mascota;
    private int equipaje;
    private int cantPax;
    
    public PedidoDTO() {
	}

    public PedidoDTO(LocalDateTimeDTO fechaDTO, ClienteDTO cliente, String zona, int mascota, int equipaje,
			int cantPax) {
		super();
		this.fechaDTO = fechaDTO;
		this.cliente = cliente;
		this.zona = zona;
		this.mascota = mascota;
		this.equipaje = equipaje;
		this.cantPax = cantPax;
	}

	public LocalDateTimeDTO getFechaDTO() {
        return fechaDTO;
    }

    public void setFechaDTO(LocalDateTimeDTO fechaDTO) {
        this.fechaDTO = fechaDTO;
    }

    public ClienteDTO getClienteDTO() {
        return cliente;
    }

    public void setClienteDTO(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getMascota() {
        return mascota;
    }

    public void setMascota(int mascota) {
        this.mascota = mascota;
    }

    public int getEquipaje() {
        return equipaje;
    }

    public void setEquipaje(int equipaje) {
        this.equipaje = equipaje;
    }

    public int getCantPax() {
        return cantPax;
    }

    public void setCantPax(int cantPax) {
        this.cantPax = cantPax;
    }
}
