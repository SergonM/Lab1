package Taller2e1;

public class T extends Thread {
    private int[] vector;
    private int inicio, fin;
    private Maximo maximoCompartido;

    public T(int[] vector, int inicio, int fin, Maximo maximoCompartido) {
        this.vector = vector;
        this.inicio = inicio;
        this.fin = fin;
        this.maximoCompartido = maximoCompartido;
    }

    @Override
    public void run() {
        int maxLocal = Integer.MIN_VALUE;
        for (int i = inicio; i < fin; i++) {
            if (vector[i] > maxLocal) {
                maxLocal = vector[i];
            }
        }
        maximoCompartido.actualizarMaximo(maxLocal);
    }
}

