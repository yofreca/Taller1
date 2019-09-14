/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Lector;
import java.io.IOException;

/**
 *
 * @author John Castellanos
 */
public class Modelo {
      private Vista ventana;
      private int cuenta; 
      private Lector sistema;
      
      
    public void iniciar() {
        getVentana().setSize(800, 400);
        getVentana().setVisible(true);
        cuenta = 0;
    }
      
    public Lector getSistema() {
        if(sistema == null){
            sistema = new Lector();
        }
        return sistema;
    }
    
    
     public Vista getVentana() {
        if(ventana == null){
            ventana = new Vista(this);
        }
        return ventana;
    }
    
      public void funcionalidadContar() throws IOException {
          getVentana().getLblResultado().setText("Leyendo archivo...");
          getSistema().LeerArchivo();
          getVentana().getLblFecha().setText(getSistema().getArchivo().getFecha().toString());
          getVentana().getLblAltitud().setText("Altitud: " + Float.toString(getSistema().getArchivo().getSiteAlt()));
          getVentana().getLblLatitud().setText("Latitud: " + Float.toString(getSistema().getArchivo().getSiteLat()));
          getVentana().getLblLongitud().setText("Longitud: " + Float.toString(getSistema().getArchivo().getSiteLon()));
          getVentana().getLblResultado().setText("Archivo Leido");
      }
    
}
