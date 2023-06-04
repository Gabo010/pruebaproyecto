package org.example.persistencia;

import org.example.modelo.Bandas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BandasDAO implements InterfazDAO{
    public BandasDAO() {
    }
    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO grupos(genero,banda,cancionConocida,paisOrigen,url) VALUES(?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("rockDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Bandas)obj).getGenero());
        pstm.setString(2, ((Bandas)obj).getBanda());
        pstm.setString(3, ((Bandas)obj).getCancionConocida());
        pstm.setString(4, ((Bandas)obj).getPaisOrigen());
        pstm.setString(5, ((Bandas)obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE grupos SET genero = ?, banda = ?, cancionConocida = ?, paisOrigen = ?, url = ? WHERE id = ?;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("rockDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Bandas)obj).getGenero());
        pstm.setString(2, ((Bandas)obj).getBanda());
        pstm.setString(3, ((Bandas)obj).getCancionConocida());
        pstm.setString(4, ((Bandas)obj).getPaisOrigen());
        pstm.setString(5, ((Bandas)obj).getUrl());
        pstm.setInt(6,((Bandas)obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;

    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM grupos WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("rockDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1,Integer.parseInt(id));
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        ArrayList<Bandas> res = new ArrayList<>();
        String sql = "SELECT * FROM grupos";

        Statement stm = ConexionSingleton.getInstance("rockDB.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);

        while (rst.next()){
            res.add(new Bandas(rst.getInt(1),rst.getString(2),rst.getString(3),
                    rst.getString(4),rst.getString(5),rst.getString(6)));
        }
        return res;
    }

    @Override
    public Object buscarPorid(String id) throws SQLException {
        String sql = "SELECT * FROM grupos WHERE id = ?;";
        Bandas bandas = null;

        PreparedStatement pstm = ConexionSingleton.getInstance("rockDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1,Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();

        if (rst.next()) {
            bandas = new Bandas(rst.getInt(1), rst.getString(2), rst.getString(3),
                    rst.getString(4), rst.getString(5), rst.getString(6));
            return bandas;
        }
        return null;
    }
}
