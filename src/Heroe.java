import javax.swing.text.Position;
import java.util.Random;

abstract class Heroe {
    // --- ATRIBUTOS FUNDAMENTALES (Lo que todo héroe debe tener) ---
    private final char symbol;      // Símbolo que lo representa en el tablero (e.g., 'G', 'M'). Es constante.
    private final String type;      // El tipo de unidad (e.g., "Guerrero", "Mago"). Es constante.
    private int hp;                 // Puntos de vida actuales. Varía durante la batalla.
    private final int hpMax;        // Puntos de vida máximos. Define la vitalidad base. Es constante.
    private Position position;      // Coordenadas (Fila, Columna) en el tablero.
    protected static final Random RANDOM = new Random(); // Generador de números aleatorios para daño/variación.

    // --- CONSTRUCTOR: Inicialización de la Unidad ---
    public Heroe(char symbol, String type, int hpMax) {
        this.symbol = symbol;
        this.type = type;
        this.hpMax = hpMax;
        // ¡CRÍTICO! Asegura que el héroe nazca con vida completa.
        this.hp = hpMax;
    }

    // --- GETTERS: Acceso a la Información ---

    public char getSymbol() { return symbol; }
    public String getType() { return type; }
    public int getHp() { return hp; }

    // El setPosition es importante para que el Controller pueda colocarlo y moverlo.
    public Position getPosition() { return position; }

    public int getHpMax() { return hpMax; }

    // --- SETTER: Controlando la Vida ---

    // Uso Math.max(0, hp) para evitar que la vida se vaya a números negativos,
    // garantizando que el HP se detenga en 0 cuando el héroe muere.
    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    // --- MÉTODOS DE UTILIDAD EN COMBATE ---

    // Genera daño aleatorio entre 0 y el valor 'max' que le pase. Útil para variaciones.
    protected int randdamage(int max) {
        return RANDOM.nextInt(max + 1);
    }

    // El héroe recibe daño, lo resta de su vida y usa setHp para validarlo.
    public void receiveDamage(int damage) {
        this.setHp(this.hp - damage);
    }

    // Comprobación rápida para el Controller: ¿Sigue vivo?
    public boolean isAlive() {
        return this.hp > 0;
    }

    // Permite al Controller actualizar la posición del héroe después de un movimiento.
    public void setPosition(Position position) {
        this.position = position;
    }

    // --- MÉTODOS ABSTRACTOS: EL CONTRATO (Polimorfismo) ---

    // Esto obliga a CADA subclase a definir su propio daño base.
    public abstract int calculateDamageBase();

    // Esto obliga a CADA subclase a definir su alcance (1 para Tanques, 3 para Arqueras, etc.).
    public abstract int getAttackRange();

    // Esto obliga a CADA subclase a definir su defensa base (aunque sea 0).
    public abstract int calculateDefense();

    // El cálculo del daño que ESTE héroe HACE (incluye bonificaciones, doble golpe, etc.)
    public abstract int calculateDamageInflicted(Heroe target);

    // El cálculo del daño que ESTE héroe RECIBE (incluye armadura, reducción, etc.)
    // Es clave para que el Tanque, por ejemplo, pueda reducir el 'dealt' (daño bruto).
    public abstract int calculateDamageReceived(int dealt);
}
