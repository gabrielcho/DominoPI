package domino;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Se encarga de dibujar todo tipo de aspecto gráfico usando las condiciones
 * dadas por la lógica del juego
 */
public class Interfaz extends JFrame {
    public Interfaz() {

        setTitle("Yeahh primera ventana Swing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        Toolkit herramientas = Toolkit.getDefaultToolkit();

        JButton boton = new JButton("BipBip");
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                herramientas.beep();
            }
        });

        boton.setBounds(50, 50, 50, 50);

        getContentPane().add(panel);
        panel.setLayout(null);
        panel.add(boton);
        setVisible(true);

    }
}
