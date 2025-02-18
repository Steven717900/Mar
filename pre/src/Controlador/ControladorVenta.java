/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Venta;
import Vista.VistaVenta;

/**
 *
 * @author Usuario 8
 */
public class ControladorVenta {
    private VistaVenta vista;
    private Venta venta;

    public ControladorVenta(VistaVenta vista) {
        this.vista = vista;
    }

    public void procesarVenta() {
        vista.mostrarMenu();
        double costoCompra = vista.leerCostoCompra();
        String tipoCliente = vista.leerTipoCliente();
        String formaPago = vista.leerFormaPago();
        
        venta = new Venta(costoCompra, tipoCliente, formaPago);
        
        vista.mostrarResultado(
            venta.getCostoCompra(),
            venta.getValorDescuentoCliente(),
            venta.getValorDescuentoPago(),
            venta.getValorFinal()
        );
    }
}
