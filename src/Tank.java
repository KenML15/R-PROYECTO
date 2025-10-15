public class Tank extends Heroe {

    // --- CONSTANTES DEL TANQUE ---

    private static final int BASE_DAMAGE = 3;           // Daño mínimo, su foco no es atacar.
    private static final int DAMAGE_VARIATION = 1;      // Poca variación (daño entre 3 y 4).
    private static final int ATTACK_RANGE = 1;          // Es una unidad de melé (cuerpo a cuerpo).
    // DEFENSE_REDUCTION está definido pero actualmente no se usa en la lógica. Podría ser un futuro bono.
    private static final int DEFENSE_REDUCTION = 1;
    // CLAVE: Reduce 1 punto de daño de CADA ataque que recibe.
    private static final int FIXED_DAMAGE_REDUCTION = 1;

    // --- CONSTRUCTOR ---

    public Tank(char symbol, String type, int hpMax) {
        // Llama al constructor de la clase base (Heroe):
        // Símbolo en tablero: 'T', Tipo: "Tanque", HP Máximo: 20 (La vida más alta del juego).
        super('T',"Tanque",20);
    }

    // --- LÓGICA DE COMBATE ESPECÍFICA ---

    /**
     * Calcula el daño bruto del Tanque.
     * El daño es el más bajo del juego (3 o 4), reflejando su rol defensivo.
     */
    @Override
    public int calculateDamageBase() {
        return BASE_DAMAGE + randdamage(DAMAGE_VARIATION);
    }

    /**
     * Define el alcance máximo del Tanque (1 casilla).
     */
    public int getAttackRange() {
        return ATTACK_RANGE;
    }

    /**
     * Retorna un valor de reducción, que podría ser usado en una futura mecánica
     * o en el método calculateDamageReceived (aunque actualmente usamos FIXED_DAMAGE_REDUCTION).
     */
    @Override
    public int calculateDefense() {
        return DEFENSE_REDUCTION;
    }

    /**
     * Calcula el daño final que el Tanque inflige.
     * No tiene bonificaciones de ataque, solo retorna su daño base.
     */
    @Override
    public int calculateDamageInflicted(Heroe target) {
        return calculateDamageBase();
    }

    /**
     * Método CRÍTICO: Aplica la reducción de daño pasiva del Tanque.
     * Reta 1 punto de daño al ataque entrante.
     */
    @Override
    public int calculateDamageReceived(int dealt) {
        // Aplica la reducción fija de daño
        int finalDamage = dealt - FIXED_DAMAGE_REDUCTION;

        // ¡Clave! Asegura que la reducción no convierta el daño en curación (nunca debe ser negativo).
        return Math.max(0, finalDamage);
    }
}