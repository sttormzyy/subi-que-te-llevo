package Persistencia;

import sistema.ViajesSubSistema;
import viajes.IViaje;
import viajes.Pedido;
import viajes.ViajeFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UTILViajesSubSistema {
    private static final ViajeFactory viajeFactory = new ViajeFactory();

    public static ViajesSubSistemaDTO viajesSubsistemaDTOfromViajesSubSistema(ViajesSubSistema viajesSubSistema) {
        ViajesSubSistemaDTO viajesSubDTO = new ViajesSubSistemaDTO();
        ArrayList<ViajeDTO> viajeLista = new ArrayList<ViajeDTO>();
        for(int i = 0; i < viajesSubSistema.getViajeLista().size(); i++) {
            viajeLista.add(UTILViajesSubSistema.viajeDTOFromIViaje(viajesSubSistema.getViajeLista().get(i)));
        }
        viajesSubDTO.setViajeLista(viajeLista);
        return viajesSubDTO;
    }

    public static ViajesSubSistema viajesSubsistemafromViajesSubSistemaDTO(ViajesSubSistemaDTO viajesSubSistemaDTO) {
        ViajesSubSistema viajesSub = new ViajesSubSistema();
        ArrayList<IViaje> viajeLista = new ArrayList<IViaje>();
        for(int i = 0; i < viajesSub.getViajeLista().size(); i++) {
            viajeLista.add(iViajeAViajeDTO(viajesSubSistemaDTO.getViajeLista().get(i)));
        }
        viajesSub.setViajeLista(viajeLista);
        return viajesSub;
    }

    public static ViajeDTO viajeDTOFromIViaje(IViaje viaje) {
        ViajeDTO viajeDTO = new ViajeDTO();
        viajeDTO.setChofer(UTILAdmSubSistema.ChoferDTOFromChofer(viaje.getChofer()));
        viajeDTO.setVehiculo(UTILAdmSubSistema.vehiculoDTOFromVehiculo(viaje.getVehiculo()));
        viajeDTO.setDistancia(viaje.getDistancia());
        viajeDTO.setEstado(viaje.getEstado());
        viajeDTO.setCalificacionChofer(viaje.getCalificacionChofer());
        viajeDTO.setPedidoDTO(pedidoDTOfromPedido(viaje.getPedido()));
        return viajeDTO;
    }

    public static IViaje iViajeAViajeDTO(ViajeDTO viajeDTO) {
        IViaje viaje = viajeFactory.getViaje(pedidoFromPedidoDTO(viajeDTO.getPedidoDTO()), viajeDTO.getDistancia());
        viaje.setChofer(UTILAdmSubSistema.choferFromChoferDTO(viajeDTO.getChofer()));
        viaje.setEstado(viajeDTO.getEstado());
        viaje.setVehiculo(UTILAdmSubSistema.vehiculoFromVehiculoDTO(viajeDTO.getVehiculo()));
        viaje.setCalificacionChofer(viajeDTO.getCalificacionChofer());
        return viaje;
    }

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
