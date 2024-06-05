package Persistencia;

import java.io.Serializable;

public class EmpresaDTO implements Serializable {
    private AdministradorDTO admin;
    /**
     * Atributo al cual Empresa delega las funcionalidades tipicas del administrador
     */
    private AdmSubSistemaDTO admSubSistemaDTO;
    /**
     * Atributo al cual Empresa delega las funcionalidades referidas al tratamiento de viajes y funcionalidades del cliente
     */
    private ViajesSubSistemaDTO viajesSubSistemaDTO;

    public AdministradorDTO getAdmin() {
        return admin;
    }

    public void setAdmin(AdministradorDTO admin) {
        this.admin = admin;
    }

    public AdmSubSistemaDTO getAdmSubSistemaDTO() {
        return admSubSistemaDTO;
    }

    public void setAdmSubSistemaDTO(AdmSubSistemaDTO admSubSistemaDTO) {
        this.admSubSistemaDTO = admSubSistemaDTO;
    }

    public ViajesSubSistemaDTO getViajesSubSistemaDTO() {
        return viajesSubSistemaDTO;
    }

    public void setViajesSubSistemaDTO(ViajesSubSistemaDTO viajesSubSistemaDTO) {
        this.viajesSubSistemaDTO = viajesSubSistemaDTO;
    }
}
