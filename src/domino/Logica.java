
package domino;

/** Lleva toda la lógica de juego como fases, flujo o juego */
public class Logica {
  Pila pila;
  Jugador humano;
  Jugador computador;
  Interfaz interfaz;

  /** Constructor que inicia el juego */
  public Logica() {
    interfaz = new Interfaz();
    humano = new Jugador();

    //interfaz.graficarMano(humano);

  }
}
