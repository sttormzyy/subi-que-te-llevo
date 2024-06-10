package Persistencia;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Persistencia.sistemaDTO.ViajesSubSistemaDTO;
import Persistencia.viajeDTO.PedidoDTO;
import Persistencia.viajeDTO.ViajeDTO;
import sistema.ViajesSubSistema;
import viajes.IViaje;
import viajes.Pedido;
import viajes.ViajeFactory;

/**
 * Clase de utilidad para la gestion del subsistema relacionados con viajes.
 * Proporciona metodos estaticos para la conversion entre objetos del modelo y DTOs (Data Transfer Objects) relacionados con los viajes.
 */
public class UTILViajesSubSistema {
    private static final ViajeFactory viajeFactory = new ViajeFactory();

    /**
     * Convierte un objeto de tipo ViajesSubSistema en un objeto de tipo ViajesSubSistemaDTO.
     * 
     * @param viajesSubSistema Objeto de tipo ViajesSubSistema a convertir.
     * @return Objeto de tipo ViajesSubSistemaDTO resultante de la conversion.
     */
    public static ViajesSubSistemaDTO viajesSubsistemaDTOfromViajesSubSistema(ViajesSubSistema viajesSubSistema) {
        ViajesSubSistemaDTO viajesSubDTO = new ViajesSubSistemaDTO();
        ArrayList<ViajeDTO> viajeLista = new ArrayList<ViajeDTO>();
        for(int i = 0; i < viajesSubSistema.getViajeLista().size(); i++) {
            viajeLista.add(UTILViajesSubSistema.viajeDTOFromIViaje(viajesSubSistema.getViajeLista().get(i)));
        }
        viajesSubDTO.setViajeListaDTO(viajeLista);
        return viajesSubDTO;
    }

    /**
     * Convierte un objeto de tipo ViajesSubSistemaDTO en un objeto de tipo ViajesSubSistema.
     * 
     * @param viajesSubSistemaDTO Objeto de tipo ViajesSubSistemaDTO a convertir.
     * @return Objeto de tipo ViajesSubSistema resultante de la conversion.
     */
    public static ViajesSubSistema viajesSubsistemafromViajesSubSistemaDTO(ViajesSubSistemaDTO viajesSubSistemaDTO) {
        ViajesSubSistema viajesSub = new ViajesSubSistema();
        ArrayList<IViaje> viajeLista = new ArrayList<IViaje>();
        for(int i = 0; i < viajesSub.getViajeLista().size(); i++) {
            viajeLista.add(iViajeAViajeDTO(viajesSubSistemaDTO.getViajeListaDTO().get(i)));
        }
        viajesSub.setViajeLista(viajeLista);
        return viajesSub;
    }

    /**
     * Convierte un objeto de tipo IViaje en un objeto de tipo ViajeDTO.
     * 
     * @param viaje Objeto de tipo IViaje a convertir.
     * @return Objeto de tipo ViajeDTO resultante de la conversion.
     */
    public static ViajeDTO viajeDTOFromIViaje(IViaje viaje) {
        ViajeDTO viajeDTO = new ViajeDTO();
        if(viaje.getChofer()!=null)
        viajeDTO.setChofer(UTILAdmSubSistema.ChoferDTOFromChofer(viaje.getChofer()));
        else
        viajeDTO.setChofer(null);
        if(viaje.getVehiculo()!=null)
        viajeDTO.setVehiculo(UTILAdmSubSistema.vehiculoDTOFromVehiculo(viaje.getVehiculo()));
        else
         viajeDTO.setVehiculo(null);   
        viajeDTO.setDistancia(viaje.getDistancia());
        viajeDTO.setEstado(viaje.getEstado());
        viajeDTO.setCalificacionChofer(viaje.getCalificacionChofer());
        viajeDTO.setPedidoDTO(pedidoDTOfromPedido(viaje.getPedido()));
        return viajeDTO;
    }

