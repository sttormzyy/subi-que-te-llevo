 package Persistencia.viajeDTO;

import java.io.Serializable;

import Persistencia.LocalDateTimeDTO;
import Persistencia.usuarioDTO.ClienteDTO;

/**
 * La clase PedidoDTO representa un objeto de transferencia de datos (DTO) para una solicitud de viaje.
 * Incluye informacion como la fecha y hora de la solicitud, el cliente que realiza la solicitud,
 * la zona de destino, el numero de mascotas, la cantidad de equipaje y el numero de pasajeros.
 */
public class PedidoDTO implements Serializable {
    private LocalDateTimeDTO fechaDTO; 
    private ClienteDTO cliente; 
    private String zona; 
    private int mascota; 
    private int equipaje; 
    private int cantPax; 
    
    /**
     * Construye un nuevo PedidoDTO con valores predeterminados.
     */
    public PedidoDTO() {
	}

    /**
     * Construye un nuevo PedidoDTO con los parametros especificados.
     * 
     * @param fechaDTO La fecha y hora de la solicitud.
     * @param cliente El cliente que realiza la solicitud.
     * @param zona La zona de destino.
     * @param mascota El numero de mascotas.
     * @param equipaje La cantidad de equipaje.
     * @param cantPax El numero de pasajeros.
     */
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

    /**
     * Obtiene la fecha y hora de la solicitud.
     * 
     * @return La fecha y hora de la solicitud.
     */
	public LocalDateTimeDTO getFechaDTO() {
        return fechaDTO;
    }

    /**
     * Establece la fecha y hora de la solicitud.
     * 
     * @param fechaDTO La fecha y hora de la solicitud a establecer.
     */
    public void setFechaDTO(LocalDateTimeDTO fechaDTO) {
        this.fechaDTO = fechaDTO;
    }

    /**
     * Obtiene el cliente que realiza la solicitud.
     * 
     * @return El cliente que realiza la solicitud.
     */
    public ClienteDTO getClienteDTO() {
        return cliente;
    }

    /**
     * Establece el cliente que realiza la solicitud.
     * 
     * @param cliente El cliente que realiza la solicitud a establecer.
     */
    public void setClienteDTO(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la zona de destino.
     * 
     * @return La zona de destino.
     */
    public String getZona() {
        return zona;
    }

    /**
     * Establece la zona de destino.
     * 
     * @param zona La zona de destino a establecer.
     */
    public void setZona(String zona) {
        this.zona = zona;
    }

    /**
     * Obtiene el numero de mascotas.
     * 
     * @return El numero de mascotas.
     */
    public int getMascota() {
        return mascota;
    }

    /**
     * Establece el numero de mascotas.
     * 
     * @param mascota El numero de mascotas a establecer.
     */
    public void setMascota(int mascota) {
        this.mascota = mascota;
    }

    /**
     * Obtiene la cantidad de equipaje.
     * 
     * @return La cantidad de equipaje.
     */
    public int getEquipaje() {
        return equipaje;
    }

    /**
     * Establece la cantidad de equipaje.
     * 
     * @param equipaje La cantidad de equipaje a establecer.
     */
    public void setEquipaje(int equipaje) {
        this.equipaje = equipaje;
    }

    /**
     * Obtiene el numero de pasajeros.
     * 
     * @return El numero de pasajeros.
     */
    public int getCantPax() {
        return cantPax;
    }

    /**
     * Establece el numero de pasajeros.
     * 
     * @param cantPax El numero de pasajeros a establecer.
     */
    public void setCantPax(int cantPax) {
        this.cantPax = cantPax;
    }
}

