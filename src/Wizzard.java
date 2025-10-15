public class Wizzard extends Heroe {

    // --- CONSTANTES DEL MAGO ---

    private static final int BASE_DAMAGE = 4;           // Daño mínimo asegurado por el hechizo.
    private static final int DAMAGE_VARIATION = 3;      // Variación aleatoria (0-3), resultando en 4-7 de daño base.
    private static final int ATTACK_RANGE = 2;          // El Mago tiene un rango de ataque de 2 casillas.
    private static final int BONUS_DAMAGE_TO_WARRIOR = 2; // Daño extra contra su contraparte (Guerrero).

    // --- CONSTRUCTOR ---

    public Wizzard(char symbol, String type, int hpMax) {
        // Llama al constructor de la clase base (Heroe):
        // Símbolo en tablero: 'M', Tipo: "Mago", HP Máximo: 8 (Unidad frágil).
        super('M',"Mago",8);
    }

    // --- LÓGICA DE COMBATE ESPECÍFICA ---

    /**
     * Calcula el daño base del Mago antes de cualquier bonificación o defensa.
     * Incluye la variación aleatoria para un resultado entre 4 y 7.
     */
    @Override
    public int calculateDamageBase() {
        return BASE_DAMAGE + randdamage(DAMAGE_VARIATION);
    }

    /**
     * Define el alcance máximo del Mago (2 casillas).
     */
    public int getAttackRange() {
        return ATTACK_RANGE;
    }

    /**
     * El Mago no tiene reducción de daño o armadura inherente.
     * Mantenemos el método para cumplir con el contrato de la clase abstracta, retornando 0.
     */
    @Override
    public int calculateDefense() {
        return 0;
    }

    /**
     * Calcula el daño total infligido, aplicando la bonificación contra Guerreros.
     * Esta es la clave del rol del Mago en el juego.
     */
    @Override
    public int calculateDamageInflicted(Heroe target) {
        int totalDamage = calculateDamageBase();

        // **⚠️ CORRECCIÓN CRÍTICA PENDIENTE:** // Si el tipo de tu Guerrero es "Guerrero" (en español),
        // debes usar 'if ("Guerrero".equals(target.getType()))' aquí.
        // Asumiendo que el tipo es "Warrior":
        if ("Warrior".equals(target.getType())) {
            totalDamage += BONUS_DAMAGE_TO_WARRIOR;
            // Opcional: System.out.println("⚡ Mago aplica bonus de daño mágico a Guerrero!");
        }
        return totalDamage;
    }

    /**
     * El Mago no tiene resistencia o reducción de daño pasiva.
     * El daño recibido es igual al daño infligido por el atacante.
     */
    @Override
    public int calculateDamageReceived(int dealt) {
        return dealt;
    }
}