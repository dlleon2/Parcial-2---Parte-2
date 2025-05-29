package Programa;

public class contador {
    private int contador = 0;

    public synchronized int incrementar() {
        contador++;
        return contador;
    }

    public synchronized int get() {
        return contador;
    }
}
