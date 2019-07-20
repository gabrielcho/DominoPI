package domino;

import java.util.Vector;

public class Tablero {
    Vector<Ficha> tablero;

    public Tablero() {
        tablero = new Vector<Ficha>();
    }

    public boolean comprobarJugada(Ficha ficha) {
        boolean jugadavalida = if(ficha.getLadoA()); 
        return true;
    }

}