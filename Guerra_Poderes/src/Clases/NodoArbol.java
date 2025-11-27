package Clases;

public class NodoArbol {

    private ColaNodo valor;
    private NodoArbol izquierda;
    private NodoArbol derecha;

    public NodoArbol(ColaNodo valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

    public ColaNodo getValor() {
        return valor;
    }

    public void setValor(ColaNodo valor) {
        this.valor = valor;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }
}
