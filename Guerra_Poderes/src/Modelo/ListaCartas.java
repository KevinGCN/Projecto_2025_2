package Modelo;

import java.util.ArrayList;
//Big O(1)

public class ListaCartas {
    //lista que almacena cartas
    private ArrayList<Carta> cartas;

    //inicializa cartas
    public ListaCartas() {
        cartas = new ArrayList<>();
    }
    //agrega una carta al final de lista
    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }
    //elimina una carta especifica de la lista
    public ArrayList<Carta> eliminarCarta(Carta carta){
        cartas.remove(carta);
        return cartas;
    }
    //obtiene su indice
    public Carta obtener(int index) {
        return cartas.get(index);
    }

    public int tamaño() {
        return cartas.size();
    }
    //verifica si la lista esta vacia
        public boolean estaVacia() {
        return cartas.isEmpty();
    }
}

