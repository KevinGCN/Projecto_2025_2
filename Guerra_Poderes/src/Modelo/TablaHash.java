package Modelo;

/**
 * Implementación simple de una tabla hash.
 * Usa un arreglo de listas para resolver colisiones.
 * 
 * BIG-O:
 *  - insertar -> O(1) promedio
 *  - buscar -> O(1) promedio
 *  - eliminar -> O(1) promedio
 */
public class TablaHash {

    // Nodo para la lista en cada cubeta
    private class Nodo {
        String clave;
        int valor;
        Nodo siguiente;

        public Nodo(String clave, int valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }

    private Nodo[] tabla;
    private int capacidad = 20; // tamaño 

    public TablaHash() {
        tabla = new Nodo[capacidad];
    }

    // Función hash básica
private int hash(String clave) {
    int suma = 0;
    for (char letra : clave.toCharArray()) {
        suma += letra;
    }
    return suma % capacidad;
}


    // Insertar o actualizar
    public void put(String clave, int valor) {
        int index = hash(clave);
        Nodo actual = tabla[index];

        // Buscar si ya existe
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                actual.valor = valor; // actualizar
                return;
            }
            actual = actual.siguiente;
        }

        // Insertar al inicio
        Nodo nuevo = new Nodo(clave, valor);
        nuevo.siguiente = tabla[index];
        tabla[index] = nuevo;
    }

    // Obtener valor por clave
    public int get(String clave) {
        int index = hash(clave);
        Nodo actual = tabla[index];

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }

        return -1; // No encontrado
    }

    // Eliminar entrada
    public void remove(String clave) {
        int index = hash(clave);
        Nodo actual = tabla[index];
        Nodo anterior = null;

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                if (anterior == null) {
                    tabla[index] = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }
}
