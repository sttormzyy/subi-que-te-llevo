package sistema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import choferes.Chofer;
import excepciones.chofer.ExceptionChofer;
import excepciones.chofer.ExceptionChoferInexistente;
import excepciones.chofer.ExceptionChoferNull;
import excepciones.pedido.ExceptionFecha;
import excepciones.pedido.ExceptionPedido;
import excepciones.pedido.ExceptionVehiculoDisp;
import excepciones.pedido.ExceptionZona;
import excepciones.usuario.ExceptionUsuario;
import excepciones.usuario.ExceptionUsuarioInexistente;
import excepciones.usuario.ExceptionUsuarioNull;
import excepciones.vehiculo.ExceptionVehiculo;
import excepciones.vehiculo.ExceptionVehiculoNull;
import excepciones.viaje.ExceptionChoferDisp;
import excepciones.viaje.ExceptionChoferSinViajesPagos;
import excepciones.viaje.ExceptionClienteSinViajesPagos;
import excepciones.viaje.ExceptionSinViajeaPagar;
import usuarios.Cliente;
import usuarios.Usuario;
import vehiculos.Vehiculo;
import viajes.IViaje;

/**
 * Clase que representa la Empresa, gestiona las operaciones y delegaciones relacionadas con el Subsistema Administrador de clientes,
 *  choferes y vehiculos, y el Subsistema de gestion de viajes. Implementa Patron Singleton.
 */
public class Empresa {
	private static Empresa empresa;
	private Usuario admin = null;
	/**
	 * Atributo al cual Empresa delega las funcionalidades tipicas del administrador
	 */
	private static AdmSubSistema admSubSistema = new AdmSubSistema();
	/**
	 * Atributo al cual Empresa delega las funcionalidades referidas al tratamiento de viajes y funcionalidades del cliente
	 */
	private static ViajesSubSistema viajesSubSistema = new ViajesSubSistema();
	
	private Empresa() {
		
	}
	
	/**
     * Obtiene una instancia unica de la clase Empresa.<br>
     * @return La instancia única de la clase Empresa.
     */
	public static Empresa getInstance()
	{
		if (empresa == null) {
			empresa = new Empresa();
		}
		return empresa;
	}

// COMIENZO funcionalidades del sistema relacionadas con el SubSistema Administrador
	
	/**
     * Agrega el usuario Administrador de la Empresa.<br>
     * *<b>POST: </b> Se añade un admin a la empresa si esta ya no contaba con uno<br>
     * @param admin  El Administrador a agregar.
     * @throws ExceptionUsuario Si el Administrador ya ha sido definido anteriormente.
     */
	public void addAdmin(Usuario admin) throws ExceptionUsuario
	{
		if(admin!=null)
		{
			if(this.admin == null)
				this.admin=admin;
			else
				throw new ExceptionUsuario("la empresa ya tiene admin");
		}else
			throw new ExceptionUsuarioNull();
	}

	/**
     * Obtiene el Administrador de la Empresa.<br>
     * @return El Administrador de la Empresa.
     */
	public Usuario getAdmin()
	{
		return this.admin;
	}
	
	/**
     * Obtiene el Subsistema de Administracion.<br>
     * @return El Subsistema de Administracion.
     */
	public static AdmSubSistema getAdmSubSys() {
		return admSubSistema;
	}
	
//Altas:
	
	/**
     * Solicita al SubSistema Administrador agregar un chofer a la Empresa.<br>
     * <b>POST: </b> Se añade un chofer a la coleccion de choferes<br>
     * @param chofer  El chofer a agregar.
     * @throws ExceptionChofer Si el chofer ya ha sido agregado anteriormente o si es null.
     */
	public void addChofer(Chofer chofer) throws ExceptionChofer
	{
		if(chofer != null)
			admSubSistema.addChofer(chofer);
		else
			throw new ExceptionChoferNull();
	}
	
