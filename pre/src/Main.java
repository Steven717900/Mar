
import Controlador.ControladorVenta;
import Vista.VistaVenta;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        VistaVenta vista = new VistaVenta();
        ControladorVenta controlador = new ControladorVenta(vista);
        controlador.procesarVenta();
    }
}
