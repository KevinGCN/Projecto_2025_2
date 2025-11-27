package Clases;

public class MotorBatalla {

    public static void atacar(Carta atacante, Carta objetivo) {

        int ataque = atacante.getAtaque();
        double daño;

        // Relación elemental
        if (atacante.getElemento().equals(objetivo.getDebilidad())) {
            daño = ataque * 1.2;
        } else if (atacante.getDebilidad().equals(objetivo.getElemento())) {
            daño = ataque * 0.7;
        } else {
            daño = ataque;
        }

        // Aplicar daño
        objetivo.setVida(objetivo.getVida() - (int) daño);

        // Consumir energía
        atacante.setEnergia(atacante.getEnergia() - 1);

        if (objetivo.getVida() <= 0) {
            System.out.println(objetivo.getNombre() + " ha sido derrotado.");
        }
    }
}
