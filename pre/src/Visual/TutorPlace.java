/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Visual;

import Controlador.Controlador;
import javax.swing.SwingUtilities;

/**
 *
 * @author julie
 */
public class TutorPlace {

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        VistaInicio inicio = new VistaInicio(controlador);
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);

    }
}
