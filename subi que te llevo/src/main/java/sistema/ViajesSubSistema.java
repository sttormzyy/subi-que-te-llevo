package sistema;

import java.time.LocalDateTime;
import java.util.ArrayList;

import choferes.Chofer;
import excepciones.pedido.ExceptionCantPax;
import excepciones.pedido.ExceptionFecha;
import excepciones.pedido.ExceptionPedido;
import excepciones.pedido.ExceptionTipodeServicio;
import excepciones.pedido.ExceptionVehiculoDisp;
import excepciones.pedido.ExceptionZona;
import excepciones.viaje.ExceptionChoferDisp;
import excepciones.viaje.ExceptionChoferSinViajesPagos;
import excepciones.viaje.ExceptionClienteSinViajesPagos;
import excepciones.viaje.ExceptionSinViajeaPagar;
import usuarios.Cliente;
import vehiculos.Vehiculo;
import viajes.IViaje;
import viajes.IViaje.EstadosViajes;
import viajes.Pedido;
import viajes.ViajeFactory;

/**
 * El subsistema de viajes, responsable de la creacion, gestion y finalizacion de viajes,
 * asi como el manejo de pedidos y la asignación de vehiculos y choferes a los viajes.
 */
public class ViajesSubSistema {
    private Empresa empresa = Empresa.getInstance(); 
    private ViajeFactory viajeFactory = new ViajeFactory();
    /**
     * Coleccion de viajes de la empresa
     */
    private ArrayList<IViaje> viajeLista = new ArrayList<IViaje>();

	public void setViajeLista(ArrayList<IViaje> viajeLista) {
		this.viajeLista = viajeLista;
	}

	/**
     * Obtiene la lista de viajes (viajeLista).<br>
     * <b>POST: </b> Se devuelve la lista de viajes.
     * @return La lista de viajes.
     */
    public ArrayList<IViaje> getViajeLista()
	{
		return this.viajeLista;
	}
    
    /**
     * Retorna un ArrayList de Viaje con el historico de los viajes de un cliente.<br>
	 * <b>PRE: </b> El parámetro cliente no puede ser nulo.<br>
	 * <b>POST: </b> Se devuelve la lista de viajes del cliente especificado.<br>
     * @param cliente El cliente del cual se desea obtener los viajes.
     * @return La lista de viajes del cliente.
     */
 	public ArrayList<IViaje> getViajeLista(Cliente cliente) 
 	{
 		assert cliente != null : "Fallo pre: El cliente no puede ser nulo.";
 		
 		ArrayList<IViaje> viajeCliente = new ArrayList<IViaje>();

 		for (int i = 0; i < this.viajeLista.size(); i++)
 		{
 			if (this.viajeLista.get(i).getCliente() == cliente) 
 			{
 				viajeCliente.add(this.viajeLista.get(i));
 			}
 		}

 		return viajeCliente;
 	}
 	
 	/**
     * Agrega un viaje a la lista de viajes (viajeLista).<br>
	 * <b>PRE: </b> El parametro viaje no puede ser nulo.<br>
	 * <b>POST: </b> Se agrega el viaje especificado a la lista de viajes.<br>
     * @param viaje El viaje a agregar.
     */
 	public void addViaje(IViaje viaje)
	{		
 		assert viaje != null : "Fallo pre: El viaje no puede ser nulo.";
 		
 		this.viajeLista.add(viaje);
	}
	
