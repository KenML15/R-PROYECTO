public class Position {

    // --- ATRIBUTOS (Las coordenadas) ---
    // Usamos 'public final' porque estas coordenadas son la identidad del objeto
    // y no deben cambiar (inmutabilidad). Esto evita que un héroe "mueva" su propia
    // posición sin pasar por la lógica del Controller y del Board.
    public final int ROW;
    public final int COLUMN;

    // --- CONSTRUCTOR ---
    // Simplemente recibe la fila y la columna y las almacena.
    public Position(int row, int column) {
        this.ROW = row;
        this.COLUMN = column;
    }

    // --- MÉTODO CLAVE: Cálculo de Distancia ---

    /**
     * Calcula la distancia de Manhattan (Movimiento en Cuadrícula) entre esta posición
     * y otra posición dada 'p'.
     * * Esta distancia es fundamental para validar movimientos (debe ser 1) y
     * ataques (debe ser <= rango de ataque).
     * * La fórmula es: |diferencia de filas| + |diferencia de columnas|.
     * @param p La otra posición con la que queremos calcular la distancia.
     * @return La distancia mínima de movimientos en cruz (adyacentes).
     */
    public int movements(Position p){
        return Math.abs(ROW - p.ROW) + Math.abs(COLUMN - p.COLUMN);
    }

    /*
    // --- MÉTODO OPCIONAL DE UTILIDAD ---
    // Podríamos agregar un método toString para debugging y visualización
    @Override
    public String toString() {
        return "(" + ROW + ", " + COLUMN + ")";
    }
    */
}
