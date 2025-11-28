package Controlador;

import Modelo.Carta;

/**
 * Motor de Batalla basado en árbol de decisiones.
 * Complejidad total: O(1)
 */
public class MotorBatalla {

    /**
     * Ejecuta un ataque entre dos cartas siguiendo un árbol de decisiones.
     * Big O: O(1) porque solo ejecuta comparaciones y operaciones simples.
     */
    public void atacar(Carta atacante, Carta objetivo) {

        // PASO 1: ¿el atacante tiene energía? (O(1))
        if (atacante.getEnergia() <= 0) {
            // No puede atacar → se recupera un punto
            atacante.setEnergia(1);
            return; // Termina el proceso
        }

        // PASO 2: ¿el objetivo aún está vivo? (O(1))
        if (objetivo.getVida() <= 0) {
            return; // No tiene sentido atacar un objetivo derrotado
        }

        // PASO 3: calcular daño base (O(1))
        int ataqueBase = atacante.getAtaque();
        double dañoFinal = ataqueBase;

        // PASO 4: árbol de decisiones para el modificador elemental (O(1))
        if (atacante.getElemento().equals(objetivo.getDebilidad())) {
            dañoFinal = ataqueBase * 1.2;          // Atacante es fuerte
        } else if (atacante.getDebilidad().equals(objetivo.getElemento())) {
            dañoFinal = ataqueBase * 0.7;          // Atacante es débil
        }
        // Caso contrario → daño neutro y se mantiene igual

        // PASO 5: aplicar daño (O(1))
        int nuevaVida = objetivo.getVida() - (int) dañoFinal;
        objetivo.setVida(nuevaVida);

        // PASO 6: consumir energía (O(1))
        atacante.setEnergia(atacante.getEnergia() - 1);

        // PASO 7: ¿objetivo derrotado? (O(1))
        if (objetivo.getVida() <= 0) {
            System.out.println(objetivo.getNombre() + " ha sido derrotado.");
        }
    }
}
