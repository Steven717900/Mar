package Visual;

import Controlador.Controlador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author julie
 */
public class VistaDetalle extends JFrame {

    private JTextArea area = new JTextArea();

    public VistaDetalle() {
        setTitle("TutorPlace");
        setSize(300, 300);
        setLayout(new FlowLayout());
        add(new JScrollPane(area), BorderLayout.CENTER);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void mostrar(String texto) {
        area.setText(texto);
        setVisible(true);
    }
}
