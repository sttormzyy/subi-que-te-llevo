package viajes;

import java.time.LocalDateTime;
import choferes.Chofer;
import usuarios.Cliente;
import vehiculos.Vehiculo;
import java.time.format.DateTimeFormatter;

/**
 * Clase abstracta que implementa la interfaz IViaje y proporciona funcionalidades comunes para los viajes.
 */
public abstract class ViajeAbstracto implements IViaje {
     private Chofer chofer;
     private Vehiculo vehiculo;
     private Pedido pedido; 
     private double distancia;
     private EstadosViajes estado;
     private int calificacionChofer;
     private static double costoBase=1000;
    
     /**
      * Constructor de la clase ViajeAbstracto.<br>
      * <b>PRE: </b> El Pedido no pueden ser nulo y la distancia debe ser mayor a cero.
      * @param pedido    El Pedido asociado al Viaje.
      * @param distancia La distancia del Viaje.
      */
	public ViajeAbstracto(Pedido pedido, double distancia)
	{
		assert pedido != null: "Fallo pre: pedido no puede ser nulo.";
		assert distancia > 0: "Fallo pre: distancia debe ser mayor a cero.";
		
		this.pedido = pedido;
		this.distancia = distancia;
		this.estado = EstadosViajes.SOLICITADO;
	}
     
     /**
      * Establece el Chofer asignado al Viaje.<br>
      * @param chofer El Chofer asignado al Viaje.
      */
     public void setChofer(Chofer chofer)
     {
         this.chofer = chofer;
     }

     /**
      * Establece el vehiculo asociado al Viaje.<br>
      * <b>PRE: </b>El parametro vehiculo no debe ser nulo. <br>
      * <b>POST: </b> Se establece el vehiculo del viaje con el parametro proporcionado.
      * @param vehiculo El vehiculo del Viaje.
      */
     public void setVehiculo(Vehiculo vehiculo) {
    	 assert vehiculo != null: "Fallo pre: vehiculo no debe ser nulo.";
         this.vehiculo = vehiculo;
     }
	
     /**
      * Obtiene el costo del Viaje.
      * @return El costo del Viaje.
      */
     public double getCosto() {
         return costoBase * (1 + this.getIncrKm() + this.getIncrPax());
     }

     /**
      * Obtiene el cliente asociado al Viaje.<br>
      * @return El cliente asociado al Viaje.
      */
     public Cliente getCliente() 
     {
         return this.pedido.getCliente();
     }

     /**
      * Obtiene el Chofer asignado al Viaje.<br>
      * @return El Chofer asignado al Viaje.
      */
     public Chofer getChofer() 
     {
         return chofer;
     }

     /**
      * Obtiene el vehiculo asociado al Viaje.<br>
      * @return El vehiculo asociado al Viaje.
      */
     public Vehiculo getVehiculo() 
     {
         return vehiculo;
     }

     /**
      * Obtiene la distancia del Viaje.<br>
      * @return La distancia del Viaje.
      */
     public double getDistancia()
     {
         return distancia;
     }

     /**
      * Obtiene la zona del Viaje.<br>
      * @return La zona del Viaje.
      */
     public String getZona()
     {
         return this.pedido.getZona();
     }

	
     /**
      * Obtiene la cantidad de pasajeros del Viaje.<br>
      * @return La cantidad de pasajeros del Viaje.
      */
     public int getCantPax()
     {
         return this.pedido.getCantPax();
     }

     /**
      * Obtiene si hay presencia de mascotas en el Viaje.<br>
      * @return 1 si hay mascotas, cualquier otro en caso contrario.
      */
     public int getMascota()
{
         return this.pedido.getMascota();
     }

     /**
      * Obtiene la cantidad de equipaje del Viaje.<br>
      * @return La cantidad de equipaje del Viaje.
      */
     public int getEquipaje() 
     {
         return this.pedido.getEquipaje();
     }

     /**
      * Obtiene la fecha del Viaje.<br>
      * @return La fecha del Viaje.
      */
     public LocalDateTime getFecha() 
     {
         return this.pedido.getFecha();
     }

     /**
      * Obtiene la calificacion del Chofer asignado al Viaje.<br>
      * @return La calificacion del Chofer asignado al Viaje.
      */
     public int getCalificacionChofer()
     {
         return calificacionChofer;
     }

     /**
      * Establece la calificacion del Chofer asignado al Viaje.<br>
      * <b>PRE: </b>El parametro calificacion no debe ser un valor negativo.
      * <b>POST: </b>calificacionChofer se establece con el valor proporcionado.
      * @param calificacion La calificacion del Chofer asignado al Viaje.
      */
     public void setCalificacionChofer(int calificacion) {
    	 assert calificacion >= 0: "Fallo pre: calificacion no debe ser un valor negativo.";
         this.calificacionChofer = calificacion;
     }


