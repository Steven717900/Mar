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

    public VistaDetalle() {
    }

    public VistaDetalle(Controlador controlador) {
        super("TutorPlace");
        setLayout(new GridLayout(5, 1));

        UIManager.put("Button.background", new Color(60, 90, 110));  
        UIManager.put("OptionPane.messageFont", new Font("Georgia", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Georgia", Font.PLAIN, 14));
        UIManager.put("Button.font", new Font("Georgia", Font.PLAIN, 14));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.background", new Color(42, 71, 89));

        JButton BotonInicioEst = new JButton("Iniciar como Estudiante");
        JButton BotonInicioTutor = new JButton("Iniciar como Tutor");
        JButton BotonRegEst = new JButton("Registrarse como Estudiante");
        JButton BotonRegTutor = new JButton("Registrarse como Tutor");
        JButton BotonVerHorarios = new JButton("Ver todos los horarios");
        Color colorOriginal = new Color(42, 71, 89);
        Color colorHover = new Color(60, 100, 130);
        CambieColor(BotonInicioEst, colorOriginal, colorHover);
        CambieColor(BotonInicioTutor, colorOriginal, colorHover);
        CambieColor(BotonRegEst, colorOriginal, colorHover);
        CambieColor(BotonRegTutor, colorOriginal, colorHover);
        CambieColor(BotonVerHorarios, colorOriginal, colorHover);

        BotonInicioEst.addActionListener(e -> controlador.InicioSesionUsuario("Estudiante"));
        BotonInicioTutor.addActionListener(e -> controlador.InicioSesionUsuario("Tutor"));
        BotonRegEst.addActionListener(e -> controlador.registrarEstudiante());
        BotonRegTutor.addActionListener(e -> controlador.registrarTutor());
        BotonVerHorarios.addActionListener(e -> controlador.mostrarHorarios());

        add(BotonInicioEst);
        add(BotonInicioTutor);
        add(BotonRegEst);
        add(BotonRegTutor);
        add(BotonVerHorarios);
    }

    public void CambieColor(JButton boton, Color colorOriginal, Color colorCambio) {
        boton.setBackground(colorOriginal);
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(colorCambio);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(colorOriginal);
            }
        });
    }

    public void mostrar(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }
}
