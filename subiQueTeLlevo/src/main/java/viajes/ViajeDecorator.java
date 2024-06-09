package viajes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import choferes.Chofer;
import usuarios.Cliente;
import vehiculos.Vehiculo;

/**
 * La clase abstracta responsable de decorar objetos de tipo IViaje.
 */
public abstract class ViajeDecorator implements IViaje{
    IViaje encapsulado;
    
    /**
     * Establece el viaje encapsulado por este Decorador.<br>
     * <b>PRE: </b>El viaje no puede ser nulo.<br>
     * <b>POST: </b>Se establece el viaje encapsulado por este Decorador.
     * @param viaje El viaje a encapsular.
     */
    public void setEncapsulado(IViaje viaje) {
        assert viaje != null : "Fallo pre: El viaje no puede ser nulo";

        this.encapsulado = viaje;
    }

    /**
     * Obtiene el viaje encapsulado por este Decorador.<br>
     * @return El viaje encapsulado.
     */
    public IViaje getEncapsulado() {
        return encapsulado;
    }
	
    
    @Override
    public Pedido getPedido(){
            return this.encapsulado.getPedido();
    }
    
    /**
     * Obtiene el costo del Viaje encapsulado por este Decorador.<br>
     * @return El costo del Viaje encapsulado.
     */
    @Override
	public double getCosto()
	{
		return encapsulado.getCosto();
	}
	
	/**
     * Obtiene el cliente del Viaje encapsulado por este Decorador.<br>
     * @return El costo del Viaje encapsulado.
     */
    @Override
	public Cliente getCliente()
	{
		return encapsulado.getCliente();
	}
	
	/**
     * Obtiene el Chofer del Viaje encapsulado por este Decorador.<br>
     * @return El Chofer del Viaje encapsulado.
     */
    @Override
	public Chofer getChofer() {
		return encapsulado.getChofer();
	}

	/**
     * Obtiene el vehiculo del Viaje encapsulado por este Decorador.<br>
     * @return El vehiculo del Viaje encapsulado.
     */
    @Override
	public Vehiculo getVehiculo() {
		return encapsulado.getVehiculo();
	}

	/**
     * Obtiene la distancia del Viaje encapsulado por este Decorador.<br>
     * @return La distancia del Viaje encapsulado.
     */
    @Override
	public double getDistancia() {
		return encapsulado.getDistancia();
	}
	
	/**
     * Obtiene la zona del Viaje encapsulado por este Decorador.<br>
     * @return La zona del Viaje encapsulado.
     */
    @Override
	public String getZona()
	{
		return encapsulado.getZona();
	}

	/**
     * Obtiene la cantidad de pasajeros del Viaje encapsulado por este Decorador.<br>
     * @return La distancia del Viaje encapsulado.
     */
    @Override
	public int getCantPax()
	{
		return encapsulado.getCantPax();
	}
	
	/**
     * Obtiene si el Viaje encapsulado por este Decorador transporta mascotas.<br>
     * @return Valor 0 no transporta mascota, cualquier otro si.
     */
    @Override
	public int getMascota()
	{
		return encapsulado.getCantPax();
	}
	
	/**
     * Obtiene si el Viaje encapsulado por este Decorador usa el baul.<br>
     * @return Valor 0 no transporta equipaje, cualquier otro si.
     */
    @Override
	public int getEquipaje()
	{
		return encapsulado.getEquipaje();
	}
	
	/**
     * Obtiene la fecha del Viaje encapsulado por este Decorador.<br>
     * @return La fecha del Viaje.
     */
    @Override
	public LocalDateTime getFecha()
	{
		return encapsulado.getFecha();
	}
	
	/**
     * Obtiene la calificacion del cliente sobre el Chofer del Viaje encapsulado por este Decorador.<br>
     * @return La calificacion ddel cliente sobre el Chofer del Viaje.
     */
    @Override
	public int getCalificacionChofer() {
		return this.encapsulado.getCalificacionChofer();
	}

	/**
     * Establece la calificacion del cliente sobre el Chofer del Viaje encapsulado por este Decorador.<br>
     * <b>PRE: </b>La calificación del Chofer debe ser un valor entero válido. <br>
     * <b>POST: </b>Se establece la calificación del cliente sobre el Chofer del Viaje encapsulado.
     * @param calificacionChofer La calificacion del Chofer a establecer.
     */
    @Override
	public void setCalificacionChofer(int calificacionChofer) {
		this.encapsulado.setCalificacionChofer(calificacionChofer);
	}
	
