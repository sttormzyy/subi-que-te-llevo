package sistema;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import choferes.Chofer;
import usuarios.Administrador;
import usuarios.Cliente;
import vehiculos.Vehiculo;
import viajes.IViaje;

public class Serializacion {

	/*TEORIA IMPORTANTE!
	 * 
	 * La serialización XML, es importante que las clases tengan un constructor predeterminado (DEBEN TENER UN VACIO si o si)
	 * y que implementen correctamente el método clone(). Es una alternativa a la serialización binaria ya que 
	 * no requiere que las clases implementen Serializable,
	 * 
	 * Para la serialización binaria, es necesario que las clases implementen la interfaz Serializable.
	 */
	
	
// ---------------------------------------- Choferes ---------------------------------------- //
	
	public static void serializarChofer(Chofer chofer, String archivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(chofer);
            //System.out.println("Chofer serializado en binario en " + archivo);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Chofer deserializarChofer(String archivo) {
        Chofer chofer = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            chofer = (Chofer) in.readObject();
            System.out.println("Chofer deserializado en binario desde " + archivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return chofer;
    }
	
	public static void serializarChoferXML(Chofer chofer, String archivo) {
        try (OutputStream fileOut = new FileOutputStream(archivo);
             XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(fileOut))) {
            encoder.writeObject(chofer);
            //System.out.println("Chofer serializado en XML en " + archivo);
        } 
        catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Chofer deserializarChoferXML(String archivo) {
        Chofer chofer = null;
        try (InputStream fileIn = new FileInputStream(archivo);
             XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(fileIn))) {
            chofer = (Chofer) decoder.readObject();
        } 
        catch (IOException i) {
            i.printStackTrace();
        }
        return chofer;
    }
    
// ---------------------------------------- Usuarios ---------------------------------------- //
    
    public static void serializarCliente(Cliente cliente, String archivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(cliente);
            //System.out.println("Cliente serializado en binario en " + archivo);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Cliente deserializarCliente(String archivo) {
        Cliente cliente = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            cliente = (Cliente) in.readObject();
            //System.out.println("Cliente deserializado en binario desde " + archivo);
        } 
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    public static void serializarClienteXML(Cliente cliente, String archivo) {
        try (OutputStream fileOut = new FileOutputStream(archivo);
             XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(fileOut))) {
            encoder.writeObject(cliente);
            //System.out.println("Cliente serializado en XML en " + archivo);
        } 
        catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Cliente deserializarClienteXML(String archivo) {
        Cliente cliente = null;
        try (InputStream fileIn = new FileInputStream(archivo);
             XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(fileIn))) {
            cliente = (Cliente) decoder.readObject();
        } 
        catch (IOException i) {
            i.printStackTrace();
        }
        return cliente;
    }
    
    public static void serializarAdministrador(Administrador administrador, String archivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(administrador);
            //System.out.println("Administrador serializado en binario en " + archivo);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Administrador deserializarAdministrador(String archivo) {
        Administrador administrador = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            administrador = (Administrador) in.readObject();
            //System.out.println("Administrador deserializado en binario desde " + archivo);
        } 
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return administrador;
    }

    public static void serializarAdministradorXML(Administrador administrador, String archivo) {
        try (OutputStream fileOut = new FileOutputStream(archivo);
             XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(fileOut))) {
            encoder.writeObject(administrador);
            //System.out.println("Administrador serializado en XML en " + archivo);
        } 
        catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Administrador deserializarAdministradorXML(String archivo) {
        Administrador administrador = null;
        try (InputStream fileIn = new FileInputStream(archivo);
             XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(fileIn))) {
            administrador = (Administrador) decoder.readObject();
        } 
        catch (IOException i) {
            i.printStackTrace();
        }
        return administrador;
    }
    
 // ---------------------------------------- Vehiculos ---------------------------------------- //
    
    public static void serializarVehiculoBinario(Vehiculo vehiculo, String archivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(vehiculo);
            //System.out.println("Vehiculo serializado en binario en " + archivo);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Vehiculo deserializarVehiculoBinario(String archivo) {
        Vehiculo vehiculo = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            vehiculo = (Vehiculo) in.readObject();
        } 
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vehiculo;
    }
    
    public static void serializarVehiculoXML(Vehiculo vehiculo, String archivo) {
        try (OutputStream fileOut = new FileOutputStream(archivo);
             XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(fileOut))) {
            encoder.writeObject(vehiculo);
            //System.out.println("Vehiculo serializado en XML en " + archivo);
        } 
        catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Vehiculo deserializarVehiculoXML(String archivo) {
        Vehiculo vehiculo = null;
        try (InputStream fileIn = new FileInputStream(archivo);
             XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(fileIn))) {
            vehiculo = (Vehiculo) decoder.readObject();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return vehiculo;
    }
    
 // ---------------------------------------- Viajes ---------------------------------------- //
    
    public static void serializarViajeBinario(IViaje viaje, String archivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(viaje);
            //System.out.println("Viaje serializado en binario en " + archivo);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static IViaje deserializarViajeBinario(String archivo) {
    	IViaje viaje = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
        	viaje = (IViaje) in.readObject();
        } 
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return viaje;
    }
    
    public static void serializarViajeXML(IViaje viaje, String archivo) {
        try (OutputStream fileOut = new FileOutputStream(archivo);
             XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(fileOut))) {
            encoder.writeObject(viaje);
            //System.out.println("Viaje serializado en XML en " + archivo);
        } 
        catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static IViaje deserializarViajeXML(String archivo) {
    	IViaje viaje = null;
        try (InputStream fileIn = new FileInputStream(archivo);
             XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(fileIn))) {
        	viaje = (IViaje) decoder.readObject();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return viaje;
    }
}
