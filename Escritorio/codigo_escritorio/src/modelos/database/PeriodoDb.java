/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.objetos.Periodo;

/**
 *
 * @author Esmeralda
 */
public class PeriodoDb {

    public List<Periodo> getPeriodo() {
        List<Periodo> periodos = new ArrayList();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM periodo;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                periodos.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return periodos;
    }

    private Periodo instanciarDeResultSet(ResultSet resultado) throws SQLException {
        return new Periodo(
                resultado.getInt("orden"),
                resultado.getString("nombre"),
                resultado.getString("ACInicio"),
                resultado.getString("ACFin")
        );
    }

}
