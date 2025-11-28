package Modelo;

/**
 * Cola simple con nodos enlazados (FIFO).
 * @author Tilines
 * Complejidad BIG-O:
 * - encolar()    -> O(1)
 * - desencolar() -> O(1)
 * - peek()       -> O(1)
 * - estaVacia()  -> O(1)
 * - tamaño()     -> O(n)  (recorre todos los nodos)
 */
public class Cola<T> {

    // Nodo interno de la cola
    private class NodoCola {
        T dato;               // Dato guardado
        NodoCola siguiente;   // Siguiente nodo

        public NodoCola(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private NodoCola frente; // Primer elemento
    private NodoCola fin;    // Último elemento

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    // Agrega un elemento al final
    public void encolar(T dato) {
        NodoCola nuevo = new NodoCola(dato);
        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    // Saca el primer elemento
    public T desencolar() {
        if (estaVacia()) {
            return null;
        }
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return dato;
    }

    // Ver el primer elemento sin sacarlo
    public T peek() {
        return estaVacia() ? null : frente.dato;
    }

    // Verifica si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Devuelve cuántos elementos hay
    public int tamaño() {
        int count = 0;
        NodoCola aux = frente;
        while (aux != null) {
            count++;
            aux = aux.siguiente;
        }
        return count;
    }

}
