/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import modelos.objetos.HechoHistorico;

/**
 *
 * @author jose_
 */
public class HechoHistoricoDb {

    private Mensaje mensajes = new Mensaje();

    public void crearHH(HechoHistorico hhACrear) {//creamos un nuevo hecho historico
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO acontecimiento "
                    + "(id,titulo,autor,Periodo_nombre,htmlCodigo,  fechaInicio,fechaFin, ACInicio, ACFin,categoria, descripcion) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?);");
            statement.setInt(1, hhACrear.getId());
            statement.setString(2, hhACrear.getTitulo());
            statement.setString(3, hhACrear.getAutor());
            statement.setString(4, hhACrear.getPeriodo());
            statement.setString(5, hhACrear.getHtmlCode());
            statement.setString(6, hhACrear.getFechaInicio());
            statement.setString(7, hhACrear.getFechaFin());
            statement.setString(8, hhACrear.getAcI());
            statement.setString(9, hhACrear.getAcF());
            statement.setString(10, hhACrear.getCategoria());
            statement.setString(11, hhACrear.getDescripcion());
            statement.executeUpdate();
            mensajes.informacion("Se ha creado el hecho historico con éxito.");
        } catch (SQLException ex) {
           // System.out.println(ex);
            mensajes.error("No se pudo guardar el hecho historico. Ingrese otro hecho historico. ");
        }
    }

    public void actualizarHechoHistorico(HechoHistorico hhActualizar) {//actualizamos hecho historico
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE acontecimiento SET "
                    + " titulo=?,autor=?, Periodo_nombre=?,htmlCodigo=?,"
                    + "fechaInicio =? , fechaFin=?,ACInicio=?, ACFin=?,  "
                    + "categoria=? ,  descripcion=? "
                    + "WHERE id=?;");
            statement.setString(1, hhActualizar.getTitulo());
            statement.setString(2, hhActualizar.getAutor());
            statement.setString(3, hhActualizar.getPeriodo());
            statement.setString(4, hhActualizar.getHtmlCode());
            statement.setString(5, hhActualizar.getFechaInicio());
            statement.setString(6, hhActualizar.getFechaFin());
            statement.setString(7, hhActualizar.getAcI());
            statement.setString(8, hhActualizar.getAcF());
            statement.setString(9, hhActualizar.getTitulo());
            statement.setString(10, hhActualizar.getDescripcion());
            statement.setInt(11, hhActualizar.getId());
            statement.executeUpdate();
            mensajes.informacion("Se ha actualizado el hecho historico con exito.");
        } catch (SQLException ex) {
            System.out.println(ex);
            mensajes.error("NO se actualizo el hechoHistorico. Asegurese que  exista");
        }

    }

    public void eliminarHechoHistorico(HechoHistorico hhAEliminar) {//eliminamos hecho historico
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM acontecimiento WHERE id=?;");
            statement.setInt(1, hhAEliminar.getId());
            statement.executeUpdate();
            mensajes.informacion("Se eliminó el hecho historico con exito.");
        } catch (SQLException ex) {
            mensajes.error("No se elimino el hechoHistorico .. Asegurese que el hechoHistorico exista");
        }
    }

    public LinkedList<HechoHistorico> leerHechosHistoricos() { //mostramos todos los hechos historicos y devolvemos en una lista
        LinkedList<HechoHistorico> listaHechosHistoricos = new LinkedList<>();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM acontecimiento;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                HechoHistorico acontecimiento = convertirAHH(resultado);
                listaHechosHistoricos.add(acontecimiento);
            }
        } catch (SQLException ex) {
            mensajes.error("No existen hechos historicos");
        }
        return listaHechosHistoricos;
    }

    public HechoHistorico leerHechoHistorico(HechoHistorico hhBuscar) {//leemos un hechoHistorico en especifico y lo devolvemos
        HechoHistorico hh = null;

        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM acontecimiento WHERE id= ? ;");
            statement.setInt(1, hhBuscar.getId());
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                hh = convertirAHH(resultado);
            }
        } catch (SQLException ex) {
            mensajes.error("No se encontro el hechoHistorico");
        }
        return hh;
    }

    public HechoHistorico convertirAHH(ResultSet resultado) {//del resultado de la busqueda obtener el hechohistorico
        HechoHistorico hhDevolver = null;
        try {
            hhDevolver = new HechoHistorico(resultado.getInt(1), resultado.getString(2), resultado.getString(3),
                    resultado.getString(4), resultado.getString(5), resultado.getString(6), resultado.getString(7),
                    resultado.getString(8), resultado.getString(9), resultado.getString(10), resultado.getString(11));
        } catch (SQLException ex) {
            mensajes.error("error en conversion de hechoHistorico");
        }
        return hhDevolver;
    }

}