 	/**
     * Genera un pedido para un cliente con los parametros especificados, si el pedido pasa las verificaciones 
     * correspondientes delega la creacion del viaje.<br>
     * <b>PRE: </b> cliente != null, zona != null, tipoServicio != null, fecha != null, mascota >= 0, equipaje >= 0, cantPax >= 0.<br>
     * <b>POST: </b> Se genera un pedido válido con los parámetros especificados y se devuelve el pedido generado.<br>
     * @param cliente      El cliente que realiza el pedido.
     * @param zona         La zona de destino del viaje.
     * @param mascota      La cantidad de mascotas que viajan.
     * @param tipoServicio El tipo de servicio solicitado (transporte o mensajeria).
     * @param equipaje     La cantidad de equipaje.
     * @param cantPax      La cantidad de pasajeros.
     * @param fecha        La fecha del viaje.
     * @return El pedido generado.
     * @throws ExceptionPedido   Si algun parametro del pedido es invalido.
     * @throws ExceptionVehiculoDisp Si no hay vehiculos disponibles que satisfagan el Pedido solicitado.
     */
    private Pedido generarPedido(Cliente cliente, String zona, int mascota, String tipoServicio, int equipaje, int cantPax, LocalDateTime fecha) 
    		throws ExceptionPedido,ExceptionVehiculoDisp
	{
        assert cliente != null : "Fallo pre: El cliente no puede ser nulo.";
        assert zona != null : "Fallo pre: La zona no puede ser nula.";
        assert tipoServicio != null : "Fallo pre: El tipo de servicio no puede ser nulo.";
        assert fecha != null : "Fallo pre: La fecha no puede ser nula.";
        assert mascota >= 0 : "Fallo pre: La cantidad de mascotas debe ser no negativa.";
        assert equipaje >= 0 : "Fallo pre: La cantidad de equipaje debe ser no negativa.";
        assert cantPax >= 0 : "Fallo pre: La cantidad de pasajeros debe ser no negativa.";
        
		if (!ValidaZona(zona)) 
		{ 
			throw new ExceptionZona(zona);
		} 
		if (cantPax >10) 
		{
			throw new ExceptionCantPax(cantPax);
		} 
		/*if (fecha.compareTo(LocalDateTime.now())<0) 
		{
			throw new ExceptionFecha(fecha);
		} */
		if ( (!tipoServicio.equalsIgnoreCase("mensajeria") && !tipoServicio.equalsIgnoreCase("transporte")) ) 
		{
			throw new ExceptionTipodeServicio();
		}	
		
		if(!cumplePrestaciones(mascota,equipaje,cantPax))
			throw new ExceptionVehiculoDisp();
				
		return new Pedido(cliente, fecha, zona, mascota, equipaje, cantPax);
			 
	}
      
    /**
     * Verifica si hay algun vehiculo disponible para un pedido.<br>
     * <b>PRE: </b> mascota, equipaje y cantPax deben ser mayores o iguales a cero.<br>
     * <b>POST: </b> Se devuelve true si hay un vehículo disponible que cumple con los requisitos del pedido, false de lo contrario.<br>
     * @param mascota  La cantidad de mascotas en el pedido.
     * @param equipaje La cantidad de equipaje en el pedido.
     * @param cantPax  La cantidad de pasajeros en el pedido.
     * @return true si hay un vehiculo disponible, false de lo contrario.
     */
    private boolean cumplePrestaciones(int mascota, int equipaje, int cantPax)
    {
        assert mascota >= 0 : "Fallo pre: La cantidad de mascotas debe ser no negativa.";
        assert equipaje >= 0 : "Fallo pre: La cantidad de equipaje debe ser no negativa.";
        assert cantPax >= 0 : "Fallo pre: La cantidad de pasajeros debe ser no negativa.";
    	
    	ArrayList<Vehiculo> vehiculoLista = empresa.getVehiculoLista();
    	Vehiculo vehiculo = null;
    	int i=0;
    	boolean autoDisp=false;
    	
    	while(i<vehiculoLista.size() && !autoDisp)
    	{
    		vehiculo = vehiculoLista.get(i);
    		if(vehiculo.getMascota()>=mascota && vehiculo.getEquipaje()>=equipaje && vehiculo.getCantMaxPas()>=cantPax)
    			autoDisp = true;
    		i++;
    	}
    	  	
    	return autoDisp;	
    }
        
    /**
     * Verifica si la zona especificada es valida<br>.
	 * <b>PRE: </b> La cadena zona no debe ser nula.<br>
	 * <b>POST: </b> Se devuelve true si la zona es válida (Estandar, Sin Asfaltar o Peligrosa), false de lo contrario.<br>
     * @param zona  La zona a verificar.
     * @return true si la zona es valida, false de lo contrario.
     */
    private boolean ValidaZona(String zona)
	{
        assert zona != null : "Fallo pre: La zona no puede ser nula.";
    	
		boolean rta = false;
		
		switch(zona.toUpperCase())
		{
			case "ESTANDAR": rta = true;
				break;
			case "SIN ASFALTAR": rta=true;
				break;
			case "PELIGROSA": rta = true;
		}
		
		return rta;
	}
    
