package sistema;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import choferes.Chofer;
import choferes.ChoferPermanente;
import excepciones.chofer.ExceptionChoferInexistente;
import excepciones.chofer.ExceptionDNIrepetido;
import excepciones.usuario.ExceptionUsuarioInexistente;
import excepciones.usuario.ExceptionUsuarioRepetido;
import excepciones.vehiculo.ExceptionPatenteInexistente;
import excepciones.vehiculo.ExceptionPatenteRepetida;
import usuarios.Cliente;
import usuarios.Usuario;
import vehiculos.Vehiculo;
import viajes.IViaje;

/**
 * El subsistema Administrador de la empresa, responsable de la gestion de clientes, choferes y vehiculos, así como la solicitud de listados y reportes, 
 * el calculo de salarios y otros metodos auxiliares.
 */
public class AdmSubSistema implements Serializable{
    private Empresa empresa = Empresa.getInstance(); 
    /**
     * Coleccion de Usuarios de la empresa, se utiliza HashMap cuyas claves son los nombre de usuario debido a que estos no pueden repetirse
     */
    private HashMap<String, Usuario> usuarioMap = new HashMap<String, Usuario>();
    /**
     * Coleccion de Choferes de la empresa, nuclea choferes de cualquier tipo de vinculacion laboral
     */
	private ArrayList<Chofer> choferLista = new ArrayList<Chofer>();
	/**
	 * Coleccion de Vehiculos de la empresa, nuclea vehiculos de todo tipo
	 */
	private ArrayList<Vehiculo> vehiculoLista = new ArrayList<Vehiculo>();
	
	
	
//Gestión de clientes, choferes y vehículos: 
    
    //Altas:

	/**
     * Agrega un cliente al sistema (UsuarioMap).<br>
     * <b>PRE: </b> El usuario es distinto de Null.<br>
     * <b>POST: </b> Se añade un usuario a la coleccion de usuarios.<br>
     * @param usuario  El usuario a agregar como cliente.
     * @throws ExceptionUsuarioRepetido si el nombre de usuario ya esta registrado en el sistema.
     */
	public void addCliente(Usuario usuario) throws ExceptionUsuarioRepetido
	{
		assert usuario != null : "Fallo Pre: El usuario no puede ser Null ";
		int cantidadElementos = usuarioMap.size(); 
		
		if (usuarioMap.containsKey(usuario.getNombreUsuario()))
		{
			throw new ExceptionUsuarioRepetido(usuario.getNombreUsuario());
		}
        else
            usuarioMap.put(usuario.getNombreUsuario(), usuario);
		
		assert usuarioMap.size() == cantidadElementos + 1 : "Fallo Post: Cambios sin efecto en usuarioMap";
		assert invarianteUsuarioMap() : "Fallo Invariante: UsuarioMap Null";
	}

	/**
     * Agrega un Chofer al sistema (ChoferLista).<br>
     * <b>PRE: </b> El Chofer es distinto de Null.<br>
     * <b>POST: </b> Se añade un chofer a la coleccion de choferes.<br>
     * @param chofer  El chofer a agregar.
     * @throws ExceptionDNIrepetido si el DNI del Chofer ya esta registrado en el sistema.
     */
	public void addChofer(Chofer chofer) throws ExceptionDNIrepetido
	{
		assert chofer != null : "Fallo Pre: El Chofer no puede ser Null ";
		
		int i=0, size = choferLista.size();
		
		while(i<size && !choferLista.get(i).getDni().equalsIgnoreCase(chofer.getDni()))
		{
			i++;
		}
		
		if(i<size)
			throw new ExceptionDNIrepetido(chofer.getDni());
		else
			choferLista.add(chofer);
		
		assert choferLista.size() == size + 1 : "Fallo Post: Cambios sin efecto en choferLista";
		assert invarianteListaChoferes() : "Fallo Invariante: ChoferLista Null";
	}
	
	/**
     * Agrega un vehiculo al sistema (vehiculoLista).<br>
     * <b>PRE: </b> El vehiculo es distinto de Null.<br>
     * <b>POST: </b> Se añade un vehiculo a la coleccion de vehiculos.<br>
     * @param vehiculo  El vehiculo a agregar.
     * @throws ExceptionPatenteRepetida si la patente del vehiculo ya esta registrada en el sistema.
     */
	public void addVehiculo(Vehiculo vehiculo) throws  ExceptionPatenteRepetida
	{
		assert vehiculo != null : "Fallo Pre: El vehiculo no puede ser Null ";
		
		int i=0, size = vehiculoLista.size();
		
		while(i<size && !vehiculoLista.get(i).getPatente().equalsIgnoreCase(vehiculo.getPatente()))
		{
			i++;
		}
		
		if(i<size)	
			throw new ExceptionPatenteRepetida(vehiculo.getPatente());
		else
			vehiculoLista.add(vehiculo);
		
		assert vehiculoLista.size() == size + 1 : "Fallo Post: Cambios sin efecto en vehiculoLista";
		assert invarianteListaVehiculo() : "Fallo Invariante: VehiculoLista Null";
	}

