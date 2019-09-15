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
import static javafx.scene.text.Font.font;
import static sun.net.www.http.HttpClient.New;
import ucar.nc2.dataset.NetcdfDataset;
import static visad.Display.Red;
import visad.DisplayRealType;

/**
 *
 * @author EdwarC
 */
public class Grafica {

    
    
    public float[][] dataset;
     public FileNetCDF filenetcdf;
    private NetcdfDataset netcdfRunFileDataset;

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
    
   

    public Grafica() throws IOException {
           
        float[][] dataset1 = filenetcdf.getZ();
        double[][] d=convertFloatsToDoubles(dataset1);
        
        float[][] dataset2 = filenetcdf.getV();
        double[][] e=convertFloatsToDoubles(dataset2);
        
        float[][] dataset3 = filenetcdf.getKDP();
        double[][] f=convertFloatsToDoubles(dataset3);
        
         float[][] dataset4 = filenetcdf.getRHOHV();
        double[][] g=convertFloatsToDoubles(dataset3);
        
        //hacergrafica(d,e,f,g);
        
}
    
public double graficarVariableFloatN(String variable) throws IOException{
    
    float[][] var1 = filenetcdf.getVariable2DFloat(variable, netcdfRunFileDataset);
    double[][] d=convertFloatsToDoubles(var1);
    //hacergrafica(d);
        return 0;
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

   
   

   
   
    public static double[][] hacergrafica(double data[][], double[][] datax, double[][] datay, double[][] dataw, double[][] dataq, double[][] datap) throws IOException {
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

// Step 1: Create our heat map chart using our data.

HeatChart map = new HeatChart(data);
// Step 2: Customise the chart.
map.setTitle("This is my heat chart title");
map.setXAxisLabel("X Axis");
map.setYAxisLabel("Y Axis");

// Step 3: Output the chart to a file.
map.setHighValueColour(Color.MAGENTA);
map.setLowValueColour(Color.RED);
map.setAxisColour(Color.RED);
map.setShowXAxisValues(true);
map.setShowYAxisValues(true);
map.setBackgroundColour(Color.BLACK);
map.setTitle("Prueba");
map.setZValues(datax);
map.setYValues(datay);
map.setZValues(dataw);
map.setXValues(datap);
map.setYValues(dataq);
map.setChartMargin(4);
map.isShowXAxisValues();
map.getZValues();
map.setXValuesHorizontal(true);
map.saveToFile(new File("graficas\\java-heat-chart.png"));



return data;
    }

    }
    
    
    