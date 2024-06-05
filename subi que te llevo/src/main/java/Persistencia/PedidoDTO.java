package Persistencia;

import java.io.Serializable;

public class PedidoDTO implements Serializable {
    private LocalDateTimeDTO fechaDTO;
    private ClienteDTO cliente;
    private String zona;
    private int mascota;
    private int equipaje;
    private int cantPax;

    public LocalDateTimeDTO getFechaDTO() {
        return fechaDTO;
    }

    public void setFechaDTO(LocalDateTimeDTO fechaDTO) {
        this.fechaDTO = fechaDTO;
    }

    public ClienteDTO getClienteDTO() {
        return cliente;
    }

    public void setClienteDTO(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getMascota() {
        return mascota;
    }

    public void setMascota(int mascota) {
        this.mascota = mascota;
    }

    public int getEquipaje() {
        return equipaje;
    }

    public void setEquipaje(int equipaje) {
        this.equipaje = equipaje;
    }

    public int getCantPax() {
        return cantPax;
    }

    public void setCantPax(int cantPax) {
        this.cantPax = cantPax;
    }
}