	/**
     * Solicita al SubSistema Administrador agregar un cliente a la Empresa.<br>
     * <b>POST: </b> Se añade un usuario a la coleccion de usuarios<br>
     * @param usuario El cliente a agregar.
     * @throws ExceptionUsuario Si el cliente ya ha sido agregado anteriormente o  es null.
     */
	public void addCliente(Usuario usuario) throws ExceptionUsuario
	{
		if(usuario != null)
			admSubSistema.addCliente(usuario);
		else
			throw new ExceptionUsuarioNull();
	}
	
	/**
     * Solicita al SubSistema Administrador agregar un vehiculo a la Empresa.<br>
     * <b>POST: </b> Se añade un vehiculo a la coleccion de vehiculos<br>
     * @param vehiculo El vehiculo a agregar.
     * @throws ExceptionVehiculo Si el vehiculo ya ha sido agregado anteriormente o es null.
     */
	public void addVehiculo(Vehiculo vehiculo) throws  ExceptionVehiculo
	{
		if(vehiculo != null)
			admSubSistema.addVehiculo(vehiculo);
		else
			throw new ExceptionVehiculoNull();
	}
	
//Modificar:
	
	/**
     * Valida y delega la modificacion de los datos de un cliente en la Empresa.<br>
     * <b>POST: </b>Si los parametros son validos y el cliente existe, este actualiza su estado<br>
     * @param nombreUsuario       El nombre de usuario del cliente a modificar.
     * @param nombreUsuarioNuevo  El nuevo nombre de usuario.
     * @param nombreReal          El nuevo nombre real del cliente.
     * @param contrasena          La nueva contraseña del cliente.
     * @throws ExceptionUsuario Si el cliente a modificar no existe.
     */
	public void modificarCliente(String nombreUsuario, String nombreUsuarioNuevo, String nombreReal, String contrasena) throws ExceptionUsuario
	{
		if(nombreUsuario != null)
			if(admSubSistema.getUsuarioMap().containsKey(nombreUsuario))
				admSubSistema.modificarCliente(nombreUsuario, nombreUsuarioNuevo, nombreReal, contrasena);
			else
				throw new  ExceptionUsuarioInexistente(nombreUsuarioNuevo);
		else
			throw new ExceptionUsuarioNull();
	}
	
	/**
     * Valida y delega la modificacion de los datos de un Chofer Permanente de la Empresa.<br>
     *<b>POST: </b>Si los parametros son validos y el chofer existe, este actualiza su estado<br>
     * @param dni           El DNI del Chofer a modificar.
     * @param nombre        El nuevo nombre del Chofer.
     * @param cantHijos     La nueva cantidad de hijos del Chofer.
     * @param fechaIngreso  La nueva fecha de ingreso del Chofer.
     * @throws ExceptionChofer  Si el chofer a modificar no existe o se ingreso Null.
     */
	public void modificarChofer(String dni, String nombre, int cantHijos, LocalDateTime fechaIngreso) throws ExceptionChofer
	{
		if(dni != null && dni != "")
			admSubSistema.modificarChofer(dni, nombre, cantHijos, fechaIngreso);
		else
			throw new ExceptionChoferNull();
	}
	
	/**
     * Valida y delega la modificacion de los datos de un Chofer Temporal o Contratado de la Empresa.<br>
     * <b>POST: </b>Si los parametros son validos y el chofer existe, este actualiza su estado<br>
     * @param dni     El DNI del Chofer a modificar.
     * @param nombre  El nuevo nombre del Chofer.
     * @throws ExceptionChofer Si el Chofer a modificar no existe o se ingreso Null.
     */
	public void modificarChofer(String dni, String nombre) throws ExceptionChofer 
	{
		if(dni != null && dni != "")
			admSubSistema.modificarChofer(dni, nombre);
		else
			throw new ExceptionChoferNull();
	}
	
//Consultas:
	
	/**
     * Consulta al SubSistema Administrador los datos de un cliente en la Empresa.<br>
     * @param nombreUsuario  El nombre de usuario del cliente a consultar.
     * @return Los datos del cliente consultado en formato cadena.
     * @throws ExceptionUsuario Si el cliente a consultar no existe o se ingreso Null.
     */
	public String consultarCliente(String nombreUsuario) throws ExceptionUsuario {
		if(nombreUsuario != null && nombreUsuario!= "")
			return admSubSistema.consultarCliente(nombreUsuario);
		else
			throw new ExceptionUsuarioNull();
	}
	
