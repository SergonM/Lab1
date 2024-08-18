package Taller2e1;
public class Main {
    public static void main(String[] args) {
        int[] vector = {3, 6, 9, 2, 5, 4, 8, 7, 10, 1};
        int numHilos = 4;  // Número de hilos
        if(args.length > 0){
            numHilos = Integer.parseInt(args[0]);
        }
        System.out.println("Usando " + numHilos + " hilos");
        Maximo maximoCompartido = new Maximo();

        T[] hilos = new T[numHilos];
        int tamañoPorcion = vector.length / numHilos;

        for (int i = 0; i < numHilos; i++) {
            int inicio = i * tamañoPorcion;
            int fin = (i == numHilos - 1) ? vector.length : inicio + tamañoPorcion;
            hilos[i] = new T(vector, inicio, fin, maximoCompartido);
            hilos[i].start();
        }

        for (int i = 0; i < numHilos; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("El valor máximo es: " + maximoCompartido.obtenerMaximo());
    }
}
