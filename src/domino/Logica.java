
package domino;

import javax.swing.*;

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

  /** Constructor que inicia el juego */
  public Logica() {
    mesa = new Tablero();
    pila = new Pila();
    humano = new Jugador();
    computador = new Jugador();
    //
    setEntorno();
    repartirFichas();
    graficarMano(humano);

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
        for (int i = 0; i < humano.mano.manoSize(); i++) {
          if (i == 6)
            System.out.println("tienes cero fichitas YEAHHH MANIN YEAHH SISAS +BICI+VIDA");
          System.out.println("Yeah manin el lado A es: " + humano.mano.verFicha(i).getLadoA() + " el B es: "
              + humano.mano.verFicha(i).getLadoB() + " tienes: " + humano.mano.manoSize() + " fichas");
        }
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
}
