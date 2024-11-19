import java.lang.*;
import java.util.*;



public class Ejercicio3 {

    public static void explainExercise() {
        System.out.println("Consigna: Desarrollar un sistema de gestión para una biblioteca con las siguientes características:\n" +
                "\n 1) Inicializacion: \n" + "-> La biblioteca tiene un conjunto de libros disponibles.\n" +
                "\n" +
                "-> Cada libro tiene un título, autor, ISBN y un estado (disponible o prestado).");
        System.out.println("2) Gestión de Miembros:\n" +
                "\n" +
                "-> La biblioteca puede registrar miembros. Cada miembro tiene un ID, nombre, y correo electrónico.");
        System.out.println("3) Préstamo de Libros:\n" +
                "\n" +
                "-> Se debe permitir a los miembros tomar prestados libros si están disponibles.\n" +
                "\n" +
                "-> Al prestar un libro, su estado debe cambiar a \"prestado\".\n" +
                "\n" +
                "-> Debe registrarse la fecha de préstamo y la fecha de devolución estimada (14 días a partir del préstamo).");
        System.out.println("4) Devolución de Libros:\n" +
                "\n" +
                "-> Permitir a los miembros devolver libros.\n" +
                "\n" +
                "-> Al devolver un libro, su estado debe cambiar a \"disponible\".");
        System.out.println("5) Operaciones:\n" +
                "\n" +
                "->  el estado actual de los libros (disponibles y prestados).\n" +
                "\n" +
                "-> Mostrar los libros prestados por un miembro específico.");
        System.out.println("### Requisitos: ###\n" +
                "\n" +
                "-> No es necesaria la implementación de una interfaz gráfica (IGU).\n" +
                "\n" +
                "-> No se debe utilizar una base de datos real; el manejo de datos debe ser lógico y en memoria");
    }

    public static void executeCode() {
        BibliotecaSistema biblioteca = new BibliotecaSistema();

        // Agregar libros pre-cargados
        biblioteca.agregarLibro(new Libro("El Quijote", "Miguel de Cervantes", "1234567890"));
        biblioteca.agregarLibro(new Libro("Cien Años de Soledad", "Gabriel García Márquez", "0987654321"));
        biblioteca.agregarLibro(new Libro("La Odisea", "Homero", "1122334455"));
        biblioteca.agregarLibro(new Libro("Donde los Árboles Cantan", "Laura Gallego", "5566778899"));
        biblioteca.agregarLibro(new Libro("El Principito", "Antoine de Saint-Exupéry", "6677889900"));

        // Agregar miembros pre-cargados
        Miembro miembro1 = new Miembro(biblioteca.generarIdMiembro(), "Juan Pérez", "juan@example.com");
        Miembro miembro2 = new Miembro(biblioteca.generarIdMiembro(), "María García", "maria@example.com");
        Miembro miembro3 = new Miembro(biblioteca.generarIdMiembro(), "Carlos Mendoza", "carlos@example.com");
        Miembro miembro4 = new Miembro(biblioteca.generarIdMiembro(), "Ana Torres", "ana@example.com");
        Miembro miembro5 = new Miembro(biblioteca.generarIdMiembro(), "Luis Fernández", "luis@example.com");

        biblioteca.agregarMiembro(miembro1);
        biblioteca.agregarMiembro(miembro2);
        biblioteca.agregarMiembro(miembro3);
        biblioteca.agregarMiembro(miembro4);
        biblioteca.agregarMiembro(miembro5);

        //  préstamos ejemplpo
        biblioteca.prestarLibro("1234567890", miembro1);
        biblioteca.prestarLibro("0987654321", miembro2);
        biblioteca.prestarLibro("1122334455", miembro3);
        //Estado inicial:
        biblioteca.mostrarEstadoLibros();
        biblioteca.mostrarLibrosPrestadosPorMiembro(miembro1);
        biblioteca.devolverLibro("1234567890", miembro1);
        biblioteca.mostrarEstadoLibros();


        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\nMenú de Biblioteca");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Registrar Miembro");
            System.out.println("3. Prestar Libro");
            System.out.println("4. Devolver Libro");
            System.out.println("5. Mostrar Estado de Libros");
            System.out.println("6. Mostrar Libros Prestados por Miembro");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion) {
                case 1:
                    System.out.print("Ingrese título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese ISBN del libro: ");
                    String isbn = scanner.nextLine();
                    biblioteca.agregarLibro(new Libro(titulo, autor, isbn));
                    System.out.println("¡Libro agregado exitosamente!");
                    break;
                case 2:
                    System.out.print("Ingrese nombre del miembro: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese correo electrónico del miembro: ");
                    String correo = scanner.nextLine();
                    Miembro nuevoMiembro = new Miembro(biblioteca.generarIdMiembro(), nombre, correo);
                    biblioteca.agregarMiembro(nuevoMiembro);
                    System.out.println("¡Miembro registrado exitosamente!");
                    break;
                case 3:
                    System.out.println("Ingrese ISBN del libro a prestar: ");
                    String isbnPrestar = scanner.nextLine();
                    System.out.print("Ingrese ID del miembro: ");
                    int idMiembroPrestar = scanner.nextInt();
                    scanner.nextLine();
                    Miembro miembroPrestar = biblioteca.buscarMiembroPorId(idMiembroPrestar);
                    if (miembroPrestar != null) {
                        biblioteca.prestarLibro(isbnPrestar, miembroPrestar);
                    } else {
                        System.out.println("Miembro no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese ISBN del libro a devolver: ");
                    String isbnDevolver = scanner.nextLine();
                    System.out.print("Ingrese ID del miembro: ");
                    int idMiembroDevolver = scanner.nextInt();
                    scanner.nextLine();  // Consumir nueva línea
                    Miembro miembroDevolver = biblioteca.buscarMiembroPorId(idMiembroDevolver); // D
                    if (miembroDevolver != null) {
                        biblioteca.devolverLibro(isbnDevolver, miembroDevolver);
                    } else {
                        System.out.println("Miembro no encontrado.");
                    }
                    break;

                case 5:
                    biblioteca.mostrarEstadoLibros();
                    break;

                case 6:
                    System.out.print("Ingrese ID del miembro: ");
                    int idMiembroMostrar = scanner.nextInt();
                    scanner.nextLine();  // Consumir nueva línea
                    Miembro miembroMostrar = biblioteca.buscarMiembroPorId(idMiembroMostrar);  // Utilizar buscarMiembroPorId
                    if (miembroMostrar != null) {
                        biblioteca.mostrarLibrosPrestadosPorMiembro(miembroMostrar);
                    } else {
                        System.out.println("Miembro no encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("¡Gracias por usar el sistema de gestión de biblioteca!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");

            }
        }
    }
}
class Libro {
        private final String titulo;
        private final String autor;
        private final String isbn;
        private Boolean estado;


    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.estado = true;
    }

    public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public String getIsbn() {
            return isbn;
        }

        public boolean getEstado() {
            return estado;
        }

        public void prestar() {
            if (estado.equals(true)) {
                estado = false;
            }
        }

        public void devolver() {
            if (estado.equals(false)) {
                estado = true;
            }
        }
    }
