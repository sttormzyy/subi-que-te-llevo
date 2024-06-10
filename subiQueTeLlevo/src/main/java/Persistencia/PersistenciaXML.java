package Persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * Esta clase proporciona metodos para la persistencia de datos en formato XML.
 */
public class PersistenciaXML implements IPersistencia {
    private XMLEncoder xmlEncoder;
    private XMLDecoder xmlDecoder;
    private FileOutputStream fileoutput;
    private FileInputStream fileinput;

    /**
     * Abre un archivo XML para lectura.
     * 
     * @param nombre El nombre del archivo XML.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public void abrirInput(String nombre) throws IOException {
        fileinput = new FileInputStream(nombre);
        xmlDecoder = new XMLDecoder(fileinput);
    }

    /**
     * Abre un archivo XML para escritura.
     * 
     * @param nombre El nombre del archivo XML.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public void abrirOutput(String nombre) throws IOException {
        fileoutput = new FileOutputStream(nombre);
        xmlEncoder = new XMLEncoder(fileoutput);
    }

    /**
     * Cierra el flujo de salida XML.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public void cerrarOutput() throws IOException {
        this.xmlEncoder.close();
    }

    /**
     * Cierra el flujo de entrada XML.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public void cerrarInput() throws IOException {
        this.xmlDecoder.close();
    }

    /**
     * Escribe un objeto en el archivo XML.
     * 
     * @param objeto El objeto a escribir en el archivo XML.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public void escribir(Object objeto) throws IOException {
        xmlEncoder.writeObject(objeto);
    }

    /**
     * Lee un objeto desde el archivo XML.
     * 
     * @return El objeto leido desde el archivo XML.
     * @throws IOException Si ocurre un error de entrada/salida.
     * @throws ClassNotFoundException Si no se puede encontrar la clase del objeto.
     */
    public Object leer() throws IOException, ClassNotFoundException {
        Object objeto = null;
        if (xmlDecoder != null)
            objeto = (Serializable) xmlDecoder.readObject();
        return objeto;
    }
}

