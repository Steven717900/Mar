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

/**
 *
 * @author julie
 */
public class Controlador {

    private HashMap<String, Estudiante> estudiantes = new HashMap<>();
    private HashMap<String, Tutor> tutores = new HashMap<>();
    private VistaDetalle vista = new VistaDetalle();
    private HashMap<String, Double> cursosDisponibles = new HashMap<>();

    public Controlador() {
        cursosDisponibles.put("Matem�ticas", 103000.0);
        cursosDisponibles.put("Programaci�n", 400000.0);
        cursosDisponibles.put("Ingl�s", 90000.0);
        cursosDisponibles.put("F�sica", 101000.0);
    }
//El tipo es para saber si es tutor o estudiante y no hacer otro metodo, miren en vista inicio

    public void InicioSesionUsuario(String tipo) {
        JTextField campoNombre = new JTextField();
        //passwordfiel para que se vean los puntitos de las contrase�as :P
        JPasswordField campoContrase�a = new JPasswordField();
        Object[] mensaje = {"Nombre:", campoNombre, "Contrase�a:", campoContrase�a}; //para que el cuadro de di�logo muestre varios componentes juntos

        //Opcion para cancelar
        int op = JOptionPane.showConfirmDialog(null, mensaje, "Iniciar sesi�n - " + tipo, JOptionPane.OK_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) { //If para que cuando d� cancelar no siga intentando ingresar
            String nombre = campoNombre.getText();
            String contrase�a = new String(campoContrase�a.getPassword());
//Para cuando es estudiante ya registrado
            if (tipo == "Estudiante") {
                Estudiante est = estudiantes.get(nombre);
                if (est != null && est.verificarPassword(contrase�a)) {
                    String[] cursos = new String[cursosDisponibles.size()]; //Crea un arreglo de tipo string con la capacidad de la cantidad de cursos que haya en el hashmap
                    int i = 0; //Para que salgan los precios al curso
                    for (String clave : cursosDisponibles.keySet()) {
                        cursos[i] = clave + " $" + cursosDisponibles.get(clave);
                        i++;
                    }
                    JComboBox<String> combo = new JComboBox<>(cursos);
                    int elegir = JOptionPane.showConfirmDialog(null, combo, "�Deseas unirte a un curso?", JOptionPane.YES_NO_OPTION);
                    if (elegir == JOptionPane.YES_OPTION) {
                        Object seleccionado = combo.getSelectedItem();
                        String curso = seleccionado.toString(); //Para convertir el combo.selectitam en string
                        try {
                            double pago = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el pago por el curso: " + curso));
                            est.agregarClase(curso);//se agrega el item seleccionado a los cursos del estudiante
                        } catch (Exception ex) { 
                            JOptionPane.showMessageDialog(null, "Pago inv�lido."); //Cualquier error mostrar� ese mensaje
                        }
                    }//Fin if
                    vista.mostrar(est.verHorario());
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales inv�lidas.");
                }
            } //Fin estudiante 
            else { //Para cuando es tutor
                Tutor tutor = tutores.get(nombre);
                if (tutor != null && tutor.verificarPassword(contrase�a)) {
                    vista.mostrar(tutor.verHorario()); //Muestra los cursos del tutor
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales inv�lidas.");
                }
            }
        }
    }//Fin de la clase inicio de sesi�n de usuario 

    public void registrarEstudiante() {
        JTextField campoNombre = new JTextField();
        JPasswordField campocontrase�a = new JPasswordField();
        Object[] mensaje = {"Nombre:", campoNombre, "Contrase�a:", campocontrase�a}; //para que el cuadro de di�logo muestre varios componentes juntos

        int op = JOptionPane.showConfirmDialog(null, mensaje, "Registrar Estudiante", JOptionPane.OK_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) {
            String nombre = campoNombre.getText();
            String contrase�a = new String(campocontrase�a.getPassword()); //pq el get text no deja

            if (estudiantes.containsKey(nombre)) {
                JOptionPane.showMessageDialog(null, "Estudiante ya registrado.");
            } else {
                Estudiante nuevo = new Estudiante(nombre, contrase�a);
                estudiantes.put(nombre, nuevo);
                JOptionPane.showMessageDialog(null, "Estudiante registrado.");
            }
        }
    }

    public void registrarTutor() {
        JTextField campoNombre = new JTextField();
        JPasswordField campoContrase�a = new JPasswordField();
        JTextField campoCurso = new JTextField();
        JTextField campoPrecio = new JTextField();
        Object[] mensaje = {"Nombre:", campoNombre,"Contrase�a:", campoContrase�a,"Curso que ense�a:", campoCurso,"Precio del curso:", campoPrecio};

        int op = JOptionPane.showConfirmDialog(null, mensaje, "Registrar Tutor", JOptionPane.OK_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) {
            try {
                String nombre = campoNombre.getText();
                String contrase�a = new String(campoContrase�a.getPassword());
                String curso = campoCurso.getText();
                double precio = Double.parseDouble(campoPrecio.getText());

                if (tutores.containsKey(nombre)) {
                    JOptionPane.showMessageDialog(null, "Tutor ya registrado, intente con otro nombre de usuario.");
                } else {
                    Tutor nuevo = new Tutor(nombre, contrase�a, curso, precio);
                    tutores.put(nombre, nuevo);
                    cursosDisponibles.putIfAbsent(curso, precio);//a�ade  a un mapa si la clave no existe 
                    JOptionPane.showMessageDialog(null, "Tutor registrado.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Precio inv�lido.");
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
