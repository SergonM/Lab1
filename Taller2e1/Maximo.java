package Taller2e1;

public class Maximo {
    private int max = Integer.MIN_VALUE;

    public synchronized void actualizarMaximo(int valor) {
        if (valor > max) {
            max = valor;
        }
    }

    public synchronized int obtenerMaximo() {
        return max;
    }
}

