/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import modelos.objetos.Usuario;

/**
 *
 * @author sergio
 */
public class VerificacionDeRoles {
private final static int  ID_ADMIN = 2; 
private final static int  ID_USER = 1; 
private final static int  ID_EDITOR = 3;


public static boolean verificarAccesoParaEditar(Usuario usuario){
    return usuario.getRol()!=ID_USER;
}
public static boolean verificarAccesoParaFuncionesAdministrativas(Usuario usuario){
    System.out.println(usuario.getRol());
    return usuario.getRol()==ID_ADMIN;
}


}