	 /**
     * Solicita al SubSistema Administrador un cliente de la Empresa.<br>
     * @param nombreUsuario  El nombre de usuario del cliente a obtener.
     * @return El cliente correspondiente al nombre de usuario especificado.
     * @throws ExceptionUsuario Si el cliente a obtener no existe o se ingreso null.
     */
	public Cliente getCliente(String nombreUsuario) throws ExceptionUsuario {
		if(nombreUsuario != null && nombreUsuario!= "")
			return admSubSistema.getCliente(nombreUsuario);
		else
			throw new ExceptionUsuarioNull();
	}
	
	/**
     * Consulta al SubSistema Administrador los datos de un chofer en la Empresa.<br>
     * @param dni  El DNI del chofer a consultar.
     * @return Los datos del chofer consultado en formato cadena.
     * @throws ExceptionChofer Si el chofer a consultar no existe o se ingreso null.
     */
	public String consultarChofer(String dni) throws ExceptionChofer{
		if(dni != null && dni != "")
			return admSubSistema.consultarChofer(dni);
		else
			throw new ExceptionChoferNull();
	}

	/**
     * Solicita al SubSistema Administrador un chofer de la Empresa.<br>
     * @param dni  El DNI del chofer a obtener.
     * @return El chofer correspondiente al DNI especificado.
     * @throws ExceptionChofer Si el chofer a obtener no existe o se ingreso null.
     */
	public Chofer getChofer(String dni) throws ExceptionChofer{
		if(dni != null && dni != "")
			return admSubSistema.getChofer(dni);
		else
			throw new ExceptionChoferNull();
	}

	/**
     * Consulta al SubSistema Administrador los datos de un vehiculo en la Empresa.<br>
     * @param patente  La patente del vehiculo a consultar.
     * @return Los datos del vehiculo consultado.
     * @throws ExceptionVehiculo Si el vehiculo a consultar no existe o se ingreso Null.
     */
	public String consultarVehiculo(String patente) throws  ExceptionVehiculo{
		if(patente!=null && patente!="")
			return admSubSistema.consultarVehiculo(patente);
		else
			throw new ExceptionVehiculoNull();
	}
	
	/**
     * Solicita al SubSistema Administrador un vehículo de la Empresa.<br>
     * @param patente  La patente del vehículo a obtener.
     * @return El vehículo correspondiente a la patente especificada.
     * @throws ExceptionVehiculo Si el vehículo a obtener no existe o se ingreso null.
     */
	public Vehiculo getVehiculo(String patente) throws  ExceptionVehiculo{
		if(patente!=null && patente!="")
			return admSubSistema.getVehiculo(patente);
		else
			throw new ExceptionVehiculoNull();
	}
	
//Solicitud de listados de clientes, choferes y vehículos:
	
	/**
     * Solicita al SubSistema Administrador el listado de clientes en la Empresa en formato cadena.<br>
     * @return El listado de clientes.
     */
	public String solicitudListadoClientes()
	{
		return admSubSistema.solicitudListadoClientes();
	}
	
	/**
     * Solicita al SubSistema Administrador el listado de Choferes en la Empresa en formato cadena.<br>
     * @return El listado de Choferes.
     */
	public String solicitudListadoChoferes()
	{
		return admSubSistema.solicitudListadoChoferes();
	}
	
	/**
     * Solicita al SubSistema Administrador el listado de vehiculos en la Empresa en formato cadena.<br>
     * @return El listado de Choferes.
     */
	public String solicitudListadoVehiculos()
	{
		return admSubSistema.solicitudListadoVehiculos();
	}	
	
	/**
     * Solicita al SubSistema de Viajes el listado de viajes en la Empresa en formato cadena.<br>
     * @return El listado de Choferes.
     */
	public String solicitudListadoViajes()
	 {
		 return admSubSistema.solicitudListadoViajes();
	 }
	
//Cálculo de salarios mensuales de cada Chofer. Esto incluye el dinero que reciben los choferes contratados:
	
