package Programa;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<jugador> jugadores = new ArrayList<>();
        for (int i = 1; i <= 16; i++) {
            jugadores.add(new jugador("Jugador " + i));
        }

        Collections.shuffle(jugadores); // Mezcla aleatoria

        torneo torneo = new torneo();
        jugador campeon = torneo.ejecutartorneo(jugadores);

        System.out.println("🏆 CAMPEÓN DEL TORNEO: " + campeon);
    }
}
