
package principal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.database.ConexionDb;
import api.login.Login;

/**
 *
 * @author luisGonzalez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            //INICIAMOS CONECTANDO  DB  
            ConexionDb.obtenerConexion();
            
            Login login = new Login();
            login.iniciar();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
