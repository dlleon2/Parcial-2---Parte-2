package Programa;
import java.util.*;
import java.util.concurrent.*;

public class torneo {
    private final ExecutorService executor;
    private final contador contador;

    public torneo() {
        this.executor = Executors.newFixedThreadPool(4);
        this.contador = new contador();
    }

    private String nombreRonda(int numJugadores) {
        switch (numJugadores) {
            case 16: return "===== OCTAVOS DE FINAL =====";
            case 8:  return "===== CUARTOS DE FINAL =====";
            case 4:  return "===== SEMIFINAL =====";
            case 2:  return "===== FINAL =====";
            default: return "===== RONDA =====";
        }
    }

    public jugador ejecutartorneo(List<jugador> jugadores) throws InterruptedException, ExecutionException {
        List<jugador> clasificados = jugadores;

        while (clasificados.size() > 1) {
            System.out.println(nombreRonda(clasificados.size()));

            List<Future<jugador>> resultados = new ArrayList<>();
            for (int i = 0; i < clasificados.size(); i += 2) {
                jugador j1 = clasificados.get(i);
                jugador j2 = clasificados.get(i + 1);
                resultados.add(executor.submit(new partido(j1, j2, contador)));
            }

            clasificados = new ArrayList<>();
            for (Future<jugador> f : resultados) {
                clasificados.add(f.get());
            }

            System.out.println(); // línea en blanco para separar rondas
        }

        executor.shutdown();
        return clasificados.get(0);
    }
}