    /**
     * Realiza un pedido de viaje para un cliente con los parametros especificados.<br>
     * <b>PRE:</b> cliente y fecha != null, zona y tipoServicio != null y != "", cantPax >= 0, distancia > 0.
     * <b>POST:</b> Se programa un viaje para el cliente con los parámetros especificados.
     * @param cliente      El cliente que realiza el pedido.
     * @param zona         La zona de destino del viaje.
     * @param mascota      La cantidad de mascotas que viajan.
     * @param tipoServicio El tipo de servicio solicitado (transporte o mensajería).
     * @param equipaje     La cantidad de equipaje.
     * @param cantPax      La cantidad de pasajeros.
     * @param distancia    La distancia del viaje.
     * @param fecha        La fecha del viaje.
     * @throws ExceptionPedido    Si algun parametro del pedido es invalido.
     * @throws ExceptionVehiculoDisp Si no hay vehiculos disponibles para el pedido.
     */
    public void pedirViaje(Cliente cliente, String zona, int mascota, String tipoServicio, int equipaje, int cantPax, double distancia, LocalDateTime fecha)
    		throws ExceptionPedido,ExceptionVehiculoDisp
    {
        assert cliente != null : "Fallo pre: El cliente no puede ser nulo";
        assert zona != null && !zona.isEmpty() : "Fallo pre: La zona no puede ser nula o vacía";
        assert tipoServicio != null && !tipoServicio.isEmpty() : "Fallo pre: El tipo de servicio no puede ser nulo o vacío";
        assert cantPax >= 0 : "Fallo pre: La cantidad de pasajeros debe ser un número positivo";
        assert distancia > 0 : "Fallo pre: La distancia del viaje debe ser un número positivo";
        assert fecha != null : "Fallo pre: La fecha no puede ser nula";
    	
    	Pedido pedidoNuevo;

        
    	pedidoNuevo = this.generarPedido(cliente, zona, mascota, tipoServicio, equipaje, cantPax, fecha);
    	IViaje viajeNuevo = viajeFactory.getViaje(pedidoNuevo, distancia);
		addViaje(viajeNuevo);
    }
    
   

    /**
     * Genera un viaje a partir de un pedido y una distancia especificados (Random).<br>
     * <b>PRE:</b> El parametro pedido no deber ser nulo, y distancia debe ser mayor a cero.<br>
     * @param pedido     El pedido del viaje.
     * @param distancia  La distancia del viaje.
     * @throws ExceptionChoferDisp Si no hay Choferes disponibles para conducir el viaje.
     */
    /*ESTA ES LA VERSION VIEJA
    private void generarViaje(Pedido pedido, double distancia) throws ExceptionChoferDisp
	{
    	assert pedido!=null:"Fallo pre: El pedido no puede ser null";
    	assert distancia>0:"Fallo pre: La distancia no puede ser negativa";
    	
		Vehiculo vehiculo;
		Chofer chofer;

		IViaje viajeNuevo = viajeFactory.getViaje(pedido, distancia);
		addViaje(viajeNuevo); 

		vehiculo = this.buscarVehiculo(pedido);
		vehiculo.setOcupado(true);
		
		chofer = this.buscarChofer();
		chofer.setOcupado(true);
		
		viajeNuevo.setChofer(chofer);
		viajeNuevo.setVehiculo(vehiculo);
		viajeNuevo.setEstado(EstadosViajes.INICIADO);   
	}
    */
    
    
    
    
    /**
     * Busca el vehículo con mayor prioridad para el pedido especificado, cuyos atributos estan todos validados.<br>
     * <b>PRE: </b> El viaje es distinto de null<br>
     */
	public boolean asignarVehiculo(IViaje viaje) 
	{
		assert viaje!=null:"Fallo pre: El pedido no puede ser null";
		
		Vehiculo vehiculoElegido = null;
		Vehiculo vehiculo = null;
		Integer maxPrioridad = 0,prioridad=0;
		ArrayList<Vehiculo> vehiculoLista = empresa.getVehiculoLista();

		for (int i = 0; i < vehiculoLista.size(); i++)
		{
			vehiculo = vehiculoLista.get(i);
			prioridad = vehiculo.getPrioridad(viaje.getPedido());
			
			if(prioridad != null && !vehiculo.isOcupado())
				if (Integer.compare(maxPrioridad, prioridad) < 0) 
				{
					maxPrioridad = prioridad;
					vehiculoElegido = vehiculo;
				}
		}

		if(vehiculoElegido != null)
		{
			viaje.setVehiculo(vehiculoElegido);
			viaje.setEstado(EstadosViajes.CONVEHICULO);
			vehiculoElegido.setOcupado(true);
			return true;
		}
		else
			return false;
             
	}

	/**
     * Busca un Chofer disponible para conducir un viaje en estado solicitado que ya tie
     * @param chofer vehiculo asignado.<br>
     */
	public void asignarChofer(Chofer chofer)
	{
		int i = viajeLista.size() - 1;

		while(viajeLista.get(i).getEstado() != EstadosViajes.CONVEHICULO)
			i--;

		viajeLista.get(i).setChofer(chofer);
		viajeLista.get(i).setEstado(EstadosViajes.INICIADO);
		chofer.setOcupado(true);
                
	}
	
