/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Model.Reporte;
import Model.TablasReporte;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author douglas.alarcon
 */
public class DocumentoPDF {

    private Document document;
    private final List<Reporte> reportes;

    public DocumentoPDF(List<Reporte> reportes) {

        this.reportes = reportes;

    }

    public void generarPDF() throws FileNotFoundException, DocumentException, BadElementException, IOException {

        document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("Reporte.pdf"));

        // Abrir el documento
        document.open();

        // Añadir información al documento 
        añadirEncabezado();
        agregarImagen();
        añadirFecha();
        añadirTextoPrincipal();

        Set<String> nombresPlan = new HashSet<>();

        for (Reporte reporte : reportes) {
            nombresPlan.add(reporte.getPlan());
        }

        TablasReporte crearTablaPdf = new TablasReporte();
        for (String nombrePlan : nombresPlan) {
            List<Reporte> reportesPlan = new ArrayList<>();
            for (Reporte reporte : reportes) {
                if (reporte.getPlan().equals(nombrePlan)) {
                    reportesPlan.add(reporte);
                }
            }
            PdfPTable tabla = crearTablaPdf.crearTabla(reportesPlan, document, nombrePlan);
            document.add(tabla);
            document.add(Chunk.NEWLINE);

            Reporte totalesPlan = crearTablaPdf.calcularTotales(reportesPlan);
            PdfPTable tablaTotalesPlan = crearTablaPdf.crearTablaTotales(totalesPlan, document);
            document.add(tablaTotalesPlan);
            document.add(Chunk.NEWLINE);

        }

        document.close();
        JOptionPane.showMessageDialog(null, "PDF se ha generado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    }

    public void añadirEncabezado() throws DocumentException {

        Paragraph title = new Paragraph();
        title.setAlignment(Paragraph.ALIGN_RIGHT);
        title.setFont(FontFactory.getFont("HELVETICA", 30, Font.BOLD, BaseColor.ORANGE));
        title.add("\n\nSanta Fe \n\n");
        title.add("Zoologico de Medellín");

        document.add(title);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);

    }

    public void agregarImagen() throws BadElementException, IOException {
        try {
            Image image = Image.getInstance("logo.png");
            image.scaleAbsolute(150, 100);
            image.setAbsolutePosition(50, 715);
            document.add(image);
        } catch (DocumentException e) {
            // handling the exception if there was an error adding the image to the document
            System.err.println("Error trying to add image to document: " + e.getMessage());
        }
    }

    public void añadirFecha() {

        String fecha = FechaActual.getFechaActualizada();

        try {
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Medellín, " + fecha));
            document.add(Chunk.NEWLINE);
        } catch (DocumentException e) {
            System.err.println("Error añadiendo la fecha al documento: " + e.getMessage());
        }
    }

    public void añadirTextoPrincipal() {

        try {
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Estimados Señores"));
            document.add(new Paragraph("Grupo de Turismo de Reservaciones de Medellín:"));
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            Paragraph texto = new Paragraph("La Administración Internacional del Zoológico, ZOODI, desea agradecerle su "
                    + "participación en el desarrollo de este nuevo software y le recuerda la necesidad de tener "
                    + "información actualizada y precisa sobre sus ventas en cada uno de sus zoológicos. Por lo tanto, "
                    + "hemos diseñado el siguiente informe como un Producto Mínimo Viable para la entrega de su trabajo, "
                    + "MVP. Esperamos tener la oportunidad de probar su aplicación pronto.");

            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(texto);

            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            document.add(new Paragraph("Atentamente,"));
            document.add(new Paragraph("Departamento de Logística del Zoológico"));

            document.newPage();

            document.add(new Paragraph("A continuación, presentamos el informe de ventas con todos los detalles correspondientes de los planes vendidos "
                    + "en nuestro zoológico durante el día:"));
            document.add(Chunk.NEWLINE);
        } catch (DocumentException e) {
            // manejar la excepción aquí, por ejemplo, imprimir un mensaje de error
            System.out.println("Error al agregar texto al documento: " + e.getMessage());
        }
    }

}
