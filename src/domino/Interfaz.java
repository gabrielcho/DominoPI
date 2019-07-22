package domino;

import java.awt.*;
import java.io.InputStream;
import java.io.File;
import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.awt.color.*;
import javax.swing.JOptionPane;
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
    public JPanel areamano;
    JPanel panel;
    JPanel areaTablero = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    JPanel areaArriba = new JPanel();
    JPanel areacomputador;
    Toolkit herramientas = Toolkit.getDefaultToolkit();

    /** Objeto Dimension para guardar las dimensiones de la ficha */
    public Dimension tamanoFicha = new Dimension(35, 85);

    public Interfaz() {

    }

    /** Configura el entorno inicial del juego. */
    public void setEntorno() {
        setTitle("Yeahh primera ventana Swing");
        setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());

        Image imagen = herramientas.getImage("src/imagesmelas/06.png");
        imagen = imagen.getScaledInstance(largoficha, altoficha, Image.SCALE_SMOOTH);

        areamano = new JPanel();
        areamano.setBackground(new Color(34, 82, 30));
        panel.setBackground(new Color(34, 82, 30));
        getContentPane().add(panel);
        setIconImage(imagen);
        panel.add(areamano, BorderLayout.SOUTH);
        setVisible(true);

        areaArriba.add(crearComponenteFichaRotada(new Ficha(1, 2), 2));

        panel.add(areaTablero, BorderLayout.CENTER);
        panel.add(areaArriba, BorderLayout.NORTH);
        setVisible(true);

    }

    /** Crea el componente swing que representa la ficha que se pasa como argumento del método, en este caso el componente es un botón sin bordes
     *  que tiene asignada una imagen.
     * Se debe poner la ficha y el objeto de tablero al que
     */
    public void agregarFichaATablero(JButton botonficha) {
        areaTablero.add(botonficha);
        areaTablero.revalidate();
        areaTablero.repaint();
    }

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
                //me hace falta que al hacerle click intente jugar la ficha en el tablero
            }
        });
        return botonficha;
    }

    /** Genera una imagen de la ficha introducida como parámetro, esta imagen ya está escalada y convertida en un
     * ImageIcon para poder setearla como iconImage de las fichas(JButtons)
     */
    /* D   E   P   R   E   C   A   T   E   D */

    /** Grafica las fichas de la mano de un jugador en la zona inferior de la pantalla */
    public void graficarMano(Jugador jugador) {
        for (int i = 0; i < jugador.mano.manoSize(); i++) {
            JButton fichaComponente = crearComponenteMano(jugador.mano.verFicha(i));
            areamano.add(fichaComponente);
            setVisible(true);

        }
    }

    /** Muestra una ventana de prompt, esta función es útil para cuando otras clases quieran tirar algún prompt .
     * Recibe un mensaje de tipo String
    */

    public static void mostrarPrompt(String mensaje) {

    }

    /** Simplemente rota la imagen de la ficha hacia la dirección que se le indique
     * 1 es IZQUIERDA
     * 2 es DERECHA
     */

    public RotatedIcon rotarIconoFicha(Ficha ficha, int direccion) { //limpia
        RotatedIcon imagenrotada = null;
        if (direccion == 1) {
            imagenrotada = new RotatedIcon(ficha.getImagenFicha(), -90);
        } else if (direccion == 2) {
            imagenrotada = new RotatedIcon(ficha.getImagenFicha(), 90);
        }
        return imagenrotada;
    }

    /** Crea un botón que tiene la ficha y una rotación específica 
     * nuevamente: 
     * 1 Representa IZQUIERDA
     * 2 Representa DERECHA
    */

    public JButton crearComponenteFichaRotada(Ficha ficha, int direccion) {
        JButton ficharotada = null;
        if (direccion == 1) {
            ficharotada = new JButton();
            ficharotada.setIcon(rotarIconoFicha(ficha, direccion));
            ficharotada.setPreferredSize(new Dimension(84, 34));
            ficharotada.setBorder(BorderFactory.createEmptyBorder());
        } else if (direccion == 2) {
            ficha.rotarLados();
            ficharotada = new JButton();
            ficha.direccion = 2;
            ficharotada.setIcon(rotarIconoFicha(ficha, direccion));
            ficharotada.setPreferredSize(new Dimension(84, 34));
            ficharotada.setBorder(BorderFactory.createEmptyBorder());
        }
        return ficharotada;
    }

    /** Crea directamente el componente de la ficha puesta en el tablero 
    public JButton crearComponenteFichaTablero(Ficha ficha) {
    /////////////////////   ///////////////////   //////////////////
    }*/

    /**Reproduce la música m e l a del juego */
    /*
    public void musicaMela(String path) {
        InputStream music;
        music = new FileInputStream(new File(path));
        AudioStream audio = new AudioStream();
        AudioStream.player.start(audio);
    }
    */
}
