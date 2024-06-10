package Persistencia.usuarioDTO;

/**
 * La clase ClienteDTO es una clase que extiende la clase UsuarioDTO.
 * Representa a un Cliente.
 * 
 * Esta clase contiene información adicional específica para un Cliente, como los puntos acumulados y si está usando la aplicación.
 */
public class ClienteDTO extends UsuarioDTO {
    
    private int puntos;             // Los puntos acumulados del Cliente
    private boolean usandoApp;      // Indica si el Cliente está usando la aplicación
    
    /**
     * Constructor por defecto de la clase ClienteDTO.
     */
    public ClienteDTO() {
    }
    
    /**
     * Constructor de la clase ClienteDTO que inicializa el nombre, el usuario y la contraseña del Cliente.
     * 
     * @param nombre El nombre real del Cliente.
     * @param usuario El nombre de usuario del Cliente.
     * @param contrasena La contraseña del Cliente.
     */
    public ClienteDTO(String nombre, String usuario, String contrasena) {
        super(nombre, usuario, contrasena);
    }

    /**
     * Obtiene los puntos acumulados del Cliente.
     * 
     * @return Los puntos acumulados del Cliente.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Establece los puntos acumulados del Cliente.
     * 
     * @param puntos Los nuevos puntos acumulados del Cliente.
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Verifica si el Cliente está usando la aplicación.
     * 
     * @return true si el Cliente está usando la aplicación, false en caso contrario.
     */
    public boolean isUsandoApp() {
        return usandoApp;
    }

    /**
     * Establece si el Cliente está usando la aplicación.
     * 
     * @param usandoApp Indica si el Cliente está usando la aplicación.
     */
    public void setUsandoApp(boolean usandoApp) {
        this.usandoApp = usandoApp;
    }   
}
