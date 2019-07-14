package domino;

import java.util.Vector;

/**
 * Representa la mano que guardará las fichas de Domino, el jugador tiene un
 * objeto de esta clase
 */

// En este caso usaremos un vector para alojar las fichas, puesto que este puede
// tener tamaño variable y no sabemos cuántas
// cartas tendremos en cualquier momento de la partida
public class Mano {
    private Vector<Ficha> mano; // Declaramos un objeto de Vector útil para guardar las fichas.

    public Mano() {
        mano = new Vector<Ficha>();
    }
}
