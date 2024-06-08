package vehiculos;

import java.io.Serializable;

import viajes.Pedido;

/**
 * La clase abstracta Vehiculo representa un tipo generico de vehiculo que se puede utilizar en los viajes.
 * Es una clase base para las subclases concretas de vehiculos como Auto, Combi y Moto.
 */
public abstract class Vehiculo implements Cloneable{
	protected String patente;
	protected int cantMaxPas;
	protected boolean ocupado=false;
	protected int mascota;
	protected int equipaje;

	/**
     * Crea una nueva instancia de Vehiculo con la patente, la cantidad maxima de pasajeros, 
     * la capacidad para mascotas y la capacidad para equipaje especificadas.<br>
     * <b>PRE: </b> Patente != null y !="" y cantMaxPas>0<br> 
     * @param patente La patente del Vehiculo.
     * @param cantMaxPas La cantidad maxima de pasajeros que puede transportar el Vehiculo.
     * @param pf La capacidad para mascotas del Vehiculo.
     * @param baul La capacidad para equipaje del Vehiculo.
     */
	public Vehiculo(String patente, int cantMaxPas, int pf, int baul)
	{
		assert (patente!=null && patente!=""):"Fallo pre: patente invalida";
		
		this.patente = patente;
		this.cantMaxPas = cantMaxPas;
		this.mascota = pf;
		this.equipaje = baul;
	}
	
	/**
     * Indica si el Vehiculo esta ocupado o no.<br>
     * @return true si el Vehiculo esta ocupado, false si no lo esta.
     */
	public boolean isOcupado() {
		return ocupado;
	}

	/**
     * Establece el estado de ocupacion del Vehiculo.
     * <b>POST: </b> Se cambia el estado ocupado del vehiculo<br>
     * @param ocupado true si el Vehiculo esta ocupado, false si no lo esta.
     */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	/**
     * Obtiene la patente del Vehiculo.<br>
     * @return La patente del Vehiculo.
     */
	public String getPatente() {
		return patente;
	}
	
	/**
     * Establece la patente del Vehiculo.<br>
     * <b>POST: </b> Se cambia la patente del vehiculo<br>
     * @param patente La nueva patente del Vehiculo.
     */
	public String setPatente(String patente) {
		return this.patente = patente;
	}
	
	/**
     * Obtiene la cantidad maxima de pasajeros que puede transportar el Vehiculo.<br>
     * @return La cantidad maxima de pasajeros.
     */
	public int getCantMaxPas() {
		return cantMaxPas;
	}

	/**
     * Establece la cantidad maxima de pasajeros que puede transportar el Vehiculo.<br>
     * <b>PRE: </b> cantMaxPas mayor que 0<br>
     * <b>POST: </b>Se cambia la cantidad maxima de pasajeros<br> 
     * @param cantMaxPas La nueva cantidad maxima de pasajeros.
     */
	public void setCantMaxPas(int cantMaxPas) {
		this.cantMaxPas = cantMaxPas;
	}

	/**
     * Obtiene la capacidad para mascotas del Vehiculo.<br>
     * @return La capacidad para mascotas.
     */
	public int getMascota() {
		return mascota;
	}

	/**
     * Establece la capacidad para mascotas del Vehiculo.<br>
     * @param mascota La nueva capacidad para mascotas.
     */
	public void setMascota(int mascota) {
		this.mascota = mascota;
	}

	/**
     * Obtiene la capacidad para equipaje del Vehiculo.<br>
     * @return La capacidad para equipaje.
     */
    public int getEquipaje() {
        return equipaje;
    }

    /**
     * Establece la capacidad para equipaje del Vehiculo.<br>
     * @param equipaje La nueva capacidad para equipaje.
     */
    public void setEquipaje(int equipaje) {
        this.equipaje = equipaje;
    }

    /**
     * Calcula la prioridad del Vehiculo para un Pedido dado.<br>
     * <b>PRE: </b> El pedido es distinto de null<br>
     * @param pedido El Pedido para el que se calcula la prioridad.
     * @return La prioridad del Vehiculo para el Pedido especificado.
     */
	public Integer getPrioridad(Pedido pedido) 
	{
		
		if(verificaPasajeros(pedido.getCantPax()))
		{
			if(verificaEquipaje(pedido.getEquipaje()))
			{
				if(verificaMascota(pedido.getMascota()))
				{
					return calculoPrioridad(pedido);
				}
			}
		}
			return null;
	}

	/**
     * Cada tipo de vehiculo calcula la prioridad de la forma que le corresponda.<br>
     * @param pedido El Pedido para el que se calcula la prioridad.
     * @return La prioridad del Vehiculo para el Pedido especificado.
     */
	protected abstract Integer calculoPrioridad(Pedido pedido);
	
	/**
     * Verifica si el vehiculo puede transportar la cantidad de pasajeros especificada.<br>
     * <b>PRE: </b> cantPax mayor que 0<br>
     * @param cantPax La cantidad de pasajeros a verificar.
     * @return true si el vehiculo puede transportar la cantidad de pasajeros especificada, false de lo contrario.
     */
	protected  boolean verificaPasajeros(int cantPax)
	{
		return this.cantMaxPas >= cantPax;
	};
	
	/**
	 * Verifica si el vehiculo cumple el requerimiento de equipaje del pedido.<br>
	 * @param equipaje Valor 1 si tiene, cualquier otro numero si no tiene disponibilidad.
	 * @return true si el vehiculo puede transportar la cantidad de equipaje especificada, false de lo contrario.
	 */
	protected abstract boolean verificaEquipaje(int equipaje);

	
	/**
	 * Verifica si el vehiculo cumple el requerimiento de mascota del pedido.<br>
	 * @param mascota Valor 1 si tiene, cualquier otro numero si no tiene disponibilidad
	 * @return true si el vehiculo puede transportar la cantidad de mascotas especificada, false de lo contrario.
	 */
	protected abstract boolean verificaMascota(int mascota);

	
	/**
	 * Devuelve una representación en formato de cadena de caracteres del vehiculo para su inclusion en un listado.<br>
	 * @return Una cadena que representa al vehículo en un formato adecuado para listados.
	 */
	public String toStringListado()
	{   String masc="no",equip="no";
	    if(this.mascota != 0)
	    {
	     	masc = "si";
	    }
	    if(this.equipaje != 0)
	    {
	    	equip = "si";
	    }
		return String.format(" %-15s %-10s %-10s %-10s %-10s",this.patente,this.cantMaxPas,this.ocupado,masc,equip);
	}	
	
	public String toString()
	{
		String petfriendly = (this.mascota!=0)?"Si":"No";
		String baul =(this.equipaje!=0)?"Si":"No";
		
		return "\nPATENTE: "+ this.patente +
				"\nTIPO: " + this.getClass().getName() +
				"\nCANT PASAJEROS MAX:" +this.cantMaxPas +
				"\nPET FRIENDLY:" + petfriendly +
				"\nEQUIPAJE:" + equipaje;
	}
        
        public String getTipo()
        {
            return getClass().getSimpleName().toLowerCase();
        }
	
	/**
     * Realiza una copia superficial del objeto Pedido.<br>
     * @return Una copia superficial del objeto Pedido.
     */
	public Vehiculo clone() throws CloneNotSupportedException 
	{
		Vehiculo clonado = null;
		try {
			clonado = (Vehiculo) super.clone();
		}
		catch (CloneNotSupportedException e) {
			 e.printStackTrace();
		}
		
		return clonado;
	}
}