	//Modificar: 
	
	/**
	 * Modifica los datos de un cliente existente en el sistema, solo se alteraran aquellos campos ingresados no nulos.<br>
	 * <b>PRE: </b> nombreUsuario distinto de Null.<br>
	 * @param nombreUsuario  El nombre de usuario del cliente a modificar.
	 * @param nombreUsuarioNuevo  El nuevo nombre de usuario para el cliente.
	 * @param nombreReal  El nuevo nombre real del cliente.
	 * @param contrasenaNueva  La nueva contraseña del cliente.
	 * @throws ExceptionUsuarioRepetido si el nuevo nombre de usuario ya esta registrado en el sistema.
	 */
	public void modificarCliente(String nombreUsuario, String nombreUsuarioNuevo, String nombreReal, String contrasenaNueva) throws ExceptionUsuarioRepetido
	{	
		assert nombreUsuario != null : "Fallo Pre: El nombreUsuario no puede ser Null ";
		
		Usuario usuario = usuarioMap.get(nombreUsuario);

		if (nombreUsuarioNuevo != null || nombreUsuarioNuevo != "")
		{
			if (!usuarioMap.containsKey(nombreUsuarioNuevo)) {
				usuarioMap.remove(nombreUsuario);
				usuario.setNombreUsuario(nombreUsuarioNuevo);
				usuarioMap.put(nombreUsuarioNuevo, usuario);
			} 
			else {
				throw new ExceptionUsuarioRepetido(nombreUsuario);
			}
		}

		if (nombreReal != null || nombreReal != "") {
			usuario.setNombreReal(nombreReal);
			assert nombreReal != usuario.getNombreReal() : "Fallo Post: cambio sin efecto en nombreReal";
		}

		if (contrasenaNueva != null || contrasenaNueva != "") {
			usuario.setContrasena(contrasenaNueva);
			assert contrasenaNueva != usuario.getContrasena() : "Fallo Post: cambio sin efecto en contraseña";
		}
		
		assert invarianteUsuarioMap() : "Fallo Invariante: UsuarioMap Null";
	}
	
	/**
	 * Modifica los datos de un Chofer Permanente existente en el sistema, solo se actualizan los campos no nulos.<br>
	 * <b>PRE: </b> dni distinto de Null.<br>
	 * <b>POST: </b>El estado del cliente es actualizado.<br>
	 * @param dni El DNI del Chofer a modificar.
	 * @param nombre El nuevo nombre del Chofer.
	 * @param cantHijos La nueva cantidad de hijos del Chofer.
	 * @param fechaIngreso La nueva fecha de ingreso del Chofer.
	 * @throws ExceptionChoferInexistente si el Chofer con el DNI especificado no existe en el sistema.
	 */
	public void modificarChofer(String dni, String nombre, int cantHijos, LocalDateTime fechaIngreso) throws ExceptionChoferInexistente
	{
		assert dni != null : "Fallo Pre: El DNI no puede ser Null ";
		
		int i=0, size = choferLista.size();

		while(i < size && !choferLista.get(i).getDni().equalsIgnoreCase(dni))
		{
			i++;
		}

		if(i<size)
			throw new ExceptionChoferInexistente(dni);
		else{
			ChoferPermanente chofer = (ChoferPermanente) choferLista.get(i);
			if (nombre != null || nombre != "") {
				chofer.setNombre(nombre);
				assert nombre == chofer.getNombre() : "Fallo Post: cambio sin efecto en nombre";
			}
			if (cantHijos != 0) {
				chofer.setCantidadHijos(cantHijos);
				assert cantHijos == chofer.getCantidadHijos() : "Fallo Post: cambio sin efecto en cantHijos";
			}
			if (fechaIngreso != null) {
				chofer.setFechaIngreso(fechaIngreso);
				assert fechaIngreso == chofer.getFechaIngreso() : "Fallo Post: cambio sin efecto en fechaIngreso";
			}
		}
		
		assert invarianteListaChoferes() : "Fallo Invariante: choferLista Null";
	}

