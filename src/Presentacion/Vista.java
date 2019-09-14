/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author John Castellanos
 */
public class Vista extends javax.swing.JFrame {

    private Controlador control;
    private Modelo modelo;
    
    public Vista(Modelo m) {
        modelo = m;
        initComponents();
        capturarEventos();
    }

    public Modelo getModelo() {
        return modelo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLeer = new javax.swing.JButton();
        lblResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLeer.setText("Leer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addComponent(btnLeer)
                .addGap(151, 151, 151))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(lblResultado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(btnLeer)
                .addGap(108, 108, 108))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }
    
     public JButton getBtnLeer() {
        return btnLeer;
    }
    
    public JLabel getLblResultado() {
        return lblResultado;
    }
    
    
    private void capturarEventos() {
        btnLeer.addActionListener(getControl());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLeer;
    private javax.swing.JLabel lblResultado;
    // End of variables declaration//GEN-END:variables
}