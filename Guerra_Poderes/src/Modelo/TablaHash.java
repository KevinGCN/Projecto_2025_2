package Modelo;

/**
 * Guarda estadísticas del jugador.
 * @author Tilines
 *Complejidad BIG-O:
 * - getters y setters -> O(1)
 */
public class TablaHash {

    // Jugador al que pertenecen los datos
    private Jugador jugador;

    // Número de rondas ganadas
    private int rondasGanadas;

    // Cartas que el jugador ha jugado
    private ListaCartas cartasJugadas;

    // Cartas que el jugador ha derrotado
    private ListaCartas cartasDerrotadas;

    // Poder total ganado
    private int poderGanado;

    public TablaHash() {
    }

    public TablaHash(Jugador jugador, int rondasGanadas, ListaCartas cartasJugadas,
                     ListaCartas cartasDerrotadas, int poderGanado) {
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
