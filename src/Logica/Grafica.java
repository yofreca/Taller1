/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static com.google.common.io.Files.map;
import com.sun.prism.paint.Gradient;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import static jdk.nashorn.internal.objects.NativeArray.map;
import org.tc33.jheatchart.HeatChart;
import sun.misc.FloatingDecimal;
import static sun.net.www.http.HttpClient.New;
import Logica.FileNetCDF;
import java.awt.Image;
import javax.swing.ImageIcon;
import static sun.net.www.http.HttpClient.New;
import static visad.Display.Red;
import visad.DisplayRealType;

/**
 *
 * @author EdwarC
 */
public class Grafica {

    
    
    public float[][] dataset;

    public FileNetCDF getFilenetcdf() {
        return filenetcdf;
    }

    public float[][] getDataset() {
        return dataset;
    }

    public void setDataset(float[][] dataset) {
        this.dataset = dataset;
    }

    public void setFilenetcdf(FileNetCDF filenetcdf) {
        this.filenetcdf = filenetcdf;
    }
    
    public FileNetCDF filenetcdf;

    public Grafica() throws IOException {
           
        float[][] dataset1 = filenetcdf.getZ();
        double[][] d=convertFloatsToDoubles(dataset1);
    //    hacergrafica(d);
        
}
    
  
    
   public static double[][] convertFloatsToDoubles(float[][] input)
{
    if (input == null)
    {
        return null; // Or throw an exception - your choice
    }
    double[][] output = new double[input.length][input.length];
    for (int i = 0; i < input.length; i++)
    {
        for (int j =0;j< input.length;j++){
            output[i][j] = input[i][j];
        }
        
    }
    return output;
}

   
   

   
   
    public static double[][] hacergrafica(double data[][], Color HighColor, Color LowColor, String fileName ) throws IOException {
            //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

          // Step 1: Create our heat map chart using our data.

          HeatChart map = new HeatChart(data);
          // Step 2: Customise the chart.
          map.setTitle("This is my heat chart title");
          map.setXAxisLabel("X Axis");
          map.setYAxisLabel("Y Axis");

          // Step 3: Output the chart to a file.
          map.setHighValueColour(HighColor);
          map.setLowValueColour(LowColor);
          map.setAxisColour(Color.BLACK);
          map.setBackgroundColour(Color.CYAN);
          map.setTitle("Grafico");
          map.saveToFile(new File("graficas/" + fileName + ".png"));


          return data;
   }

    public static ImageIcon scaleImage(ImageIcon icon, int w, int h)
    {
        
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w)
        {
          nw = w;
          nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h)
        {
          nh = h;
          nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }


}
    
    
    