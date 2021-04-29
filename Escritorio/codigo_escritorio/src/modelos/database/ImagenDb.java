/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.objetos.Imagen;

/**
 *
 * @author jose_
 */
public class ImagenDb {
    
    public void crear(Imagen imagen){}
    public void modificar(Imagen imagen){}
    public void eliminar(int id){}
    
    public Imagen getImagen(int idEscritorio,String ruta,String categoria){
        
        Imagen i=new Imagen(idEscritorio, ruta, ruta, categoria);

        return i;
    }
    
    private Imagen instanciarDeResultSet(ResultSet resultado) throws SQLException{
        return new Imagen(
                resultado.getInt("id"),
                resultado.getString("dirWeb"),
                resultado.getString("dirEscritorio"),
                resultado.getString("categoria")
        );
    }
}
