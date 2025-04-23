package consecionario.Clases;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.File;

import javax.swing.JOptionPane;
import java.io.FileOutputStream;

public class GeneradorPDF {

   public static void generarResumenVenta(Cliente cliente, CatalogoCarros carroSeleccionado, String rutaSalida) {
        try {
            // Crear carpeta si no existe
            String rutaBase = "src/consecionario/Facturas/VentasSinSeguro/";
            File carpeta = new File(rutaBase);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            // Ruta del archivo
            if (rutaSalida == null || rutaSalida.isEmpty()) {
                rutaSalida = rutaBase + "Resumen_Venta_" + cliente.getNombre().replaceAll("\\s+", "_") + ".pdf";
            }

            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(rutaSalida));
            document.open();

            // Fuentes
            Font fontEmpresa = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, BaseColor.DARK_GRAY);
            Font fontSlogan = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
            Font fontDireccion = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY);
            Font fontFactura = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
            Font fontNormal = new Font(Font.FontFamily.HELVETICA, 10);
            Font fontBold = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);


            // Tabla para encabezado: 2 columnas
            PdfPTable encabezado = new PdfPTable(2);
            encabezado.setWidthPercentage(100);
            encabezado.setWidths(new int[]{2, 3}); // proporción columnas

            // Celda 1: Nombre de la empresa
            PdfPCell celdaIzquierda = new PdfPCell();
            celdaIzquierda.setBorder(Rectangle.NO_BORDER);
            celdaIzquierda.addElement(new Phrase("AutoNova Group", fontEmpresa));
            celdaIzquierda.addElement(new Phrase("FACTURA", fontFactura));
            document.add(new Paragraph("\n"));
            encabezado.addCell(celdaIzquierda);

            // Celda 2: Eslogan y dirección
            PdfPCell celdaDerecha = new PdfPCell();
            celdaDerecha.setBorder(Rectangle.NO_BORDER);
            celdaDerecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celdaDerecha.addElement(new Phrase("COCHES NUEVOS Y SEMINUEVOS GARANTIZADOS", fontSlogan));
            celdaDerecha.addElement(new Phrase("Vasco de Quiroga 4871, Contadero,", fontDireccion));
            celdaDerecha.addElement(new Phrase("Cuajimalpa de Morelos, 05348 Ciudad de México, CDMX", fontDireccion));
            encabezado.addCell(celdaDerecha);

            document.add(encabezado);

            // Línea separadora
            LineSeparator separator = new LineSeparator();
            separator.setLineColor(BaseColor.LIGHT_GRAY);
            document.add(new Chunk(separator));

            // Puedes continuar con tu tabla de datos aquí abajo...

            document.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(2);
            tabla.setWidthPercentage(100);
            
            tabla.addCell(getCelda("DATOS DEL CLIENTE", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            tabla.addCell(getCelda("DATOS DEL DOCUMENTO",FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            tabla.addCell(getCelda("Nombre del Cliente: "+cliente.getNombre(), FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            
            tabla.addCell(new Phrase("Folio fiscal: 7A4B98C5-XXXX", fontNormal));
            tabla.addCell(getCelda("RFC del receptor: XAXX010101000",FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            
            
            tabla.addCell(getCelda("Dirección: "+cliente.getCalle() +cliente.getColonia() +cliente.getMunicipio() +cliente.getEstado() +cliente.getCP() , FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            //tabla.addCell/"Fecha de emisión"
            
            
            tabla.addCell(getCelda("Carro:", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            tabla.addCell(getCelda(carroSeleccionado.getModelo(), null));
            tabla.addCell(getCelda("Año:", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            tabla.addCell(getCelda(String.valueOf(carroSeleccionado.getAnioFabricacion()), null));
            tabla.addCell(getCelda("Precio:", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            tabla.addCell(getCelda("$" + carroSeleccionado.getPrecio(), null));
            tabla.addCell(getCelda("Seguro requerido:", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            tabla.addCell(getCelda("No", null));
            
            PdfPCell docCell = new PdfPCell();
            docCell.setBorder(Rectangle.NO_BORDER);
            docCell.addElement(new Phrase("DATOS DEL DOCUMENTO", fontBold));
           
            docCell.addElement(new Phrase("Fecha emisión: 22/04/2025", fontNormal));
            docCell.addElement(new Phrase("Forma de pago: 99 - POR DEFINIR", fontNormal));
            
            document.add(tabla);

            document.close();
            JOptionPane.showMessageDialog(null, "Resumen generado en: " + rutaSalida);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
        }
    }

    private static PdfPCell getCelda(String texto, Font fuente) {
        if (fuente == null) {
            fuente = new Font(Font.FontFamily.HELVETICA, 11);
        }
        PdfPCell celda = new PdfPCell(new Phrase(texto, fuente));
        celda.setBorder(Rectangle.NO_BORDER);
        return celda;
    }

}
