package Persistencia.viajeDTO;


import viajes.IViaje;
import viajes.IViaje.EstadosViajes;

import java.io.Serializable;
import java.time.LocalDateTime;

import Persistencia.choferDTO.ChoferDTO;
import Persistencia.usuarioDTO.ClienteDTO;
import Persistencia.vehiculoDTO.VehiculoDTO;

/**
 * La clase ViajeDTO representa un objeto de transferencia de datos (DTO) para un viaje.
 * Contiene información sobre el chofer asignado, el vehículo utilizado, la solicitud de viaje asociada,
 * la distancia recorrida, el estado del viaje y la calificación otorgada al chofer.
 */
public class ViajeDTO implements Serializable {
	private ChoferDTO chofer; // Chofer asignado al viaje
	private VehiculoDTO vehiculo; // Vehículo utilizado para el viaje
	private PedidoDTO pedido; // Solicitud de viaje asociada
	private double distancia; // Distancia recorrida durante el viaje
	private IViaje.EstadosViajes estado; // Estado actual del viaje
	private int calificacionChofer; // Calificación otorgada al chofer

	/**
	 * Construye un nuevo objeto ViajeDTO con valores predeterminados.
	 */
	public ViajeDTO() {
	}

	/**
	 * Construye un nuevo objeto ViajeDTO con los parámetros especificados.
	 * 
	 * @param chofer El chofer asignado al viaje.
	 * @param vehiculo El vehículo utilizado para el viaje.
	 * @param pedido La solicitud de viaje asociada.
	 * @param distancia La distancia recorrida durante el viaje.
	 * @param estado El estado actual del viaje.
	 * @param calificacionChofer La calificación otorgada al chofer.
	 */
	public ViajeDTO(ChoferDTO chofer, VehiculoDTO vehiculo, PedidoDTO pedido, double distancia, EstadosViajes estado,
			int calificacionChofer) {
		this.chofer = chofer;
		this.vehiculo = vehiculo;
		this.pedido = pedido;
		this.distancia = distancia;
		this.estado = estado;
		this.calificacionChofer = calificacionChofer;
	}

	/**
	 * Obtiene el chofer asignado al viaje.
	 * 
	 * @return El chofer asignado al viaje.
	 */
	public ChoferDTO getChofer() {
		return chofer;
	}

	/**
	 * Establece el chofer asignado al viaje.
	 * 
	 * @param chofer El chofer asignado al viaje a establecer.
	 */
	public void setChofer(ChoferDTO chofer) {
		this.chofer = chofer;
	}

	/**
	 * Obtiene el vehículo utilizado para el viaje.
	 * 
	 * @return El vehículo utilizado para el viaje.
	 */
	public VehiculoDTO getVehiculo() {
		return vehiculo;
	}

	/**
	 * Establece el vehículo utilizado para el viaje.
	 * 
	 * @param vehiculo El vehículo utilizado para el viaje a establecer.
	 */
	public void setVehiculo(VehiculoDTO vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * Obtiene la solicitud de viaje asociada.
	 * 
	 * @return La solicitud de viaje asociada.
	 */
	public PedidoDTO getPedidoDTO() {
		return pedido;
	}

	/**
	 * Establece la solicitud de viaje asociada.
	 * 
	 * @param pedido La solicitud de viaje asociada a establecer.
	 */
	public void setPedidoDTO(PedidoDTO pedido) {
		this.pedido = pedido;
	}

	/**
	 * Obtiene la distancia recorrida durante el viaje.
	 * 
	 * @return La distancia recorrida durante el viaje.
	 */
	public double getDistancia() {
		return distancia;
	}

	/**
	 * Establece la distancia recorrida durante el viaje.
	 * 
	 * @param distancia La distancia recorrida durante el viaje a establecer.
	 */
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	/**
	 * Obtiene el estado actual del viaje.
	 * 
	 * @return El estado actual del viaje.
	 */
	public EstadosViajes getEstado() {
		return estado;
	}

	/**
	 * Establece el estado actual del viaje.
	 * 
	 * @param estado El estado actual del viaje a establecer.
	 */
	public void setEstado(EstadosViajes estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene la calificación otorgada al chofer.
	 * 
	 * @return La calificación otorgada al chofer.
	 */
	public int getCalificacionChofer() {
		return calificacionChofer;
	}

	/**
	 * Establece la calificación otorgada al chofer.
	 * 
	 * @param calificacionChofer La calificación otorgada al chofer a establecer.
	 */
	public void setCalificacionChofer(int calificacionChofer) {
		this.calificacionChofer = calificacionChofer;
	}

	/**
	 * Establece la cantidad de pasajeros para el pedido asociado al viaje.
	 * 
	 * @param cantPax La cantidad de pasajeros a establecer.
	 */
	public void setCantPax(int cantPax) {
		pedido.setCantPax(cantPax);
	}

	/**
	 * Obtiene la cantidad de pasajeros del pedido asociado al viaje.
	 * 
	 * @return La cantidad de pasajeros del pedido asociado al viaje.
	 */
	public int getCantPax() {
		return pedido.getCantPax();
	}

	/**
	 * Establece la cantidad de mascotas para el pedido asociado al viaje.
	 * 
	 * @param mascota La cantidad de mascotas a establecer.
	 */
	public void setMascota(int mascota) {
		pedido.setMascota(mascota);
	}

	/**
	 * Obtiene la cantidad de mascotas del pedido asociado al viaje.
	 * 
	 * @return La cantidad de mascotas del pedido asociado al viaje.
	 */
	public int getMascota() {
		return pedido.getMascota();
	}

	/**
	 * Establece la cantidad de equipaje para el pedido asociado al viaje.
	 * 
	 * @param equipaje La cantidad de equipaje a establecer.
	 */
	public void setEquipaje(int equipaje) {
		pedido.setEquipaje(equipaje);
	}

	/**
	 * Obtiene la cantidad de equipaje del pedido asociado al viaje.
	 * 
	 * @return La cantidad de equipaje del pedido asociado al viaje.
	 */
	public int getEquipaje() {
		return pedido.getEquipaje();
	}

	/**
	 * Establece la zona del pedido asociado al viaje.
	 * 
	 * @param zona La zona del pedido asociado al viaje a establecer.
	 */
	public void setZona(String zona) {
		pedido.setZona(zona);
	}

	/**
	 * Obtiene la zona del pedido asociado al viaje.
	 * 
	 * @return La zona del pedido asociado al viaje.
	 */
	public String getZona() {
		return pedido.getZona();
	}

	/**
	 * Establece el cliente del pedido asociado al viaje.
	 * 
	 * @param cliente El cliente del pedido asociado al viaje a establecer.
	 */
	public void setClienteDTO(ClienteDTO cliente) {
		pedido.setClienteDTO(cliente);
	}

}
