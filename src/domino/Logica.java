
package domino;

import javax.swing.*;
import java.util.Vector;
import java.awt.Color;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Lleva toda la lógica de juego como fases, flujo o juego */
public class Logica extends Interfaz {
  private Pila pila;
  private Jugador humano;
  private Jugador computador;
  private Interfaz interfaz;
  private Tablero mesa;
  private Vector<JButton> arrayFichasComponentes; //Notar que este ArrayList guarda componentes de ficha, no fichas.,,

  /** Constructor que inicia el juego */
  public Logica() {
    arrayFichasComponentes = new Vector<JButton>();

    mesa = new Tablero();
    pila = new Pila();
    humano = new Jugador();
    computador = new Jugador();
    //
    setEntorno();
    repartirFichas();
    graficarMano(humano);
    dibujarTablero();

  }

  /* La gran idea es tener algo así:
  public void creacomponente(Ficha ficha, func) {
    interfaz.crearComponenteMano(ficha, func)
    
  }*/

  public JButton crearComponenteMano(Ficha ficha) {
    JButton botonficha = new JButton();
    botonficha.setIcon(ficha.imagenFicha());
    botonficha.setPreferredSize(tamanoFicha);
    botonficha.setBorder(BorderFactory.createEmptyBorder());
    botonficha.setBackground(Color.BLACK);
    botonficha.setForeground(Color.BLACK);

    botonficha.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        if (mesa.tableroSize() == 0) {
          areamano.remove(botonficha);
          primeraJugada(ficha);
          humano.quitarFicha(ficha);

        } else {

          if (hacerJugada(ficha, 1 + JOptionPane.showConfirmDialog(null, "X Q lado quierej jugá?", "yeah manin",
              JOptionPane.YES_NO_CANCEL_OPTION))) {
            areamano.remove(botonficha);
            areamano.revalidate();
            areamano.repaint();
          }
        }
        dibujarTablero();

        //me hace falta que al hacerle click intente jugar la ficha en el tablero
      }
    });
    return botonficha;
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

  /**Comprueba la jugada de la ficha en determinado lado del tablero
   * 1 es IZQUIERDA
   * 2 es DERECHA
   */
  public boolean hacerJugada(Ficha ficha, int lado) {
    boolean sepuedejugar;
    if (mesa.comprobarJugada(ficha, lado)) {
      sepuedejugar = true;
      humano.quitarFicha(ficha);
      System.out.println("Se puede hacer la jugada bajo logica"); // Es para probar el lado derecho
      System.out.println("Comprobando el lado del tablero:  " + mesa.getLado(lado));
      if (lado == 1) { // Si el lado del tablero es a la izquierda
        if (mesa.getLado(lado) == ficha.getLadoA()) { // Si el lado del la ficha de ese pedazo del tablero es igual a la del lado A
          arrayFichasComponentes.add(0, crearComponenteFichaRotada(ficha, 2));
          mesa.ponerFicha(ficha, lado);

        } else if (mesa.getLado(lado) == ficha.getLadoB()) {
          arrayFichasComponentes.add(0, crearComponenteFichaRotada(ficha, 1));
          mesa.ponerFicha(ficha, lado);
        }

      } else if (lado == 2) {
        System.out.println("Al menos detecta que está en el lado 2");
        System.out.println("Lado de mesa: " + mesa.getLado(lado) + " Lado A de ficha: "
            + mesa.tablero.lastElement().getLadoA() + " LadoB de Ficha" + mesa.tablero.lastElement().getLadoB());
        System.out.println("Tenemos una ficha cuyo lado A es: " + ficha.getLadoA() + " lado B es: " + ficha.getLadoB());
        if (mesa.getLado(lado) == ficha.getLadoA()) {
          System.out.println("Al menos detecta que está en el lado 22");
          arrayFichasComponentes.addElement(crearComponenteFichaRotada(ficha, 1));
          mesa.ponerFicha(ficha, lado);
        } else if (mesa.getLado(lado) == ficha.getLadoB()) {
          System.out.println("Al menos detecta que está en el lado 2222");
          arrayFichasComponentes.addElement(crearComponenteFichaRotada(ficha, 2));
          mesa.ponerFicha(ficha, lado);
        } else
          JOptionPane.showMessageDialog(null, "Aparentemente ninguno de los lados de la ficha se puede poner");
        for (int i = 0; i < mesa.tablero.size(); i++)
          System.out.print("[" + mesa.tablero.get(i).getLadoA() + "|" + mesa.tablero.get(i).getLadoB() + "]");
      }
    }

    else {
      JOptionPane.showMessageDialog(null, "Nea no puedes jugar con esa ficha");
      sepuedejugar = false;
    }
    return sepuedejugar;
  }

  /** Dibuja las fichas contenidas en un vector del objeto de clase Tablero, esto evitaría que tuviesemos que graficar desde los metods
   * de asignacion de jugada
   */
  public void dibujarTablero() {
    areaTablero.removeAll();
    for (int i = 0; i < arrayFichasComponentes.size(); i++) {
      agregarFichaATablero(arrayFichasComponentes.elementAt(i));
      areaTablero.revalidate();
      areaTablero.repaint();
    }
  }

  public void primeraJugada(Ficha ficha) {
    mesa.tablero.addElement(ficha);
    arrayFichasComponentes.addElement(crearComponenteFichaRotada(ficha, 1));
  }

}
