import java.util.*;


public class Ejercicio1 {

    public static void explainExercise() {
        System.out.println("Consigna del Ejercicio 1: (Ejercicio tomado del canal TODOCODE - Créditos a Luisina por subirlo)");
        System.out.println("Suponer un sistema de reserva de asientos para un anfiteatro.\n" +
                "El teatro cuenta con 10 filas de 10 asientos cada una.\n" +
                "Se necesita desarrollar un sistema (sin uso de bases de datos, únicamente manejo de datos de forma lógica) que permita llevar a cabo lo siguiente:");
        System.out.println("1. Cargar el \"mapa\" de las filas y asientos. Indicando con una \"X\" los asientos ocupados\n" +
                "y con una \"L\" los asientos libres. Al iniciar el programa, todos los asientos deben estar libres.");
        System.out.println("2. Manejar la reserva de asientos contemplando que un asiento SOLO PUEDE SER RESERVADO\n" +
                "si se encuentra en estado \"L\", en caso de que esté en estado \"X\", se deberá permitir al comprador elegir otro asiento.\n" +
                "Si se encuentra en estado \"L\", deberá pasar automáticamente al estado \"X\".");
        System.out.println("3. Para finalizar el programa se deberá ingresar un valor en particular.\n" +
                "Contemplar que no existe una cantidad exacta de veces que el programa se pueda ejecutar.");
        System.out.println("4. Contemplar que SOLO EXISTEN 10 FILAS y 10 ASIENTOS. No se pueden vender asientos fuera de esas numeraciones.\n" +
                "No se permite \"sobreventa\".");
        System.out.println("\nConsideraciones: No es necesaria implementación ni de IGU ni de BD. Se evaluará 100% el manejo lógico del desarrollo de la aplicación.");
        System.out.println("\nExtra: En caso de que un cliente solicite visualizar cuáles son los asientos libres,\n" +
                "el sistema debe permitir mostrar de forma gráfica el mapa de asientos, mas NO UTILIZAR IGU para este caso.\n" +
                "Utilizar ÚNICAMENTE lógica y la salida por consola.");
    }

    public static void executeCode() {
        Scanner scanner = new Scanner(System.in);


        char[][] asientos = new char[10][10];
        for (char[] row : asientos) {
            Arrays.fill(row, 'L');
        }
        System.out.println("Estado Inicial de la sala: ");
        printMatriz(asientos);

        while (true) {
            System.out.println("Ingrese el número de fila (1-10) o 0 para salir:");
            int fila = scanner.nextInt() - 1;
            if (fila == -1) {
                break;
            }
            if (fila < 0 || fila >= 10) {
                System.out.println("Número de fila inválido. Por favor, ingrese un número entre 1 y 10.");
                continue;
            }

            System.out.println("Ingrese el número de asiento (1-10):");
            int asiento = scanner.nextInt() - 1;
            if (asiento < 0 || asiento >= 10) {
                System.out.println("Número de asiento inválido. Por favor, ingrese un número entre 1 y 10.");
                continue;
            }

            if (asientos[fila][asiento] == 'L') {
                asientos[fila][asiento] = 'X';
                System.out.println("¡Asiento reservado exitosamente!");
            } else {
                System.out.println("El asiento ya está ocupado. Por favor, elija otro.");
            }
        }
        System.out.println("Estado Final de la sala: ");
        printMatriz(asientos);
    }
    // Punto N°1 - Funcion para cargar el mapa del estado actual de la sala.
    public static void printMatriz(char[][] asientos) {
        for (char[] row : asientos) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
