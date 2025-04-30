package consecionario.Clases;

import BD.ConexionBD;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.sun.jdi.connect.spi.Connection;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class GeneradorPDF {

 

    /* ----------  ESTILOS & COLORES  ---------- */
    private static final BaseColor AZUL   = new BaseColor(0x00, 0x26, 0x3A);
    private static final Font fEmpresa    = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
    private static final Font fSlogan     = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    private static final Font fDireccion = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL);
    private static final Font fEtiqueta   = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, AZUL);
    private static final Font fTablaHd    = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.WHITE);
    private static final Font fNormal     = new Font(Font.FontFamily.HELVETICA, 9);

    /* ----------  MÉTODO PRINCIPAL  ---------- */
    public static void generarResumenVenta(Cliente cliente,CatalogoCarros carro,String rutaSalida) {

        try {
            Double TotalConIVA = carro.getPrecio();
            Double TotalSinIVA = TotalConIVA / 1.16;
            Double IVA = TotalSinIVA * 0.16;
            DecimalFormat df = new DecimalFormat("#,##0.00");
            LocalDate hoy = LocalDate.now();                   
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaEmision = hoy.format(fmt); 

            // Carpeta de salida
            String base = "src/consecionario/Facturas/Ventas/";
            File dir = new File(base);
            if (!dir.exists()) dir.mkdirs();

            if (rutaSalida == null || rutaSalida.isEmpty()) {
                rutaSalida = base + "Resumen_Venta_"
                           + cliente.getNombre().replaceAll("\\s+", "_") + ".pdf";
            }

            Document doc = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter.getInstance(doc, new FileOutputStream(rutaSalida));
            doc.open();

            /* -------- 1. ENCABEZADO -------- */
            PdfPTable head = new PdfPTable(2);
            head.setWidthPercentage(100);
            head.setWidths(new int[]{3, 2});

            PdfPCell left = new PdfPCell();
            left.setBorder(Rectangle.NO_BORDER);
            left.addElement(new Phrase("AutoNova Group", fEmpresa));
            head.addCell(left);

            PdfPCell right = new PdfPCell();
            right.setBorder(Rectangle.NO_BORDER);
            right.setHorizontalAlignment(Element.ALIGN_RIGHT);
           right.addElement(new Phrase("\nFACTURA: " + "F" + cliente.getId() + "-" + LocalDate.now().getYear(), fEtiqueta));
            right.addElement(new Phrase("COCHES NUEVOS Y SEMINUEVOS\nGARANTIZADOS", fSlogan));
            right.addElement(new Phrase("Vasco de Quiroga 4871, Contadero,\nCuajimalpa de Morelos, 05348 Ciudad de México, CDMX", fDireccion));
            
            head.addCell(right);

            doc.add(head);
            doc.add(new Chunk("\n"));
            doc.add(new LineSeparator());
            doc.add(new Chunk("\nFACTURA\n\n", fEtiqueta));

            /* -------- 2. DATOS CLIENTE / DOC -------- */
            PdfPTable datos = tablaDosCol(100);
            datos.addCell(celdaCabecera("DATOS DEL CLIENTE"));
            datos.addCell(celdaCabecera("DATOS DEL DOCUMENTO"));

            datos.addCell(new Phrase("Nombre del Cliente: \n" + cliente.getNombre() + cliente.getApellidoP() + cliente.getApellidoM(), fNormal));
            datos.addCell(new Phrase("Folio fiscal: \n" + "7A4B98C5-XXXX", fNormal));

            datos.addCell(new Phrase("Dirección:\n"
                    + cliente.getCalle() + ", "
                    + cliente.getColonia() + ", "
                    + cliente.getMunicipio() + ", "
                    + cliente.getEstado() + ", C.P. " + cliente.getCP(), fNormal));

            datos.addCell(new Phrase("RFC del emisor: XAXX010101000"
                    + "\nFecha de emisión: " + fechaEmision, fNormal));

            doc.add(datos);
            doc.add(Chunk.NEWLINE);

            /* --------------------------------------------------------------------------------
           4) FORMA DE PAGO / MONEDA
        -------------------------------------------------------------------------------- */
        PdfPTable pago = tablaDosCol(100);
        pago.addCell(celdaCabecera("FORMA DE PAGO"));
        pago.addCell(celdaCabecera("MONEDA"));
        pago.addCell(new Phrase("01 - EFECTIVO", fNormal));
        pago.addCell(new Phrase("MXN - PESO MEXICANO", fNormal));
        doc.add(pago);
        doc.add(new Chunk("\n"));

        /* --------------------------------------------------------------------------------
           5) TABLA CONCEPTOS (Cantidad, Descripción, Clave)
        -------------------------------------------------------------------------------- */
        PdfPTable conceptos = new PdfPTable(new float[]{1, 5, 2});
        conceptos.setWidthPercentage(100);

        // Cabeceras azul con texto blanco
        for (String h : new String[]{"CANTIDAD", "DESCRIPCIÓN", "CLAVE DE UNIDAD"})
            conceptos.addCell(celdaCabecera(h));

        // Fila concepto
        // --- Construir la descripción completa ---
StringBuilder sb = new StringBuilder();
sb.append("UN VEHÍCULO ").append(carro.getEstado())
  .append(" CON LA SIGUIENTE DESCRIPCIÓN\n\n")
  .append("MARCA: ").append(carro.getMarca()).append('\n')
  .append("MODELO: ").append(carro.getModelo()).append('\n')
  .append("TIPO: ").append(carro.getCategoria()).append('\n')
  .append("COLOR: ").append(carro.getColor()).append('\n')
  .append("AÑO: ").append(carro.getAnioFabricacion()).append('\n')
  .append("KILOMETRAJE: ").append(carro.getKilometraje());

Phrase descripcion = new Phrase(sb.toString(), fNormal);

// --- Añadir a la tabla ---
conceptos.addCell(new Phrase("01", fNormal));  // Cantidad
conceptos.addCell(descripcion);                // Descripción
conceptos.addCell(new Phrase(String.valueOf(carro.getId()), fNormal));

        doc.add(conceptos);
        doc.add(new Chunk("\n"));

        /* Nota / Norma */
        Paragraph nota = new Paragraph("La transmisión de la propiedad del bien al que se refiere la presente factura se formaliza a través del contrato de adhesión correspondiente, conforme a las disposiciones de la Norma Oficial Mexicana 1 C‑05CFI‑2010", fNormal);
        nota.setAlignment(Element.ALIGN_JUSTIFIED);
        doc.add(nota);
        doc.add(new Chunk("\n"));

        Paragraph leyenda = new Paragraph("AUTOMÓVIL CON LAS CARACTERÍSTICAS Y CONDICIONES EN LAS QUE SE ENCUENTRA", fEtiqueta);
        leyenda.setAlignment(Element.ALIGN_CENTER);
        doc.add(leyenda);
        doc.add(new Chunk("\n"));

        /* --------------------------------------------------------------------------------
           6) IMPORTE Y TOTALES
        -------------------------------------------------------------------------------- */
        PdfPTable totTitulo = new PdfPTable(1);
        totTitulo.setWidthPercentage(100);
        PdfPCell cImp = celdaCabecera("IMPORTE");
        cImp.setHorizontalAlignment(Element.ALIGN_LEFT);
        totTitulo.addCell(cImp);
        doc.add(totTitulo);

        // tabla totales (alinear a la derecha)
        PdfPTable totales = new PdfPTable(2);
        totales.setWidths(new float[]{2, 1});
        totales.setWidthPercentage(40);
        totales.setHorizontalAlignment(Element.ALIGN_RIGHT);

        totales.addCell(celdaLinea("Subtotal:", false));
        totales.addCell(celdaLinea("$" +df.format(TotalSinIVA), true));

        totales.addCell(celdaLinea("IVA 16%:", false));
        totales.addCell(celdaLinea("$" +df.format(IVA), true));

        totales.addCell(celdaLinea("Total:", true));
        totales.addCell(celdaLinea("$" +df.format(TotalConIVA), true));

        doc.add(totales);

        
    

            doc.close();

            JOptionPane.showMessageDialog(null, "PDF generado en:\n" + rutaSalida);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al generar el PDF:\n" + e.getMessage());
        }
    }

    /* ----------  HELPERS  ---------- */
    private static PdfPTable tablaDosCol(float pct) {
        PdfPTable t = new PdfPTable(2);
        t.setWidthPercentage(pct);
        return t;
    }

    private static PdfPCell celdaCabecera(String txt) {
        PdfPCell c = new PdfPCell(new Phrase(txt, fTablaHd));
        c.setBackgroundColor(AZUL);
        c.setBorder(Rectangle.NO_BORDER);
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        c.setPadding(4f);
        return c;
    }

    private static PdfPCell celdaLinea(String txt, boolean boldRight) {
        Font f = boldRight ? fEtiqueta : fNormal;
        PdfPCell c = new PdfPCell(new Phrase(txt, f));
        c.setBorder(Rectangle.NO_BORDER);
        c.setHorizontalAlignment(boldRight ? Element.ALIGN_RIGHT : Element.ALIGN_LEFT);
        c.setPadding(2f);
        return c;
    }
   

}