	/**
	 * Modifica el nombre de un Chofer existente en el sistema, este metodo se aplica a Chofer Contratado y Chofer Temporal.<br>
	 * <b>PRE: </b> El parametro dni es distinto de Null.<br>
	 * <b>POST: </b>El chofer actualiza su estado.<br>
	 * @param dni El DNI del Chofer a modificar.
	 * @param nombre El nuevo nombre del Chofer.
	 * @throws ExceptionChoferInexistente si el Chofer con el DNI especificado no existe en el sistema.
	 */
	public void modificarChofer(String dni, String nombre) throws ExceptionChoferInexistente 
	{
		assert dni != null : "Fallo Pre: El DNI no puede ser Null ";

		int i=0, size = choferLista.size();
		Chofer chofer  = null;

		while(i < size && !choferLista.get(i).getDni().equalsIgnoreCase(dni))
		{
			i++;
		}

		if(i<size)
			throw new ExceptionChoferInexistente(dni);
		else{
			chofer = choferLista.get(i);
			chofer.setNombre(nombre);
			assert nombre == chofer.getNombre() : "Fallo Post: cambio sin efecto en nombre";
		}
         
    }

	//Consultas:
	
	/**
	 * Consulta la informacion de un cliente en el sistema.<br>
	 * <b>PRE: </b> El nombre de usuario es distinto de Null.<br>
	 * @param nombreUsuario: El nombre de usuario del cliente a consultar.
	 * @return Una cadena de texto con la información del cliente.
	 * @throws ExceptionUsuarioInexistente si el cliente con el nombre de usuario especificado no existe en el sistema.
	 */
	public String consultarCliente(String nombreUsuario) throws ExceptionUsuarioInexistente
	{	
		assert nombreUsuario != null : "Fallo Pre: El nombreUsuario no puede ser Null ";
		
		if (usuarioMap.containsKey(nombreUsuario))
		{
			return usuarioMap.get(nombreUsuario).toString();
		}
		else
			throw new  ExceptionUsuarioInexistente(nombreUsuario);
	}

	/**
	 * Obtiene un cliente del sistema a partir de su nombre de usuario.<br>
	 * <b>PRE: </b> El nombre de usuario es distinto de Null.<br>
	 * @param nombreUsuario. El nombre de usuario del cliente a obtener.
	 * @return Referencia al cliente correspondiente al nombre de usuario especificado.
	 * @throws ExceptionUsuarioInexistente si el cliente con el nombre de usuario especificado no existe en el sistema.
	 */
	public Cliente getCliente(String nombreUsuario) throws ExceptionUsuarioInexistente
	{
		assert nombreUsuario != null : "Fallo Pre: El nombreUsuario no puede ser Null ";

		if (usuarioMap.containsKey(nombreUsuario))
		{
			return (Cliente) usuarioMap.get(nombreUsuario);
		}
		else
			throw new  ExceptionUsuarioInexistente(nombreUsuario);
	}

	/**
	 * Consulta un Chofer en el sistema a partir de su DNI.<br>
	 * <b>PRE: </b> El dni es distinto de Null.<br>
	 * @param dni: El DNI del Chofer a consultar.
	 * @return Una representación en cadena de caracteres del Chofer consultado.
	 * @throws ExceptionChoferInexistente si el Chofer con el DNI especificado no existe en el sistema.
	 */
	public String consultarChofer(String dni) throws ExceptionChoferInexistente 
	{
		assert dni != null : "Fallo Pre: El dni no puede ser Null ";
		
		int i=0, size = choferLista.size();

		while(i < size && !choferLista.get(i).getDni().equalsIgnoreCase(dni))
		{
			i++;
		}

		if(i<size)
			throw new ExceptionChoferInexistente(dni);
		else{
			return choferLista.get(i).toString();
		}
    }
	
	/**
	 * Consulta un Chofer en el sistema a partir de su DNI.<br>
	 * <b>PRE: </b> El dni es distinto de Null.<br>
	 * @param dni: El DNI del Chofer a consultar.
	 * @return Referencia al chofer correspondiente al DNI especificado.
	 * @throws ExceptionChoferInexistente si el Chofer con el DNI especificado no existe en el sistema.
	 */
	public Chofer getChofer(String dni) throws ExceptionChoferInexistente 
	{
		assert dni != null : "Fallo Pre: El dni no puede ser Null ";
		
		int i=0, size = choferLista.size();

		while(i < size && !choferLista.get(i).getDni().equalsIgnoreCase(dni))
		{
			i++;
		}

		if(i<size)
			throw new ExceptionChoferInexistente(dni);
		else{
			return choferLista.get(i);
		}
    }

