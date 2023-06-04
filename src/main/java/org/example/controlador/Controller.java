package org.example.controlador;

import org.example.modelo.Bandas;
import org.example.modelo.TablaBandas;
import org.example.vista.VentanaBandas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class Controller extends MouseAdapter {
    private VentanaBandas view;
    private TablaBandas tblBandas;

    public Controller(VentanaBandas view){
        this.view = view;
        tblBandas = new TablaBandas();
        this.view.getTblBandas().setModel(tblBandas);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getTblBandas().addMouseListener(this);
        this.view.getBtnUpdate().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {
            tblBandas.cargarDatos();
            this.view.getTblBandas().setModel(tblBandas);
            this.view.getTblBandas().updateUI();
        }
        if (e.getSource() == this.view.getBtnAgregar()) {
            Bandas banda = new Bandas();
            banda.setGenero(this.view.getTxtGenero().getText());
            banda.setBanda(this.view.getTxtBanda().getText());
            banda.setCancionConocida(this.view.getTxtCancionConocida().getText());
            banda.setPaisOrigen(this.view.getTxtPaisOrigen().getText());
            banda.setUrl(this.view.getTxtUrl().getText());
            if (tblBandas.insertarBandas(banda)) {
                JOptionPane.showMessageDialog(view, "Se agrego el cafe", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblBandas().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpieza();
        }
        if (e.getSource() == view.getTblBandas()) {
            int index = this.view.getTblBandas().getSelectedRow();
            Bandas tmp = tblBandas.getBandasIndex(index);
            try {
                this.view.getLblIcon().setIcon(tmp.getImagen());
            } catch (MalformedURLException urle) {
                System.out.println(urle.getMessage());
            }
        }
        if (e.getSource() == this.view.getBtnUpdate()) {
            int index = this.view.getTblBandas().getSelectedRow();
            Bandas tmp = tblBandas.getBandasIndex(index);
            tmp.setGenero(this.view.getTxtGenero2().getText());
            tmp.setBanda(this.view.getTxtBanda2().getText());
            tmp.setCancionConocida(this.view.getTxtCancionConocida().getText());
            tmp.setPaisOrigen(this.view.getTxtPaisOrigen2().getText());
            tmp.setUrl(this.view.getLblUrl2().getText());
            if (tblBandas.actualizarBandas(tmp)){
                JOptionPane.showMessageDialog(view,"Datos actualizados","Actualizacion",JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblBandas().updateUI();
            }
            this.view.limpieza();
        }
        if (e.getSource() == this.view.getBtnEliminar()) {
            int index = this.view.getTblBandas().getSelectedRow();
            Bandas tmp = tblBandas.getBandasIndex(index);
            String id = String.valueOf(tmp.getId());
            int resultado = JOptionPane.showConfirmDialog(view,"Seguro que quieres eliminar?");
            if (resultado == JOptionPane.YES_NO_OPTION){
                if (tblBandas.eliminarBandas(id)){
                    JOptionPane.showMessageDialog(view,"Se ha eliminado el elemento seleccionado");
                }
            }else {
                JOptionPane.showMessageDialog(view, "No se ha eliminado");
            }
            this.view.getTblBandas().updateUI();
        }
    }

}
