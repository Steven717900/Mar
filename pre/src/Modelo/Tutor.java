/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author julie
 */
// MODELO
public class Tutor extends Persona {

    private Stack<String> clasesPendientes = new Stack<>();
    private String curso;
    private double precio;

    public Tutor(String nombre, String password, String curso, double precio) {
        super(nombre, password);
        this.curso = curso;
        this.precio = precio;
        clasesPendientes.push(curso);
    }

    public void mostrarInfo() {
        System.out.println("Tutor: " + nombre + " | Curso: " + curso + " | Precio: $" + precio);
    }

    public String getCurso() {
        return curso;
    }

    public double getPrecio() {
        return precio;
    }

    public String verHorario() {
        return "Tutor " + nombre + ": " + curso + " - $" + precio;
    }

}