	/**
	 * Consulta del estado de un vehiculo a partir de su patente.<br>
	 * <b>PRE: </b> La patente es distinta de Null.<br>
	 * @param patente: La patente del vehiculo a consultar.
	 * @return  Una representacion String de los datos del vehiculo
	 * @throws ExceptionPatenteInexistente
	 */
	public String consultarVehiculo(String patente) throws  ExceptionPatenteInexistente
	{
		assert patente != null : "Fallo Pre: La patente no puede ser Null ";
		
		int i=0, size = vehiculoLista.size();

		while(i<size && !vehiculoLista.get(i).getPatente().equalsIgnoreCase(patente))
		{
			i++;
		}

		if(i<size){
			return vehiculoLista.toString();
		}
		else
			throw new ExceptionPatenteInexistente(patente);
	}
	
	/**
	 * Consulta un vehiculo en el sistema a partir de su patente.<br>
	 * <b>PRE: </b> La patente es distinta de Null.<br>
	 * @param patente: La patente del vehiculo a consultar.
	 * @return Una referencia al vehiculo pretendido.
	 * @throws ExceptionPatenteInexistente si el vehiculo con la patente especificada no existe en el sistema.
	 */
	public Vehiculo getVehiculo(String patente) throws  ExceptionPatenteInexistente
	{
		assert patente != null : "Fallo Pre: La patente no puede ser Null ";
		
		int i=0, size = vehiculoLista.size();

		while(i<size && !vehiculoLista.get(i).getPatente().equalsIgnoreCase(patente))
		{
			i++;
		}

		if(i<size){
			return vehiculoLista.get(i);
		}
		else
			throw new ExceptionPatenteInexistente(patente);
	}

//Solicitud de listados de clientes, choferes y vehículos:

	/**
	 * Genera un listado de todos los clientes registrados en el sistema.<br>
	 * @return Una cadena que representa el listado de clientes, incluyendo el nombre de usuario y el nombre real de cada cliente.
	 */
    public String solicitudListadoClientes() {
        StringBuilder listadoClientes = new StringBuilder();

        listadoClientes.append("\n	LISTADO  CLIENTES\n");
        listadoClientes.append("\n   Usuario		 Nombre\n");
        for (Usuario usuario : usuarioMap.values())
        {
            Cliente cliente = (Cliente) usuario;
            listadoClientes.append(cliente.toStringListado()).append("\n");
        }

        return listadoClientes.toString();
    }

    /**
     * Genera un listado de todos los Choferes registrados en el sistema.<br>
     * @return Una cadena que representa el listado de Choferes, incluyendo el nombre, DNI y puntos de cada Chofer.
     */
    public String solicitudListadoChoferes() {
        StringBuilder listadoChoferes = new StringBuilder();

        listadoChoferes.append("\n 		LISTADO  CHOFERES\n");
        listadoChoferes.append("\n  Nombre		DNI		Puntos\n");
        for (Chofer chofer : choferLista) {
            listadoChoferes.append(chofer.toStringListado()).append("\n");
        }
        return listadoChoferes.toString();
    }

    /**
     * Genera un listado de todos los vehiculos registrados en el sistema.<br>
     * @return Una cadena que representa el listado de vehiculos, incluyendo la patente, cantidad maxima de pasajeros, estado de ocupacion, si permite mascotas y equipaje.
     */
    public String solicitudListadoVehiculos() {
        StringBuilder listadoVehiculos = new StringBuilder();

        listadoVehiculos.append("\n			LISTADO  VEHICULOS\n");
        listadoVehiculos.append("\n  Patente     CantMaxPas   Ocupado   Mascota   Equipaje\n");
        for (Vehiculo vehiculo : vehiculoLista) {
            listadoVehiculos.append(vehiculo.toStringListado()).append("\n");
        }
        return listadoVehiculos.toString();
    }

    /**
     * Genera un listado de todos los viajes registrados en el sistema, ordenados por costo.<br>
     * @return Una cadena que representa el listado de viajes, incluyendo la fecha, costo, zona, cliente, chofer, vehiculo, distancia, cantidad de pasajeros, si se permite mascotas y equipaje, y el estado del viaje.
     */
    public String solicitudListadoViajes() {
        StringBuilder listadoViajes = new StringBuilder();
        ArrayList<IViaje> listaViajes = getListaClonViajesOrdenados();

        listadoViajes.append("\n		LISTADO  VIAJES\n");
        listadoViajes.append("\n  Fecha     Costo      Zona        Cliente        Chofer     Vehiculo     Distancia(km) Cant Pas   Mascota  Equipaje  Estado\n");
        for (IViaje viaje : listaViajes) 
        {
            listadoViajes.append(viaje.toStringListado()).append("\n");
        }
        return listadoViajes.toString();
    }

