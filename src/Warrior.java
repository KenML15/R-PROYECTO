public class Warrior extends Heroe{

    // --- CONSTANTES DEL GUERRERO ---

    private static final int BASE_DAMAGE = 6;       // Daño base alto.
    private static final int DAMAGE_VARIATION = 2;  // Poca variación, daño fiable (rango 6-8).
    private static final int ATTACK_RANGE = 1;      // CLAVE: Unidad de melé, solo ataca a casillas adyacentes.

    // --- CONSTRUCTOR ---

    public Warrior(char symbol, String type, int hpMax) {
        // Llama al constructor de la clase base (Heroe):
        // Símbolo en tablero: 'G', Tipo: "Guerrero", HP Máximo: 15 (Vida decente, un pilar).
        super('G',"Guerrero",15);
    }

    // --- LÓGICA DE COMBATE ESPECÍFICA ---

    /**
     * Calcula el daño bruto del Guerrero.
     * El daño es alto y fiable, variando solo entre 6 y 8.
     */
    @Override
    public int calculateDamageBase() {
        return BASE_DAMAGE + randdamage(DAMAGE_VARIATION);
    }

    /**
     * Define el alcance máximo del Guerrero (1 casilla).
     * Solo puede golpear unidades inmediatamente adyacentes.
     */
    public int getAttackRange() {
        return ATTACK_RANGE;
    }

    /**
     * El Guerrero no tiene habilidades pasivas de reducción de daño o armadura extra.
     * Mantenemos el método para cumplir con el contrato, retornando 0.
     */
    @Override
    public int calculateDefense() {
        return 0;
    }

    /**
     * Calcula el daño final que el Guerrero inflige.
     * En este caso, el Guerrero no tiene bonificaciones contra tipos específicos,
     * así que simplemente regresa su daño base calculado.
     */
    @Override
    public int calculateDamageInflicted(Heroe target) {
        // Simplemente retorna el daño base calculado.
        // Si no lo haces, ¡el Guerrero no atacará!
        return calculateDamageBase();
    }

    /**
     * El Guerrero no tiene resistencia a daño (como el Tanque).
     * El daño recibido es igual al daño infligido por el atacante.
     */
    @Override
    public int calculateDamageReceived(int dealt) {
        return dealt;
    }
}