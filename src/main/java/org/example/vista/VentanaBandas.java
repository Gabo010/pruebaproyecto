package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaBandas extends JFrame {
    //Labels
    private JLabel lblId;
    private JLabel lblGenero;
    private JLabel lblBanda;
    private JLabel lblCancionConocida;
    private JLabel lblPaisOrigen;
    private JLabel lblUrl;
    private JLabel lblIcon;

    //TextFields
    private JTextField txtId;
    private JTextField txtGenero;
    private JTextField txtBanda;
    private JTextField txtCancionConocida;
    private JTextField txtPaisOrigen;
    private JTextField txtUrl;

    //Tables
    private JTable tblBandas;
    private JScrollPane scrollPane;

    //Panels y layout
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    //Buttons
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnEliminar;
    private JButton btnUpdate;

    //Elementos del panel4
    private JLabel lblId2;
    private JLabel lblGenero2;
    private JLabel lblBanda2;
    private JLabel lblCancionConocida2;
    private JLabel lblPaisOrigen2;
    private JLabel lblUrl2;
    private JTextField txtId2;
    private JTextField txtGenero2;
    private JTextField txtBanda2;
    private JTextField txtCancionConocida2;
    private JTextField txtPaisOrigen2;
    private JTextField txtUrl2;

    public VentanaBandas(String title) throws HeadlessException {
        super(title);

        //inicio
        this.setSize(1000,900);
        layout =  new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(250, 118, 155));
        lblId = new JLabel("id: ");
        lblGenero = new JLabel("Genero de la banda: ");
        lblBanda = new JLabel("Nombre de la banda: ");
        lblCancionConocida = new JLabel("Cancion mas conocida: ");
        lblPaisOrigen = new JLabel("Pais: ");
        lblUrl = new JLabel("URL:");
        txtId = new JTextField(2);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtGenero = new JTextField(12);
        txtBanda = new JTextField(15);
        txtCancionConocida = new JTextField(15);
        txtPaisOrigen = new JTextField(15);
        txtUrl = new JTextField(15);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblGenero);
        panel1.add(txtGenero);
        panel1.add(lblBanda);
        panel1.add(txtBanda);
        panel1.add(lblCancionConocida);
        panel1.add(txtCancionConocida);
        panel1.add(lblPaisOrigen);
        panel1.add(txtPaisOrigen);
        panel1.add(lblUrl);
        panel1.add(txtUrl);
        panel1.add(btnAgregar);



        //panel2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(131, 241, 215));
        tblBandas = new JTable();
        scrollPane = new JScrollPane(tblBandas);
        btnCargar = new JButton("Cargar Datos");
        panel2.add(btnCargar);
        panel2.add(scrollPane);



        //panel3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(255, 134, 72));
        lblIcon = new JLabel("...");
        panel3.add(lblIcon);

        //panel4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(225, 126, 248));
        lblId2 = new JLabel("id: ");
        lblGenero2 = new JLabel("Genero de la banda: ");
        lblPaisOrigen2 = new JLabel("Nombre de la banda: ");
        lblCancionConocida2 = new JLabel("Cancion mas famosa: ");
        lblPaisOrigen2 = new JLabel("Pais de origen: ");
        lblUrl2 = new JLabel("URL:");
        txtId2 = new JTextField(2);
        txtGenero2 = new JTextField(12);
        txtBanda2 = new JTextField(15);
        txtCancionConocida2 = new JTextField(15);
        txtPaisOrigen2 = new JTextField(15);
        txtUrl2 = new JTextField(15);
        btnUpdate = new JButton("Actualizar");
        btnEliminar = new JButton("Borrar");
        panel4.add(lblId2);
        panel4.add(txtId2);
        panel4.add(lblGenero2);
        panel4.add(txtGenero2);
        panel4.add(lblBanda2);
        panel4.add(txtBanda2);
        panel4.add(lblCancionConocida2);
        panel4.add(txtCancionConocida2);
        panel4.add(lblPaisOrigen2);
        panel4.add(txtPaisOrigen2);
        panel4.add(lblUrl2);
        panel4.add(txtUrl2);
        panel4.add(btnUpdate);
        panel4.add(btnEliminar);


        //Vista
        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblGenero() {
        return lblGenero;
    }

    public void setLblGenero(JLabel lblGenero) {
        this.lblGenero = lblGenero;
    }

    public JLabel getLblBanda() {
        return lblBanda;
    }

    public void setLblBanda(JLabel lblBanda) {
        this.lblBanda = lblBanda;
    }

    public JLabel getLblCancionConocida() {
        return lblCancionConocida;
    }

    public void setLblCancionConocida(JLabel lblCancionConocida) {
        this.lblCancionConocida = lblCancionConocida;
    }

    public JLabel getLblPaisOrigen() {
        return lblPaisOrigen;
    }

    public void setLblPaisOrigen(JLabel lblPaisOrigen) {
        this.lblPaisOrigen = lblPaisOrigen;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JLabel getLblIcon() {
        return lblIcon;
    }

    public void setLblIcon(JLabel lblIcon) {
        this.lblIcon = lblIcon;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtGenero() {
        return txtGenero;
    }

    public void setTxtGenero(JTextField txtGenero) {
        this.txtGenero = txtGenero;
    }

    public JTextField getTxtBanda() {
        return txtBanda;
    }

    public void setTxtBanda(JTextField txtBanda) {
        this.txtBanda = txtBanda;
    }

    public JTextField getTxtCancionConocida() {
        return txtCancionConocida;
    }

    public void setTxtCancionConocida(JTextField txtCancionConocida) {
        this.txtCancionConocida = txtCancionConocida;
    }

    public JTextField getTxtPaisOrigen() {
        return txtPaisOrigen;
    }

    public void setTxtPaisOrigen(JTextField txtPaisOrigen) {
        this.txtPaisOrigen = txtPaisOrigen;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JTable getTblBandas() {
        return tblBandas;
    }

    public void setTblBandas(JTable tblBandas) {
        this.tblBandas = tblBandas;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    public JLabel getLblId2() {
        return lblId2;
    }

    public void setLblId2(JLabel lblId2) {
        this.lblId2 = lblId2;
    }

    public JLabel getLblGenero2() {
        return lblGenero2;
    }

    public void setLblGenero2(JLabel lblGenero2) {
        this.lblGenero2 = lblGenero2;
    }

    public JLabel getLblBanda2() {
        return lblBanda2;
    }

    public void setLblBanda2(JLabel lblBanda2) {
        this.lblBanda2 = lblBanda2;
    }

    public JLabel getLblCancionConocida2() {
        return lblCancionConocida2;
    }

    public void setLblCancionConocida2(JLabel lblCancionConocida2) {
        this.lblCancionConocida2 = lblCancionConocida2;
    }

    public JLabel getLblPaisOrigen2() {
        return lblPaisOrigen2;
    }

    public void setLblPaisOrigen2(JLabel lblPaisOrigen2) {
        this.lblPaisOrigen2 = lblPaisOrigen2;
    }

    public JLabel getLblUrl2() {
        return lblUrl2;
    }

    public void setLblUrl2(JLabel lblUrl2) {
        this.lblUrl2 = lblUrl2;
    }

    public JTextField getTxtId2() {
        return txtId2;
    }

    public void setTxtId2(JTextField txtId2) {
        this.txtId2 = txtId2;
    }

    public JTextField getTxtGenero2() {
        return txtGenero2;
    }

    public void setTxtGenero2(JTextField txtGenero2) {
        this.txtGenero2 = txtGenero2;
    }

    public JTextField getTxtBanda2() {
        return txtBanda2;
    }

    public void setTxtBanda2(JTextField txtBanda2) {
        this.txtBanda2 = txtBanda2;
    }

    public JTextField getTxtCancionConocida2() {
        return txtCancionConocida2;
    }

    public void setTxtCancionConocida2(JTextField txtCancionConocida2) {
        this.txtCancionConocida2 = txtCancionConocida2;
    }

    public JTextField getTxtPaisOrigen2() {
        return txtPaisOrigen2;
    }

    public void setTxtPaisOrigen2(JTextField txtPaisOrigen2) {
        this.txtPaisOrigen2 = txtPaisOrigen2;
    }

    public JTextField getTxtUrl2() {
        return txtUrl2;
    }

    public void setTxtUrl2(JTextField txtUrl2) {
        this.txtUrl2 = txtUrl2;
    }
    public void limpieza(){
        txtGenero.setText("");
        txtBanda.setText("");
        txtCancionConocida.setText("");
        txtPaisOrigen.setText("");
        txtUrl.setText("");
    }
}
