/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import Modelo.Estudiante;
import Modelo.Tutor;
import Visual.VistaDetalle;
import Visual.VistaInicio;

/**
 *
 * @author julie
 */
public class Controlador {
//hashmap me dueles, es tan util pero me frustra tanto idk

    private HashMap<String, Estudiante> estudiantes = new HashMap<>();
    private HashMap<String, Tutor> tutores = new HashMap<>();
    private VistaDetalle vista = new VistaDetalle();
    private HashMap<String, Double> cursosDisponibles = new HashMap<>();

    public Controlador() {
        cursosDisponibles.put("Matemáticas", 103000.0);
        cursosDisponibles.put("Programación", 400000.0);
        cursosDisponibles.put("Inglés", 90000.0);
        cursosDisponibles.put("Física", 101000.0);
    }
//El tipo es para saber si es tutor o estudiante y no hacer otro metodo, miren en vista inicio

    public void InicioSesionUsuario(String tipo) {
        JTextField campoNombre = new JTextField();
        //passwordfiel para que se vean los puntitos de las contraseñas :P
        JPasswordField campoContraseña = new JPasswordField();
        Object[] mensaje = {"Nombre:", campoNombre, "Contraseña:", campoContraseña};

        //Opci+on para cancelar
        int op = JOptionPane.showConfirmDialog(null, mensaje, "Iniciar sesión - " + tipo, JOptionPane.OK_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) {
            String nombre = campoNombre.getText();
            String contraseña = new String(campoContraseña.getPassword());
//Para cuando es estudiante
            if (tipo == "Estudiante") {
                Estudiante est = estudiantes.get(nombre);
                if (est != null && est.verificarPassword(contraseña)) {
                    //Para que salgan los precios al curso
                    String[] cursos = new String[cursosDisponibles.size()];
                    int i = 0;
                    //Entry es una clase interna de Java que representa una pareja clave-valor dentro de un Map
                    for (Map.Entry<String, Double> entry : cursosDisponibles.entrySet()) {
                        cursos[i] = entry.getKey() + " - $" + entry.getValue();
                        i++;
                    }
                    JComboBox<String> combo = new JComboBox<>(Arrays.copyOf(cursos, cursos.length, String[].class));  //Esta vaina no la entendí bn, me todó pedirle ayuda a gpt
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
            } //Para cuando es tutor
            else {
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
                    cursosDisponibles.putIfAbsent(curso, precio);//El método putIfAbsent() de Java añade un par clave-valor a un mapa si la clave no existe . Si la clave existe, devuelve su valor asociado, sin mostrar ninguna nueva adición. Si la clave no existe, añade el par al mapa y devuelve null.
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
        String texto = "HORARIOS DISPONIBLES:\n\n";

        for (Estudiante e : estudiantes.values()) {
            texto += e.verHorario() + "\n";
        }

        for (Tutor t : tutores.values()) {
            texto += t.verHorario() + "\n";
        }

        vista.mostrar(texto);
    }
}

