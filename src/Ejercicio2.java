import java.util.*;

public class Ejercicio2 {
    public static void explainExercise() {
        System.out.println("Consigna del Ejercicio 2: (Basado en el escenario del sistema de reserva de asientos para un anfiteatro)");
        System.out.println("1. Crear la 'plantilla' necesaria para guardar los siguientes datos por ticket: número, fila, asiento, fecha de compra, fecha de validez, precio.\n");
        System.out.println("2. Usar una 'base de datos lógica' mediante alguna estructura de datos que permita almacenar un número indeterminado de tickets. Cargar una serie de tickets a dicha estructura.\n");
        System.out.println("3. Crear un método que recorra la estructura seleccionada y sume los precios de todos los tickets. Mostrar por pantalla el total. No es necesario usar IGU para esto.\n");
        System.out.println("4. Solicitar al usuario que ingrese un número de fila. A partir de esto, mostrar por pantalla los datos de los tickets pertenecientes a esa fila. No es necesario usar IGU para esto.\n");
        System.out.println("\nConsideraciones: No es necesaria implementación ni de IGU ni de BD. Se evaluará 100% el manejo lógico del desarrollo de la aplicación.");
        System.out.println("\nExtra: En caso que se desee agregar una 'plantilla' para clientes con los datos: id, dni, nombre, apellido.");
        System.out.println("¿Cómo se implementaría? ¿De qué manera se relacionaría con ticket para que el mismo posea los datos del cliente que tiene asignado? Realizar la implementación.");
    }

    public static void executeCode() {
        Scanner scanner = new Scanner(System.in);


        Cliente cliente1 = new Cliente(1, "12345678", "Juan", "Pérez");
        Cliente cliente2 = new Cliente(2, "87654321", "María", "García");
        Cliente cliente3 = new Cliente(3, "78623473", "María", "Lopez");

        Anfiteatro anfiteatro = new Anfiteatro();

        anfiteatro.reservarAsiento(1, 1, cliente1);
        anfiteatro.reservarAsiento(2, 3, cliente2);
        anfiteatro.reservarAsiento(2, 3, cliente3);
        anfiteatro.reservarAsiento(3, 5, cliente1);





        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Mostrar asientos libres");
            System.out.println("2. Reservar un asiento");
            System.out.println("3. Calcular total de tickets");
            System.out.println("4. Mostrar tickets por fila");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    anfiteatro.mostrarAsientosLibres();
                    break;
                case 2:
                    System.out.print("Ingrese el número de fila (1-10): ");
                    int fila = scanner.nextInt();
                    System.out.print("Ingrese el número de asiento (1-10): ");
                    int numero = scanner.nextInt();
                    System.out.print("Ingrese el ID del cliente: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el DNI del cliente: ");
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del cliente: ");
                    String apellido = scanner.nextLine();
                    Cliente cliente = new Cliente(id, dni, nombre, apellido);
                    anfiteatro.reservarAsiento(fila, numero, cliente);
                    break;
                case 3:
                    double total = anfiteatro.calcularTotalTickets();
                    System.out.println("Total de todos los tickets: " + total);
                    break;
                case 4:
                    System.out.print("Ingrese el número de fila: ");
                    fila = scanner.nextInt();
                    anfiteatro.mostrarTicketsPorFila(fila);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }

    static class Cliente {
        private int id;
        private String dni;
        private String nombre;
        private String apellido;

        // Constructor, getters y setters
        public Cliente(int id, String dni, String nombre, String apellido) {
            this.id = id;
            this.dni = dni;
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public int getId() { return id; }
        public String getDni() { return dni; }
        public String getNombre() { return nombre; }
        public String getApellido() { return apellido; }
    }

    static class Asiento {
        private int fila;
        private int numero;
        private char estado;

        public Asiento(int fila, int numero) {
            this.fila = fila;
            this.numero = numero;
            this.estado = 'L'; // Asiento libre al inicio
        }

        public int getFila() { return fila; }
        public int getNumero() { return numero; }
        public char getEstado() { return estado; }

        public void reservar() {
            if (estado == 'L') {
                estado = 'X';
            }
        }
    }

    static class Ticket {
        private int numero;
        private Asiento asiento;
        private Date fechaCompra;
        private Date fechaValidez;
        private double precio;

        public Ticket(int numero, Asiento asiento, Date fechaCompra, Date fechaValidez, double precio) {
            this.numero = numero;
            this.asiento = asiento;
            this.fechaCompra = fechaCompra;
            this.fechaValidez = fechaValidez;
            this.precio = precio;
        }

        public int getNumero() { return numero; }
        public Asiento getAsiento() { return asiento; }
        public Date getFechaCompra() { return fechaCompra; }
        public Date getFechaValidez() { return fechaValidez; }
        public double getPrecio() { return precio; }
    }

    static class Anfiteatro {
        private Asiento[][] asientos = new Asiento[10][10];
        private List<Ticket> tickets = new ArrayList<>();

        public Anfiteatro() {
            inicializarAsientos();
        }

        public void inicializarAsientos() {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    asientos[i][j] = new Asiento(i + 1, j + 1);
                }
            }
        }

        public Ticket reservarAsiento(int fila, int numero, Cliente cliente) {
            if (fila < 1 || fila > 10 || numero < 1 || numero > 10) {
                System.out.println("Número de fila o asiento inválido.");
                return null;
            }
            Asiento asiento = asientos[fila - 1][numero - 1];
            if (asiento.getEstado() == 'L') {
                asiento.reservar();
                Ticket ticket = new Ticket(tickets.size() + 1, asiento, new Date(), new Date(), 100.0); // Precio fijado en $100
                tickets.add(ticket);
                System.out.println("¡Asiento reservado exitosamente!");
                return ticket;
            } else {
                System.out.println("El asiento ya está ocupado.");
                return null;
            }
        }

        public void mostrarAsientosLibres() {
            for (Asiento[] fila : asientos) {
                for (Asiento asiento : fila) {
                    if (asiento.getEstado() == 'L') {
                        System.out.print("L ");
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
        }

        public double calcularTotalTickets() {
            return tickets.stream().mapToDouble(Ticket::getPrecio).sum();
        }

        public void mostrarTicketsPorFila(int fila) {
            tickets.stream()
                    .filter(ticket -> ticket.getAsiento().getFila() == fila)
                    .forEach(ticket -> System.out.println("Ticket #" + ticket.getNumero() + " - Fila: " + ticket.getAsiento().getFila() +
                            ", Asiento: " + ticket.getAsiento().getNumero() + ", Precio: " + ticket.getPrecio()));
        }
    }
}
