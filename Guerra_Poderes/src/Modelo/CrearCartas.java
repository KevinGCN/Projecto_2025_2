package Modelo;
/**
 *
 * @author carli
 */
public class CrearCartas {

    public static void crear(Jugador jugador, Jugador computadora) {
        Carta c1 = new Carta("Flamix", 100, 25, 5, "Fuego", "Agua");
        Carta c2 = new Carta("Aquaron", 120, 20, 5, "Agua", "Planta");
        Carta c3 = new Carta("Leafy", 90, 30, 5, "Planta", "Fuego");
        Carta e1 = new Carta("Robotron", 110, 22, 5, "Metal", "Fuego");
        Carta e2 = new Carta("MagmaDog", 95, 27, 5, "Fuego", "Agua");
        Carta e3 = new Carta("Hydrax", 130, 18, 5, "Agua", "Planta");

        if (jugador.getColaEspera().estaVacia()) {
            jugador.getColaEspera().encolar(c1);
            jugador.getColaEspera().encolar(c2);
            jugador.getColaEspera().encolar(c3);
        }

        if (computadora.getColaEspera().estaVacia()) {
            computadora.getColaEspera().encolar(e1);
            computadora.getColaEspera().encolar(e2);
            computadora.getColaEspera().encolar(e3);
        }

        if (jugador.getMazo().estaVacia()) {
            jugador.getMazo().agregarCarta(c1);
            jugador.getMazo().agregarCarta(c2);
            jugador.getMazo().agregarCarta(c3);
        }
        if (computadora.getMazo().estaVacia()) {
            computadora.getMazo().agregarCarta(e1);
            computadora.getMazo().agregarCarta(e2);
            computadora.getMazo().agregarCarta(e3);
        }
    }
}
