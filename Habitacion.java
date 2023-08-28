/**
 * Clase que representa una habitación en el hotel.
 * Cada habitación tiene un número único, un tipo (Estándar, Deluxe, Suite),
 * una capacidad máxima de ocupantes y un precio por noche.
 * Además, mantiene un estado que indica si está disponible o reservada.
 * 
 * @author Fernando Hernandez
 * @version 1.0
 */
public class Habitacion {
    
    /** Número único de la habitación */
    private int numero;
    
    /** Tipo de habitación (Estándar, Deluxe, Suite) */
    private String tipo;
    
    /** Capacidad máxima de ocupantes de la habitación */
    private int capacidad;
    
    /** Precio por noche de la habitación */
    private double precioPorNoche;
    
    /** Estado de la habitación (disponible o reservada) */
    private String estado;

    /**
     * Constructor de la clase Habitacion.
     * 
     * @param numero Número único de la habitación.
     * @param tipo Tipo de habitación.
     * @param capacidad Capacidad máxima de ocupantes.
     * @param precioPorNoche Precio por noche.
     */
    public Habitacion(int numero, String tipo, int capacidad, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precioPorNoche = precioPorNoche;
        this.estado = "disponible"; // Por defecto, la habitación está disponible
    }

    /**
     * Reserva la habitación. Si ya está reservada, muestra un mensaje.
     */
    public void reservar() {
        if (estado.equals("disponible")) {
            estado = "reservada";
        } else {
            System.out.println("La habitación ya está reservada.");
        }
    }

    /**
     * Libera la habitación. Si ya está disponible, muestra un mensaje.
     */
    public void liberar() {
        if (estado.equals("reservada")) {
            estado = "disponible";
        } else {
            System.out.println("La habitación ya está disponible.");
        }
    }

    /**
     * Verifica si la habitación está disponible.
     * 
     * @return true si la habitación está disponible, false en caso contrario.
     */
    public boolean verificarDisponibilidad() {
        return estado.equals("disponible");
    }

    // Getters y Setters con comentarios Javadoc

    /** @return Número único de la habitación */
    public int getNumero() {
        return numero;
    }

    /** @return Tipo de habitación */
    public String getTipo() {
        return tipo;
    }

    /** @return Capacidad máxima de ocupantes */
    public int getCapacidad() {
        return capacidad;
    }

    /** @return Precio por noche de la habitación */
    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    /** @return Estado actual de la habitación (disponible o reservada) */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el tipo de habitación.
     * 
     * @param tipo Nuevo tipo de habitación.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Establece la capacidad máxima de ocupantes.
     * 
     * @param capacidad Nueva capacidad máxima.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Establece el precio por noche de la habitación.
     * 
     * @param precioPorNoche Nuevo precio por noche.
     */
    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    /**
     * Representación en cadena de la habitación.
     * 
     * @return Una cadena con los detalles de la habitación.
     */
    @Override
    public String toString() {
        return "Habitacion [numero=" + numero + ", tipo=" + tipo + ", capacidad=" + capacidad + ", precioPorNoche=" + precioPorNoche + ", estado=" + estado + "]";
    }
}
