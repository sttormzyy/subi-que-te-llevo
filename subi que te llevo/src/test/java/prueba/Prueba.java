package prueba;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import controladores.ControladorCliente;
import controladores.ControladorMenuSimulacion;
import excepciones.vehiculo.ExceptionVehiculo;
import sistema.Empresa;
import sistema.Serializacion;
import vehiculos.Vehiculo;
import vehiculos.VehiculoFactory;
import vista.MainFrameCliente;
import vista.VentanaSimulacion;

public class Prueba {

	public static void main(String[] args) {
		VehiculoFactory vehFact = new VehiculoFactory();
		Empresa empresa = Empresa.getInstance();

                try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("No se pudo configurar el look and feel Nimbus.");
        }
		/*//Agrego admin
		try {
			empresa.addAdmin(new Administrador("admin","admin","1234"));
		}
		catch(ExceptionUsuario e)
		{
			System.out.println("\nError: " +e.getMessage());
		}

		//Ingreso el ultimo auto con la misma patente q otro para ver la excepcion
		try {
			empresa.addVehiculo(vehFact.getVehiculo("moto","AA345AA"));
			empresa.addVehiculo(vehFact.getVehiculo("auto","BB345BB"));
			empresa.addVehiculo(vehFact.getVehiculo("auto","CC345CC"));
			empresa.addVehiculo(vehFact.getVehiculo("combi","DD345DD"));
			empresa.addVehiculo(vehFact.getVehiculo("combi","AA345AA"));
		}catch(ExceptionVehiculo e)
		{
			System.out.println("\nError:" +e.getMessage());
		}

		Chofer ch1 = new ChoferContratado("44555777","carlos");
		Chofer ch2 = new ChoferPermanente("11999888","pitagoras",20,LocalDateTime.now());
		Chofer ch3 = new ChoferTemporario("33777444","einstein");
		Chofer ch4 = new ChoferPermanente("99888777","raul",20,LocalDateTime.now());
		Chofer ch5 = new ChoferPermanente("99888777","esteban",2,LocalDateTime.now());

		
		//Ingreso ultimo chofer con dni repetido para ver excepcion
		try {
			empresa.addChofer(ch1);
			empresa.addChofer(ch2);
			empresa.addChofer(ch3);
			empresa.addChofer(ch4);
			empresa.addChofer(ch5);
		}catch(ExceptionChofer e)
		{
			System.out.println("\nError:" +e.getMessage());
		}

		Cliente c1 = new Cliente("pepito","julian","128");
		Cliente c2 = new Cliente("xD","lucas","343");
		Cliente c3 = new Cliente("Company","carlos","3343");
		Cliente c4 = new Cliente("holasoymartin","martin","asdsa");

		try {
			empresa.addCliente(c1);
			empresa.addCliente(c2);
			empresa.addCliente(c3);
			empresa.addCliente(c4);
		}catch(ExceptionUsuario e)
		{
			System.out.println("\nError:" +e.getMessage());
		}

		//Lista los choferes, vehiculos y clientes ingresados a la empresa
		System.out.println(empresa.solicitudListadoClientes());
		System.out.println(empresa.solicitudListadoChoferes());			
		System.out.println(empresa.solicitudListadoVehiculos());

		
		
		//pepito pide viaje con fecha invalida
		try {
			empresa.pedirViaje("pepito","peligrosa",0, "transporte", 0,5,10, LocalDateTime.of(2023,2,2,0,0));
		} catch (ExceptionVehiculoDisp e) {
			System.out.println("\nError pepito:" +e.getMessage());
		} catch (ExceptionChoferDisp e) {
			System.out.println("\nError pepito:" +e.getMessage());
		} catch (ExceptionPedido e) {
			System.out.println("\nError pepito:" +e.getMessage());
		} catch (ExceptionUsuario e) {
			System.out.println("\nError pepito:" +e.getMessage());
		}
		
		
       //pepito pide viaje valido
		try {
			empresa.pedirViaje("pepito","peligrosa",0, "transporte", 0,5,10, LocalDateTime.now());
		} catch (ExceptionVehiculoDisp e) {
			System.out.println("\nError:" +e.getMessage());
		} catch (ExceptionChoferDisp e) {
			System.out.println("\nError:" +e.getMessage());
		} catch (ExceptionPedido e) {
			System.out.println("\nError:" +e.getMessage());
		} catch (ExceptionUsuario e) {
			System.out.println("\nError Company:" +e.getMessage());
		}

		//Company pide viaje con tipo de servicio invalido
		try {
			empresa.pedirViaje("Company","peligrosa",0,"larga distancia",1,1,900,LocalDateTime.now());
		} catch (ExceptionVehiculoDisp e) {
			System.out.println("\nError Company:" +e.getMessage());
		} catch (ExceptionChoferDisp e) {
			System.out.println("\nError Company:" +e.getMessage());
		} catch (ExceptionPedido e) {
			System.out.println("\nError Company:" +e.getMessage());
		} catch (ExceptionUsuario e) {
			System.out.println("\nError Company:" +e.getMessage());
		}
		
		//Company pide viaje valido
		try {
			empresa.pedirViaje("Company","peligrosa",0,"transporte",1,1,900,LocalDateTime.now());
		} catch (ExceptionVehiculoDisp e) {
			System.out.println("\nError Company:" +e.getMessage());
		} catch (ExceptionChoferDisp e) {
			System.out.println("\nError Company:" +e.getMessage());
		} catch (ExceptionPedido e) {
			System.out.println("\nError Company:" +e.getMessage());
		} catch (ExceptionUsuario e) {
			System.out.println("\nError Company:" +e.getMessage());
		}


		//xD pide viaje con zona invalida
		try {
			empresa.pedirViaje("xD","peru",1,"transporte",0,5,8,LocalDateTime.now());
		} catch (ExceptionVehiculoDisp e) {
			System.out.println("\nError xD:" +e.getMessage());
		} catch (ExceptionChoferDisp e) {
			System.out.println("\nError xD:" +e.getMessage());
		} catch (ExceptionPedido e) {
			System.out.println("\nError xD:" +e.getMessage());
		} catch (ExceptionUsuario e) {
			System.out.println("\nError xD:" +e.getMessage());
		}
		
		
		//xD pide viaje valido
		try {
			empresa.pedirViaje("xD","estandar",0,"transporte",0,5,23,LocalDateTime.now());
		} catch (ExceptionVehiculoDisp e) {
			System.out.println("\nError xD:" +e.getMessage());
		} catch (ExceptionChoferDisp e) {
			System.out.println("\nError xD:" +e.getMessage());
		} catch (ExceptionPedido e) {
			System.out.println("\nError xD:" +e.getMessage());
		} catch (ExceptionUsuario e) {
			System.out.println("\nError xD:" +e.getMessage());
		}



		//holasoymartin pide viaje con cantidad de pasajeros invalida
		try {
			empresa.pedirViaje("holasoymartin","peligrosa", 1, "mensajeria", 1, 12, 22, LocalDateTime.now());
		} catch (ExceptionVehiculoDisp e) {
			System.out.println("\nError holasoymartin:" +e.getMessage());
		} catch (ExceptionChoferDisp e) {
			System.out.println("\nError holasoymartin:" +e.getMessage());
		} catch (ExceptionPedido e) {
			System.out.println("\nError holasoymartin:" +e.getMessage());
		} catch (ExceptionUsuario e) {
			System.out.println("\nError holasoymartin:" +e.getMessage());
		}



		//holasoymartin pide viaje valido
		try {
			empresa.pedirViaje("holasoymartin","peligrosa", 1, "mensajeria", 1, 4, 22, LocalDateTime.now());
		} catch (ExceptionVehiculoDisp e) {
			System.out.println("\nError holasoymartin:" +e.getMessage());
		} catch (ExceptionChoferDisp e) {
			System.out.println("\nError holasoymartin:" +e.getMessage());
		} catch (ExceptionPedido e) {
			System.out.println("\nError holasoymartin:" +e.getMessage());
		} catch (ExceptionUsuario e) {
			System.out.println("\nError holasoymartin:" +e.getMessage());
		}
		

		//Los choferes finalizan sus viajes
		try {
			empresa.finalizarViaje("44555777");
			empresa.finalizarViaje("11999888");
			empresa.finalizarViaje("33777444");
		} catch (ExceptionChoferSinViajesPagos | ExceptionChofer e) {
			System.out.println("\nError:" +e.getMessage());
		}


		System.out.println(empresa.solicitudListadoViajes());
		
		//Reportes de salarios individuales y totales
		try {
			System.out.println(empresa.reporteSalariosChoferes(LocalDateTime.now()));
			System.out.println(empresa.getTotalSalarios(LocalDateTime.now()));
		} catch (ExceptionFecha e) {
			System.out.println("\nError:" +e.getMessage());
		}


		//Actualiza los puntajes de los choferes del mes pasado como parametro
		try {
			empresa.actualizarPuntaje(5);
		} catch (ExceptionFecha e) {
			System.out.println("\nError:" +e.getMessage());
		}


		//Muestra listado de choferes con los puntos actualizados
		System.out.println(empresa.solicitudListadoChoferes());		
		 */
                VentanaSimulacion menuSimulacion = new VentanaSimulacion();
                ControladorMenuSimulacion c = new ControladorMenuSimulacion();
                menuSimulacion.setControlador(c);
                c.setVista(menuSimulacion);

                MainFrameCliente vistaCliente = new MainFrameCliente();
                vistaCliente.setPanel();
                ControladorCliente controlador = new ControladorCliente(empresa,vistaCliente);
                vistaCliente.setControlador(controlador);

               /* 
                
                try {
                	empresa.addVehiculo(vehFact.getVehiculo("moto","AA345AA"));
                	Vehiculo v1 = empresa.getVehiculo("AA345AA");
        		}
                catch(ExceptionVehiculo e)
        		{
        			System.out.println("\nError:" +e.getMessage());
        		}
                
                Serializacion.serializarVehiculoBinario( v1 , "vehiculo.ser");
                Vehiculo vehiculoDeserializado = Serializacion.deserializarVehiculoBinario("vehiculo.ser");

                */  
                  
        
	}

       
        
}
