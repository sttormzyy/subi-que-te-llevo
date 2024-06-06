package Persistencia;

import excepciones.usuario.ExceptionUsuario;
import sistema.Empresa;

public class UTILEmpresa {
    public static EmpresaDTO empresaDTOFromEmpresa(Empresa empresa) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setAdmSubSistemaDTO(UTILAdmSubSistema.admSubSistemaDTOfromAdmSubSistema(empresa.getAdmSubSys()));
        empresaDTO.setViajesSubSistemaDTO(UTILViajesSubSistema.viajesSubsistemaDTOfromViajesSubSistema(empresa.getViajesSubSistema()));
        empresaDTO.setAdmin(UTILAdmSubSistema.administradorDTOFromAdministrador(empresa.getAdmin()));
        return empresaDTO;
    }

    // Paso empresa como parametro???
    public static Empresa empresaFromEmpresaDTO(EmpresaDTO empresaDTO) {
        Empresa empresa = Empresa.getInstance();
        empresa.setAdmSubSistema(UTILAdmSubSistema.admSubSistemaFromAdmSubSistemaDTO(empresaDTO.getAdmSubSistemaDTO()));
        empresa.setViajesSubSistema(UTILViajesSubSistema.viajesSubsistemafromViajesSubSistemaDTO(empresaDTO.getViajesSubSistemaDTO()));
        try {
            empresa.addAdmin(UTILAdmSubSistema.administradorFromAdministradorDTO(empresaDTO.getAdmin()));
        } catch (ExceptionUsuario e) {
            // Hay que ver que hacemos acá
        }
        return empresa;
    }
}
