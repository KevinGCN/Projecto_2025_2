package Clases;
/**
 *
 * @author Tilines
 */
public class Mob {
    private String nombre;
    private int vida;
    private int ataque;
    private int energia;
    private String elemento;
    private String debilidad;

    public Mob() {
    }

    public Mob(String nombre, int vida, int ataque, int energia, String elemento, String debilidad) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.energia = energia;
        this.elemento = elemento;
        this.debilidad = debilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
    
    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getDebilidad() {
        return debilidad;
    }

    public void setDebilidad(String debilidad) {
        this.debilidad = debilidad;
    }

    public boolean tieneVida(Mob objetivo) {
        return objetivo.getVida() > 0;
    }

    public boolean esFuerte(Mob atacante, Mob objetivo) {
        return atacante.getElemento().equals(objetivo.getDebilidad());
    }

    public boolean esDebil(Mob atacante, Mob objetivo) {
        return atacante.getDebilidad().equals(objetivo.getElemento());
    }

    public void Atacar(Mob atacante, Mob objetivo) {
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
        if (objetivo.vida > 0) {
            vidaNueva = vida - (int)temp;
            objetivo.setVida(vidaNueva);
            if (atacante.getEnergia() > 0) {
                atacante.setEnergia(atacante.getEnergia()-1);
            } else {
                atacante.setEnergia(1);
            }
        } else {
            System.out.println(objetivo.nombre + " ha sido eliminado");
        }
    }

}
