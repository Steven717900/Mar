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


// MODELO
public class Tutor extends Persona{
    private LinkedList<String> clases = new LinkedList<>(); // Lista simplemente enlazada
    private Queue<String> solicitudes = new LinkedList<>(); // Cola de solicitudes

    public Tutor(String nombre) {
        super(nombre);
    }

    public LinkedList<String> getClases() {
        return clases;
    }

    public void setClases(LinkedList<String> clases) {
        this.clases = clases;
    }

    public Queue<String> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(Queue<String> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    @Override
    public String toString() {
        return "Tutor{" + "clases=" + clases + ", solicitudes=" + solicitudes + '}';
    }

    


}

