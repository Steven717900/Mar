/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import Modelo.Estudiante;
import Modelo.Tutor;
import Visual.VistaDetalle;

public class Controlador {

    private HashMap<String, Estudiante> estudiantes = new HashMap<>();
    private HashMap<String, Tutor> tutores = new HashMap<>();
    private VistaDetalle vista = new VistaDetalle();
    private HashMap<String, Double> cursosDisponibles = new HashMap<>();

    public Controlador() {
        cursosDisponibles.put("Matematicas", 103000.0);
        cursosDisponibles.put("Programacion", 400000.0);
        cursosDisponibles.put("Ingles", 90000.0);
        cursosDisponibles.put("Fisica", 101000.0);
    }

    public void InicioSesionUsuario(String tipo) {
        JTextField campoNombre = new JTextField();
        JPasswordField campoContraseña = new JPasswordField();
        Object[] mensaje = {"Nombre:", campoNombre, "Contraseña:", campoContraseña};

        int op = JOptionPane.showConfirmDialog(null, mensaje, "Iniciar sesión - " + tipo, JOptionPane.OK_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) {
            String nombre = campoNombre.getText();
            String contraseña = new String(campoContraseña.getPassword());

            if (tipo.equals("Estudiante")) {
                Estudiante est = estudiantes.get(nombre);
                if (est != null && est.verificarPassword(contraseña)) {
                    String[] cursos = new String[cursosDisponibles.size()];
                    int i = 0;
                    for (Map.Entry<String, Double> entry : cursosDisponibles.entrySet()) {
                        cursos[i++] = entry.getKey() + " - $" + entry.getValue();
                    }
                    JComboBox<String> combo = new JComboBox<>(cursos);
                    int elegir = JOptionPane.showConfirmDialog(null, combo, "¿Deseas unirte a un curso?", JOptionPane.YES_NO_OPTION);
                    if (elegir == JOptionPane.YES_OPTION) {
                        String curso = (String) combo.getSelectedItem();
                        try {
                            double pago = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el pago por el curso: " + curso));
                            est.agregarClase(curso);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Pago inválido.");
                        }
                    }
                    vista.mostrar(est.verHorario());
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales inválidas.");
                }
            } else { // Tutor
                Tutor tutor = tutores.get(nombre);
                if (tutor != null && tutor.verificarPassword(contraseña)) {
                    vista.mostrar(tutor.verHorario());
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales inválidas.");
                }
            }
        }
    }

    public void registrarEstudiante() {
        JTextField campoNombre = new JTextField();
        JPasswordField campoPass = new JPasswordField();
        Object[] mensaje = {"Nombre:", campoNombre, "Contraseña:", campoPass};

        int op = JOptionPane.showConfirmDialog(null, mensaje, "Registrar Estudiante", JOptionPane.OK_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) {
            String nombre = campoNombre.getText();
            String pass = new String(campoPass.getPassword());

            if (estudiantes.containsKey(nombre)) {
                JOptionPane.showMessageDialog(null, "Estudiante ya registrado.");
            } else {
                Estudiante nuevo = new Estudiante(nombre, pass);
                estudiantes.put(nombre, nuevo);
                JOptionPane.showMessageDialog(null, "Estudiante registrado.");
            }
        }
    }

    public void registrarTutor() {
        JTextField campoNombre = new JTextField();
        JPasswordField campoContraseña = new JPasswordField();
        JTextField campoCurso = new JTextField();
        JTextField campoPrecio = new JTextField();
        Object[] mensaje = {
            "Nombre:", campoNombre,
            "Contraseña:", campoContraseña,
            "Curso que enseña:", campoCurso,
            "Precio del curso:", campoPrecio
        };

        int op = JOptionPane.showConfirmDialog(null, mensaje, "Registrar Tutor", JOptionPane.OK_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) {
            try {
                String nombre = campoNombre.getText();
                String contraseña = new String(campoContraseña.getPassword());
                String curso = campoCurso.getText();
                double precio = Double.parseDouble(campoPrecio.getText());

                if (tutores.containsKey(nombre)) {
                    JOptionPane.showMessageDialog(null, "Tutor ya registrado.");
                } else {
                    Tutor nuevo = new Tutor(nombre, contraseña, curso, precio);
                    tutores.put(nombre, nuevo);
                    cursosDisponibles.putIfAbsent(curso, precio);
                    JOptionPane.showMessageDialog(null, "Tutor registrado.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Precio inválido.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error inesperado.");
            }
        }
    }

    public void mostrarHorarios() {
        StringBuilder texto = new StringBuilder("HORARIOS DISPONIBLES:\n\n");

        for (Estudiante e : estudiantes.values()) {
            texto.append(e.verHorario()).append("\n");
        }

        for (Tutor t : tutores.values()) {
            texto.append(t.verHorario()).append("\n");
        }

        vista.mostrar(texto.toString());
    }
}
