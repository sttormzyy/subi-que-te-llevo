package Persistencia;

import java.time.LocalDateTime;

/**
 * Clase para representar el objeto LocalDateTimeDTO a partir de una fecha LocalDateTime.
 */
public class LocalDateTimeDTO {
    private int anio, segundo, mes, dia, hora, minuto;

    /**
     * Constructor por defecto de LocalDateTimeDTO.
     */
    public LocalDateTimeDTO() {
    }

    /**
     * Obtiene el año.
     * 
     * @return El año.
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Establece el año.
     * 
     * @param anio El año a establecer.
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Obtiene el segundo.
     * 
     * @return El segundo.
     */
    public int getSegundo() {
        return segundo;
    }

    /**
     * Establece el segundo.
     * 
     * @param segundo El segundo a establecer.
     */
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    /**
     * Obtiene el mes.
     * 
     * @return El mes.
     */
    public int getMes() {
        return mes;
    }

    /**
     * Establece el mes.
     * 
     * @param mes El mes a establecer.
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Obtiene el día.
     * 
     * @return El día.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Establece el día.
     * 
     * @param dia El día a establecer.
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Obtiene la hora.
     * 
     * @return La hora.
     */
    public int getHora() {
        return hora;
    }

    /**
     * Establece la hora.
     * 
     * @param hora La hora a establecer.
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el minuto.
     * 
     * @return El minuto.
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Establece el minuto.
     * 
     * @param minuto El minuto a establecer.
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
}

