package Persistencia;

import java.io.Serializable;

import Persistencia.sistemaDTO.EmpresaDTO;
import excepciones.usuario.ExceptionUsuario;
import sistema.Empresa;

public class UTILEmpresa implements Serializable{
    public static EmpresaDTO empresaDTOFromEmpresa(Empresa empresa) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setAdmSubSistemaDTO(UTILAdmSubSistema.admSubSistemaDTOfromAdmSubSistema(empresa.getAdmSubSys()));
        empresaDTO.setViajesSubSistemaDTO(UTILViajesSubSistema.viajesSubsistemaDTOfromViajesSubSistema(empresa.getViajesSubSistema()));
        if(empresa.getAdmin()!=null) empresaDTO.setAdminDTO(UTILAdmSubSistema.administradorDTOFromAdministrador(empresa.getAdmin()));
        return empresaDTO;
    }

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
