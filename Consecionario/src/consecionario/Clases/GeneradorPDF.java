package consecionario.Clases;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;

import javax.swing.JOptionPane;
import java.io.FileOutputStream;

public class GeneradorPDF {

    public static void generarResumenVenta(Cliente cliente, CatalogoCarros carroSeleccionado, String rutaSalida) {
       

        try {
            // Generar nombre del archivo si no se proporciona ruta
            if (rutaSalida == null || rutaSalida.isEmpty()) {
                rutaSalida = "Resumen_Venta_" + cliente.getNombre().replaceAll("\\s+", "_") + ".pdf";
            }

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(rutaSalida));

            document.open();
            document.add(new Paragraph("Resumen de Venta"));
            document.add(new Paragraph("Cliente: " + cliente.getNombre()));
            document.add(new Paragraph("Carro: " + carroSeleccionado.getModelo()));
            document.add(new Paragraph("Año: " + carroSeleccionado.getAnioFabricacion()));
            document.add(new Paragraph("Precio: $" + carroSeleccionado.getPrecio()));
            document.add(new Paragraph("Nota: El cliente no requiere seguro."));
            document.close();

            JOptionPane.showMessageDialog(null, "Resumen generado en: " + rutaSalida);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
        }
    }
}
