package Vista;

import Controlador.MotorBatalla;
import Modelo.Carta;
import Modelo.Jugador;
import java.util.Scanner;

public class Menu {

    private final MotorBatalla motor = new MotorBatalla();
    private final Scanner sc = new Scanner(System.in);

    /**
     * Arranca el ciclo de combate entre dos jugadores.
     */
    public void iniciarCombate(Jugador jugador, Jugador cpu) {

        Carta cartaJugador = seleccionarCartaInicial(jugador);
        Carta cartaCPU = seleccionarCartaCPU(cpu);

        int ganadasJugador = 0;
        int ganadasCPU = 0;

        while (cartaJugador != null && cartaCPU != null) {

            ejecutarRonda(cartaJugador, cartaCPU);

            if (cartaJugador.getVida() <= 0) {
                ganadasCPU++;
                manejarDerrotaJugador(jugador, cpu, cartaJugador, cartaCPU);
                cartaJugador = siguienteCarta(jugador);

            } else if (cartaCPU.getVida() <= 0) {
                ganadasJugador++;
                manejarDerrotaCPU(jugador, cpu, cartaJugador, cartaCPU);
                cartaCPU = seleccionarCartaCPU(cpu);
            }
        }

        mostrarResultadosFinales(jugador, ganadasJugador, ganadasCPU);
    }

    // ======================================================
    // MÉTODOS LIMPIOS – RESPONSABILIDAD ÚNICA
    // ======================================================

    private Carta seleccionarCartaInicial(Jugador jugador) {
        System.out.println("\nSelecciona una carta para combatir:");
        int indice = sc.nextInt();
        return jugador.getMazo().obtener(indice);
    }

    private Carta seleccionarCartaCPU(Jugador cpu) {
        int index = (int) (Math.random() * cpu.getMazo().tamaño());
        Carta cartaCPU = cpu.getMazo().obtener(index);
        System.out.println("\nLa computadora elige: " + cartaCPU.getNombre());
        return cartaCPU;
    }

    private void ejecutarRonda(Carta cartaJugador, Carta cartaCPU) {
        System.out.println("\n>>> TU ATACAS PRIMERO");
        motor.atacar(cartaJugador, cartaCPU);

        if (cartaCPU.getVida() > 0) {
            System.out.println("\n>>> LA COMPUTADORA ATACA");
            motor.atacar(cartaCPU, cartaJugador);
        }

        mostrarResultadoRonda(cartaJugador, cartaCPU);
    }

    private void mostrarResultadoRonda(Carta j, Carta c) {
        System.out.println("\n--- RESULTADO ---");
        System.out.println("Tu carta: " + j);
        System.out.println("Carta computadora: " + c);
    }

    private void manejarDerrotaJugador(Jugador jugador, Jugador cpu, Carta cartaJugador, Carta cartaCPU) {
        System.out.println("\nPerdiste la batalla");

        jugador.getPilaDescarte().push(cartaJugador);
        jugador.getMazo().eliminarCarta(cartaJugador);

        cpu.getColaEspera().encolar(cartaCPU);
    }

    private void manejarDerrotaCPU(Jugador jugador, Jugador cpu, Carta cartaJugador, Carta cartaCPU) {
        System.out.println("\nGanaste la batalla");

        cpu.getPilaDescarte().push(cartaCPU);
        cpu.getMazo().eliminarCarta(cartaCPU);

        jugador.getColaEspera().encolar(cartaJugador);
    }

    private Carta siguienteCarta(Jugador jugador) {
        if (jugador.getMazo().tamaño() == 0) return null;
        return jugador.getMazo().obtener(0);
    }

    private void mostrarResultadosFinales(Jugador j, int wins, int loses) {
        System.out.println("\n=====================");
        System.out.println("RESULTADOS FINALES");
        System.out.println("=====================");
        System.out.println(j.getNombre() + " Ganó: " + wins);
        System.out.println(j.getNombre() + " Perdió: " + loses);
    }
}
