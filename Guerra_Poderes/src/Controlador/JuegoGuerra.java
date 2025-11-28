package Controlador;

import Modelo.Jugador;

public class JuegoGuerra {

    private Jugador jugador1;
    private Jugador jugador2;

    public JuegoGuerra(Jugador j1, Jugador j2) {
        this.jugador1 = j1;
        this.jugador2 = j2;
    }

    public void iniciar() {
        System.out.println("¡Comienza la guerra de cartas entre " +
            jugador1.getNombre() + " y " + jugador2.getNombre() + "!");
    }
}