	/**
     * Solicita al SubSistema Administrador generar un reporte de los salarios de todos los Choferes en un mes especifico en formato cadena.<br>
     * @param fecha  La fecha correspondiente al mes del reporte.
     * @return El reporte de salarios de los Choferes.
     * @throws ExceptionFecha Si la fecha especificada es invalida.
     */
	public String reporteSalariosChoferes(LocalDateTime fecha)  throws ExceptionFecha
	{
		if( LocalDateTime.now().isEqual(fecha)||LocalDateTime.now().isBefore(fecha))
			return admSubSistema.reporteSalariosChoferes(fecha);
		else
			throw new ExceptionFecha(fecha);
	}

//Cálculo del total de dinero necesario para pagar los salarios.
	
	/**
     * Solicita al SubSistema Administrador el monto total de dinero necesarios para pagar un mes especifico de salarios.<br>
     * @param fecha  La fecha correspondiente al mes del calculo.
     * @return El total de dinero necesarios para pagar los salarios del mes especificado.
     * @throws ExceptionFecha Si la fecha especificada es invalida.
     */
	public String getTotalSalarios(LocalDateTime fecha) throws ExceptionFecha
	{
		if(LocalDateTime.now().isEqual(fecha)||LocalDateTime.now().isBefore(fecha))
			return admSubSistema.getTotalSalarios(fecha);
		else
			throw new ExceptionFecha(fecha);
	}

//Reportes varios:

	/**
     * Solicita al SubSistema Administrador los viajes de un chofer en un periodo especifico.<br>
     * @param dni         El DNI del chofer.
     * @param fechaInf    La fecha de inicio del periodo.
     * @param fechaSup    La fecha de fin del periodo.
     * @return Los viajes del chofer en el periodo especificado.
     * @throws ExceptionChofer Si el Chofer no existe o el DNI ingresado es Null.
     * @throws ExceptionFecha  Si las fechas especificadas son invalidas.
     */
	 public ArrayList<IViaje> getViajesChoferPeriodo(String dni,LocalDateTime fechaInf, LocalDateTime fechaSup) 
			 throws ExceptionChofer,ExceptionFecha
	 {
		 if(dni != null && dni!="")
		 {
			 if(fechaInf == null)
				 throw new ExceptionFecha("Fecha inferior null");
			 
			 if(fechaSup == null)
				 throw new ExceptionFecha("Fecha superior null");
			 
			 if(fechaInf.isAfter(fechaSup))
				 throw new ExceptionFecha("Fecha inferior esta despues de la superior",fechaInf,fechaSup);
				 
			 Chofer chofer = buscarChofer(dni);
		 
			 if(chofer != null)
				 return admSubSistema.getViajesChoferPeriodo(chofer, fechaInf,fechaSup);
			 else
				 throw new ExceptionChoferInexistente(dni);

		 }			 
		 else
			 throw new ExceptionChoferNull();
	 }
	 
	 /**
	  * Solicita al SubSistema Administrador generar un reporte de los viajes de un Chofer en un periodo especifico.<br>
	  * @param dni         El DNI del Chofer.
	  * @param fechaInf    La fecha de inicio del periodo.
	  * @param fechaSup    La fecha de fin del periodo.
	  * @return El reporte de los viajes del Chofer en el periodo especificado.
	  * @throws ExceptionChofer Si el Chofer no existe.
	  * @throws ExceptionFecha  Si las fechas especificadas son invalidas.
	  */
	 public String reporteViajesChoferPeriodo(String dni,LocalDateTime fechaInf, LocalDateTime fechaSup) 
			 throws ExceptionChofer,ExceptionFecha
	 {
		 if(dni != null && dni!="")
		 {
			 if(fechaInf == null)
				 throw new ExceptionFecha("Fecha inferior null");

			 if(fechaSup == null)
				 throw new ExceptionFecha("Fecha superior null");

			 if(fechaInf.isAfter(fechaSup))
				 throw new ExceptionFecha("Fecha inferior esta despues de la superior",fechaInf,fechaSup);

			 Chofer chofer = buscarChofer(dni);

			 if(chofer != null)
				 return admSubSistema.reporteViajesChoferPeriodo(chofer, fechaInf,fechaSup);
			 else
				 throw new ExceptionChoferInexistente(dni);
		 }
		 else
			 throw new ExceptionChoferNull();

	 }
	 
