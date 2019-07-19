package domino;

import javax.swing.ImageIcon;

/**
 * Se encarga de generar las 28 fichas de juego además de arrojar sus valores,
 * útiles para la graficación posterior la generación
 */

/*
 * Tratando de implementar lo gráfico al tiempo de la lógica, es viable
 * asignarle las imágenes de las ficha directamente a esta mondá un tipo de
 * getter de imagen para graficarlo de una en la clase de interfaz
 */
public class Ficha {

    private int ladoA;
    private int ladoB;

    public Ficha(int a, int b) {
        ladoA = a;
        ladoB = b;
    }

    public int getLadoA() {
        return ladoA;
    }

    public int getLadoB() {
        return ladoB;
    }

}