    /**
     * Genera una lista clonada de los viajes ordenados por costo (Clonacion profunda).<br>
     * @return Una lista clonada de los viajes ordenados por costo.
     */
    private ArrayList<IViaje> getListaClonViajesOrdenados()
    {
        ArrayList<IViaje> viajeLista = empresa.getViajeLista();
        
        ArrayList<IViaje> viajeListaClon = (ArrayList<IViaje>) viajeLista.clone();
        viajeListaClon.clear();
        
        for(int i = 0; i < viajeLista.size(); i++){
        	 viajeListaClon.add((IViaje) viajeLista.get(i).clone());
        }
        
        //Ordena la lista clonada por costo,en IViaje sobreescribi el metodo compare
        Collections.sort(viajeListaClon);

        return viajeListaClon;
    }

//Cálculo de salarios mensuales de cada Chofer. Esto incluye el dinero que reciben los choferes contratados:

    /**
     * Genera un reporte de los salarios mensuales de todos los Choferes registrados en el sistema.<br>
     * <b>PRE: </b> La fecha es distinta de Null.<br>
     * @param fecha: La fecha para la cual se calculan los salarios.
     * @return Una cadena que representa el listado de salarios de los Choferes, incluyendo el nombre, DNI y salario.
     */
    public String reporteSalariosChoferes(LocalDateTime fecha)
    {
    	assert fecha != null : "Falla Pre: fecha Null";
    	
    	StringBuilder listadoSalarios = new StringBuilder();

    	listadoSalarios.append("\n		LISTADO  SUELDOS\n");
    	listadoSalarios.append("\n Nombre		       DNI	        Salario\n");
    	for (Chofer chofer : choferLista) {
    		listadoSalarios.append(chofer.toStringListadoSalarios(fecha)).append("\n");
    	}
    	return listadoSalarios.toString();

    }

//Cálculo del total de dinero necesario para pagar los salarios:

    /**
     * Calcula el total de salarios necesarios para pagar a todos los Choferes registrados en el sistema
     * en un mes especifico.<br>
     * <b>PRE: </b> La fecha es distinta de Null.<br>
     * @param fecha: La fecha para la cual se calculan los salarios.
     * @return Una cadena que representa el total de salarios necesarios para pagar a todos los Choferes.
     */
    public String getTotalSalarios(LocalDateTime fecha)
    {
    	assert fecha != null : "Falla Pre: fecha Null";
    	
    	StringBuilder totalSalarios = new StringBuilder();

    	double total = 0;
    	for (Chofer chofer : choferLista) 
    	{
    		total += chofer.getSueldo(fecha); //seria para el mes actual
    	}
    	totalSalarios.append("\nTotal salarios: $").append(total);
    	return totalSalarios.toString();

    }
    
//Reportes 
    
    /**
     * Genera un reporte de los viajes realizados por un Chofer durante un periodo de tiempo especificado.
     * <b>PRE: </b> Las fechas son distintas de Null y fechaInf es menor que fechaSup.<br>
     * @param chofer: El Chofer del cual se desea obtener el reporte de viajes.
     * @param fechaInf: La fecha de inicio del periodo.
     * @param fechaSup: La fecha de fin del periodo.
     * @return Una cadena que representa el reporte de los viajes del Chofer en el periodo especificado.
     */
    public String reporteViajesChoferPeriodo(Chofer chofer,LocalDateTime fechaInf, LocalDateTime fechaSup)
    {
    	assert fechaInf != null : "Falla Pre: fechaInf Null";
    	assert fechaSup != null : "Falla Pre: fechaSup Null";
    	assert fechaInf.compareTo(fechaSup) < 0 : "Falla Pre: fechaInf tiene que ser inferior a fechaSup";
    	
    	StringBuilder viajesChoferPeriodo = new StringBuilder();
    	ArrayList<IViaje> viajesLista = getViajesChoferPeriodo(chofer,fechaInf, fechaSup);
    	
    	viajesChoferPeriodo.append("\n		LISTADO  VIAJES\n");
    	viajesChoferPeriodo.append("\n  Fecha     Costo      Zona       Cliente      Vehiculo     Distancia(km) Cant Pas   Mascota  Equipaje  Estado\n");
        for (IViaje viaje : viajesLista) 
        {
            viajesChoferPeriodo.append(viaje.toStringListado()).append("\n");
        }
        
        return viajesChoferPeriodo.toString();  	
    }
     
