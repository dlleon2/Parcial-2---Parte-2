package Programa;

import java.util.Random;
import java.util.concurrent.Callable;

public class partido implements Callable<jugador> {
    private final jugador jugador1;
    private final jugador jugador2;
    private final contador contador;
    private final Random random = new Random();

    public partido(jugador jugador1, jugador jugador2, contador contador) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.contador = contador;
    }

    @Override
    public jugador call() {
        int idPartido = contador.incrementar();
        jugador ganador = random.nextBoolean() ? jugador1 : jugador2;

        System.out.printf("Partido %d: %s vs %s --> Ganador: %s\n",
                idPartido, jugador1, jugador2, ganador);

        return ganador;
    }
}
