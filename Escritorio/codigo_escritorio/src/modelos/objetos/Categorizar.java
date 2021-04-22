package modelos.objetos;

/**
 *
 * @author esmeralda
 */
public class Categorizar {
    int idHecho;
    int idCategoria1;

    public Categorizar(int idHecho, int idCategoria1) {
        this.idHecho = idHecho;
        this.idCategoria1 = idCategoria1;
    }
    

    public int getIdCategoria1() {
        return idCategoria1;
    }

    public void setIdCategoria1(int idCategoria1) {
        this.idCategoria1 = idCategoria1;
    }

    public int getIdHecho() {
        return idHecho;
    }

    public void setIdHecho(int idHecho) {
        this.idHecho = idHecho;
    }

    

    @Override
    public String toString() {
        return "\n Categorizar{" + "idCategoria1=" + idCategoria1 + ", idHecho=" + idHecho + '}';
    }


    
}
