/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author douglas.alarcon
 */
public class Venta extends Entity {

    private final String plan;
    private final double valor;
    private final double porcentajeDescuento;

    public Venta(String plan, double valor, double porcentajeDescuento) {
        super(plan);
        this.plan = plan;
        this.valor = valor;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getPlan() {
        return plan;
    }

    public double getValor() {
        return valor;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public double getValorDescuento() {
        return valor * porcentajeDescuento;
    }

    public double getValorTotal() {
        return valor - getValorDescuento();
    }

}