	 /**
	  * Solicita al SubSistema Administrador un ArrayList de IViaje de los viajes de un cliente en un periodo especifico.<br>
	  * @param nombreUsuario  El nombre de usuario del cliente.
	  * @param fechaInf       La fecha de inicio del periodo.
	  * @param fechaSup       La fecha de fin del periodo.
	  * @return Los viajes del cliente en el periodo especificado.
	  * @throws ExceptionUsuario Si el cliente no existe o se ingreso Null.
	  * @throws ExceptionFecha  Si las fechas especificadas son invalidas.
	  */
	 public ArrayList<IViaje> getViajesClientePeriodo(String nombreUsuario, LocalDateTime fechaInf, LocalDateTime fechaSup)
			 throws ExceptionUsuario,ExceptionFecha
	 {
		 Cliente cliente = getCliente(nombreUsuario);
		
		 if(fechaInf == null)
			 throw new ExceptionFecha("Fecha inferior null");

		 if(fechaSup == null)
			 throw new ExceptionFecha("Fecha superior null");

		 if(fechaInf.isAfter(fechaSup))
			 throw new ExceptionFecha("Fecha inferior esta despues de la superior",fechaInf,fechaSup);
		 return admSubSistema.getViajesClientePeriodo(cliente,fechaInf, fechaSup);
	 }
	
	 /**
	  * Solicita al SubSistema Administrador generar un reporte de los viajes de un cliente en un periodo especifico.<br>
	  * @param nombreUsuario  El nombre de usuario del cliente.
	  * @param fechaInf       La fecha de inicio del periodo.
	  * @param fechaSup       La fecha de fin del periodo.
	  * @return El reporte de los viajes del cliente en el periodo especificado.
	  * @throws ExceptionUsuario Si el cliente no existe o se ingreso Null.
	  * @throws ExceptionFecha  Si las fechas especificadas son invalidas.
	  */
	 public String reporteViajesClientePeriodo(String nombreUsuario, LocalDateTime fechaInf, LocalDateTime fechaSup) 
			 throws ExceptionUsuario,ExceptionFecha
	 {
		 Cliente cliente = getCliente(nombreUsuario);
		 
		 if(fechaInf == null)
			 throw new ExceptionFecha("Fecha inferior null");

		 if(fechaSup == null)
			 throw new ExceptionFecha("Fecha superior null");

		 if(fechaInf.isAfter(fechaSup))
			 throw new ExceptionFecha("Fecha inferior esta despues de la superior",fechaInf,fechaSup);
		 return admSubSistema.reporteViajesClientePeriodo(cliente,fechaInf, fechaSup);
	 }
	 
//Getters
	 
	 /**
	  * Solicita al SubSistema Administrador la lista de usuarios en la Empresa.<br>
	  * @return La lista de usuarios.
	  */
	 public ArrayList<Usuario> getUsuarioLista(){
		 return admSubSistema.getUsuarioLista();
	 }

	 /**
	  * Solicita al SubSistema Administrador el mapa de usuarios en la Empresa.<br>
	  * @return El mapa de usuarios.
	  */
	 public HashMap<String, Usuario> getUsuarioMap() {
		 return admSubSistema.getUsuarioMap();
	 }

	 /**
	  * Solicita al SubSistema Administrador la lista de vehiculos en la Empresa.<br>
	  * @return La lista de vehiculos.
	  */
	 public ArrayList<Vehiculo> getVehiculoLista(){
		 return admSubSistema.getVehiculoLista();
	 }

