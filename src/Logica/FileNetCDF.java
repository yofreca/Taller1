/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.io.IOException;
import ucar.ma2.Array;
import ucar.ma2.DataType;
import ucar.ma2.Index;
import ucar.ma2.InvalidRangeException;
import ucar.ma2.Range;
import ucar.nc2.Attribute;
import ucar.nc2.Dimension;
import ucar.nc2.Group;
import ucar.nc2.Variable;
import ucar.nc2.NetcdfFile;
import ucar.nc2.dataset.NetcdfDataset;

/**
 *
 * @author John Castellanos
 */
public class FileNetCDF {
    private double esStartTime, radialTime;
    private short elevationNumber;
    private float elevationAngle, radialAzim, radialElev, siteLat, siteLon,siteAlt, firstGateRange, gateSize, nyquist, unambigRange, calibConst;
    private float[][] Z,V,ZDR,KDP,PHIDP,RHOHV,HCLASS;   
    
    private Variable variable;
    

    public double getEsStartTime() {
        return esStartTime;
    }

    public double getRadialTime() {
        return radialTime;
    }

    public short getElevationNumber() {
        return elevationNumber;
    }

    public float getElevationAngle() {
        return elevationAngle;
    }

    public float getRadialAzim() {
        return radialAzim;
    }

    public float getRadialElev() {
        return radialElev;
    }

    public float getSiteLat() {
        return siteLat;
    }

    public float getSiteLon() {
        return siteLon;
    }

    public float getSiteAlt() {
        return siteAlt;
    }

    public float getFirstGateRange() {
        return firstGateRange;
    }

    public float getGateSize() {
        return gateSize;
    }

    public float getNyquist() {
        return nyquist;
    }

    public float getUnambigRange() {
        return unambigRange;
    }

    public float getCalibConst() {
        return calibConst;
    }

    public float[][] getZ() {
        return Z;
    }

    public float[][] getV() {
        return V;
    }

    public float[][] getZDR() {
        return ZDR;
    }

    public float[][] getKDP() {
        return KDP;
    }

    public float[][] getPHIDP() {
        return PHIDP;
    }

    public float[][] getRHOHV() {
        return RHOHV;
    }

    public float[][] getHCLASS() {
        return HCLASS;
    }
    
    public void LeerArchivo() throws IOException
    {
        NetcdfDataset netcdfRunFileDataset = new NetcdfDataset(NetcdfDataset.openFile("F:\\Java\\NEtCDF\\LeerNetCDF\\outN.1", null));
        
        esStartTime = getVariableEscalarDouble("esStartTime",netcdfRunFileDataset);
        radialTime = getVariableEscalarDouble("radialTime",netcdfRunFileDataset);
    }
    
    
    private double getVariableEscalarDouble(String sNameVariable, NetcdfDataset netcdfRunFileDataset) throws IOException
    {
        Variable variable = netcdfRunFileDataset.findVariable(sNameVariable);
        double varDouble = variable.readScalarDouble();
        return varDouble;
    }
    
    private short getVariableEscalarShort(String sNameVariable, NetcdfDataset netcdfRunFileDataset) throws IOException
    {
        Variable variable = netcdfRunFileDataset.findVariable(sNameVariable);
        short varShort = variable.readScalarShort();
        return varShort;
    }
    
    
    private float getVariableEscalarFloat(String sNameVariable, NetcdfDataset netcdfRunFileDataset) throws IOException
    {
        Variable variable = netcdfRunFileDataset.findVariable(sNameVariable);
        float varFloat = variable.readScalarFloat();
        return varFloat;
    }
    
    private float[][] getVariable2DFloat(String sNameVariable, NetcdfDataset netcdfRunFileDataset) throws IOException
    {
        Variable variable = netcdfRunFileDataset.findVariable(sNameVariable);
        Array ArrayVar  = variable.read();
      
        Object ObjectVar = ArrayVar.copyToNDJavaArray();
        float[][] float2D = (float[][]) ObjectVar;
        return float2D;
    }
    
}