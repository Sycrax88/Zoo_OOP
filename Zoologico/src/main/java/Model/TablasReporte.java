/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.util.List;

public class TablasReporte {

    public PdfPTable crearTabla(List<Reporte> reportes, Document document, String nombrePlan) throws DocumentException {

        PdfPTable tablaReporte = new PdfPTable(5);
        PdfPCell titulo = new PdfPCell(new Phrase(nombrePlan));
        titulo.setColspan(5);
        titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
        tablaReporte.addCell(titulo);

        tablaReporte.addCell("VALOR");
        tablaReporte.addCell("CANTIDAD");
        tablaReporte.addCell("VALOR VENTA");
        tablaReporte.addCell("DESCUENTO");
        tablaReporte.addCell("TOTAL");

        for (Reporte reporte : reportes) {
            // Si el plan del reporte es el correspondiente, lo agregamos a la tabla
            if (reporte.getPlan().equals(nombrePlan)) {
                tablaReporte.addCell(String.valueOf(reporte.getValorUnidad()));
                tablaReporte.addCell(String.valueOf(reporte.getCantidad()));
                tablaReporte.addCell(String.valueOf(reporte.getValorVenta()));
                tablaReporte.addCell(String.valueOf(reporte.getPorcentajeDescuento()));
                tablaReporte.addCell(String.valueOf(reporte.getValorTotal()));

            }

        }
        return tablaReporte;

    }

    public Reporte calcularTotales(List<Reporte> reportesPlan) {
        double totalVendido = 0.0;
        double totalNeto = 0.0;
        double totalDescuentos = 0.0;

        for (Reporte reporte : reportesPlan) {
            totalVendido += reporte.getValorVenta();
            totalNeto += reporte.getValorTotal();
            totalDescuentos += reporte.getValorDescuento();
        }

        Reporte totales = new Reporte("", 0.0, 0.0);
        totales.setTotales(totalVendido, totalNeto, totalDescuentos);

        return totales;
    }

    public PdfPTable crearTablaTotales(Reporte totales, Document document) {
        PdfPTable tablaTotales = new PdfPTable(3);
        tablaTotales.setWidthPercentage(40);
        tablaTotales.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell cell1 = new PdfPCell(new Paragraph("Total Vendido"));
        PdfPCell cell2 = new PdfPCell(new Paragraph("Total Descuentos"));
        PdfPCell cell3 = new PdfPCell(new Paragraph("Total Neto"));

        tablaTotales.addCell(cell1);
        tablaTotales.addCell(cell2);
        tablaTotales.addCell(cell3);

        cell1 = new PdfPCell(new Paragraph(Double.toString(totales.getTotalVendido())));
        cell2 = new PdfPCell(new Paragraph(Double.toString(totales.getTotalDescuentos())));
        cell3 = new PdfPCell(new Paragraph(Double.toString(totales.getTotalNeto())));

        tablaTotales.addCell(cell1);
        tablaTotales.addCell(cell2);
        tablaTotales.addCell(cell3);

        return tablaTotales;
    }

}
  
