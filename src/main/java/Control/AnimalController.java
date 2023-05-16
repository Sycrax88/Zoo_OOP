/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Animal;
import Repository.DataBase;
import View.VistaAnimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author douglas.alarcon
 */
public class AnimalController {

    public static VistaAnimal ventana = new VistaAnimal();

    public static void mostrar() {
        cargarDatosTabla();
        ventana.setVisible(true);
    }

    public static void ocultar() {
        ventana.setVisible(false);
    }

    public static void botonAgregar() {
        String nombre = ventana.getTxtNombre().getText();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(ventana, "El campo de nombre está vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!nombre.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(ventana, "El nombre solo puede contener letras", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Animal animal = new Animal(nombre);
        DataBase.animales.agregar(animal);
        ventana.getTxtNombre().setText("");

        cargarDatosTabla();
    }

    public static void botonSalir() {
        PrincipalController.mostrar();
        ocultar();
    }

    public static void botonEliminar(JTable grilla) {

        int selectedRow = grilla.getSelectedRow();
        if (selectedRow != -1) {
            // Ask for confirmation before deleting
            int option = JOptionPane.showOptionDialog(null, "¿Deseas borrar este animal?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (option == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) grilla.getModel();
                // Get the name of the animal to be deleted from the table
                String animal = model.getValueAt(selectedRow, 0).toString();
                model.removeRow(selectedRow);
                // Remove the animal object from the list 

                List<Animal> animales = DataBase.animales.obtenerEntidades();
                animales.removeIf(a -> a.getNombre().equals(animal));

                // Update the table by removing the corresponding row
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).toString().equals(animal)) {
                        model.removeRow(i);
                        break;
                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay un animal seleccionado");
        }
    }

    private static void cargarDatosTabla() {
        List<Animal> animales = DataBase.animales.obtenerEntidades();
        DefaultTableModel model = (DefaultTableModel) ventana.getGrilla().getModel();

        model.setNumRows(0);
        for (Animal animal : animales) {
            Object[] fila = new Object[1];
            fila[0] = animal.getNombre();
            model.addRow(fila);
        }

    }

}
