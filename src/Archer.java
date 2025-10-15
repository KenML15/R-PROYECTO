public class Archer extends Heroe {

    // --- CONSTANTES DE LA ARQUERA ---

    private static final int BASE_DAMAGE = 5;           // Daño base moderado.
    private static final int DAMAGE_VARIATION = 2;      // Variación (0-2), daño entre 5 y 7.
    private static final int ATTACK_RANGE = 3;          // ¡CLAVE! El rango más alto del juego (3 casillas).
    private static final int BONUS_DAMAGE_TO_TANK = 2;  // Bonificación de daño contra el Tanque.

    // --- CONSTRUCTOR ---

    public Archer(char symbol, String type, int hpMax) {
        // Llama al constructor de la clase base (Heroe):
        // Símbolo en tablero: 'A', Tipo: "Arquera", HP Máximo: 10 (Vida frágil, debe estar protegida).
        super('A',"Arquera",10);
    }

    // --- LÓGICA DE COMBATE ESPECÍFICA ---

    /**
     * Calcula el daño bruto de la Arquera antes de bonificaciones.
     * Incluye la variación aleatoria para un resultado entre 5 y 7.
     */
    @Override
    public int calculateDamageBase() {
        return BASE_DAMAGE + randdamage(DAMAGE_VARIATION);
    }

    /**
     * El Arquera no tiene defensas pasivas.
     */
    @Override
    public int calculateDefense() {
        return 0;
    }

    /**
     * Define el alcance máximo del Arquera (3 casillas).
     */
    @Override
    public int getAttackRange() {
        return ATTACK_RANGE;
    }

    /**
     * Calcula el daño total infligido, aplicando la bonificación anti-Tanque.
     * Este es el rol principal de la Arquera: eliminar amenazas pesadas.
     */
    @Override
    public int calculateDamageInflicted(Heroe target) {
        int totalDamge = calculateDamageBase();

        // ⚠️ CORRECCIÓN CRÍTICA PENDIENTE: El tipo del Tanque es "Tanque" (en español).
        // Si el tipo es "Tanque", debes usar: 'if ("Tanque".equals(target.getType()))'
        if ("Tank".equals(target.getType())) {
            totalDamge += BONUS_DAMAGE_TO_TANK;
            System.out.println("The archer applies +2 additional damage to" + target.getType());
        }
        return totalDamge;
    }

    /**
     * El Arquera no tiene resistencia o reducción de daño.
     * El daño recibido es igual al daño infligido por el atacante.
     */
    @Override
    public int calculateDamageReceived(int dealt) {
        return dealt;
    }
}
