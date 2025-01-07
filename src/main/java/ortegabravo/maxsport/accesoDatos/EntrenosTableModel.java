
package ortegabravo.maxsport.accesoDatos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ortegabravo.maxsport.modelo.Workout;


public class EntrenosTableModel extends AbstractTableModel {
    
   

    private final String[] columns = {"Id Entreno", "Fecha", "Usuario", "Comentario"};
    public ArrayList<Workout> entrenos = null;

    public EntrenosTableModel(ArrayList<Workout> entrenos) {
        this.entrenos = entrenos;
    }

    @Override
    public int getRowCount() {

        return entrenos.size();
    }

    @Override
    public int getColumnCount() {

        return columns.length;
    }

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

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }

}

    
    

