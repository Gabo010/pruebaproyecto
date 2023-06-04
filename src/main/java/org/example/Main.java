package org.example;

import org.example.controlador.Controller;
import org.example.vista.VentanaBandas;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        VentanaBandas view  = new VentanaBandas("Grupos de rock");
        Controller controller = new Controller(view);
    }
}