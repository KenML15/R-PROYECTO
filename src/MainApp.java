import java.util.Scanner; // Clase necesaria para leer la entrada del usuario.

public class MainApp {

    // --- CONSTANTES ---
    private static final int BOARD_SIZE = 5; // Tamaño del tablero 5x5.

    // --- MÉTODO PRINCIPAL: PUNTO DE ENTRADA ---

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false; // Bandera para controlar la salida del bucle principal.

        // Inicializa el cerebro del juego (Controller) con los parámetros base.
        Controller game = new Controller(BOARD_SIZE, "Player 1", "Player 2");
        System.out.println("Welcome to ARENA DE HEROES");

        // --- BUCLE PRINCIPAL DEL MENÚ ---
        while (!exit) {

            showmenu(); // 1. MOSTRAR EL MENÚ

            // 2. VERIFICAR Y LEER ENTRADA (Manejo de errores de input)
            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine(); // CLAVE: Consume el salto de línea pendiente después del número.

                // 3. PROCESAR LA OPCIÓN
                switch (option) {
                    case 1:
                        showhistory(); // Muestra la historia/reglas.
                        break;
                    case 2:
                        System.out.println("\nPreparing the battlefield...!\n");
                        // CLAVE: Cede el control del juego al Controller.startGame().
                        game.startGame();
                        break;
                    case 3:
                        exit = true; // Establece la bandera para salir del bucle.
                        System.out.println("End of the game. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please enter 1, 2, or 3");
                        break;
                }
            } else {
                // Manejo de entrada no numérica (e.g., el usuario escribe una letra).
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Limpia el buffer para evitar un bucle infinito de error.
            }
        }

        // CERRAR EL SCANNER AL FINAL DE LA APLICACIÓN para liberar recursos.
        scanner.close();
    }

    // --- MÉTODOS DE LA INTERFAZ DE USUARIO ---

    /**
     * Simplemente imprime las opciones disponibles en el menú principal.
     */
    public static void showmenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. History");
        System.out.println("2. Play");
        System.out.println("3. Exit");
        System.out.print("Enter your option: ");
    }

    /**
     * Imprime el trasfondo (lore) y las reglas básicas del juego.
     */
    private static void showhistory() {
        // ... (Contenido de la historia y reglas) ...
    }

}
