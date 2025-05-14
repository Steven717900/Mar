/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
/**
 *
 * @author julie
 */

interface Usuario {
    String verHorario();
        void mostrarInfo();

}
abstract  class Persona implements Usuario{
   protected String nombre;
    protected String password;

    public Persona(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  public boolean verificarPassword(String pass) {
        return this.password.equals(pass);
    }



}
