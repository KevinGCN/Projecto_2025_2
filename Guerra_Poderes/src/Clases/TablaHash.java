package Clases;
/**
 *Guarda estadísticas del jugador.
 * @author Tilines
 */
public class TablaHash {
    private Jugador jugador;
    private int rondasGanadas;
    private ListaCartas cartasJugadas;
    private ListaCartas cartasDerrotadas;
    private int poderGanado;

    public TablaHash() {
    }

    public TablaHash(Jugador jugador, int rondasGanadas, ListaCartas cartasJugadas, ListaCartas cartasDerrotadas, int poderGanado) {
        this.jugador = jugador;
        this.rondasGanadas = rondasGanadas;
        this.cartasJugadas = cartasJugadas;
        this.cartasDerrotadas = cartasDerrotadas;
        this.poderGanado = poderGanado;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public void setRondasGanadas(int rondasGanadas) {
        this.rondasGanadas = rondasGanadas;
    }

    public ListaCartas getCartasJugadas() {
        return cartasJugadas;
    }

    public void setCartasJugadas(ListaCartas cartasJugadas) {
        this.cartasJugadas = cartasJugadas;
    }

    public ListaCartas getCartasDerrotadas() {
        return cartasDerrotadas;
    }

    public void setCartasDerrotadas(ListaCartas cartasDerrotadas) {
        this.cartasDerrotadas = cartasDerrotadas;
    }

    public int getPoderGanado() {
        return poderGanado;
    }

    public void setPoderGanado(int poderGanado) {
        this.poderGanado = poderGanado;
    }
}
