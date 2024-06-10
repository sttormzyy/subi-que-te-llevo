package Persistencia.sistemaDTO;

import java.io.Serializable;

import Persistencia.usuarioDTO.AdministradorDTO;

/**
 * La clase EmpresaDTO es una clase que representa la estructura de datos de una empresa en forma de DTO (Data Transfer Object).
 * Contiene información sobre el administrador de la empresa, el sub-sistema de administración y el sub-sistema de viajes.
 * 
 * Como la clase Empresa aplica Singleton necesitamos constructores públicos.
 */
public class EmpresaDTO implements Serializable {
    
    private AdministradorDTO admin;                // El administrador de la empresa
    private AdmSubSistemaDTO admSubSistema;        // El sub-sistema de administración
    private ViajesSubSistemaDTO viajesSubSistema;  // El sub-sistema de viajes
    
    /**
     * Constructor por defecto de la clase EmpresaDTO.
     */
    public EmpresaDTO() {
    }

    /**
     * Constructor de la clase EmpresaDTO que inicializa el administrador, el sub-sistema de administración
     * y el sub-sistema de viajes de la empresa.
     * 
     * @param admin El administrador de la empresa.
     * @param admSubSistema El sub-sistema de administración de la empresa.
     * @param viajesSubSistema El sub-sistema de viajes de la empresa.
     */
    public EmpresaDTO(AdministradorDTO admin, AdmSubSistemaDTO admSubSistema, ViajesSubSistemaDTO viajesSubSistema) {
        this.admin = admin;
        this.admSubSistema = admSubSistema;
        this.viajesSubSistema = viajesSubSistema;
    }

    /**
     * Obtiene el administrador de la empresa.
     * 
     * @return El administrador de la empresa.
     */
    public AdministradorDTO getAdminDTO() {
        return admin;
    }

    /**
     * Establece el administrador de la empresa.
     * 
     * @param admin El nuevo administrador de la empresa.
     */
    public void setAdminDTO(AdministradorDTO admin) {
        this.admin = admin;
    }

    /**
     * Obtiene el sub-sistema de administración de la empresa.
     * 
     * @return El sub-sistema de administración de la empresa.
     */
    public AdmSubSistemaDTO getAdmSubSistemaDTO() {
        return admSubSistema;
    }

    /**
     * Establece el sub-sistema de administración de la empresa.
     * 
     * @param admSubSistema El nuevo sub-sistema de administración de la empresa.
     */
    public void setAdmSubSistemaDTO(AdmSubSistemaDTO admSubSistema) {
        this.admSubSistema = admSubSistema;
    }

    /**
     * Obtiene el sub-sistema de viajes de la empresa.
     * 
     * @return El sub-sistema de viajes de la empresa.
     */
    public ViajesSubSistemaDTO getViajesSubSistemaDTO() {
        return viajesSubSistema;
    }

    /**
     * Establece el sub-sistema de viajes de la empresa.
     * 
     * @param viajesSubSistema El nuevo sub-sistema de viajes de la empresa.
     */
    public void setViajesSubSistemaDTO(ViajesSubSistemaDTO viajesSubSistema) {
        this.viajesSubSistema = viajesSubSistema;
    }
}

