/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author John Castellanos
 */
public class Modelo {
      private Vista ventana;
      private int cuenta; 
    
      
      
    public void iniciar() {
        getVentana().setSize(580, 260);
        getVentana().setVisible(true);
        cuenta = 0;
    }
      
    
    
     public Vista getVentana() {
        if(ventana == null){
            ventana = new Vista(this);
        }
        return ventana;
    }
    
      public void funcionalidadContar() {
           cuenta += 1;
            getVentana().getLblResultado().setText("La cuenta es " +  cuenta);
      }
    
}