     /**
      * Devuelve el incremento en el costo por kilometro adicional para este tipo de viaje.<br>
      * @return El incremento en el costo por kilometro adicional.
      */
	public abstract double getIncrKm();
	
	/**
     * Devuelve el incremento en el costo por Pasajero para este tipo de viaje.<br>
     * @return El incremento en el costo por Pasajero.
     */
	public abstract double getIncrPax();


	/**
	 * Obtiene el estado del Viaje.<br>
	 * @return El estado del Viaje.
	 */
	public EstadosViajes getEstado() 
	{
	    return this.estado;
	}

	/**
	 * Establece el estado del Viaje.<br>
	 * <b>POST:</b> El estado del Viaje se establece con el valor proporcionado.
	 * @param estado El estado del Viaje.
	 */
	public void setEstado(EstadosViajes estado)
	{
	    this.estado = estado;
	}

	/**
	 * Obtiene el costo base del Viaje.<br>
	 * @return El costo base del Viaje.
	 */
	public static double getCostoBase() 
	{
	    return costoBase;
	}

	/**
	 * Establece el costo base del Viaje.<br>
	 * <b>PRE: </b> El parametro costoBase debe ser mayor a cero.
	 * @param costoBase El nuevo costo base del Viaje.
	 */
	public static void setCostoBase(double costoBase) {
		assert costoBase > 0: "Fallo pre: costoBase debe ser mayor a cero,";
	    ViajeAbstracto.costoBase = costoBase;
	}

	/**
	 * Compara este Viaje con otro viaje segun el costo.<br>
	 * <b>PRE: </b>El parametro viaje no puede ser nulo.
	 * @param viaje El otro Viaje con el que se compara.
	 * @return El resultado de la comparacion.
	 */
	public int compareTo(IViaje viaje) {
		assert viaje != null: "Fallo pre: viaje no puede ser nulo.";
	    return Double.compare(viaje.getCosto(), this.getCosto());
	}

	/**
	 * Clona superficialmente los atributos de tipo objeto con los que un viaje mantiene 
	 * relacion de agregacion (Vehiculo, Chofer) y profundamente aquellos que mantienen una 
	 * relacion de composicion (Pedido)<br>
	 * @return Una copia de este objeto.
	 */
    public Object clone()
    {
    	ViajeAbstracto clonado = null;
    	try {
		    clonado = (ViajeAbstracto) super.clone();
		    clonado.pedido = (Pedido)this.pedido.clone();
		} 
    	catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
    	return clonado;
    }
    
    /**
     * Devuelve una representacion en formato de cadena de este Viaje para listado general.<br>
     * @param costo El costo del Viaje.
     * @return Una cadena formateada que representa este Viaje para listado general.
     */
    public String toStringListado()
    {

    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
    	String fecha = this.getFecha().format(formatter);
    	
    	return String.format("%-10s  $%.2f  %-10s  %-13s  %-10s  %-13s  %-10s  %-10s  %-8s  %-6s  %-10s",fecha,getCosto(),getZona(),getCliente().getNombreUsuario(),this.chofer.getDni(),
    		this.vehiculo.getPatente(),this.distancia,getCantPax(),getMascota(),getEquipaje()
    		,this.estado);
    }
    
    /**
     * Devuelve una representacion en formato de cadena de este Viaje para el reporte del Chofer.<br>
     * @param costo El costo del Viaje.
     * @return Una cadena formateada que representa este Viaje para el reporte del Chofer.
     */
    public String toStringReporteChofer()
    {


    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
    	String fecha = this.getFecha().format(formatter);
    	
    	return String.format("%-10s  $%.2f  %-10s  %-13s  %-13s  %-10s  %-10s  %-8s  %-6s  %-10s",fecha,getCosto(),getZona(),getCliente().getNombreUsuario(),
    		this.vehiculo.getPatente(),this.distancia,getCantPax(),getMascota(),getEquipaje()
    		,this.estado);
    }
    
    /**
     * Devuelve una representacion en formato de cadena de este Viaje para el reporte del cliente.<br>
     * @param costo El costo del Viaje.
     * @return Una cadena formateada que representa este Viaje para el reporte del cliente.
     */
    public String toStringReporteCliente()
    {

    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
    	String fecha = this.getFecha().format(formatter);
    	
    	return String.format("%-10s  $%.2f  %-10s  %-13s  %-13s  %-10s  %-10s  %-8s  %-6s  %-10s",fecha,getCosto(),getZona(),this.chofer.getDni(),
    		this.vehiculo.getPatente(),this.distancia,getCantPax(),getMascota(),getEquipaje()
    		,this.estado);
    }
	
	
}
