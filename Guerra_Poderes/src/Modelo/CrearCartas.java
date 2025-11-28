package Modelo;

/**
 * Clase responsable de crear y asignar cartas iniciales
 * para el jugador y la computadora.
 *
 * Complejidad general del método:
 * -------------------------------
 * - Crear cartas: O(1) por ser instanciaciones directas.
 * - Encolar cartas en la cola: O(n) donde n es la cantidad de cartas 
 *   agregadas (3 en este caso). Cada operación encolar = O(1).
 * - Agregar cartas al mazo (lista o pila): O(n). Cada inserción es O(1).
 */
public class CrearCartas {

    /**
     * Método estático que crea las cartas básicas y las agrega a las
     * estructuras de datos del jugador y de la computadora.
     *
     * @param jugador Objeto Jugador con cola de espera y mazo.
     * @param computadora Objeto Jugador controlado por la IA.
     */
    public static void crear(Jugador jugador, Jugador computadora) {

        // --- Creación de cartas base (operación O(1)) ---
        Carta c1 = new Carta("Flamix", 100, 25, 5, "Fuego", "Agua");
        Carta c2 = new Carta("Aquaron", 120, 20, 5, "Agua", "Planta");
        Carta c3 = new Carta("Leafy", 90, 30, 5, "Planta", "Fuego");

        Carta e1 = new Carta("Robotron", 110, 22, 5, "Metal", "Fuego");
        Carta e2 = new Carta("MagmaDog", 95, 27, 5, "Fuego", "Agua");
        Carta e3 = new Carta("Hydrax", 130, 18, 5, "Agua", "Planta");

        // --- Agregar cartas a la cola de espera ---
        // Validar si la cola está vacía evita duplicados al reiniciar la partida.
        // Cada encolado es O(1), el bloque completo es O(3) ≈ O(1)
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

        // --- Agregar cartas al mazo (lista, pila o arreglo dinámico) ---
        // Cada inserción es O(1)
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
