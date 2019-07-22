package domino;

import javax.swing.ImageIcon;
import java.awt.*;

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

    private ImageIcon imagenficha;

    /** El constructor de Ficha sólo le asigna los dos valores recibidos por parámetro a la ficha */
    public Ficha(int a, int b) {
        ladoA = a;
        ladoB = b;
        imagenficha = imagenFicha();
    }

    /** Obtiene el lado A del objeto de <code>Ficha</code> */
    public int getLadoA() {
        return ladoA;
    }

    /** Obtiene el lado B del objeto de <code>Ficha</code> */
    public int getLadoB() {
        return ladoB;
    }

    /** Ahora la clase ficha tiene de una la imagen asignada */
    public ImageIcon imagenFicha() {
        Toolkit toolImagen = Toolkit.getDefaultToolkit();
        String pathficha = "src/imagesmelas/" + Integer.toString(ladoA) + Integer.toString(ladoB) + ".png"; //guarda un string que corresponde al nombre de archivo de la ficha ingresada
        Image sourceficha = toolImagen.getImage(pathficha); //Crea un objeto Image que obtiene la imagen correspondiente a la ficha
        sourceficha = sourceficha.getScaledInstance(35, 85, Image.SCALE_SMOOTH); //Escala la imagen de ficha a un tamaño deseado.
        ImageIcon imagenficha = new ImageIcon(sourceficha); // Crea un ImageIcon con la imagen de sourceficha para poder asignarla a los botones
        return imagenficha;
    }

    public void rotarFicha() {

    }

    public void rotarLados() {
        int aux;
        aux = ladoA;
        ladoA = ladoB;
        ladoB = aux;
    }

    public ImageIcon getImagenFicha() {
        return imagenficha;
    }

    public int puntajeFicha() {
        return ladoA + ladoB;
    }

}