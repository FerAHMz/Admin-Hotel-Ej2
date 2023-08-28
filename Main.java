/**
 * Clase principal que proporciona una interfaz de usuario para gestionar las reservas de habitaciones en un hotel.
 * 
 * @author Fernando Hernandez
 * @version 1.0
 */
import java.util.Scanner;

public class Main {

    /**
     * Método principal que se ejecuta al iniciar el programa.
     * 
     * @param args Argumentos de línea de comando.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Inicialización de mínimo 3 habitaciones disponibles
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese los datos de la habitación " + (i + 1) + ":");
            System.out.print("Número: ");
            int numero = scanner.nextInt();
            System.out.print("Tipo (Estándar/Deluxe/Suite): ");
            String tipo = scanner.next();
            System.out.print("Capacidad máxima de ocupantes: ");
            int capacidad = scanner.nextInt();
            System.out.print("Precio por noche: ");
            double precio = scanner.nextDouble();
            Habitacion habitacion = new Habitacion(numero, tipo, capacidad, precio);
            hotel.agregarHabitacion(habitacion);
        }

        // Inicialización de variable cliente
        Cliente cliente = null;

        // Menú principal de interacción
        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Recibir huésped");
            System.out.println("2. Asignar cliente a habitación");
            System.out.println("3. Ver habitaciones ocupadas");
            System.out.println("4. Ver lista de espera");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Recibir datos del huésped
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese el número de veces que ha visitado el hotel: ");
                    int visitas = scanner.nextInt();
                    cliente = new Cliente(nombre, visitas);
                    break;
                case 2:
                    // Intentar asignar cliente a habitación
                    if (cliente != null && hotel.asignarClienteAHabitacion(cliente)) {
                        System.out.println("Cliente asignado a habitación exitosamente.");
                    } else {
                        System.out.println("No se pudo asignar al cliente a una habitación. Se ha agregado a la lista de espera.");
                    }
                    break;
                case 3:
                    // Mostrar habitaciones ocupadas
                    hotel.mostrarHabitacionesOcupadas();
                    break;
                case 4:
                    // Mostrar lista de espera
                    hotel.mostrarListaDeEspera();
                    break;
                case 5:
                    // Salir del programa
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
