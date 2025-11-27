package Clases;
import java.util.Scanner;
/**
 *
 * @author Tilines
 */
public class NodoArbol {
    private ColaNodo valor;
    private NodoArbol izquierda;
    private NodoArbol derecha;

    public NodoArbol(ColaNodo valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

    public ColaNodo getValor() { return valor; }
    
    public void setValor(ColaNodo valor) { this.valor = valor; }

    public NodoArbol getIzquierda() { return izquierda; }
    
    public void setIzquierda(NodoArbol izquierda) { this.izquierda = izquierda; }

    public NodoArbol getDerecha() { return derecha; }
    
    public void setDerecha(NodoArbol derecha) { this.derecha = derecha; }
    
    public boolean esFuerte(Carta atacante, Carta objetivo) {
        return atacante.getElemento().equals(objetivo.getDebilidad());
    }
    public boolean esDebil(Carta atacante, Carta objetivo) {
        return atacante.getDebilidad().equals(objetivo.getElemento());
    }
    public boolean tieneVida(Carta objetivo) {
        return objetivo.getVida() > 0;
    }
    
    public void seleccionarCarta(ListaCartas cartas){
        Jugador usuario = new Jugador();
        Jugador computador = new Jugador();
        Scanner sc = new Scanner (System.in);
        int num_carta = sc.nextInt();
        String debilidad = usuario.getMazo().obtener(num_carta).getDebilidad();
        for (int i = 0; i < computador.getMazo().tamaño(); i++) {
            if (debilidad.equals(computador.getMazo().obtener(i).getElemento())) {
                Atacar(computador.getMazo().obtener(i), usuario.getMazo().obtener(num_carta));
            }
        }
        sc.close();
    }
            
    public void Atacar(Carta atacante, Carta objetivo) {
        int vida = objetivo.getVida();
        int ataque = atacante.getAtaque();
        double temp;
        int vidaNueva;
        if (esFuerte(atacante, objetivo)) {
            temp = ataque * 1.2;
        } else if (esDebil(atacante, objetivo)) {
            temp = ataque * 0.7;
        } else {
            temp = ataque;
        }
        if (objetivo.getVida() > 0) {
            vidaNueva = vida - (int)temp;
            objetivo.setVida(vidaNueva);
            if (atacante.getEnergia() > 0) {
                atacante.setEnergia(atacante.getEnergia()-1);
            } else {
                atacante.setEnergia(1);
            }
        } else {
            System.out.println(objetivo.getNombre() + " ha sido eliminado");
        }
    }
}

