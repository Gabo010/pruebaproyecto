package org.example.modelo;

import org.example.persistencia.BandasDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class TablaBandas implements TableModel {
    public static final int COLUMNS = 6;
    private ArrayList<Bandas> datos;
    private BandasDAO bandasDAO;
    public TablaBandas(){
        bandasDAO = new BandasDAO();
        datos = new ArrayList<>();
    }
    public TablaBandas(ArrayList<Bandas> datos) {
        this.datos = datos;
        bandasDAO = new BandasDAO();
    }
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Genero";
            case 2:
                return "Banda";
            case 3:
                return "Cancion mas Conocida";
            case 4:
                return "Pais de origen";
            case 5:
                return "URL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex) {
            case 0:
                return Integer.class;
            case 1, 2, 3, 4, 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bandas tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getGenero();
            case 2:
                return tmp.getBanda();
            case 3:
                return tmp.getCancionConocida();
            case 4:
                return tmp.getPaisOrigen();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object a, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //datos.get(rowIndex).setId((String) a);
                break;
            case 1:
                datos.get(rowIndex).setGenero((String) a);
                break;
            case 2:
                datos.get(rowIndex).setBanda((String) a);
                break;
            case 3:
                datos.get(rowIndex).setCancionConocida((String) a);
                break;
            case 4:
                datos.get(rowIndex).setPaisOrigen((String) a);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) a);
                break;
            default:
                System.out.println("No se modifica nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

    public void cargarDatos() {
        try {
            datos = bandasDAO.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println("Error " + sqle.getMessage());
        }

    }

    public boolean insertarBandas(Bandas bandas) {
        boolean res = false;
        try {
            if (bandasDAO.insertar(bandas)) {
                datos.add(bandas);
                res = true;
            } else {
                res = false;

            }
        } catch (SQLException sqle) {
            System.out.println("Error " + sqle.getMessage());
        }
        return res;
    }

    public boolean actualizarBandas(Bandas bandas) {
        boolean res = false;
        try {
            if (bandasDAO.update(bandas)) {
                datos.add(bandas);
                res = true;
            } else {
                res = false;

            }
        } catch (SQLException sqle) {
            System.out.println("Error " + sqle.getMessage());
        }
        return res;
    }

    public Bandas getBandasIndex(int index) {
        return datos.get(index);
    }

    public boolean eliminarBandas(String id){
        boolean res = false;
        try {
            if (bandasDAO.delete(id)) {
                res = true;
            } else {
                res = false;
            }
        } catch (SQLException sqle) {
            System.out.println("Error " + sqle.getMessage());
        }
        return res;
    }
}
