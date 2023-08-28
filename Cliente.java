/**
 * Clase que representa a un cliente del hotel.
 * Cada cliente tiene un nombre, un tipo (Regular, Frecuente, VIP) basado en el número de visitas al hotel,
 * y un registro del número total de visitas realizadas.
 * 
 * @author Fernando Hernandez
 * @version 1.0
 */
public class Cliente {
    
    /** Nombre del cliente */
    private String nombre;
    
    /** Tipo de cliente (Regular, Frecuente, VIP) */
    private String tipo;
    
    /** Número total de visitas realizadas por el cliente al hotel */
    private int visitas;

    /**
     * Constructor de la clase Cliente.
     * 
     * @param nombre Nombre del cliente.
     * @param visitas Número total de visitas realizadas por el cliente.
     */
    public Cliente(String nombre, int visitas) {
        this.nombre = nombre;
        this.visitas = visitas;
        this.tipo = clasificarCliente(); // Clasifica al cliente basado en las visitas
    }

    /**
     * Clasifica al cliente en base a sus visitas.
     * 
     * @return Tipo de cliente (Regular, Frecuente, VIP).
     */
    private String clasificarCliente() {
        if (visitas < 5) {
            return "Regular";
        } else if (visitas >= 5 && visitas < 10) {
            return "Frecuente";
        } else {
            return "VIP";
        }
    }

    /**
     * Ingresa y actualiza el número de visitas anteriores del cliente.
     * 
     * @param visitas Número de visitas a actualizar.
     */
    public void ingresarVisitas(int visitas) {
        this.visitas = visitas;
        this.tipo = clasificarCliente(); // Actualiza la clasificación del cliente
    }

    // Getters y Setters con comentarios Javadoc

    /** @return Nombre del cliente */
    public String getNombre() {
        return nombre;
    }

    /** @return Tipo de cliente (Regular, Frecuente, VIP) */
    public String getTipo() {
        return tipo;
    }

    /** @return Número total de visitas realizadas por el cliente */
    public int getVisitas() {
        return visitas;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Representación en cadena del cliente.
     * 
     * @return Una cadena con los detalles del cliente.
     */
    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", tipo=" + tipo + ", visitas=" + visitas + "]";
    }
}
