/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Model;

/**
 *
 * @author douglas.alarcon
 */
public enum Descuento {
    SIN_DESCUENTO("Sin Descuento", 0.0),
    DESCUENTO_NORMAL("Descuento normal", 0.05),
    DESCUENTO_ALTO("Descuento alto", 0.1);

    private final String nombre;
    private final double valor;

    private Descuento(String nombre, double valor) {

        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

}
