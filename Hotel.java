/**
 * Clase que representa un hotel con sus habitaciones, reservas y lista de espera.
 * 
 * @author Fernando Hernandez
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Date;

public class Hotel {
    
    // Propiedades
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Reserva> reservas;
    private ArrayList<Cliente> listaEspera;

    // Constructor
    public Hotel() {
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.listaEspera = new ArrayList<>();
    }

    // Métodos

    // Agrega una nueva habitación al hotel
    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    // Asigna un cliente a una habitación disponible
    public boolean asignarClienteAHabitacion(Cliente cliente) {
        // Primero, intentamos encontrar una habitación que coincida con el tipo de cliente
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.verificarDisponibilidad() && esClienteAptoParaHabitacion(cliente, habitacion)) {
                Reserva reserva = new Reserva(cliente, habitacion, new Date(), null); // Suponiendo que la fecha de fin se define más tarde
                reservas.add(reserva);
                habitacion.reservar();
                return true;
            }
        }

        // Si no se encuentra una habitación adecuada que coincida con el tipo de cliente, buscamos cualquier habitación disponible
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.verificarDisponibilidad()) {
                Reserva reserva = new Reserva(cliente, habitacion, new Date(), null); // Suponiendo que la fecha de fin se define más tarde
                reservas.add(reserva);
                habitacion.reservar();
                return true;
            }
        }

        // Si no se encuentra ninguna habitación adecuada, se agrega al cliente a la lista de espera
        listaEspera.add(cliente);
        return false;
    }

    // Verifica si el cliente cumple con los requisitos para reservar una habitación específica
    private boolean esClienteAptoParaHabitacion(Cliente cliente, Habitacion habitacion) {
        switch (habitacion.getTipo()) {
            case "Estándar":
                return true;
            case "Deluxe":
                return cliente.getTipo().equals("Frecuente") || cliente.getTipo().equals("VIP");
            case "Suite":
                return cliente.getTipo().equals("VIP");
            default:
                return false;
        }
    }

    // Muestra las habitaciones ocupadas
    public void mostrarHabitacionesOcupadas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva.getHabitacion().toString() + " ocupada por " + reserva.getCliente().getNombre());
        }
    }

    // Muestra la lista de espera
    public void mostrarListaDeEspera() {
        for (Cliente cliente : listaEspera) {
            System.out.println(cliente.getNombre());
        }
    }

    // Getters
    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public ArrayList<Cliente> getListaEspera() {
        return listaEspera;
    }

    @Override
    public String toString() {
        return "Hotel [habitaciones=" + habitaciones.size() + ", reservas=" + reservas.size() + ", listaEspera=" + listaEspera.size() + "]";
    }
}
