
package domino;

/** Lleva toda la lógica de juego como fases, flujo o juego */
public class Logica {
  Pila pila;
  Jugador humano;
  Jugador computador;
  Interfaz interfaz;

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
