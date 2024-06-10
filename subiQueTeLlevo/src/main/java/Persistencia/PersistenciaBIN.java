package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * La clase PersistenciaBIN proporciona métodos para la persistencia de objetos en formato binario.
 */
public class PersistenciaBIN implements IPersistencia<Serializable> {
    private FileOutputStream fileoutput;
    private FileInputStream fileinput;
    private ObjectOutputStream objectoutput;
    private ObjectInputStream objectinput;

    /**
     * Abre un archivo de entrada para leer objetos.
     * @param nombre El nombre del archivo.
     * @throws IOException Si ocurre un error de entrada/salida al abrir el archivo.
     */
    public void abrirInput(String nombre) throws IOException {
        fileinput = new FileInputStream(nombre);
        objectinput = new ObjectInputStream(fileinput);
    }

    /**
     * Abre un archivo de salida para escribir objetos.
     * @param nombre El nombre del archivo.
     * @throws IOException Si ocurre un error de entrada/salida al abrir el archivo.
     */
    public void abrirOutput(String nombre) throws IOException {
        fileoutput = new FileOutputStream(nombre);
        objectoutput = new ObjectOutputStream(fileoutput);
    }

    /**
     * Cierra el archivo de salida.
     * @throws IOException Si ocurre un error de entrada/salida al cerrar el archivo.
     */
    public void cerrarOutput() throws IOException {
        if (objectoutput != null)
            objectoutput.close();
    }

    /**
     * Cierra el archivo de entrada.
     * @throws IOException Si ocurre un error de entrada/salida al cerrar el archivo.
     */
    public void cerrarInput() throws IOException {
        if (objectinput != null)
            objectinput.close();
    }

    /**
     * Escribe un objeto serializable en el archivo de salida.
     * @param serializable El objeto serializable a escribir.
     * @throws IOException Si ocurre un error de entrada/salida al escribir el objeto.
     */
    public void escribir(Serializable serializable) throws IOException {
        if (objectoutput != null)
            objectoutput.writeObject(serializable);
    }

    /**
     * Lee un objeto serializable desde el archivo de entrada.
     * @return El objeto serializable leido.
     * @throws IOException Si ocurre un error de entrada/salida al leer el objeto.
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */
    public Serializable leer() throws IOException, ClassNotFoundException {
        Serializable serializable = null;
        if (objectinput != null)
            serializable = (Serializable) objectinput.readObject();
        return serializable;
    }
}

