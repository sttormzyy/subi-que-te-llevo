package Persistencia.sistemaDTO;

import java.io.Serializable;

import Persistencia.usuarioDTO.AdministradorDTO;
import sistema.AdmSubSistema;
import sistema.ViajesSubSistema;
import usuarios.Administrador;

public class EmpresaDTO implements Serializable{
    private AdministradorDTO admin;
    private AdmSubSistemaDTO admSubSistema;
    private ViajesSubSistemaDTO viajesSubSistema;
    
    //Como la clase Empresa aplica Singleton necesitamos constructores publicos
    public EmpresaDTO() {
    }

    public EmpresaDTO(AdministradorDTO admin, AdmSubSistemaDTO admSubSistema, ViajesSubSistemaDTO viajesSubSistema) {
        this.admin = admin;
        this.admSubSistema = admSubSistema;
        this.viajesSubSistema = viajesSubSistema;
    }

    public AdministradorDTO getAdminDTO() {
        return admin;
    }

    public void setAdminDTO(AdministradorDTO admin) {
        this.admin = admin;
    }

    public AdmSubSistemaDTO getAdmSubSistemaDTO() {
        return admSubSistema;
    }

    public void setAdmSubSistemaDTO(AdmSubSistemaDTO admSubSistema) {
        this.admSubSistema = admSubSistema;
    }

    public ViajesSubSistemaDTO getViajesSubSistemaDTO() {
        return viajesSubSistema;
    }

    public void setViajesSubSistemaDTO(ViajesSubSistemaDTO viajesSubSistema) {
        this.viajesSubSistema = viajesSubSistema;
    }
}
