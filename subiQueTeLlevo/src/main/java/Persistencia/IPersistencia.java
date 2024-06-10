package Persistencia;

import java.io.IOException;
import java.io.Serializable;

/**
 * La interfaz IPersistencia define los metodos basicos para la persistencia de objetos.
 * @param <E> El tipo de objeto a persistir.
 */
public interface IPersistencia<E> extends Serializable {
    
    /**
     * Abre un archivo de entrada para leer objetos.
     * @param nombre El nombre del archivo.
     * @throws IOException Si ocurre un error de entrada/salida al abrir el archivo.
     */
    void abrirInput(String nombre) throws IOException;

    /**
     * Abre un archivo de salida para escribir objetos.
     * @param nombre El nombre del archivo.
     * @throws IOException Si ocurre un error de entrada/salida al abrir el archivo.
     */
    void abrirOutput(String nombre) throws IOException;

    /**
     * Cierra el archivo de salida.
     * @throws IOException Si ocurre un error de entrada/salida al cerrar el archivo.
     */
    void cerrarOutput() throws IOException;

    /**
     * Cierra el archivo de entrada.
     * @throws IOException Si ocurre un error de entrada/salida al cerrar el archivo.
     */
    void cerrarInput() throws IOException;

    /**
     * Escribe un objeto en el archivo de salida.
     * @param objecto El objeto a escribir.
     * @throws IOException Si ocurre un error de entrada/salida al escribir el objeto.
     */
    void escribir(E objecto) throws IOException;

    /**
     * Lee un objeto desde el archivo de entrada.
     * @return El objeto leido.
     * @throws IOException Si ocurre un error de entrada/salida al leer el objeto.
     * @throws ClassNotFoundException Si la clase del objeto leido no puede ser encontrada.
     */
    E leer() throws IOException, ClassNotFoundException;
}

