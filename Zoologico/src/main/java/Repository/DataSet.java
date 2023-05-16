/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.Animal;
import Model.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author douglas.alarcon
 * @param <T>
 */
public class DataSet<T extends Entity> {

    private final List<T> dataSet = new ArrayList();

    public void agregar(T entity) {
        dataSet.add(entity);
    }

    public T obtenerEntidad(String nombrePlan) {
        Optional<T> entity = dataSet.stream().filter(p -> p.getNombre().equals(nombrePlan)).findFirst();
        return entity.get();
    }

    public List<T> obtenerEntidades() {
        return dataSet;
    }

    public void eliminar(Animal nombre) {

    }

}
