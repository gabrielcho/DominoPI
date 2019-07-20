package domino;

import java.awt.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.color.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Se encarga de dibujar todo tipo de aspecto gráfico usando las condiciones
 * dadas por la lógica del juego
 */

public class Interfaz extends JFrame {
    private int largoficha = 35;
    private int altoficha = 85;
    private JPanel areamano;
    /** Objeto Dimension para guardar las dimensiones de la ficha */
    private Dimension tamañoFicha = new Dimension(35, 85);

    public Interfaz() {

        setEntorno();

    }

    /** Configura el entorno inicial del juego. */
    public void setEntorno() {
        setTitle("Yeahh primera ventana Swing");
        setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        Toolkit herramientas = Toolkit.getDefaultToolkit();

        Image imagen = herramientas.getImage("06.png");
        imagen = imagen.getScaledInstance(largoficha, altoficha, Image.SCALE_SMOOTH);
        /* boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                herramientas.beep();
            }
        }); */
        ////
        areamano = new JPanel();
        areamano.setBackground(new Color(34, 82, 30));
        panel.setBackground(new Color(34, 82, 30));
        getContentPane().add(panel);
        setIconImage(imagen);
        panel.add(areamano, BorderLayout.SOUTH);
        setVisible(true);

    }

    /** Crea el componente swing que representa la ficha que se pasa como argumento del método, en este caso el componente es un botón sin bordes
     *  que tiene asignada una imagen.
     */
    public JButton crearComponenteFicha(Ficha ficha) {
        JButton botonficha = new JButton();
        botonficha.setIcon(imagenFicha(ficha));
        botonficha.setPreferredSize(tamañoFicha);
        botonficha.setBorder(BorderFactory.createEmptyBorder());
        return botonficha;
    }

    /** Genera una imagen de la ficha introducida como parámetro, esta imagen ya está escalada y convertida en un
     * ImageIcon para poder setearla como iconImage de las fichas(JButtons)
     */
    public ImageIcon imagenFicha(Ficha ficha) {
        Toolkit toolImagen = Toolkit.getDefaultToolkit();
        String pathficha = Integer.toString(ficha.getLadoA()) + Integer.toString(ficha.getLadoB()) + ".png"; //guarda un string que corresponde al nombre de archivo de la ficha ingresada
        Image sourceficha = toolImagen.getImage(pathficha); //Crea un objeto Image que obtiene la imagen correspondiente a la ficha
        sourceficha = sourceficha.getScaledInstance(largoficha, altoficha, Image.SCALE_SMOOTH); //Escala la imagen de ficha a un tamaño deseado.
        ImageIcon imagenficha = new ImageIcon(sourceficha); // Crea un ImageIcon con la imagen de sourceficha para poder asignarla a los botones*/
        return imagenficha;
    }

    /** Grafica las fichas de la mano de un jugador en la zona inferior de la pantalla */
    public void graficarMano(Jugador jugador) {
        for (int i = 0; i < jugador.mano.manoSize(); i++) {
            JButton fichaComponente = crearComponenteFicha(jugador.mano.verFicha(i));
            areamano.add(fichaComponente);
            setVisible(true);

        }
    }
}
