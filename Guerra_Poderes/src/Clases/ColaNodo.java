package Clases;

public class ColaNodo {

    private Jugador jugador;
    private ColaNodo izquierda;
    private ColaNodo derecha;

    public ColaNodo(Jugador jugador) {
        this.jugador = jugador;
        this.izquierda = null;
        this.derecha = null;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
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
}
