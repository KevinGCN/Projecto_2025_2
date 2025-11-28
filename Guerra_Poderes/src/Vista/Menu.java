package Vista;

import Controlador.MotorBatalla;
import Modelo.Carta;
import Modelo.Jugador;
import java.util.Scanner;

public class Menu {

    private final MotorBatalla motor = new MotorBatalla();
    private final Scanner sc = new Scanner(System.in);

    /**
     * Ciclo principal de combate entre jugador y CPU.
     */
    public void iniciarCombate(Jugador jugador, Jugador cpu) {

        Carta cartaJugador = seleccionarCartaInicial(jugador);
        Carta cartaCPU = seleccionarCartaCPU(cpu);

        int ganadasJugador = 0;
        int ganadasCPU = 0;

        while (cartaJugador != null && cartaCPU != null) {

            ejecutarRonda(cartaJugador, cartaCPU);

            // Validar derrotas según árbol de decisiones
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
    // MÉTODOS SIMPLES – RESPONSABILIDAD ÚNICA
    // ======================================================

    private Carta seleccionarCartaInicial(Jugador jugador) {
        System.out.println("\nSelecciona una carta para iniciar combate:");
        int indice = sc.nextInt();
        Carta seleccionada = jugador.getMazo().obtener(indice);

        // Asegurar que no se seleccione una carta muerta
        while (seleccionada.getVida() <= 0) {
            System.out.println("Esa carta ya está derrotada. Selecciona otra:");
            indice = sc.nextInt();
            seleccionada = jugador.getMazo().obtener(indice);
        }
        return seleccionada;
    }

    private Carta seleccionarCartaCPU(Jugador cpu) {
        if (cpu.getMazo().tamaño() == 0) return null;

        int index = (int) (Math.random() * cpu.getMazo().tamaño());
        Carta carta = cpu.getMazo().obtener(index);

        // Evitar que CPU elija una carta muerta
        while (carta.getVida() <= 0) {
            index = (int) (Math.random() * cpu.getMazo().tamaño());
            carta = cpu.getMazo().obtener(index);
        }

        System.out.println("\nLa computadora elige: " + carta.getNombre());
        return carta;
    }

    private void ejecutarRonda(Carta j, Carta c) {
        System.out.println("\n>>> TU ATACAS");

        motor.atacar(j, c);

        if (c.getVida() > 0) {
            System.out.println("\n>>> LA COMPUTADORA ATACA");
            motor.atacar(c, j);
        }

        mostrarResultadoRonda(j, c);
    }

    private void mostrarResultadoRonda(Carta j, Carta c) {
        System.out.println("\n--- RESULTADO DE LA RONDA ---");
        System.out.println("Tu carta: " + j);
        System.out.println("Carta CPU: " + c);
    }

    private void manejarDerrotaJugador(Jugador jugador, Jugador cpu, Carta cj, Carta cc) {
        System.out.println("\nPerdiste la ronda.");

        jugador.getPilaDescarte().push(cj);
        jugador.getMazo().eliminarCarta(cj);

        cpu.getColaEspera().encolar(cc);
    }

    private void manejarDerrotaCPU(Jugador jugador, Jugador cpu, Carta cj, Carta cc) {
        System.out.println("\nGanaste la ronda.");

        cpu.getPilaDescarte().push(cc);
        cpu.getMazo().eliminarCarta(cc);

        jugador.getColaEspera().encolar(cj);
    }

    private Carta siguienteCarta(Jugador jugador) {
        if (jugador.getMazo().tamaño() == 0) return null;

        Carta siguiente = jugador.getMazo().obtener(0);

        // Evitar seleccionar carta muerta
        if (siguiente.getVida() <= 0) {
            jugador.getMazo().eliminarCarta(siguiente);
            return siguienteCarta(jugador);
        }
        return siguiente;
    }

    private void mostrarResultadosFinales(Jugador j, int w, int l) {
        System.out.println("\n=====================");
        System.out.println("RESULTADOS FINALES");
        System.out.println("=====================");
        System.out.println(j.getNombre() + " Gano: " + w);
        System.out.println(j.getNombre() + " Perdio: " + l);
    }
}
