package domino;

public class Jugador {
    private int dinero;
    Mano mano;

    public Jugador() {
        dinero = 0;
        mano = new Mano();

    }

    /** Toma la ficha que por argumento se le pase para adicionarla a su mano */
    public void tomarFicha(Ficha ficha) {
        mano.agregarFicha(ficha); //Se tiene que agregar la ficha al vector privado de la clase Mano
    }

    /** Se resta la suma ingresada al monto de dinero del jugador */
    public void restarDinero(int suma) {
        dinero -= suma;
    }

    /** Se adiciona la suma ingresada al monto de dinero del jugador */
    public void darDinero(int suma) {
        dinero += suma;
    }

    public void quitarFicha(Ficha ficha) {
        mano.borrarFicha(ficha);
    }

}
