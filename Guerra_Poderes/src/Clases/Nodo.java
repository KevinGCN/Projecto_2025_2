package Clases;
/**
 *
 * @author Tilines
 */
public class Nodo {
    private String raiz;   
    private Nodo izquierda;   
    private Nodo derecha;

    public Nodo() {
    }

    public Nodo(String raiz, Nodo izquierda, Nodo derecha) {
        this.raiz = null;
        this.izquierda = null;
        this.derecha = null;
    }

    public String getRaiz() {
        return raiz;
    }

    public void setRaiz(String raiz) {
        this.raiz = raiz;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    
 
}
