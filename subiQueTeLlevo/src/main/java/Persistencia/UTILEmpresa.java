package Persistencia;

import java.io.Serializable;

import Persistencia.sistemaDTO.EmpresaDTO;
import excepciones.usuario.ExceptionUsuario;
import sistema.Empresa;

/**
 * Clase de utilidad para la gestion de objetos Empresa y su conversion a DTOs.
 * Proporciona metodos estaticos para la conversion entre objetos de dominio y DTOs relacionados con la Empresa.
 */
public class UTILEmpresa implements Serializable{
	/**
     * Convierte un objeto de tipo Empresa en un objeto de tipo EmpresaDTO.
     * 
     * @param empresa Objeto de tipo Empresa a convertir.
     * @return Objeto de tipo EmpresaDTO resultante de la conversion.
     */
    public static EmpresaDTO empresaDTOFromEmpresa(Empresa empresa) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setAdmSubSistemaDTO(UTILAdmSubSistema.admSubSistemaDTOfromAdmSubSistema(empresa.getAdmSubSys()));
        empresaDTO.setViajesSubSistemaDTO(UTILViajesSubSistema.viajesSubsistemaDTOfromViajesSubSistema(empresa.getViajesSubSistema()));
        if(empresa.getAdmin()!=null) empresaDTO.setAdminDTO(UTILAdmSubSistema.administradorDTOFromAdministrador(empresa.getAdmin()));
        return empresaDTO;
    }

    /**
     * Convierte un objeto de tipo EmpresaDTO en un objeto de tipo Empresa.
     * 
     * @param empresaDTO Objeto de tipo EmpresaDTO a convertir.
     * @return Objeto de tipo Empresa resultante de la conversion.
     */
    public static Empresa empresaFromEmpresaDTO(EmpresaDTO empresaDTO) {
        Empresa empresa = Empresa.getInstance();
        empresa.setAdmSubSistema(UTILAdmSubSistema.admSubSistemaFromAdmSubSistemaDTO(empresaDTO.getAdmSubSistemaDTO()));
        empresa.setViajesSubSistema(UTILViajesSubSistema.viajesSubsistemafromViajesSubSistemaDTO(empresaDTO.getViajesSubSistemaDTO()));
        
        if(empresaDTO.getAdminDTO()!=null)
        try {
            empresa.addAdmin(UTILAdmSubSistema.administradorFromAdministradorDTO(empresaDTO.getAdminDTO()));
        } catch (ExceptionUsuario e) {
            // Hay que ver que hacemos acá
        }
        return empresa;
    }
}
