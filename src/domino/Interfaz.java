package domino;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public Interfaz() {

        setVentana();

        JPanel panel = new JPanel();
        Toolkit herramientas = Toolkit.getDefaultToolkit();

        Image imagen = herramientas.getImage("06.png");
        imagen = imagen.getScaledInstance(largoficha, altoficha, Image.SCALE_SMOOTH);
        ImageIcon imagenboton = new ImageIcon(imagen);
        JButton boton = new JButton("");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                herramientas.beep();
            }
        });

        boton.setBorder(BorderFactory.createEmptyBorder());

        boton.setIcon(graficarFicha(new Ficha(0, 0)));

        boton.setBounds(35, 85, 35, 85);

        getContentPane().add(panel);
        setIconImage(imagen);
        panel.setLayout(null); // yeah dale potosi
        panel.add(boton);
        setVisible(true);

    }

    public void setVentana() {
        setTitle("Yeahh primera ventana Swing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public ImageIcon graficarFicha(Ficha ficha) {
        Toolkit toolImagen = Toolkit.getDefaultToolkit();
        String pathficha = Integer.toString(ficha.getLadoA()) + Integer.toString(ficha.getLadoB()) + ".png"; //guarda un string que corresponde al nombre de archivo de la ficha ingresada
        Image sourceficha = toolImagen.getImage(pathficha); //Crea un objeto Image que obtiene la imagen correspondiente a la ficha
        sourceficha = sourceficha.getScaledInstance(largoficha, altoficha, Image.SCALE_SMOOTH); //Escala la imagen de ficha a un tamaño deseado.
        ImageIcon imagenficha = new ImageIcon(sourceficha); // Crea un ImageIcon con la imagen de sourceficha para poder asignarla a los botones*/
        return imagenficha;
    }

}