    /**
     * Obtiene una lista de los viajes realizados por un Chofer dentro de un período de tiempo especificado.
     * <b>PRE: </b> Las fechas son distintas de Null y fechaInf es menor que fechaSup. <br>
     * @param chofer: El Chofer del cual se desean obtener los viajes.
     * @param fechaInf: La fecha de inicio del periodo.
     * @param fechaSup. La fecha de fin del periodo.
     * @return Una lista de objetos IViaje que representan los viajes del Chofer en el periodo especificado.
     */
    public ArrayList<IViaje> getViajesChoferPeriodo(Chofer chofer,LocalDateTime fechaInf, LocalDateTime fechaSup)
    {
    	assert fechaInf != null : "Falla Pre: fechaInf Null";
    	assert fechaSup != null : "Falla Pre: fechaSup Null";
    	assert fechaInf.compareTo(fechaSup) < 0 : "Falla Pre: fechaInf tiene que ser inferior a fechaSup";
    	
    	ArrayList<IViaje> viajesLista = empresa.getViajeLista();
    	ArrayList<IViaje> viajesChoferPeriodo = new ArrayList<IViaje>();
    	LocalDateTime fechaViaje;
    	
    	for(IViaje viaje: viajesLista)
    	{
    		fechaViaje = viaje.getFecha();
    		if( viaje.getChofer()==chofer && fechaViaje.isAfter(fechaInf) && fechaViaje.isBefore(fechaSup))
    			viajesChoferPeriodo.add(viaje);
    	}
    	
    	return viajesChoferPeriodo;
    }
    
    /**
     * Genera un reporte de los viajes realizados por un cliente dentro de un periodo de tiempo especificado.
     * <b>PRE: </b> Las fechas son distintas de Null y fechaInf ES menor que fechaSup.<br>
     * @param cliente: El cliente del cual se desean obtener los viajes.
     * @param fechaInf: La fecha de inicio del periodo.
     * @param fechaSup: La fecha de fin del periodo.
     * @return Una cadena que representa el reporte de los viajes del cliente en el periodo especificado.
     */
    public String reporteViajesClientePeriodo(Cliente cliente,LocalDateTime fechaInf, LocalDateTime fechaSup)
    {
    	assert fechaInf != null : "Falla Pre: fechaInf Null";
    	assert fechaSup != null : "Falla Pre: fechaSup Null";
    	assert fechaInf.compareTo(fechaSup) < 0 : "Falla Pre: fechaInf tiene que ser inferior a fechaSup";
    	
    	StringBuilder viajesClientePeriodo = new StringBuilder();
    	ArrayList<IViaje> viajesLista = getViajesClientePeriodo(cliente,fechaInf,  fechaSup);
    	
    	viajesClientePeriodo.append("\n		LISTADO  VIAJES\n");
    	viajesClientePeriodo.append("\n  Fecha     Costo      Zona      Chofer      Vehiculo     Distancia(km) Cant Pas   Mascota  Equipaje  Estado\n");
        for (IViaje viaje : viajesLista) 
        {
             viajesClientePeriodo.append(viaje.toStringListado()).append("\n");
        }
        
        return viajesClientePeriodo.toString();  	
    }
    
    /**
     * Obtiene una lista de los viajes realizados por un cliente dentro de un periodo de tiempo especificado.<br>
     * <b>PRE: </b> Las fechas son distintas de Null y fechaInf es menor que fechaSup.<br>
     * @param cliente: El cliente del cual se desean obtener los viajes.
     * @param fechaInf: La fecha de inicio del periodo.
     * @param fechaSup: La fecha de fin del periodo.
     * @return Una lista de los viajes del cliente en el periodo especificado.
     */
    public ArrayList<IViaje> getViajesClientePeriodo(Cliente cliente, LocalDateTime fechaInf, LocalDateTime fechaSup)
    {
    	assert fechaInf != null : "Falla Pre: fechaInf Null";
    	assert fechaSup != null : "Falla Pre: fechaSup Null";
    	assert fechaInf.compareTo(fechaSup) < 0 : "Falla Pre: fechaInf tiene que ser inferior a fechaSup";
    	
    	ArrayList<IViaje> viajesLista = empresa.getViajeLista();
    	ArrayList<IViaje> viajesClientePeriodo = new ArrayList<IViaje>();
    	LocalDateTime fechaViaje;
    	
    	for(IViaje viaje: viajesLista)
    	{
    		fechaViaje = viaje.getFecha();
    		if(viaje.getCliente()==cliente && fechaViaje.isAfter(fechaInf) && fechaViaje.isBefore(fechaSup))
    			viajesClientePeriodo.add(viaje);
    	}
    	
    	return viajesClientePeriodo;
    }

//Getters y Setters:
    
