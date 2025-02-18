/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import java.util.Scanner;

public class VistaVenta {
    public void mostrarMenu() {
        System.out.println("Bienvenido a Telarés");
        System.out.println("Por favor ingrese la información de la venta:");
        System.out.println("Costo de compra: ");
    }

    public double leerCostoCompra() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    public String leerTipoCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese tipo de cliente (Mayorista o Minorista): ");
        return sc.nextLine();
    }

    public String leerFormaPago() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese forma de pago (Contado o Crédito): ");
        return sc.nextLine();
    }

    public void mostrarResultado(double costoCompra, double descuentoCliente, double descuentoPago, double valorFinal) {
        System.out.println("Costo de compra: " + costoCompra);
        System.out.println("Descuento por tipo de cliente: " + descuentoCliente);
        System.out.println("Descuento por forma de pago: " + descuentoPago);
        System.out.println("Valor final a pagar: " + valorFinal);
    }
}