	 /**
	  * Solicita al SubSistema Administrador la lista de Choferes en la Empresa.<br>
	  * @return La lista de Choferes.
	  */
	 public ArrayList<Chofer> getChoferLista() {
		 return admSubSistema.getChoferLista();
	 }
	    
//FIN funcionalidades de la empresa relacionadas al SubSistema Administrador	
	
	
	
//COMIENZO funcionalidades Subsistema de Viajes

	 /**
	  * Obtiene la lista de viajes en el subsistema de viajes.
	  * @return La lista de viajes.
	  */
	public ArrayList<IViaje> getViajeLista()
	{
		return viajesSubSistema.getViajeLista();
	}
	
	/**
     * Realiza la solicitud de un viaje en el subsistema de viajes.<br>
     * <b>POST: </b> Si los datos resultan validos (todos distintos de null en caso de objetos o mayor a 0 en caso de primitivos), se delega la evaluacion de un pedido a ViajesSubSistema<br>
     * @param nombreUsuario El nombre de usuario del cliente que solicita el viaje.
     * @param zona           La zona de destino del viaje.
     * @param mascota        Indica si el viaje incluye mascota.
     * @param tipoServicio   El tipo de servicio del viaje.
     * @param equipaje       El numero de equipajes del viaje.
     * @param cantPax        La cantidad de pasajeros del viaje.
     * @param distancia      La distancia del viaje.
     * @param fecha          La fecha del viaje.
     * @throws ExceptionPedido        Si ocurre un error al realizar el Pedido del viaje.
     * @throws ExceptionVehiculoDisp  Si no hay vehiculos disponibles para el viaje.
     * @throws ExceptionChoferDisp    Si no hay Choferes disponibles para el viaje.
     * @throws ExceptionUsuario       Si el cliente que solicita el viaje no existe.
     */
	public void pedirViaje(String nombreUsuario,String zona, int mascota, String tipoServicio, int equipaje, int cantPax, double distancia, LocalDateTime fecha)
			throws ExceptionPedido,ExceptionVehiculoDisp,ExceptionChoferDisp,ExceptionUsuario
	{
		Cliente cliente = getCliente(nombreUsuario);
		
		if(cantPax<0 || distancia <0)
			if(cantPax<0)
				throw new IllegalArgumentException("La cantidad de pasajeros debe ser positiva");
			else
				throw new IllegalArgumentException("La distancia debe ser positiva");
		
		if(fecha == null)
			throw new ExceptionFecha();
		
		if(nombreUsuario == null)
			throw new ExceptionUsuarioNull();
		
		if(zona == null)
			throw new ExceptionZona(zona);
		
		viajesSubSistema.pedirViaje(cliente,zona, mascota, tipoServicio, equipaje, cantPax, distancia, fecha);	
	}

	/**
     * Realiza el pago de un viaje en el Subsistema de Viajes.<br>
     * <b>POST: </b> Si el cliente tenia un viaje iniciado, este cambia su estado a pago<br>
     * @param nombreUsuario  El nombre de usuario del cliente que realiza el pago.
     * @throws ExceptionSinViajeaPagar Si no hay ningun viaje pendiente de pago para el cliente.
     * @throws ExceptionUsuario        Si el cliente que realiza el pago no existe.
     */
	public void pagarViaje(String nombreUsuario) throws ExceptionSinViajeaPagar,ExceptionUsuario
	{
		Cliente cliente = getCliente(nombreUsuario);

		viajesSubSistema.pagarViaje(cliente);

	}
	
	/**
     * Califica a un Chofer por un viaje en el Subsistema de Viajes.<br>
     * <b>POST: </b> Si el cliente tenia un viaje pago, el mismo adquiere una calificacion del chofer<br>
     * @param nombreUsuario  El nombre de usuario del cliente que califica al Chofer.
     * @param calificacion   La calificación otorgada al Chofer.
     * @throws ExceptionClienteSinViajesPagos Si el cliente no tiene viajes pagados para calificar.
     * @throws ExceptionUsuario              Si el cliente que realiza la calificación no existe.
     */
	public void calificarChofer(String nombreUsuario, int calificacion) throws  ExceptionClienteSinViajesPagos,ExceptionUsuario
	{
		Cliente cliente = getCliente(nombreUsuario);
		
		if(calificacion < 0 && calificacion <=10)
			viajesSubSistema.calificarChofer(cliente,calificacion);
		else
			throw new IllegalArgumentException("La calificacion no puede ser negativa ni mayor a 10");
	}
	
