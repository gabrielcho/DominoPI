
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
    arrayFichasComponentes.add(crearComponenteFichaRotada(mesa.tablero.lastElement(), 1));
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
        areamano.remove(botonficha);
        areamano.revalidate();
        areamano.repaint();
        humano.quitarFicha(ficha);
        hacerJugada(ficha, 1 + JOptionPane.showConfirmDialog(null, "X Q lado quierej jugá?", "yeah manin",
            JOptionPane.YES_NO_CANCEL_OPTION));
        for (int i = 0; i < mesa.tableroSize(); i++)
          System.out.println("El ladoA es: " + mesa.tablero.get(i).getLadoA() + " El ladoB es: "
              + mesa.tablero.get(i).getLadoB() + " de la ficha # " + i);
        dibujarTablero();
        /* for (int i = 0; i < humano.mano.manoSize(); i++) {
          if (i == 6)
            System.out.println("tienes cero fichitas YEAHHH MANIN YEAHH SISAS +BICI+VIDA");
          System.out.println("Yeah manin el lado A es: " + humano.mano.verFicha(i).getLadoA() + " el B es: "
              + humano.mano.verFicha(i).getLadoB() + " tienes: " + humano.mano.manoSize() + " fichas");
        }*/
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
  public void hacerJugada(Ficha ficha, int lado) {
    System.out.println("Pasa primera prueba"); // Es para probar el lado derecho
    if (mesa.comprobarJugada(ficha, lado)) {
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
        System.out.println("Lado de mesa: " + mesa.getLado(lado) + " Lado A de ficha: " + ficha.getLadoA()
            + " LadoB de Ficha" + ficha.getLadoB());
        if (mesa.getLado(lado) == ficha.getLadoA()) {
          System.out.println("Al menos detecta que está en el lado 22");
          arrayFichasComponentes.addElement(crearComponenteFichaRotada(ficha, 1));
          mesa.ponerFicha(ficha, lado);
        } else if (mesa.getLado(lado) == ficha.getLadoB()) {
          System.out.println("Al menos detecta que está en el lado 2222");
          arrayFichasComponentes.addElement(crearComponenteFichaRotada(ficha, 2));
          mesa.ponerFicha(ficha, lado);
        } else
          System.out.println("Tencontre bug de mierda");
      }
    }

    else
      JOptionPane.showMessageDialog(null, "Nea no puedes jugar con esa ficha");

  }

  /** Dibuja las fichas contenidas en un vector del objeto de clase Tablero, esto evitaría que tuviesemos que graficar desde los metods
   * de asignacion de jugada
   */
  public void dibujarTablero() {
    for (int i = 0; i < arrayFichasComponentes.size(); i++) {
      agregarFichaATablero(arrayFichasComponentes.elementAt(i));
      areaTablero.revalidate();
      areaTablero.repaint();
    }
  }

}
