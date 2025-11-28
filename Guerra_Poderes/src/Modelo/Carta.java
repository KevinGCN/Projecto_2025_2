package Modelo;
/**
 *Representa una carta tipo JuGiOh con atributos básicos.
 * @author Tilines
 */
public class Carta {
    private String nombre;
    private int vida;
    private int ataque;
    private int energia;
    private String elemento;
    private String debilidad;

    public Carta() {
    }

    public Carta(String nombre, int vida, int ataque, int energia, String elemento, String debilidad) {
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

    
    @Override
    public String toString() {
        return nombre + " [HP: " + vida + ", ATK:" + ataque + ", ENG:" + energia +
               ", Elem:" + elemento + ", Deb:" + debilidad + "]";
    }
}
