
package domino;

/** Lleva toda la lógica de juego como fases, flujo o juego */
public class Logica {
  private Pila pila;
  private Jugador humano;
  private Jugador computador;
  private Interfaz interfaz;
  private Tablero mesa;

  /** Constructor que inicia el juego */
  public Logica() {
    mesa = new Tablero();
    pila = new Pila();
    interfaz = new Interfaz();
    humano = new Jugador();
    computador = new Jugador();
    //

    repartirFichas();
    interfaz.graficarMano(humano);

  }

  public static void ponerFichaEnTablero() {

  }

  /** Método usado para repartir las fichas a los respectivos jugadores */
  public void repartirFichas() {
    for (int i = 0; i < 7; i++) {
      humano.tomarFicha(pila.sacarFicha());
      computador.tomarFicha(pila.sacarFicha());
    }
  }
}
