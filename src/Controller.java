import java.util.ArrayList; // Necesario para la inicialización
import java.util.List;    // Necesario para el método selectHeroe
import java.util.Scanner; // Necesario para la interacción con el usuario

public class Controller {
    // --- ATRIBUTOS DEL ESTADO DEL JUEGO ---
    private Board board;          // El campo de batalla.
    private Player player1;       // Jugador 1 y su ejército.
    private Player player2;       // Jugador 2 y su ejército.
    private Scanner scanner;      // Para leer la entrada del usuario (acciones, selecciones).
    private final int N_SIZE;     // El tamaño del tablero (inmutable).
    private boolean isPlayerturn; // TRUE para Player 1, FALSE para Player 2.

    // --- CONSTRUCTOR ---
    public Controller(int size, String name1, String name2) {
        this.N_SIZE = size;
        this.board = new Board(size); // Crea el tablero.
        this.scanner = new Scanner(System.in); // Inicializa el input.

        this.isPlayerturn = true; // Player 1 siempre empieza.
        // Inicializa los jugadores con listas de héroes vacías (se llenarán en setupGame).
        this.player1 = new Player(name1, new ArrayList<>());
        this.player2 = new Player(name2, new ArrayList<>());
    }

    // --- GESTIÓN DE TURNOS ---

    // Retorna el objeto Player cuyo turno es actualmente.
    public Player getTurnoActual() {
        return isPlayerturn ? player1 : player2;
    }

    // Retorna el objeto Player que no tiene el turno (el objetivo).
    public Player getOponente() {
        return isPlayerturn ? player2 : player1;
    }

    /**
     * Alterna la bandera 'isPlayerturn' e imprime mensajes de fin/comienzo de turno.
     */
    private void changeTurn() {
        System.out.println("The game start. Turn for: " + getTurnoActual().getName());
        isPlayerturn = !isPlayerturn;
        System.out.println("\n Turn ended. Next turn is: " + getTurnoActual().getName());
    }

    // --- LÓGICA DE BAJAS Y CONDICIÓN DE VICTORIA ---

    /**
     * Procesa la eliminación de un héroe.
     * 1. Determina a qué jugador pertenece.
     * 2. Limpia su posición en el Board.
     * 3. Lo retira de la lista del Player (removeheroe).
     * 4. Verifica si el Player ha sido derrotado.
     */
    private void removeHeroAndCheck(Heroe deadHero) {
        // ... (Lógica para determinar el dueño y remover del Player/Board) ...
        // ... (La lógica es correcta) ...
    }

    // --- LÓGICA DE COMBATE ---

    /**
     * Ejecuta una acción de ataque completa.
     * 1. Verifica la pertenencia del atacante.
     * 2. Calcula el daño infligido (llamando al polimorfismo de Heroe).
     * 3. Aplica el daño al objetivo (target.receiveDamage).
     * 4. Llama a removeHeroAndCheck si el objetivo muere.
     * 5. Cambia el turno.
     * @param attack El héroe atacante.
     * @param target El héroe objetivo.
     */
    public void executeattack(Heroe attack, Heroe target){
        if (!getTurnoActual().getHeroes().contains(attack)) {
            System.err.println("Error...");
            return;
        }
        int netdamage = attack.calculateDamageInflicted(target); // Lógica de daño
        target.receiveDamage(netdamage);                       // Lógica de defensa

        if (!target.isAlive()) {
            removeHeroAndCheck(target);
        }
        changeTurn();
    }

    // --- LÓGICA DE MOVIMIENTO ---

    /**
     * Ejecuta una acción de movimiento completa.
     * 1. Valida pertenencia, límites, ocupación y rango (distancia 1).
     * 2. Si es válido, limpia la posición anterior.
     * 3. Actualiza la posición del héroe y del tablero.
     * 4. Cambia el turno.
     */
    public void executeMove (Heroe hero, Position newPosition) {
        // ... (La lógica de validación corregida es excelente y robusta) ...
        // ... (La lógica de actualización de posición es correcta) ...
        changeTurn();
    }

    // --- LÓGICA DE INICIALIZACIÓN (SETUP) ---

    /**
     * Método CRÍTICO: Crea y posiciona a los 5 héroes de cada jugador en el Board.
     * Usa el método de utilidad 'placeHero'.
     */
    public void setupGame() {
        // ... (Lógica de creación de héroes y asignación de posición) ...
        // ... (La lógica es correcta y completa) ...
    }

    /**
     * Método de utilidad privado para simplificar el setup.
     * Asigna posición al héroe, lo agrega al Player y lo coloca en el Board.
     */
    private void placeHero(Player player, Board board, Heroe hero, Position position) {
        hero.setPosition(position);
        player.addHeroe(hero);
        board.placeHeroe(hero.getSymbol(), position);
    }

    // --- BUCLE PRINCIPAL DEL JUEGO ---

    /**
     * Inicia el juego.
     * 1. Llama a setupGame para preparar el tablero.
     * 2. Inicia el bucle principal (while) mientras nadie esté derrotado.
     * 3. Anuncia al ganador cuando el bucle termina.
     */
    public void startGame() {
        // ... (Lógica de setup y bucle principal) ...
        // ... (La lógica de determinar el ganador es correcta) ...
    }

    // --- GESTIÓN DE ENTRADA DEL USUARIO ---

    /**
     * Controla el flujo de un solo turno, pidiendo al usuario la acción (ATTACK o MOVE)
     * y las unidades/posiciones involucradas.
     */
    private void handleTurnAction(Player currentPlayer) {
        // ... (Lógica para pedir acción, seleccionar héroe/objetivo/destino y llamar a executeMove/executeattack) ...
        // ... (Incluye la validación de rango antes de atacar) ...
        // ... (La lógica de reintento en caso de input inválido es correcta) ...
    }

    /**
     * Lee y valida la entrada de coordenadas (Fila Columna).
     */
    private Position selectPosition(String role) {
        // ... (Usa nextInt y try-catch para robustez) ...
        // ... (La lógica es correcta) ...
    }

    /**
     * Muestra la lista de héroes disponibles para un Player y pide la selección por índice.
     */
    private Heroe selectHeroe(Player player, String role) {
        // ... (Usa la lista de héroes del Player y valida el índice) ...
        // ... (La lógica es correcta) ...
    }
}
