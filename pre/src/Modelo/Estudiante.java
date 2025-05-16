/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author julie
 */
public class Estudiante extends Persona {

    private LinkedList<String> clases = new LinkedList<>();
    private Queue<String> colaSesiones = new LinkedList<>();

    public Estudiante(String nombre, String password) {
        super(nombre, password);
    }

    public void agregarClase(String clase) {
        clases.add(clase);
        colaSesiones.offer("Sesión pendiente: " + clase);
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre);
        for (String c : clases) {
            System.out.println("Clase: " + c);
        }
    }

    public LinkedList<String> getClases() {
        return clases;
    }

    @Override
    public String verHorario() {
        String texto = "Horario de estudiante " + nombre + ":\n";
        for (String c : clases) {
            texto += "- " + c + "\n";
        }
        return texto;
    }
}
