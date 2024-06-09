package Persistencia.usuarioDTO;

public class ClienteDTO extends UsuarioDTO {
	private int puntos;
        private boolean usandoApp;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(String nombre, String usuario, String contrasena) {
		super(nombre, usuario, contrasena);
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

    public boolean isUsandoApp() {
        return usandoApp;
    }

    public void setUsandoApp(boolean usandoApp) {
        this.usandoApp = usandoApp;
    }
        
     
}
