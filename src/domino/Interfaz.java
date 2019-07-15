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
    public Interfaz() {

        setVentana();
        
        JPanel panel = new JPanel();
        Toolkit herramientas = Toolkit.getDefaultToolkit();
        
        Image imagen = herramientas.getImage("06.png");
        imagen = imagen.getScaledInstance(35, 85, Image.SCALE_SMOOTH);
        ImageIcon imagenboton = new ImageIcon(imagen);
        JButton boton = new JButton("");        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                herramientas.beep();
            }
        });
        boton.setBorder(BorderFactory.createEmptyBorder());

        boton.setIcon(imagenboton);

        boton.setBounds(35, 85, 35, 85);

        getContentPane().add(panel);
        setIconImage(imagen);
        panel.setLayout(null);
        panel.add(boton);
        setVisible(true);

    }

    public void setVentana() {
        setTitle("Yeahh primera ventana Swing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
