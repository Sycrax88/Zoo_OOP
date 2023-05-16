/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Utilities.DocumentoPDF;
import Model.Plan;
import Model.Reporte;
import Model.Venta;
import Repository.DataBase;
import View.VistaVenta;
import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author douglas.alarcon
 */
public class VentaController {

    public static VistaVenta ventana = new VistaVenta();

    public static void mostrar() {
        CargarListaDescuentos();
        cargarDatosTabla();

        ventana.setVisible(true);
    }

    public static void ocultar() {
        ventana.setVisible(false);
    }

    public static void botonCalcular() {
        String nombrPlan = (String) ventana.getCbxPlanes().getSelectedItem();
        Plan plan = DataBase.planes.obtenerEntidad(nombrPlan);
        double valor = plan.getPrecio();
        String descripcion = plan.getDescripcion();
        double valorDescuento = getPorcentajeDescuento() * valor;
        double valorTotal = valor - valorDescuento;
        ventana.getTxtValor().setText(String.valueOf(valor));
        ventana.getTxtValorDescuento().setText(String.valueOf(valorDescuento));
        ventana.getTxtValorTotal().setText(String.valueOf(valorTotal));
        ventana.getTxtDescripcion().setText(descripcion);
    }

    public static void botonPagar() {
        // se ejecuta para obtener los otros campos en caso de no ser ingresados
        botonCalcular();
        // Captura de datos de la ventana
        String plan = (String) ventana.getCbxPlanes().getSelectedItem();
        Double valor = Double.parseDouble(ventana.getTxtValor().getText());
        Double descuento = getPorcentajeDescuento();
        //creación de la entidad
        Venta venta = new Venta(plan, valor, descuento);
        // Persistencia a la base de datos
        DataBase.ventas.agregar(venta);

        mostrar();
    }

    public static void botonCancelar() {

        ventana.getTxtValor().setText("");
        ventana.getTxtValorDescuento().setText("");
        ventana.getTxtValorTotal().setText("");
        ventana.getTxtDescripcion().setText("");
        ventana.getCbxPlanes().setSelectedIndex(0);
        ventana.getRbtCincoPorCiento().setSelected(false);
        ventana.getRdbDiezPorCiento().setSelected(false);

    }

    public static void botonSalir() {

        PrincipalController.mostrar();
        ocultar();

    }

    public static void botonGenerarReporte() throws FileNotFoundException, DocumentException {
        try {
            List<Reporte> reportes = DataBase.ventas.obtenerReporte();
            DocumentoPDF documentoPdf = new DocumentoPDF(reportes);
            documentoPdf.generarPDF();
        } catch (IOException e) {

        }
    }

    private static double getPorcentajeDescuento() {
        double value = 0.0;
        if (ventana.getRbtCincoPorCiento().isSelected()) {
            value = 0.05;
        } else if (ventana.getRdbDiezPorCiento().isSelected()) {
            value = 0.1;
        }
        return value;
    }

    private static void CargarListaDescuentos() {
        List<Plan> planes = DataBase.planes.obtenerEntidades();

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (Plan plan : planes) {
            String nombrePlan = plan.getNombre();
            model.addElement(nombrePlan);
        }
        ventana.getCbxPlanes().setModel(model);
    }

    private static void cargarDatosTabla() {
        List<Venta> ventas = DataBase.ventas.obtenerEntidades();
        DefaultTableModel model = (DefaultTableModel) ventana.getGrilla().getModel();

        model.setNumRows(0);
        for (Venta venta : ventas) {
            Object[] fila = new Object[5];
            fila[0] = venta.getPlan();
            fila[1] = venta.getValor();
            fila[2] = venta.getPorcentajeDescuento();
            fila[3] = venta.getValorDescuento();
            fila[4] = venta.getValorTotal();
            model.addRow(fila);
        }

    }

    public static void botonAbrirReporte(String Reporte) {
        try {
            // Create a file object with the path to the PDF file.
            File path = new File(Reporte + ".pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) { // If there is an error while opening the file, show an error message.
            JOptionPane.showMessageDialog(null, ex, "Error al abrir el PDF", 2);
        }
    }

}