	/**
     * Finaliza los viajes de un chofer en el Subsistema de Viajes.<br>
     * <b>POST: </b> Si el chofer tenia un viaje pago, este cambia su estado a finalizado y se liberan el chofer y el vehiculo asociados a ese viaje<br>
     * @param dni  El DNI del chofer.
     * @throws ExceptionChofer               Si el chofer no existe.
     * @throws ExceptionChoferSinViajesPagos Si el chofer no tiene viajes pagados para finalizar.
     */
    public void finalizarViaje(String dni) throws ExceptionChofer, ExceptionChoferSinViajesPagos
    {
    	if(dni!=null && dni!="")
    	{
    		Chofer chofer = buscarChofer(dni);

    		if(chofer!=null)
    			viajesSubSistema.finalizarViaje(chofer);
    		else
    			throw new  ExceptionChoferInexistente(dni);
    	}
    	else
    		throw new ExceptionChoferNull();
	}
    
// FIN funcionalidades subsistema de viajes

    
    
// COMIENZO funcionalidades generales de la empresa que no estan relacionadas con otras como para crear un susbsistema aparte
    
    /**
     * Solicita al SubSistema Administrador buscar un Chofer en la empresa.<br>
     * <b>PRE:</b> El DNI es distinto de null<br>
     * @param dni  El DNI del Chofer a buscar.
     * @return El Chofer correspondiente al DNI especificado.
     */
    private Chofer buscarChofer(String dni)
    {
    	int i=0;
    	ArrayList<Chofer> choferLista = admSubSistema.getChoferLista();
		   
    	while(i<choferLista.size() && choferLista.get(i).getDni()!=dni)
		{
    		i++;
		}
		   
		if(i<choferLista.size())
			return choferLista.get(i);
		else
			return null;
    	
    }

    /**
     * Solicita al SubSistema Administrador actualizar el puntaje de los Choferes en un mes específico.<br>
     *<b>POST: </b> Si el mes ingresado fue valido, los choferes tendran actualizados sus puntajes<br>
     * @param mes: El número de mes.
     * @throws ExceptionFecha Si el número de mes es invalido.
     */
	public void actualizarPuntaje(int mes) throws ExceptionFecha
	{
		if(mes>0 &&  mes<=12)
			admSubSistema.actualizarPuntaje(mes);
		else
			throw new ExceptionFecha(mes);
	}
	
	/**
     * Solicita al SubSistema Administrador el recaudo contratado por un Chofer en una fecha especifica.<br>
     * @param chofer  El Chofer para el cual se calcula el recaudo.
     * @param fecha   La fecha para la cual se calcula el recaudo.
     * @return El recaudo contratado por el Chofer en la fecha especificada.
     */
	public double getRecaudoContratado(Chofer chofer, LocalDateTime fecha) 
	{
		return admSubSistema.getRecaudoContratado(chofer, fecha);
	}
	
	/**
     * Solicita al SubSistema Administrador la cantidad de viajes temporales realizados por un Chofer en una fecha especifica.<br>
     * @param chofer  El Chofer para el cual se calcula la cantidad de viajes temporales.
     * @param fecha   La fecha para la cual se calcula la cantidad de viajes temporales.
     * @return La cantidad de viajes temporales realizados por el Chofer en la fecha especificada.
     */
	public double getCantidadViajesTemp(Chofer chofer, LocalDateTime fecha) 
	{
		return admSubSistema.getCantidadViajesTemp(chofer, fecha);
	}
	
// FIN funcionalidades generales de la empresa que no estan relacionadas con otras como para crear un susbsistema aparte
	 	 
// Invariantes
	
	public boolean invarianteListaViajes()
    {
        return  viajesSubSistema.invarianteListaViajes();
    }
}
