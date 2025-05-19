/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Visual;

import Controlador.Controlador;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author julie
 */
public class TutorPlace {

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        VistaDetalle vista = new VistaDetalle(controlador);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setSize(400, 400);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }
}
