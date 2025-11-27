package Clases;

public class ColaNodo {

    private Jugador nombre;
    private ColaNodo izquierda;
    private ColaNodo derecha;

    public ColaNodo() {
    }

    public ColaNodo(Jugador nombre) {
        this.nombre = nombre;
        this.izquierda = null;
        this.derecha = null;
    }

    public Jugador getNombre() {
        return nombre;
    }

    public void setNombre(Jugador nombre) {
        this.nombre = nombre;
    }

    public ColaNodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(ColaNodo izquierda) {
        this.izquierda = izquierda;
    }

    public ColaNodo getDerecha() {
        return derecha;
    }

    public void setDerecha(ColaNodo derecha) {
        this.derecha = derecha;
    }

    public boolean tieneIzquierda() {
        return this.izquierda != null;
    }

    public boolean tieneDerecha() {
        return this.derecha != null;
    }
}
