public class Killer extends Heroe {

    // --- CONSTANTES DEL ASESINO ---

    private static final int HP_INICIAL = 9;              // Vida baja (frágil), típica de una unidad de daño.
    private static final int BASE_DAMAGE_PER_HIT = 7;     // Daño alto por golpe.
    private static final int DAMAGE_VARIATION = 2;        // Variación (0-2), para daño entre 7 y 9 por golpe.
    private static final int ATTACK_RANGE = 1;            // Es una unidad de melé (cuerpo a cuerpo).
    private static final int NUMBER_OF_HITS = 2;          // ¡CLAVE! Simula un ataque doble.
    private static final int BONUS_DAMAGE_TO_FRAGILE = 3; // Bonificación contra unidades de bajo HP.

    // --- CONSTRUCTOR ---

    public Killer(char symbol, String type, int hpMax) {
        // Llama al constructor de la clase base (Heroe):
        // Símbolo en tablero: 'S' (Sombra/Silent), Tipo: "Asesino", HP Máximo: 9.
        super('S', "Asesino", HP_INICIAL);
    }

    // --- LÓGICA DE COMBATE BÁSICA ---

    /**
     * Calcula el daño base de un *solo* golpe del Asesino.
     * Es la base para el cálculo del daño total en calculateDamageInflicted.
     */
    @Override
    public int calculateDamageBase() {
        return BASE_DAMAGE_PER_HIT + randdamage(DAMAGE_VARIATION);
    }

    /**
     * Define el alcance del Asesino (1 casilla), obligándolo a posicionarse junto al objetivo.
     */
    @Override
    public int getAttackRange() {
        return ATTACK_RANGE;
    }

    /**
     * El Asesino no tiene defensas pasivas.
     */
    @Override
    public int calculateDefense() {
        return 0;
    }

    // --- LÓGICA DE ATAQUE ESPECIALIZADO (Daño Múltiple y Bonificación) ---

    /**
     * Calcula el daño total infligido al objetivo, aplicando el doble golpe y el bono.
     * Esta lógica es compleja porque simula múltiples interacciones con la defensa del objetivo.
     */
    @Override
    public int calculateDamageInflicted(Heroe target) {
        int totalDamageDealt = 0;
        int bonification = 0;

        // 1. Evaluar Bonificación contra Unidades Frágiles
        String targetType = target.getType();
        // Aplica el bono si el objetivo es la Arquera o el Mago.
        if ("Arquera".equals(targetType) || "Mago".equals(targetType)) {
            bonification = BONUS_DAMAGE_TO_FRAGILE;
            System.out.println("El Asesino aplica +" + bonification + " de daño extra a " + targetType);
        }

        // 2. Simular el Ataque Doble
        for (int i = 0; i < NUMBER_OF_HITS; i++) {
            // Se calcula el daño base + bono (el daño base es aleatorio por golpe).
            int damagePerHit = calculateDamageBase() + bonification;

            // CRÍTICO: El daño de CADA golpe debe pasar por la defensa del objetivo.
            // Si el objetivo es un Tanque, cada golpe individual se reducirá en 1.
            int damageAfterDefense = target.calculateDamageReceived(damagePerHit);

            totalDamageDealt += damageAfterDefense;
        }

        return totalDamageDealt;
    }

    // --- LÓGICA DE DEFENSA ---

    /**
     * El Asesino no tiene reducción de daño pasiva.
     */
    @Override
    public int calculateDamageReceived(int dealt) {
        return dealt;
    }
}
