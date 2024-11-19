import java.util.Scanner;

public class Menu {
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bienvenido a la aplicación");
            System.out.println("Te encontraras con una serie de PRUEBAS TECNICAS TRAINEE/JUNIOR");
            System.out.println("Cualquier consulta puedes consultar el codigo fuente para ver el desarrollo del mismo");
            System.out.println("1. Ejercicio 1 - Manejo de logica Matrices ");
            System.out.println("2. Ejercicio 2 - POO pt1 Sistema de Cines");
            System.out.println("3. Ejercicio 3 - POO pt2 Sistema bibliotecario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    Ejercicio1.explainExercise();
                    Ejercicio1.executeCode();
                    break;
                case 2:
                    Ejercicio2.explainExercise();
                    Ejercicio2.executeCode();
                    break;
                case 3:
                    Ejercicio3.explainExercise();
                    Ejercicio3.executeCode();
                case 4:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}
