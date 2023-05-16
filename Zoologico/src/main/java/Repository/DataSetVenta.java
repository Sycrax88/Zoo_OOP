/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.Reporte;
import Model.Venta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglas.alarcon
 */
public class DataSetVenta extends DataSet {

    public List<Reporte> obtenerReporte() {
        List<Reporte> reportes = new ArrayList();
        List<Venta> ventas = DataBase.ventas.obtenerEntidades();

        for (Venta venta : ventas) {
            String plan = venta.getPlan();
            double valorUnidad = venta.getValor();
            double porcentajeDescuento = venta.getPorcentajeDescuento();

            // Crear el objeto Reporte y agregarlo a la lista de reportes
            Reporte reporte = new Reporte(plan, valorUnidad, porcentajeDescuento);
            reportes.add(reporte);

        }
        return reportes;
    }
}


    
    