    /**
     * Obtiene una lista de todos los usuarios, tras la conversion del HashMap UsuarioMap.<br>
     * @return Una lista de usuarios.
     */
    public ArrayList<Usuario> getUsuarioLista()
	{	
    	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		for (String key: this.usuarioMap.keySet()) 
		{
			usuarios.add(this.usuarioMap.get(key));
		}
		return usuarios;
	}
	
    /**
     * Obtiene el mapa de usuarios (UsuarioMap).<br>
     * @return El mapa de usuarios.
     */
	public HashMap<String, Usuario> getUsuarioMap() {
		return usuarioMap;
	}
	
	/**
     * Obtiene una lista de todos los vehiculos (vehiculoLista).<br>
     * @return Una lista de vehiculos.
     */
	public ArrayList<Vehiculo> getVehiculoLista()
	{
		return this.vehiculoLista;
	}
	
	/**
     * Obtiene una lista de todos los choferes (ChoferLista).<br>
     * @return Una lista de choferes.
     */
	public ArrayList<Chofer> getChoferLista() 
	{
		return this.choferLista;
	} 

//Otros: 
	
	
	/**
	 * Acumula la plata de todos los viajes de un determinado Chofer contratado para luego calcular su sueldo.<br>
	 * <b>PRE: </b>Tanto el chofer como la fecha son distintos de Null.<br>
	 * @param chofer: El Chofer del cual se desea calcular el recaudo.
	 * @param fecha. La fecha para la cual se calcula el recaudo.
	 * @return El total facturado por el Chofer en el mes y año especificados.
	 */
    public double getRecaudoContratado(Chofer chofer, LocalDateTime fecha) 
	{	
    	assert fecha != null : "Falla Pre: fecha Null";
    	assert chofer != null : "Falla Pre: chofer Null";
    	double OldTotalfacturado = 0;
    	
    	//los viajes se agregan al final con add, por lo que si recorro desde el final empiezo por los mas recientes
    	double totalFacturado = 0;
		ArrayList<IViaje> viajeLista = empresa.getViajeLista();
		int i = viajeLista.size() - 1;
		
		//Recorro hasta encontrar el año especifico
        while (i >= 0 && fecha.getYear() < viajeLista.get(i).getFecha().getYear() ) {
            i--;
        }
        
        //Recorro el año mientras no sobrepase el mes pedido
    	if ( i >= 0 && fecha.getYear() == viajeLista.get(i).getFecha().getYear() ) {
    		
        	while( i >= 0 && fecha.getMonthValue() <= viajeLista.get(i).getFecha().getMonthValue() ) {
            	
        		if ( i >= 0 && viajeLista.get(i).getChofer() == chofer && fecha.getMonthValue() == viajeLista.get(i).getFecha().getMonthValue() ) {
        			OldTotalfacturado = totalFacturado;
        			totalFacturado += viajeLista.get(i).getCosto();
            		assert totalFacturado == OldTotalfacturado + viajeLista.get(i).getCosto() : "Falla Post: cambio sin efecto en totalFacturado";
            	}
            	i--;
            }
    	}
		
		return totalFacturado; //Si esta vacia devuelve 0
	}

    
    /**
     * Devuelve la cantidad de viajes realizados por un Chofer Temporario, dato usado luego para calcular su sueldo.<br>
     * <b>PRE: </b> Tanto el chofer como la fecha son distintos de Null.<br>
     * @param chofer: El Chofer del cual se desea obtener la cantidad de viajes.
     * @param fecha: La fecha para la cual se desea calcular la cantidad de viajes.
     * @return La cantidad de viajes realizados por el Chofer en el mes y año especificados.
     */
	public double getCantidadViajesTemp(Chofer chofer, LocalDateTime fecha) 
	{
		assert fecha != null : "Falla Pre: fecha Null";
    	assert chofer != null : "Falla Pre: chofer Null";
		
		double cantViajes = 0;
		ArrayList<IViaje> viajeLista = empresa.getViajeLista();
		int i = viajeLista.size() - 1;
		
		//Recorro hasta encontrar el año especifico desde el final, viejos al principio y recientes al final
        while (i >= 0 && fecha.getYear() < viajeLista.get(i).getFecha().getYear() ) {
            i--;
        }
        
        //Recorro el año mientras no sobrepase el mes pedido
    	if ( i >= 0 && fecha.getYear() == viajeLista.get(i).getFecha().getYear() ) {
    		
        	while( i >= 0 && fecha.getMonthValue() <= viajeLista.get(i).getFecha().getMonthValue() ) {
            	
        		if ( i >= 0 && viajeLista.get(i).getChofer() == chofer && fecha.getMonthValue() == viajeLista.get(i).getFecha().getMonthValue() ) {
        			cantViajes++;
            	}
            	i--;
            }
    	}
    	
		return cantViajes;
	}
	
