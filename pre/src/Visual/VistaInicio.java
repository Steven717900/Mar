/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class VistaInicio extends JFrame {

    public VistaInicio(Controlador controlador) {
        setTitle("TutorPlace");
        setSize(400, 350);
        setLayout(new GridLayout(5, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton BotonInicioEst = new JButton("Iniciar como Estudiante");
        JButton BotonInicioTutor = new JButton("Iniciar como Tutor");
        JButton BotonRegEst = new JButton("Registrarse como Estudiante");
        JButton BotonRegTutor = new JButton("Registrarse como Tutor");
        JButton BotonVerHorarios = new JButton("Ver todos los horarios");

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

}