class Miembro {
        private int id;
        private String nombre;
        private String correo;

        //CGS
        public Miembro(int id, String nombre, String correo) {
            this.id = id;
            this.nombre = nombre;
            this.correo = correo;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCorreo() {
            return correo;
        }
    }
class Prestamo {
    private final Libro libro;
    private final Miembro miembro;
    private final Date fechaPrestamo;
    private final Date fechaDevolucion;

    //CGS
    public Prestamo(Libro libro, Miembro miembro, Date fechaPrestamo, Date fechaDevolucion) {
        this.libro = libro;
        this.miembro = miembro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public Miembro getMiembro() {
        return miembro;
    }
}
class BibliotecaSistema {
        private List<Libro> libros = new ArrayList<>();
        private List<Miembro> miembros = new ArrayList<>();
        private List<Prestamo> prestamos = new ArrayList<>();

        public void agregarLibro(Libro libro) {
            libros.add(libro);
        }

        public void agregarMiembro(Miembro miembro) {
            miembros.add(miembro);
        }

         public int generarIdMiembro() {
            return miembros.size() + 1;
        }

    public Miembro buscarMiembroPorId(int id) {
        for (Miembro miembro : miembros) {
            if (miembro.getId() == id) {
                return miembro;
            }
        }
        return null;
    }


    public void prestarLibro(String isbn, Miembro miembro) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn) && libro.getEstado()) { // Corrigiendo la comparación de booleanos
                libro.prestar();
                Date fechaPrestamo = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(fechaPrestamo);
                cal.add(Calendar.DATE, 14);
                Date fechaDevolucion = cal.getTime();
                prestamos.add(new Prestamo(libro, miembro, fechaPrestamo, fechaDevolucion));
                System.out.println("¡Libro prestado exitosamente!");
                return;
            }
        }
        System.out.println("El libro no está disponible o no existe.");
    }



    public void devolverLibro(String isbn, Miembro miembro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getIsbn().equals(isbn) && prestamo.getMiembro().getId() == miembro.getId()) {
                prestamo.getLibro().devolver();
                prestamos.remove(prestamo);
                System.out.println("¡Libro devuelto exitosamente!");
                return;
            }
        }
        System.out.println("El libro no se puede devolver o no fue prestado por este miembro.");
    }

    public void mostrarEstadoLibros() {
        for (Libro libro : libros) {
            System.out.println("Título: " + libro.getTitulo() + ", Estado: " + libro.getEstado());
        }
    }

    public void mostrarLibrosPrestadosPorMiembro(Miembro miembro) {
        System.out.println("Libros prestados por " + miembro.getNombre() + ":");
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getMiembro().getId() == miembro.getId()) {
                System.out.println("Título: " + prestamo.getLibro().getTitulo() + ", Fecha de préstamo: " + prestamo.getFechaPrestamo());
            }
        }
    }
}


