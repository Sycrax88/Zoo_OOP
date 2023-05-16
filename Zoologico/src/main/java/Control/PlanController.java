/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Animal;
import Model.Plan;
import Repository.DataBase;
import View.VistaPlan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author douglas.alarcon
 */
public class PlanController {

    public static VistaPlan ventana = new VistaPlan();

    public static void mostrar() {
        ventana.setVisible(true);
        cargarDatosAnimales();
        cargarDatosTabla();
    }

    public static void ocultar() {
        ventana.setVisible(false);
    }

    public static void botonAgregar() {
        // Captura de datos de la ventana
        String nombre = ventana.getTxtNombre().getText();
        String precioString = ventana.getTxtPrecio().getText();

        if (nombre.isEmpty() || precioString.isEmpty()) {
            JOptionPane.showMessageDialog(ventana, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!precioString.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(ventana, "El precio debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double precio = Double.parseDouble(precioString);

        List<Animal> animalesSeleccionados = obtenerAnimalesSeleccionados();

        if (animalesSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(ventana, "Debe seleccionar al menos un animal", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Se crea entidad plan
        Plan plan = new Plan(nombre, precio, animalesSeleccionados);

        // persiste la entidad.
        DataBase.planes.agregar(plan);

        // Limpia campos
        ventana.getTxtNombre().setText("");
        ventana.getTxtPrecio().setText("");
        //Refresca pantalla

        mostrar();
    }

    public static void botonEliminar(JTable grilla) {

        int selectedRow = grilla.getSelectedRow();
        if (selectedRow != -1) {
            // Ask for confirmation before deleting
            int option = JOptionPane.showOptionDialog(null, "¿Estás seguro que quieres eliminar el plan?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (option == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) grilla.getModel();
                // Get the name of the plan to be deleted from the table
                String planNombre = model.getValueAt(selectedRow, 0).toString();
                double planPrecio = Double.parseDouble(model.getValueAt(selectedRow, 1).toString());
                model.removeRow(selectedRow);
                // Remove the plan object from the list
                List<Plan> planes = DataBase.planes.obtenerEntidades();
                planes.removeIf(plan -> plan.getNombre().equals(planNombre) && plan.getPrecio() == planPrecio);
            }

        }

    }

    public static void botonModificar(JTable grilla) {

        int selectedRow = grilla.getSelectedRow();
        if (selectedRow != -1) {
            // Obtiene el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) grilla.getModel();
            // Obtiene los nuevos valores ingresados en los campos de texto correspondientes
            String nuevoNombre = ventana.getTxtNombre().getText();
            String nuevoPrecio = ventana.getTxtPrecio().getText();
            // Verifica que los nuevos valores no estén vacíos y sean válidos
            if (nuevoNombre.isEmpty() || nuevoPrecio.isEmpty()) {
                JOptionPane.showMessageDialog(ventana, "Debe ingresar valores para modificar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double nuevoPrecioDouble;
            try {
                nuevoPrecioDouble = Double.parseDouble(nuevoPrecio);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(ventana, "El valor ingresado para el precio no es válido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Actualiza los valores en el modelo de la tabla
            model.setValueAt(nuevoNombre, selectedRow, 0);
            model.setValueAt(nuevoPrecioDouble, selectedRow, 1);
            // Actualiza los valores en la lista de planes
            List<Plan> planes = DataBase.planes.obtenerEntidades();
            Plan plan = planes.get(selectedRow);
            plan.setNombre(nuevoNombre);
            plan.setPrecio(nuevoPrecioDouble);
            JOptionPane.showMessageDialog(ventana, "Los cambios han sido guardados exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public static void botonSalir() {
        PrincipalController.mostrar();
        PlanController.ocultar();

        ventana.getTxtNombre().setText("");
        ventana.getTxtPrecio().setText("");
    }

    public static void seleccionFilaTablaPlanes() {
        int row = ventana.getGrilla().getSelectedRow();

        DefaultTableModel model = (DefaultTableModel) ventana.getGrilla().getModel();

        String nombre = (String) model.getValueAt(row, 0);
        ventana.getTxtNombre().setText(nombre);

        String precio = Double.toString((double) model.getValueAt(row, 1));
        ventana.getTxtPrecio().setText(precio);
    }

    private static void cargarDatosTabla() {
        List<Plan> planes = DataBase.planes.obtenerEntidades();
        DefaultTableModel model = (DefaultTableModel) ventana.getGrilla().getModel();

        model.setNumRows(0);
        for (Plan plan : planes) {
            Object[] fila = new Object[3];
            fila[0] = plan.getNombre();
            fila[1] = plan.getPrecio();
            fila[2] = plan.getDescripcion();
            model.addRow(fila);
        }

    }

    private static void cargarDatosAnimales() {
        ventana.getLstAnimales().updateUI();
        List<Animal> animales = DataBase.animales.obtenerEntidades();
        DefaultListModel model = new DefaultListModel();
        for (Animal animal : animales) {
            String nombreAnimal = animal.getNombre();
            model.addElement(nombreAnimal);
        }

        ventana.getLstAnimales().setModel(model);
    }

    private static List<Animal> obtenerAnimalesSeleccionados() {
        List<Animal> animalesSeleccionados = new ArrayList();
        List<String> nombreAnimalesSeleccionados = ventana.getLstAnimales().getSelectedValuesList();

        for (String nombreAnimal : nombreAnimalesSeleccionados) {
            Animal animal = DataBase.animales.obtenerEntidad(nombreAnimal);
            animalesSeleccionados.add(animal);
        }

        return animalesSeleccionados;
    }
}
