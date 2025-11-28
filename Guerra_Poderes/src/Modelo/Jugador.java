package Modelo;
/**
 *  Representa un jugador con mazo, cola y pila.
 * @author Tilines
 */
public class Jugador {
    //Atributos de l aclase jugador
    private String nombre;
    private int rondasG;
    private ListaCartas mazo;
    private Cola<Carta> colaEspera;
    private Pila pilaDescarte;
    //constructor vacio de la clase jugador
    public Jugador() {
    }
    //crea un jugador sin inicializar sus atributos
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.rondasG = 0;
        this.mazo = new ListaCartas();
        this.colaEspera = new Cola<>();
        this.pilaDescarte = new Pila();
    }
    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public int getRondasG() {
        return rondasG;
    }

    public void setRondasG(int rondasG) {
        this.rondasG = rondasG;
    }
    
    public ListaCartas getMazo() {
        return mazo;
    }

    public Cola<Carta> getColaEspera() {
        return colaEspera;
    }

    public Pila getPilaDescarte() {
        return pilaDescarte;
    }
    //devuelve true si el mazo no esta vacio
    public boolean tieneCartas(ListaCartas mazo){
        return !mazo.estaVacia();
    }
}

