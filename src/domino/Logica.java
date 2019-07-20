
package domino;

import java.util.Vector;

/** Lleva toda la lógica de juego como fases, flujo o juego */
public class Logica {
  private Pila pila;
  private Jugador humano;
  private Jugador computador;
  private Interfaz interfaz;
  private Vector<Ficha> mesa;

  /** Constructor que inicia el juego */
  public Logica() {
    pila = new Pila();
    interfaz = new Interfaz();
    humano = new Jugador();
    for (int i = 0; i < 7; i++)
      humano.tomarFicha(pila.sacarFicha());
    interfaz.graficarMano(humano);
  }
}
