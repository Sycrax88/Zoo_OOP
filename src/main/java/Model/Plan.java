/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglas.alarcon
 */
public class Plan extends Entity {

    private double precio;
    private List<Animal> animales = new ArrayList();

    public Plan(String nombre, double precio, List<Animal> animales) {
        super(nombre);
        this.precio = precio;
        this.animales = animales;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public String getDescripcion() {
        String descripcion = "Visitar: ";
        for (Animal animal : animales) {
            descripcion += " " + animal.getNombre();
        }
        return descripcion;
    }

}
