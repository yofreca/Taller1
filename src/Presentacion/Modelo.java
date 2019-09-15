/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Grafica;
import static Logica.Grafica.convertFloatsToDoubles;
import static Logica.Grafica.hacergrafica;
import Logica.Lector;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author John Castellanos
 */
public class Modelo {
      private Vista ventana;
      private int cuenta; 
      private Lector sistema;
      
      
    public void iniciar() {
        getVentana().setSize(900, 500);
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
          getVentana().getBtnGraficar().setEnabled(true);
          getVentana().getCmbVariables().setEnabled(true);
        
      }
    
      
      public void funcionalidadGraficar() throws IOException{
           float[][] dataset1 = null;
           Color highColor = null, lowColor = null;
           String path = new File(".").getCanonicalPath();
           String label = "Variable: ";
           String opc = getVentana().getCmbVariables().getSelectedItem().toString();
         
          
         
        switch (opc) {
            case "Z":
              dataset1 = getSistema().getArchivo().getZ();
              highColor = Color.red;
              lowColor = Color.blue;
              label += "Reflectivity";
            break;
            case "V":
              dataset1 = getSistema().getArchivo().getV();
              highColor = Color.black;
              lowColor = Color.white;
              label += "Velocity";
            break;
            case "ZDR":
              dataset1 = getSistema().getArchivo().getZDR();
              highColor = Color.GREEN;
              lowColor = Color.red;
              label += "Polarization Diversity";
            break;
            case "KDP":
              dataset1 = getSistema().getArchivo().getKDP();
              highColor = Color.red;
              lowColor = Color.yellow;
              label += "Specific Differential Phase";
            break;
            case "PHIDP":
              dataset1 = getSistema().getArchivo().getPHIDP();
               highColor = Color.red;
              lowColor = Color.yellow;
              label += "Differential Phase";
            break;
            case "RHOHV":
              dataset1 = getSistema().getArchivo().getRHOHV();
               highColor = Color.black;
              lowColor = Color.white;
              label += "Copolar Cross Correlation";
            break;
            case "HCLASS":
              dataset1 = getSistema().getArchivo().getHCLASS();
               highColor = Color.red;
              lowColor = Color.blue;
              label += "Hydrological Classification";
            break;    
                
        }   
         
        double[][] d= convertFloatsToDoubles(dataset1);
        hacergrafica(d,highColor,lowColor,opc);
        
                
         BufferedImage img= ImageIO.read(new File(path + "\\graficas\\" + opc + ".png"));
         ImageIcon icon = new ImageIcon(img);
        
         icon = Grafica.scaleImage(icon, 700, 400);
         
         getVentana().setImagen(icon);
          
          getVentana().getLblResultado().setText(label);
      }
      
}