	/**
	 * Establece el chofer asociado a este Viaje encapsulado.<br>
	 * <b>PRE: </b>El chofer no puede ser nulo.<br>
 	 * <b>POST: </b>Se establece el chofer asociado a este Viaje encapsulado.
	 * @param chofer El chofer a establecer.
	 */
    @Override
	public void setChofer(Chofer chofer) {
	    assert chofer != null : "Fallo pre: El chofer no puede ser nulo";
		encapsulado.setChofer(chofer);
	}
	
	/**
	 * Establece el vehiculo asociado a este Viaje  encapsulado.<br>
	 * <b>PRE:</b> El vehículo no puede ser nulo.
 	 * <b>POST:</b> Se establece el vehículo asociado a este Viaje encapsulado.
	 * @param vehiculo El vehiculo a establecer.
	 */
    @Override
	public void setVehiculo(Vehiculo vehiculo) {
	    assert vehiculo != null : "Fallo pre: El vehículo no puede ser nulo";
	    
		encapsulado.setVehiculo(vehiculo);
	}
	
	/**
	 * Establece el estado asociado a este Viaje encapsulado.<br>
	 * <b>POST: </b> Se establece el estado asociado a este Viaje encapsulado.
	 * @param estado El estado a establecer.
	 */
    @Override
	public void setEstado(EstadosViajes estado) {
		encapsulado.setEstado(estado);
	}
	
	/**
	 * Obtiene el estado asociado a este Viaje encapsulado.<br>
	 * @return El estado del Viaje encapsulado.
	 */
    @Override
	public EstadosViajes getEstado() {
		return encapsulado.getEstado();
	}
	
	/**
	 * Compara este Viaje con otro Viaje basado en el costo. <br>
	 * <b>PRE: </b> El Viaje proporcionado no puede ser nulo.
	 * @param viaje El Viaje con el que se compara.
	 * @return Un valor negativo si este viaje tiene un costo menor que el Viaje proporcionado,
	 *         cero si tienen el mismo costo, o un valor positivo si este Viaje tiene un costo mayor.
	 */
    @Override
	public int compareTo(IViaje viaje)
	{
		return this.encapsulado.compareTo(viaje);
	}
	
	/**
	 * Devuelve una clonacion profunda del Decorator y la clonacion profunda del viaje la delegamos a ViajeAbstracto.<br>
	 * @return Una copia de este objeto encapsulado.
	 */
    @Override
	public Object clone()
    {
        ViajeDecorator clonado = null;
        try {
             clonado = (ViajeDecorator) super.clone();
             clonado.encapsulado = (IViaje) this.encapsulado.clone();
        } 
        catch (CloneNotSupportedException e) {
        }
        return clonado;
    }
	
	/**
	 * Devuelve una representación en forma de cadena de este viaje para su inclusión en un listado.<br>
	 * <b>PRE: </b>El parametro costo no puede ser un numero negativo.
	 * @return Una cadena que representa este viaje en un listado.
	 */

    @Override
	 public String toStringListado()
	    {
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
	    	String fecha = this.getFecha().format(formatter);
	    	
	    	return String.format("%-10s  $%.2f  %-10s  %-13s  %-10s  %-13s  %-10s  %-10s  %-8s  %-6s  %-10s",fecha,getCosto(),getZona(),getCliente().getNombreUsuario(),getChofer().getDni(),
	    		getVehiculo().getPatente(),getDistancia(),getCantPax(),getMascota(),getEquipaje()
	    		,getEstado());
	    }
	    
	    /**
	     * Devuelve una representacion en formato de cadena de este Viaje para el reporte del Chofer.<br>
	     * @return Una cadena formateada que representa este Viaje para el reporte del Chofer.
	     */
    @Override
	    public String toStringReporteChofer()
	    {
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
	    	String fecha = this.getFecha().format(formatter);
	    	
	    	return String.format("%-10s  $%.2f  %-10s  %-13s  %-13s  %-10s  %-10s  %-8s  %-6s  %-10s",fecha,getCosto(),getZona(),getCliente().getNombreUsuario(),
	    		getVehiculo().getPatente(),getDistancia(),getCantPax(),getMascota(),getEquipaje()
	    		,getEstado());
	    }
	    
	    /**
	     * Devuelve una representacion en formato de cadena de este Viaje para el reporte del cliente.<br>
	     * @return Una cadena formateada que representa este Viaje para el reporte del cliente.
	     */
    @Override
	    public String toStringReporteCliente()
	    {
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
	    	String fecha = this.getFecha().format(formatter);
	    	
	    	return String.format("%-10s  $%.2f  %-10s  %-13s  %-13s  %-10s  %-10s  %-8s  %-6s  %-10s",fecha,getCosto(),getZona(),getChofer().getDni(),
	    		getVehiculo().getPatente(),getDistancia(),getCantPax(),getMascota(),getEquipaje()
	    		,getEstado());
	    }
		
	
	
}
