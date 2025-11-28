package Controlador;

import Modelo.Carta;
//Big O(1)
public class MotorBatalla {
    //simula un ataque entre dos cartas
    public void atacar(Carta atacante, Carta objetivo) {
        //se obtiene el valor de ataque, esta sera la base para calcular el saño final
        int ataque = atacante.getAtaque();
        double daño;

        // Relación elemental, aplica modificador para ver si el daño son ventajosos o desventajosos
        if (atacante.getElemento().equals(objetivo.getDebilidad())) {
            daño = ataque * 1.2;
        } else if (atacante.getDebilidad().equals(objetivo.getElemento())) {
            daño = ataque * 0.7;
        } else {
            daño = ataque;
        }
        //vida del objetivo
        if (objetivo.getVida() > 0 && atacante.getEnergia() > 0) {
            // Aplicar daño
            objetivo.setVida(objetivo.getVida() - (int) daño);
        }
        //energia
        if (atacante.getEnergia() != 0){
            // Consumir energía
            atacante.setEnergia(atacante.getEnergia() - 1);
        } else {
            atacante.setEnergia(1);
        }

        if (objetivo.getVida() <= 0) {
            System.out.println(objetivo.getNombre() + " ha sido derrotado.");
        }
    }
}
