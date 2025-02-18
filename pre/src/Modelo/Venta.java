/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Venta {

    private double costoCompra;
    private String tipoCliente;
    private String formaPago;
    private double descuentoCliente;
    private double descuentoPago;
    private double valorDescuentoCliente;
    private double valorDescuentoPago;
    private double valorFinal;

    public Venta(double costoCompra, String tipoCliente, String formaPago) {
        this.costoCompra = costoCompra;
        this.tipoCliente = tipoCliente;
        this.formaPago = formaPago;
        this.calcularDescuentos();
    }

    public void calcularDescuentos() {
        if (tipoCliente.equals("Mayorista")) {
            descuentoCliente = 0.07;
        } else if (tipoCliente.equals("Minorista")) {
            descuentoCliente = 0.04;
        }
        if (formaPago.equals("Contado")) {
            descuentoPago = 0.10;
        } else {
            descuentoPago = 0.0;
        }
        valorDescuentoCliente = costoCompra * descuentoCliente;
        valorDescuentoPago = costoCompra * descuentoPago;
        valorFinal = costoCompra - valorDescuentoCliente - valorDescuentoPago;
    }

    public double getCostoCompra() {
        return costoCompra;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public double getDescuentoCliente() {
        return descuentoCliente;
    }

    public double getDescuentoPago() {
        return descuentoPago;
    }

    public double getValorDescuentoCliente() {
        return valorDescuentoCliente;
    }

    public double getValorDescuentoPago() {
        return valorDescuentoPago;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setCostoCompra(double costoCompra) {
        this.costoCompra = costoCompra;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public void setDescuentoCliente(double descuentoCliente) {
        this.descuentoCliente = descuentoCliente;
    }

    public void setDescuentoPago(double descuentoPago) {
        this.descuentoPago = descuentoPago;
    }

    public void setValorDescuentoCliente(double valorDescuentoCliente) {
        this.valorDescuentoCliente = valorDescuentoCliente;
    }

    public void setValorDescuentoPago(double valorDescuentoPago) {
        this.valorDescuentoPago = valorDescuentoPago;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

}
