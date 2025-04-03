package ortegabravo.maxsport.accesoDatos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ortegabravo.maxsport.modelo.Usuari;

/**
 * Modelo de tabla para gestionar y visualizar los datos de usuarios en una
 * tabla.
 * @author Jonathan M.Ortega Bravo
 * @since 2024-10-24
 */
public class UsuariosTableModel extends AbstractTableModel {

    private final String[] columns = {"Id Usuario", "Nombre", "Correo", "Foto"};
    public ArrayList<Usuari> usuaris = null;

    /**
     * Constructor que inicializa el modelo de la tabla con una lista de
     * usuarios.
     *
     * @param usuaris la lista de usuarios a mostrar en la tabla
     */
    public UsuariosTableModel(ArrayList<Usuari> usuaris) {
        this.usuaris = usuaris;
    }

    /**
     * Obtiene el número de filas en la tabla, que corresponde al tamaño de la
     * lista de usuarios.
     *
     * @return el número de filas en la tabla
     */
    @Override
    public int getRowCount() {

        return usuaris.size();
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
                usuaris.get(rowIndex).getId();
            case 1 ->
                usuaris.get(rowIndex).getNom();
            case 2 ->
                usuaris.get(rowIndex).getEmail();
            // case 3-> usuaris.get(rowIndex).setFoto(foto);
            case 3 ->
                "prueba";
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
