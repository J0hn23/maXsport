
package ortegabravo.maxsport.accesoDatos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ortegabravo.maxsport.modelo.Usuari;


public class UsuariosTableModel extends AbstractTableModel {

    private final String[] columns = {"Id Usuario", "Nombre", "Correo", "Foto"};
    public ArrayList<Usuari> usuaris = null;

    public UsuariosTableModel(ArrayList<Usuari> usuaris) {
        this.usuaris = usuaris;
    }

    @Override
    public int getRowCount() {

        return usuaris.size();
    }

    @Override
    public int getColumnCount() {

        return columns.length;
    }

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

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }

}
    
    
    
    
    
    
    
    