	/**
     * Realiza el pago de un viaje pendiente para un cliente especificado.<br>
     * <b>PRE: </b> El cliente es distinto de null<br>
     * <b>POST: </b> El viaje cambia su estado a pago<br>
     * @param cliente El cliente que realiza el pago.
     * @throws ExceptionSinViajeaPagar Si no hay ningun viaje pendiente para el cliente especificado.
     */
	public void pagarViaje(Cliente cliente) throws ExceptionSinViajeaPagar
	{
		assert cliente!=null:"Fallo pre: El cliente no puede ser null";
		
		IViaje viajePendiente =  buscarViaje(cliente,EstadosViajes.INICIADO);
		
		if(viajePendiente != null)
			viajePendiente.setEstado(EstadosViajes.PAGO);
		else
			throw new ExceptionSinViajeaPagar();
		
		assert viajePendiente.getEstado()==EstadosViajes.PAGO:"Fallo post: El viaje no cambio su estado a pago";
	}
	
	/**
     * Busca un viaje pendiente para un cliente especificado.<br>
     * <b>PRE: </b> El cliente es distinto de null<br>
     * @param cliente El cliente para el cual se busca el viaje pendiente.
     * @return El viaje pendiente del cliente especificado.
     * @throws ExceptionSinViajeaPagar Si no hay ningun viaje pendiente para el cliente especificado.
     */
	private IViaje buscarViaje(Cliente cliente, EstadosViajes estado) 
	{
		assert cliente!=null:"Fallo pre: El cliente debe ser distinto de null";
		
		IViaje viajePendiente;
		int i = viajeLista.size() - 1;
		
		while (i >= 0 && viajeLista.get(i).getCliente() != cliente)
		{
			i--;
		}

		if (i == -1) 
		{
			return null;
		} 
		
		viajePendiente = viajeLista.get(i);
		if (viajePendiente.getEstado() != estado)
		{
		  return null;
			
		} else {
			return viajePendiente;
		}

	}
	
	/**
     * Finaliza un viaje asignado a un Chofer especificado.<br>
     * <b>PRE: </b> El chofer es distinto de null<br>
     * <b>POST: </b> El viaje cambia su estado a finalizado<br>
     * @param chofer El Chofer que finaliza el viaje.
     * @throws ExceptionChoferSinViajesPagos Si el Chofer no tiene ningun viaje pendiente de pago.
     */
	public void finalizarViaje(Chofer chofer) throws ExceptionChoferSinViajesPagos
	{
		assert chofer!=null:"Fallo pre: EL chofer que finaliza viaje no puede ser null";
		
		ArrayList<Chofer> choferLista = empresa.getChoferLista();
		ArrayList<Vehiculo> vehiculoLista = empresa.getVehiculoLista();
		Vehiculo vehiculo = null;		
		IViaje viaje = null;
		
		int i=viajeLista.size()-1;
		
		while(i>=0 && viajeLista.get(i).getChofer() != chofer)
		{
			i--;
		}
		
		if(i<viajeLista.size())
		{
			viaje = viajeLista.get(i);
			viaje.setEstado(EstadosViajes.FINALIZADO);
			vehiculo = viaje.getVehiculo();
			
			chofer.setOcupado(false);
			vehiculo.setOcupado(false);
			
			assert viaje.getEstado()==EstadosViajes.FINALIZADO:"Fallo post: El viaje no fue finalizado";
		}
		else
			throw new ExceptionChoferSinViajesPagos();		
	}

	
	/**
     * Califica a un chofer por un cliente luego de finalizar un viaje.<br>
     * <b>PRE: </b> La calificacion es mayor que 0 y menor que 10, el cliente es distinto de null<br>
     * <b>POST: </b> El viaje adquiere una calificacion<br>
     * @param cliente     El cliente que califica al chofer.
     * @param calificacion La calificación asignada al chofer.
     * @throws ExceptionClienteSinViajesPagos Si el cliente no tiene ningún viaje pendiente de pago.
     */
	public void calificarChofer(Cliente cliente, int calificacion) throws ExceptionClienteSinViajesPagos
	{
		assert cliente!=null:"Fallo pre: EL cliente que califica no puede ser null";
		assert (calificacion >0 && calificacion <=10):"Fallo pre: La calificacion no puede ser negativa ni mayor a 10";
		
		IViaje viajePagoOFinalizado = buscarViaje(cliente,EstadosViajes.PAGO);
		
	    if(viajePagoOFinalizado == null)
	    	viajePagoOFinalizado = buscarViaje(cliente,EstadosViajes.FINALIZADO);
		
		if(viajePagoOFinalizado != null)
			viajePagoOFinalizado.setCalificacionChofer(calificacion);
		else
			throw new ExceptionClienteSinViajesPagos();
		
		assert viajePagoOFinalizado.getCalificacionChofer()!=0:"Fallo post: El viaje no fue calificado";
	}
	
	//invariantes
	
	/**
	 * Permite evaluar el invariante de lista de viajes<br>
	 * @return  true si la lista es distinta de null, false en caso contrario
	 */
	public boolean invarianteListaViajes()
	{
		return this.viajeLista!=null;
	}
	

}
