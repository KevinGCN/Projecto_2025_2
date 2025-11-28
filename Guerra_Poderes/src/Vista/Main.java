package Vista;
import java.util.Scanner;
import Controlador.JuegoGuerra;
import Modelo.CrearCartas;
import Modelo.Jugador;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Crear jugadores
        System.out.print("Ingrese nombre del jugador: ");
        String nombreJugador = sc.nextLine();

        Jugador jugador = new Jugador(nombreJugador);
        Jugador computadora = new Jugador("Computadora");

        //2.Iniciar Juego
        JuegoGuerra empezar = new JuegoGuerra(jugador, computadora);
        empezar.iniciar();
        
        //3. Crear cartas
        CrearCartas.crear(jugador, computadora);
        
        //4 Mostrar cartas
        System.out.println("\nTUS CARTAS:");
        for (int i = 0; i < jugador.getMazo().tamaño(); i++) {
            System.out.println(i + ". " + jugador.getMazo().obtener(i));
        }
         //5.Llamado de Menu
         Vista.Menu menu = new Vista.Menu();
         menu.iniciarCombate(jugador, computadora);
        
    }

}
