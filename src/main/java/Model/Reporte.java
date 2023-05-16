/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author douglas.alarcon
 */
public class Reporte {

    private final String plan;
    private final double valorUnidad;
    private final int cantidad;
    private final double porcentajeDescuento;
    private double totalVendido;
    private double totalNeto;
    private double totalDescuentos;

    public Reporte(String plan, double valorUnidad, double porcentajeDescuento) {
        this.plan = plan;
        this.valorUnidad = valorUnidad;
        this.cantidad = 1;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getPlan() {
        return plan;
    }

    public double getValorUnidad() {
        return valorUnidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public double getValorVenta() {
        return valorUnidad * cantidad;
    }

    public double getValorDescuento() {

        return porcentajeDescuento * getValorVenta();
    }

    public double getValorTotal() {

        return getValorVenta() - getValorDescuento();

    }

    public void TotalesReporte(double totalVendido, double totalNeto, double totalDescuentos) {
        this.totalVendido = totalVendido;
        this.totalNeto = totalNeto;
        this.totalDescuentos = totalDescuentos;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    public double getTotalNeto() {
        return totalNeto;
    }

    public double getTotalDescuentos() {
        return totalDescuentos;
    }

    public void setTotales(double totalVendido, double totalNeto, double totalDescuentos) {
        this.totalVendido = totalVendido;
        this.totalNeto = totalNeto;
        this.totalDescuentos = totalDescuentos;
    }

}
    