	/**
	 * Arma un HashMap cuyas claves son los choferes y sus valores los Kmrecorridos por ese Chofer.
	 * A partir de ahi, iteramos sobre la coleccion de viajes para ir acumulando los km a los choferes
	 * y actualizando su puntaje. Al finalizar el recorrido de viajes, se recorre el HashMap en busqueda del chofer
	 * con mas km recorridos para sumarle los 15 puntos extra.<br>
	 * <b>PRE: </b> El mes tiene que ser un valor comprendido entre 1 y 12.<br>
	 * <b>POST: </b> Los choferes tendran actualizados sus puntajes.<br>
	 * @param mes El mes para el cual se actualiza el puntaje. Se espera un valor entero que represente el mes del año.
	 */
	public void actualizarPuntaje(int mes) 
	{
		assert 1 <= mes && mes <= 12 : "Fallo Pre: mes fuera de rango";
		double oldPuntaje = 0;
		
		HashMap<Chofer,Double> kilometrajeXchofer =  new HashMap<>();
		ArrayList<IViaje> viajeLista = empresa.getViajeLista();
		Chofer chofer, maxChofer = null;
		double  kilometrosViaje, kilometrosTotales, maxKm = -1;
		LocalDateTime fechaActual = LocalDateTime.now();
		int i = viajeLista.size() - 1;
		
		for(IViaje viaje: viajeLista)
		{
			//Recorro hasta encontrar el año especifico desde el final, viejos al principio y recientes al final
	        while (i >= 0 && fechaActual.getYear() < viajeLista.get(i).getFecha().getYear() ) {
	            i--;
	        }
			
	        //Recorro el año mientras no sobrepase el mes pedido
			if(viaje.getFecha().getYear() == fechaActual.getYear() && viaje.getFecha().getMonthValue() <= mes)
			{
				if (viaje.getFecha().getMonthValue() == mes) {
					chofer = viaje.getChofer();
					oldPuntaje = chofer.getPuntos();
					chofer.addPuntos(5);
					assert chofer.getPuntos() == oldPuntaje + 5 : "Fallo Post: cambios sin efecto en Puntos del Chofer";
			
					kilometrosViaje = viaje.getDistancia();
					kilometrosTotales = kilometrajeXchofer.getOrDefault(chofer, 0.0);
					kilometrajeXchofer.put(chofer, kilometrosTotales + kilometrosViaje);
				}
			}
		}
	
		for(Map.Entry<Chofer,Double> entry : kilometrajeXchofer.entrySet())
		{
			if(entry.getValue() > maxKm)
			{
				maxChofer = entry.getKey();
				maxKm = entry.getValue();
			}
		}
	
		if(maxChofer != null)
		{
			oldPuntaje = maxChofer.getPuntos();
			maxChofer.addPuntos(15);
			assert maxChofer.getPuntos() == oldPuntaje + 5 : "Fallo Post: cambios sin efecto en Puntos del Chofer que mas Km recorrio";
		}	
		
		assert invarianteListaViajes() : "Fallo Invariante: viajeLista Null";
	}
	
	/**
	 * Permite evaluar el invariante de la lista de choferes.<br>
	 * @return  true si la lista es distinta de null, false en caso contrario
	 */
	private boolean invarianteListaChoferes()
	{
		return this.choferLista != null;
	}
	
	/**
	 * Permite evaluar el invariante de la lista de vehiculos.<br>
	 * @return  true si la lista es distinta de null, false en caso contrario
	 */
	private boolean invarianteListaVehiculo()
	{
		return this.vehiculoLista != null;
	}
	
	/**
	 * Permite evaluar el invariante de la lista de clientes.<br>
	 * @return true si la lista es distinta de null, false en caso contrario
	 */
	private boolean invarianteUsuarioMap()
	{
		return this.usuarioMap != null;
	}
	
	/**
	 * Permite evaluar el invariante de la lista de viajes.<br>
	 * @return  boolean true si la lista es distinta de Null, false en caso contrario
	 */
	private boolean invarianteListaViajes()
	{
		return empresa.invarianteListaViajes();
	}
	
}
