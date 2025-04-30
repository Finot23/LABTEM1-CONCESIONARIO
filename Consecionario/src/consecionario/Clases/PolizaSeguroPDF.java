/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario.Clases;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import consecionario.Formularios.Seguros;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.BiConsumer;
import javax.swing.JOptionPane;

public class PolizaSeguroPDF {

    //colores fuentes
    private static final BaseColor AZUL = new BaseColor(0x00, 0x26, 0x3A);
    private static final Font fTitulo   = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    private static final Font fBold     = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    private static final Font fNormal   = new Font(Font.FontFamily.HELVETICA, 9);
    private static final Font fCabBlue  = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.WHITE);

    public static void generarResumenSeguro(Cliente cliente, CatalogoCarros carro , Seguro seguro, String rutaSalida) {
        
        try{
            
            LocalDate hoy = LocalDate.now();                   
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaEmision = hoy.format(fmt); 
            //Un mes después
            LocalDate unMesDespues = hoy.plusMonths(1);
            String fechaMes = unMesDespues.format(fmt);     

            //semestre
            LocalDate semestreDespues = hoy.plusMonths(6);
            String fechaSemestre = semestreDespues.format(fmt); 

            //año
            LocalDate unAnioDespues = hoy.plusYears(1);
            String fechaAnio = unAnioDespues.format(fmt);   
             DecimalFormat df = new DecimalFormat("#,##0.00");
             Double PrimaConIVA = seguro.getPrima();
             Double PrimaSinIVA = PrimaConIVA / 1.16;
             Double IVA = PrimaConIVA * 0.16;
             
        
            //Carpeta
            String base = "src/consecionario/Facturas/PolizaSeguro/";
            File dir = new File(base);
            if (!dir.exists()) dir.mkdirs();

            if (rutaSalida == null || rutaSalida.isEmpty()) {
                rutaSalida = base + "Poliza_Seguro_"
                           + cliente.getNombre().replaceAll("\\s+", "_") + ".pdf";
            }
        
        Document doc = new Document(PageSize.A4, 36, 36, 36, 36);
        PdfWriter.getInstance(doc, new FileOutputStream(rutaSalida));
        doc.open();

     
        PdfPTable head = new PdfPTable(2);
        head.setWidthPercentage(100);
        head.setWidths(new int[]{3, 2});

        PdfPCell left = new PdfPCell();
        left.setBorder(Rectangle.NO_BORDER);
        left.addElement(new Phrase("AutoNova Group", fTitulo));
        left.addElement(new Phrase("SEGURO DE AUTO", fBold));
        left.addElement(new Phrase("\nFACTURA: " + "F" + cliente.getId() + "-" + LocalDate.now().getYear(), fNormal));
        head.addCell(left);

        PdfPCell right = new PdfPCell();
        right.setBorder(Rectangle.NO_BORDER);
        right.setHorizontalAlignment(Element.ALIGN_RIGHT);
        
        head.addCell(right);

        doc.add(head);
        doc.add(Chunk.NEWLINE);

        ///Datos del Contratante
        PdfPTable bloque1 = tablaDosCol();
        bloque1.addCell(cab("Contratante"));
        bloque1.addCell(cab("Conductor Principal"));

        bloque1.addCell(text("Nombre del Cliente: " +cliente.getNombre() + cliente.getApellidoP() + cliente.getApellidoM()));
        bloque1.addCell(text("Nombre: "+cliente.getNombre() + cliente.getApellidoP() + cliente.getApellidoM()));

        bloque1.addCell(new Phrase("Dirección:\n"
                    + cliente.getCalle() + ", "
                    + cliente.getColonia() + ", "
                    + cliente.getMunicipio() + ", "
                    + cliente.getEstado() + ", C.P. " + cliente.getCP(), fNormal));
        bloque1.addCell(text("Código del Cliente: " +cliente.getId()));

        bloque1.addCell(text("Edad: " +cliente.getEdad()));
        bloque1.addCell(text("Teléfono: " +cliente.getTelefono()));

        bloque1.addCell(text("Género: "+cliente.getGenero()));
        bloque1.addCell(empty());

        doc.add(bloque1);
        doc.add(Chunk.NEWLINE);

        //Cláusula Intro
        Paragraph intro = new Paragraph(
            "Seguros AutoNova Group S.A. de C.V. asegura, de conformidad con las cláusulas "
          + "de esta póliza, durante la vigencia establecida, el vehículo descrito a continuación…",
            fBold);
        intro.setAlignment(Element.ALIGN_JUSTIFIED);
        doc.add(intro);
        doc.add(Chunk.NEWLINE);

        //Datos del Vehículo
        PdfPTable veh = tablaDosCol();
        veh.addCell(cab("Datos del Vehículo"));
        veh.addCell(cab("Fecha de Expedición de la Póliza"));

        veh.addCell(text("MARCA: " +carro.getMarca()));
        veh.addCell(text("Día   Mes   Año"));

        veh.addCell(text("MODELO: " +carro.getModelo()));
        veh.addCell(text(LocalDate.now()
                     .format(DateTimeFormatter.ofPattern("dd   MM   yyyy"))));

        veh.addCell(text("TIPO: " +carro.getCategoria()));
        veh.addCell(empty());

        veh.addCell(text("COLOR: " +carro.getColor()));
        veh.addCell(empty());

        veh.addCell(text("AÑO: " +carro.getAnioFabricacion()));
        veh.addCell(empty());

        veh.addCell(text("KILOMETRAJE: " +carro.getKilometraje() + "km"));
        veh.addCell(empty());

        veh.addCell(text("PLACAS: "));
        veh.addCell(empty());

        veh.addCell(text("NO. DE SERIE: " + seguro.getNoSerie()));
        veh.addCell(empty());

        veh.addCell(text("USO: Particular"));
        veh.addCell(empty());

        doc.add(veh);
        doc.add(Chunk.NEWLINE);

        //vigencia
        PdfPTable vig = tablaDosCol();
        vig.addCell(cab("Vigencia de la Póliza"));
        vig.addCell(cab(""));
        vig.addCell(text("Desde las 12:00 hrs. del " +fechaEmision));
        String fechaTope;
if ("MENSUAL".equalsIgnoreCase(seguro.getPeriodo())) {
    fechaTope = fechaMes;        // +1 mes
} else {
    fechaTope = fechaSemestre;   // +6 meses
}
vig.addCell(text("Hasta las 12:00 hrs. del " + fechaTope));

        doc.add(vig);
        doc.add(Chunk.NEWLINE);

        //plan prima
        PdfPTable plan = tablaDosCol();
        plan.addCell(cab("Detalles del Plan"));
        plan.addCell(cab("Desglose de la Prima"));

        plan.addCell(text("Cobertura seleccionada: " +seguro.getCobertura()));
        plan.addCell(text("Prima Neta antes de descuento: $"+df.format(seguro.getPrima())));

        plan.addCell(text("Forma de pago: " +seguro.getMetodoP()));
        plan.addCell(text("Recargo Pago Póliza: $0.00"));

        plan.addCell(text("Moneda: MXN"));
        plan.addCell(text("IVA 16%: $"+df.format(IVA)));

        
        plan.addCell(text("Importe a pagar: $0.00"));

        plan.addCell(empty());
        plan.addCell(text("Primer pago: $"+df.format(seguro.getPrima())));

        plan.addCell(empty());
        plan.addCell(text("Pagos subsecuentes: $0.00"));

        doc.add(plan);
        doc.add(Chunk.NEWLINE);

        //coberturas
        PdfPTable cob = new PdfPTable(new float[]{4, 3, 2});
cob.setWidthPercentage(100);
for (String h : new String[]{"Cobertura / Servicio", "Suma Asegurada", "Deducible"})
    cob.addCell(celdaCab(h));

BiConsumer<String, String[]> fila = (nombre, datos) -> {
    cob.addCell(text(nombre));
    cob.addCell(text(datos[0]));   // suma asegurada
    cob.addCell(text(datos[1]));   // deducible
};

//agregar filas
if (seguro.isCoberturaVial())         
    fila.accept("Asistencia Vial",      new String[]{"Incluida", "N/A"});

if (seguro.isCoberturaPerdidaTotal())  
    fila.accept("Daños Materiales (PT)", new String[]{"Valor Comercial", "10 %"});

if (seguro.isCoberturaRobo())          
    fila.accept("Robo de Autopartes",   new String[]{"$30 000", "20 %"});

if (seguro.isCoberturaLlantas())       
    fila.accept("Llantas y Cristales",  new String[]{"$15 000", "15 %"});

if (seguro.isCoberturaRCA())          
    fila.accept("Civil Ampliada",       new String[]{"$3 000 000", "N/A"});

if (seguro.isCoberturaJuridico())     
    fila.accept("Apoyo Jurídico",       new String[]{"Incluido", "N/A"});

//añade la tabla al doc
doc.add(cob);

        
        doc.add(Chunk.NEWLINE);
        doc.add(new Paragraph("AutoNova Group", fBold));
        doc.close();
    }catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al generar el PDF:\n" + e.getMessage());
        }
    }
        
       
    private static PdfPTable tablaDosCol() throws DocumentException {
        PdfPTable t = new PdfPTable(2);
        t.setWidthPercentage(100);
        t.setWidths(new int[]{1, 1});
        return t;
    }
    private static PdfPCell cab(String txt) {
        PdfPCell c = new PdfPCell(new Phrase(txt, fCabBlue));
        c.setBackgroundColor(AZUL);
        c.setBorder(Rectangle.NO_BORDER);
        c.setPadding(4f);
        return c;
    }
    private static PdfPCell text(String txt) {
        PdfPCell c = new PdfPCell(new Phrase(txt, fNormal));
        c.setBorder(Rectangle.NO_BORDER);
        return c;
    }
    private static PdfPCell empty() {
        PdfPCell c = new PdfPCell(new Phrase(""));
        c.setBorder(Rectangle.NO_BORDER);
        return c;
    }
    private static PdfPCell celdaCab(String h) {
        PdfPCell c = new PdfPCell(new Phrase(h, fCabBlue));
        c.setBackgroundColor(AZUL);
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        c.setPadding(4f);
        return c;
    }
    }


  
