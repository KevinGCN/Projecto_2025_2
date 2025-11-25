package Clases;

public class Nodo {

    private String valor;
    private Nodo izquierda;
    private Nodo derecha;

    public Nodo() {
    }

    public Nodo(String valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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

    public boolean tieneIzquierda() {
        return this.izquierda != null;
    }

    public boolean tieneDerecha() {
        return this.derecha != null;
    }
}
