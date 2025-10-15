public class Board {

    // --- ATRIBUTOS FUNDAMENTALES ---

    // El tamaño (e.g., 5 para 5x5). Es inmutable una vez que se crea el tablero.
    private final int SIZE;

    // Constante que representa una casilla vacía. Usar una constante hace el código más legible.
    static final char EMPTY = '.';

    // La matriz 2D que realmente almacena el estado del tablero (los símbolos de los héroes).
    private char[][] board;

    // --- CONSTRUCTOR ---

    // Al crear el tablero, definimos su tamaño y lo inicializamos.
    public Board(int size) {
        this.SIZE = size;
        this.board = new char[SIZE][SIZE];
        init(); // Llama al método para llenar el tablero con casillas vacías.
    }

    // --- GESTIÓN DEL ESTADO DEL TABLERO ---

    /**
     * Inicializa la matriz, llenando todas las casillas con el símbolo EMPTY ('.').
     */
    public void init() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    /**
     * Coloca un héroe en el tablero. Es llamado durante el setup y después de un movimiento.
     * @param symbol El símbolo del héroe (e.g., 'G', 'A').
     * @param p La posición de destino.
     */
    public void placeHeroe(char symbol, Position p) {
        if (isValidPosition(p)) {
            board[p.ROW][p.COLUMN] = symbol;
        } else {
            System.err.println("Error: Position out of board bounds.");
        }
    }

    /**
     * Limpia una casilla, restableciéndola a EMPTY.
     * Es crucial para "desocupar" la posición anterior de un héroe que se mueve o muere.
     * @param p La posición a limpiar.
     */
    public void clearPosition(Position p) {
        if (isValidPosition(p)) {
            board[p.ROW][p.COLUMN] = EMPTY;
        }
    }

    // --- MÉTODOS DE VALIDACIÓN LÓGICA ---

    /**
     * Verifica si una posición está ocupada por un héroe.
     * Es clave para la validación de movimientos (no puedes moverte a una casilla ocupada).
     * @param p La posición a revisar.
     * @return true si la posición es válida Y no está vacía.
     */
    public boolean isOccupied(Position p) {
        // Primero verifica que la posición esté dentro de los límites.
        // Luego verifica que el contenido de esa casilla NO sea el símbolo EMPTY.
        return isValidPosition(p) && board[p.ROW][p.COLUMN] != EMPTY;
    }

    /**
     * Comprueba si una posición está dentro de los límites del tablero (0 a SIZE-1).
     * @param p La posición a verificar.
     * @return true si la posición es segura y válida.
     */
    public boolean isValidPosition(Position p) {
        return p.ROW >= 0 && p.ROW < SIZE && p.COLUMN >= 0 && p.COLUMN < SIZE;
    }


    // --- GETTERS ---

    // Retorna la matriz, útil si el Controller necesita analizar el tablero directamente.
    public char[][] getBoard() {
        return board;
    }

    public int getSize() {
        return SIZE;
    }

    // --- VISUALIZACIÓN ---

    /**
     * Imprime el tablero en la consola con formato, incluyendo coordenadas (0, 1, 2...).
     * Es la interfaz visual principal para el jugador.
     */
    public void printboard() {
        // ... Lógica detallada para dibujar las coordenadas y las líneas de la cuadrícula.
        // Se asegura de que la salida sea legible y alineada.

        System.out.print("    ");
        for (int j = 0; j < SIZE; j++) {
            System.out.print(j + "   ");
        }
        System.out.println();
        // ... (código que dibuja el tablero y el contenido) ...
    }

}
