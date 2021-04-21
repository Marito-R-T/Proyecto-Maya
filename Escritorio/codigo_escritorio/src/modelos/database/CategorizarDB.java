package modelos.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import modelos.objetos.Categorizar;

/**
 *
 * @author esmeralda
 */
public class CategorizarDB {
    
    
    public void crearCategorizacion(Categorizar categorizacionACrear) {//creamos una categorizacion
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO categorizar "
                    + "(idHechoHistorico,idCategoria) "
                    + "VALUES (?,?);");
            statement.setInt(1, categorizacionACrear.getIdHecho());
            statement.setInt(2, categorizacionACrear.getIdCategoria1());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n Cree otra clasificacion por favor. ");
        }
    }

    public void actualizarCategorizacion(Categorizar categorizacionActualizar, int idhHAnterior, int idCategoriaAnterior) {//actualizamos categorizacion
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE categorizar SET "
                    + " idHechoHistorico =? , idCategoria=?  "
                    + "WHERE idHechoHistorico =? AND  idCategoria=? ;");
            statement.setInt(1, categorizacionActualizar.getIdHecho());
            statement.setInt(2, categorizacionActualizar.getIdCategoria1());
            statement.setInt(3, idhHAnterior);
            statement.setInt(4, idCategoriaAnterior);

            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n NO se actualizo la categorizacion. Asegurese que  exista");
        }

    }

    public void eliminarHechoHistorico(Categorizar categorizarEliminar) {//eliminamos categorizacion
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM categorizar  "
        + "WHERE idHechoHistorico =? AND  idCategoria=? ;");
            statement.setInt(1, categorizarEliminar.getIdHecho());
            statement.setInt(2, categorizarEliminar.getIdCategoria1());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n No se elimino la categorizacion . Asegurese que  exista");
        }
    }

    public LinkedList<Categorizar> leerCategorizaciones() { //mostramos todas las categorizaciones y devolvemos en una lista
        LinkedList<Categorizar> listaCategorizaciones = new LinkedList<>();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM categorizar;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Categorizar c = convertirCategorizacion(resultado);
                listaCategorizaciones.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("No se leyeron las categorizaciones de la DB");
        }
        return listaCategorizaciones;
    }

    public Categorizar leerHechoHistorico(Categorizar categorizacionBuscar) {//leemos una categorizacion en especifico y lo devolvemos
        Categorizar c = null;

        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM categorizar "
                    + "WHERE idHechoHistorico =? AND idCategoria=? ;");
            statement.setInt(1, categorizacionBuscar.getIdHecho());
            statement.setInt(2, categorizacionBuscar.getIdCategoria1());
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                c = convertirCategorizacion(resultado);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n no se encontro la categorizacion");
        }
        return c;
    }

    public Categorizar convertirCategorizacion(ResultSet resultado) {//del resultado de la busqueda obtener la categorizacion
        Categorizar categorizacionDevolver = null;
        try {
            //aqui devuelve numeros del id de hecho historico y del id de la categoria
            
            categorizacionDevolver = new Categorizar(resultado.getInt(1),resultado.getInt(2));
        } catch (SQLException ex) {
            System.out.println("error en conversion de categorizacion");
        }
        return categorizacionDevolver;
    }

    
}
