/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import static Logica.Grafica.convertFloatsToDoubles;
import static Logica.Grafica.hacergrafica;
import Logica.Lector;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author John Castellanos
 */
public class Modelo {
      private Vista ventana;
      private int cuenta; 
      private Lector sistema;
      
      int x, y;

   
      
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

    void funcionalidadGraficar() throws IOException {
        getVentana().getLblResultado().setText("graficando...");
        float[][] dataset1 = getSistema().LeerArchivo().getHCLASS();
        float[][] dataset2 = getSistema().LeerArchivo().getKDP();
        float[][] dataset3 = getSistema().LeerArchivo().getPHIDP();
        float[][] dataset4 = getSistema().LeerArchivo().getRHOHV();        
        float[][] dataset5 = getSistema().LeerArchivo().getV();
        float[][] dataset6 = getSistema().LeerArchivo().getZDR();
        float[] dataset7 = getSistema().LeerArchivo().getRadialAzim();
        float[] dataset8 = getSistema().LeerArchivo().getRadialElev();
        
        float[][] AzimElev = new float[dataset7.length][dataset8.length];
        int k=0;
        int l=0;
        for(int i=0;i<dataset7.length;i++){
            System.out.println(i);
            for(int j=0;j<dataset8.length;j++){
                //AzimElev[k][l] =[i][j];
            }
        }
        
        
        
        double[][] d=convertFloatsToDoubles(dataset1);
        double[][] e=convertFloatsToDoubles(dataset2);
        double[][] f=convertFloatsToDoubles(dataset3);
        double[][] g=convertFloatsToDoubles(dataset4);
        double[][] h=convertFloatsToDoubles(dataset5);
        double[][] i=convertFloatsToDoubles(dataset6);
        hacergrafica(d,e,f,g,h,i);
        getVentana().getLblResultado().setText("Finalizado...");
        getVentana().getLblResultado().setText("");
        
       
        
    }

    public void funcionalidadMostrarGrafica() {
        
        
        
       
               }

    
    
    
}
