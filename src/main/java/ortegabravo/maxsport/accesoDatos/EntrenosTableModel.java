package ortegabravo.maxsport.accesoDatos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ortegabravo.maxsport.modelo.Workout;

/**
 * Modelo de tabla para gestionar y visualizar los datos de entrenamientos en
 * una tabla.
 */
public class EntrenosTableModel extends AbstractTableModel {

    private final String[] columns = {"Id Entreno", "Fecha", "Usuario", "Comentario"};
    public ArrayList<Workout> entrenos = null;

    /**
     * Constructor que inicializa el modelo de la tabla con una lista de
     * entrenamientos.
     *
     * @param entrenos la lista de entrenamientos a mostrar en la tabla
     */
    public EntrenosTableModel(ArrayList<Workout> entrenos) {
        this.entrenos = entrenos;
    }

    /**
     * Obtiene el número de filas en la tabla, que corresponde al tamaño de la
     * lista de entrenamientos.
     *
     * @return el número de filas en la tabla
     */
    @Override
    public int getRowCount() {

        return entrenos.size();
    }

    /**
     * Obtiene el número de columnas en la tabla, que corresponde a la longitud
     * del array de nombres de columnas.
     *
     * @return el número de columnas en la tabla
     */
    @Override
    public int getColumnCount() {

        return columns.length;
    }

    /**
     * Obtiene el valor de una celda específica en la tabla basado en el índice
     * de fila y columna.
     *
     * @param rowIndex el índice de la fila
     * @param columnIndex el índice de la columna
     * @return el valor de la celda en la posición especificada
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return switch (columnIndex) {
            case 0 ->
                entrenos.get(rowIndex).getId();
            case 1 ->
                entrenos.get(rowIndex).getForDate();
            case 2 ->
                entrenos.get(rowIndex).getIdUsuari();
            // case 3-> usuaris.get(rowIndex).setFoto(foto);
            case 3 ->
                entrenos.get(rowIndex).getComments();

            default ->
                "-";
        };
    }

    /**
     * Obtiene el nombre de una columna específica en la tabla.
     *
     * @param column el índice de la columna
     * @return el nombre de la columna en la posición especificada
     */
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    /**
     * Obtiene la clase de los objetos en una columna específica.
     *
     * @param columnIndex el índice de la columna
     * @return la clase de los objetos en la columna especificada
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }

}
