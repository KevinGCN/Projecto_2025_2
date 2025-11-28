package Modelo;

/**
 * Pila simple para guardar cartas descartadas (LIFO).
 * @author Tilines
 * Complejidad BIG-O:
 * - push()  -> O(1)
 * - pop()   -> O(1)
 * - vacia() -> O(1)
 */
public class Pila {

    // Nodo interno de la pila
    private class NodoPila {
        Carta carta;      // Carta guardada
        NodoPila abajo;   // Nodo siguiente (debajo en la pila)

        public NodoPila(Carta carta) {
            this.carta = carta;
        }
    }

    private NodoPila tope; // Último elemento agregado

    // Agrega una carta a la pila
    public void push(Carta carta) {
        NodoPila nuevo = new NodoPila(carta);
        nuevo.abajo = tope;
        tope = nuevo;
    }

    // Saca la carta del tope
    public Carta pop() {
        if (vacia()) return null;
        Carta c = tope.carta;
        tope = tope.abajo;
        return c;
    }

    // Verifica si la pila está vacía
    public boolean vacia() {
        return tope == null;
    }
}
