/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.IOException;

/**
 *
 * @author John Fredy
 */
public class Lector {
    private FileNetCDF netcdf;

    public FileNetCDF LeerArchivo() throws IOException
    {
        getArchivo().LeerArchivo();
        return getArchivo();
    }
    
    
    public FileNetCDF getArchivo() {
        if(netcdf == null){
            netcdf = new FileNetCDF();
        }
        return netcdf;
    }
    
}
