/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 *
 * @author jose_
 */
public class Utilidades {
    
    public static java.time.LocalDate SqlDateToJavaLocalDate(java.sql.Date fecha){
        return java.time.LocalDate.parse(fecha.toString());
    }
    
    public static java.sql.Date JavaLocalDateToSqlDate(java.time.LocalDate fecha){
        return java.sql.Date.valueOf(fecha);
    }
    
    public static java.sql.Date JavaDateToSqlDate(java.util.Date fecha){
        return new java.sql.Date(fecha.getTime());
    }
    
    public static java.util.Date SqlDateToJavaDate(java.sql.Date fecha){
        return new java.util.Date(fecha.getTime());
    }
    
    public static java.util.Date LocalDateToDate(java.time.LocalDate fecha){
        return Date.from(fecha.atStartOfDay().toInstant(ZoneOffset.UTC));
    }
    
    public static java.time.LocalDate DateToLocalDate(java.util.Date fecha){
        return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
