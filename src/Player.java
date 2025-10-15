import java.util.ArrayList;

public class Player {

    // --- ATRIBUTOS FUNDAMENTALES ---

    private String name;                // El nombre del estratega ("Player 1", "IA", etc.).

    // El corazón del jugador: su lista de unidades activas en el tablero.
    private ArrayList<Heroe> heroes;

    // --- CONSTRUCTOR ---

    // Al crear un Player, le damos un nombre y un ejército inicial (que puede estar vacío al inicio).
    public Player(String name, ArrayList<Heroe> heroes) {
        this.name = name;
        this.heroes = heroes; // Se inicializa con la lista de héroes (vacía o precargada).
    }

    // --- MÉTODOS DE ACCESO (Getters) ---

    // El Controller usa este método para saber de quién es el turno.
    public String getName() {
        return name;
    }

    // Es vital para que el Controller pueda iterar sobre los héroes del jugador
    // y para mostrar el menú de selección de unidades.
    public ArrayList<Heroe> getHeroes() {
        return heroes;
    }

    // --- MÉTODOS DE GESTIÓN DEL EJÉRCITO ---

    /**
     * Retira un héroe de la lista del jugador.
     * Este método se llama en el Controller.removeHeroAndCheck()
     * justo después de que la vida del héroe cae a cero.
     * * (Nota: Por convención Java, se recomienda 'removeHeroe' o 'removeHero').
     */
    public void removeheroe(Heroe hero){
        heroes.remove(hero);
    }

    /**
     * Método clave para el bucle principal del juego.
     * Si la lista de héroes está vacía, el jugador ha sido derrotado y el juego termina.
     * @return true si el jugador ya no tiene unidades.
     */
    public boolean isDefeated() {
        return heroes.isEmpty();
    }

    /**
     * Agrega un nuevo héroe a la lista.
     * Es usado por el Controller.setupGame() para construir el ejército al inicio.
     */
    public void addHeroe(Heroe hero) {
        heroes.add(hero);
    }
}
