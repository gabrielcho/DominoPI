package domino;

import javax.swing.JOptionPane;
import java.util.Vector;

public class Tablero {
    /** Vector usado para alojar las fichas organizadamente en el supuesto tablero de juego */
    Vector<Ficha> tablero;
    int IZQUIERDA = 1;
    int DERECHA = 2;

    public Tablero() {
        tablero = new Vector<Ficha>();
        tablero.addElement(new Ficha(1, 3));
    }

    /** Obtiene el lado mostrado de la ficha jugada al lado izquierdo del tablero*/
    public int getLado(int lado) {
        if (lado == 1)
            return tablero.firstElement().getLadoA();
        else if (lado == 2)
            return tablero.firstElement().getLadoB();
        else
            return 9999;
    }

    public int tableroSize() {
        return tablero.size();
    }

    /**  obtiene el lado mostrado de la ficha del lado derecho del tablero.
     *  En este caso siempre sería el ladoB 
    */
    public int ladoDer() {
        return tablero.lastElement().getLadoB();
    }

    /** Comprueba la jugada de una ficha sobre determinado lado del tablero */
    public boolean comprobarJugada(Ficha ficha, int lado) {
        boolean jugadavalida = false;

        if (lado == IZQUIERDA) {
            if (ficha.getLadoA() == tablero.firstElement().getLadoA()
                    || ficha.getLadoB() == tablero.firstElement().getLadoA()) {
                jugadavalida = true;
            } else
                jugadavalida = false;
        } else if (lado == DERECHA) {
            if (ficha.getLadoA() == tablero.lastElement().getLadoB()
                    || ficha.getLadoB() == tablero.lastElement().getLadoB()) {
                jugadavalida = true;
            } else
                jugadavalida = false;
        }

        else
            JOptionPane.showMessageDialog(null, "No es un lado válido");

        return jugadavalida;
    }

    /** Método usado para colocar la ficha en nuestro Vector de fichas, como el Vector simboliza el tablero de juego, debe tener ciertas reglas, 
     * por lo tanto no todas las fichas pueden jugarse en el tablero, así que primero realizamos una comprobación con el método comprobarJugada()
     * y luego si cumple con las condiciones, procedemos a colocarla en el lado del tablero seleccionado.
     */
    public void ponerFicha(Ficha ficha, int lado) {
        if (comprobarJugada(ficha, lado)) {
            if (lado == IZQUIERDA)
                tablero.add(0, ficha);
            else if (lado == DERECHA)
                tablero.addElement(ficha);
            if (lado == 0)
                tablero.addElement(ficha);
            else
                JOptionPane.showMessageDialog(null, "No es una jugada válida!");

        }

    }

}