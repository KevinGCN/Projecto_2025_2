package Clases;
/**
 *
 * @author Tilines
 */
public class Nodo {
    private String valor;
    private Nodo raiz;   
    private Nodo izquierda;   
    private Nodo derecha;

    public Nodo() {
    }

    public Nodo(String valor, Nodo raiz, Nodo izquierda, Nodo derecha) {
        this.valor = valor;
        this.raiz = null;
        this.izquierda = null;
        this.derecha = null;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
            
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
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

    public boolean tieneIzquierda(){
        return this.izquierda == null;
    }
    
    public boolean tieneDerecha(){
        return this.derecha == null;
    }
    
    public Nodo traerContenido(Nodo nodo){
        Nodo temp = new Nodo();
        if (nodo.tieneIzquierda()) {
            temp.setRaiz(nodo.getIzquierda());
        } else if (nodo.tieneDerecha()){
            temp.setRaiz(nodo.getDerecha());
        } else {
            temp.setRaiz(nodo.getRaiz());
        }
        System.out.println(nodo.getValor());
        return traerContenido(nodo);
    }
}
