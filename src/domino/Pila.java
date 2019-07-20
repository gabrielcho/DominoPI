package domino;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * Esta clase es la que contiene todas las fichas y se encarga de "repartirlas"
 * y aleatorizar su ordenamiento.
 */
public class Pila {
    private int fichasRobadas;

    /** Es la matriz que contiene los objetos de ficha usados en el juego */
    private Ficha[] pilaFichas = {

            new Ficha(0, 0), new Ficha(1, 1), new Ficha(2, 2), new Ficha(3, 3), new Ficha(4, 4), new Ficha(5, 5),
            new Ficha(0, 1), new Ficha(1, 2), new Ficha(2, 3), new Ficha(3, 4), new Ficha(4, 5), new Ficha(5, 6),
            new Ficha(0, 2), new Ficha(1, 3), new Ficha(2, 4), new Ficha(3, 5), new Ficha(4, 6), new Ficha(0, 3),
            new Ficha(1, 4), new Ficha(2, 5), new Ficha(3, 6), new Ficha(0, 4), new Ficha(1, 5), new Ficha(2, 6),
            new Ficha(0, 5), new Ficha(1, 6), new Ficha(0, 6), new Ficha(6, 6) };

    /** El constructor de un objeto Pila, este constructor nos aleatoriza las fichas contenidas en la pila para darle 
     * realismo al juego
     */
    public Pila() {
        fichasRobadas = 0;
        aleatorizar(pilaFichas);
        for (int i = 0; i < 28; i++) {
            System.out.println("Ficha num: " + i);
            System.out.println("Lado A: " + pilaFichas[i].getLadoA());
            System.out.println("Lado B: " + pilaFichas[i].getLadoB());
        }
        System.out.println("El tamaño de la matriz es: " + Integer.toString(Array.getLength(pilaFichas)));

    }

    /** Método usado para aleatorizar nuestro array de fichas 
     * @return Un array organizado.
    */
    public static Ficha[] aleatorizar(Ficha[] array) { //Tomado de ProgramCreek.com
        Random rgen = new Random(); // Random number generator			

        for (int i = 0; i < array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            Ficha temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    /** Función getter de fichas usada para pasar fichas a los jugadores o sólo sacar una ficha de la pila 
     * @return Objeto ficha tomado de la pila.
    */
    public Ficha sacarFicha() {
        Ficha fichasacada = pilaFichas[27 - fichasRobadas];
        System.out.println(pilaFichas[27 - fichasRobadas].getLadoA());
        fichasRobadas++;
        return fichasacada;
    }

}