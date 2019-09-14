/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Castellanos
 */
public class Controlador implements ActionListener {
    
     private Vista ventana;
    private Modelo modelo;
    
    public Controlador(Vista aThis) {
        ventana = aThis;
        modelo = ventana.getModelo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         try {
             modelo.funcionalidadContar();
         } catch (IOException ex) {
             Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
}