    /**
     * Convierte un objeto de tipo ViajeDTO en un objeto de tipo IViaje.
     * 
     * @param viajeDTO Objeto de tipo ViajeDTO a convertir.
     * @return Objeto de tipo IViaje resultante de la conversion.
     */
    public static IViaje iViajeAViajeDTO(ViajeDTO viajeDTO) {
        IViaje viaje = viajeFactory.getViaje(pedidoFromPedidoDTO(viajeDTO.getPedidoDTO()), viajeDTO.getDistancia());
        viaje.setChofer(UTILAdmSubSistema.choferFromChoferDTO(viajeDTO.getChofer()));
        viaje.setEstado(viajeDTO.getEstado());
        viaje.setVehiculo(UTILAdmSubSistema.vehiculoFromVehiculoDTO(viajeDTO.getVehiculo()));
        viaje.setCalificacionChofer(viajeDTO.getCalificacionChofer());
        return viaje;
    }

    /**
     * Convierte un objeto de tipo Pedido en un objeto de tipo PedidoDTO.
     * 
     * @param pedido Objeto de tipo Pedido a convertir.
     * @return Objeto de tipo PedidoDTO resultante de la conversion.
     */
    public static PedidoDTO pedidoDTOfromPedido(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setCantPax(pedido.getCantPax());
        pedidoDTO.setMascota(pedido.getMascota());
        pedidoDTO.setEquipaje(pedido.getEquipaje());
        pedidoDTO.setFechaDTO(localDateTimeDTOFromLocalDateTime(pedido.getFecha()));
        pedidoDTO.setZona(pedido.getZona());
        pedidoDTO.setClienteDTO(UTILAdmSubSistema.clienteDTOFromCliente(pedido.getCliente()));
        return pedidoDTO;
    }

    /**
     * Convierte un objeto de tipo PedidoDTO en un objeto de tipo Pedido.
     * 
     * @param pedidoDTO Objeto de tipo PedidoDTO a convertir.
     * @return Objeto de tipo Pedido resultante de la conversion.
     */
    public static Pedido pedidoFromPedidoDTO(PedidoDTO pedidoDTO) {

        return new Pedido(
                UTILAdmSubSistema.clienteFromClienteDTO(pedidoDTO.getClienteDTO()),
                localDateTimeFromLocalDateTimeDTO(pedidoDTO.getFechaDTO()),
                pedidoDTO.getZona(),
                pedidoDTO.getMascota(),
                pedidoDTO.getEquipaje(),
                pedidoDTO.getCantPax()
                );
    }

    /**
     * Convierte un objeto de tipo LocalDateTime en un objeto de tipo LocalDateTimeDTO.
     * 
     * @param ldt Objeto de tipo LocalDateTime a convertir.
     * @return Objeto de tipo LocalDateTimeDTO resultante de la conversion.
     */
    public static LocalDateTime localDateTimeFromLocalDateTimeDTO(LocalDateTimeDTO ldtDTO) {
        return LocalDateTime.of(
                ldtDTO.getAnio(),
                ldtDTO.getMes(),
                ldtDTO.getDia(),
                ldtDTO.getHora(),
                ldtDTO.getMinuto(),
                ldtDTO.getSegundo()
        );
    }

    /**
     * Convierte un objeto de tipo LocalDateTimeDTO en un objeto de tipo LocalDateTime.
     * 
     * @param ldtDTO Objeto de tipo LocalDateTimeDTO a convertir.
     * @return Objeto de tipo LocalDateTime resultante de la conversion.
     */
    public static LocalDateTimeDTO localDateTimeDTOFromLocalDateTime(LocalDateTime ldt) {
        LocalDateTimeDTO ldtDTO = new LocalDateTimeDTO();
        ldtDTO.setAnio(ldt.getYear());
        ldtDTO.setMes(ldt.getMonthValue());
        ldtDTO.setDia(ldt.getDayOfMonth());
        ldtDTO.setHora(ldt.getHour());
        ldtDTO.setMinuto(ldt.getMinute());
        ldtDTO.setSegundo(ldt.getSecond());
        return ldtDTO;
    }
}
