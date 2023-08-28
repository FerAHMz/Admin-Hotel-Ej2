/**
 * Clase que representa una reserva de habitación en el hotel.
 * Cada reserva está asociada a un cliente, una habitación, una fecha de inicio y una fecha de fin.
 * 
 * @author Fernando Hernandez
 * @version 1.0
 */
import java.util.Date;

public class Reserva {
    
    /** Cliente que realiza la reserva */
    private Cliente cliente;
    
    /** Habitación que se reserva */
    private Habitacion habitacion;
    
    /** Fecha de inicio de la reserva */
    private Date fechaInicio;
    
    /** Fecha de finalización de la reserva */
    private Date fechaFin;

    /**
     * Constructor de la clase Reserva.
     * 
     * @param cliente Cliente que realiza la reserva.
     * @param habitacion Habitación que se reserva.
     * @param fechaInicio Fecha de inicio de la reserva.
     * @param fechaFin Fecha de finalización de la reserva.
     */
    public Reserva(Cliente cliente, Habitacion habitacion, Date fechaInicio, Date fechaFin) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Crea una nueva reserva.
     * 
     * @param cliente Cliente que realiza la reserva.
     * @param habitacion Habitación que se reserva.
     * @param fechaInicio Fecha de inicio de la reserva.
     * @param fechaFin Fecha de finalización de la reserva.
     */
    public void crearReserva(Cliente cliente, Habitacion habitacion, Date fechaInicio, Date fechaFin) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        habitacion.reservar(); // Cambia el estado de la habitación a reservada
    }

    /**
     * Cancela una reserva existente.
     */
    public void cancelarReserva() {
        habitacion.liberar(); // Cambia el estado de la habitación a disponible
    }

    // Getters y Setters con comentarios Javadoc

    /** @return Cliente que realiza la reserva */
    public Cliente getCliente() {
        return cliente;
    }

    /** @return Habitación que se reserva */
    public Habitacion getHabitacion() {
        return habitacion;
    }

    /** @return Fecha de inicio de la reserva */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /** @return Fecha de finalización de la reserva */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece el cliente que realiza la reserva.
     * 
     * @param cliente Cliente que realiza la reserva.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Establece la habitación que se reserva.
     * 
     * @param habitacion Habitación que se reserva.
     */
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    /**
     * Establece la fecha de inicio de la reserva.
     * 
     * @param fechaInicio Fecha de inicio de la reserva.
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Establece la fecha de finalización de la reserva.
     * 
     * @param fechaFin Fecha de finalización de la reserva.
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Representación en cadena de la reserva.
     * 
     * @return Una cadena con los detalles de la reserva.
     */
    @Override
    public String toString() {
        return "Reserva [cliente=" + cliente.getNombre() + ", habitacion=" + habitacion.getNumero() + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
    }
}
