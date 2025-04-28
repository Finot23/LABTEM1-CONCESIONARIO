/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario.Clases;

/**
 *
 * @author antoniosalinas
 */


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import consecionario.Formularios.Creditos;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class CreditoAutoPDF {

    /* ===== Estilos ===== */
    private static final BaseColor AZUL = new BaseColor(0x00, 0x26, 0x3A);
    private static final Font fEmpresa  = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
    private static final Font fBold     = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    private static final Font fNormal   = new Font(Font.FontFamily.HELVETICA, 9);
    private static final Font fCab      = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.WHITE);

    public static void generarResumenCredito(Cliente cliente, CatalogoCarros carro, Credito credito,String rutaSalida){
                               
try{
        /* ====== Datos de ejemplo (reemplaza por tu objeto Credito) ===== */
        double monto        = carro.getPrecio() - credito.getEnganche();  // TODO: credito.getMonto()
        double enganche     =  credito.getEnganche();  // credito.getEnganche()
        double plazoMeses   =  credito.getMeses();   // credito.getPlazo()
        double tasaAnual    =  credito.getTasa_interes();    // credito.getTasa()
        double pagoMensual  =  credito.getPago_mensual();  // credito.getPagoMensual()
        double cft          =     15.8;    // CAT / CFT
        LocalDate fechaContrato = LocalDate.now();
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        /* ====== Preparar PDF ====== */
        String base = "src/consecionario/Facturas/ResumenCreditos/";
            File dir = new File(base);
            if (!dir.exists()) dir.mkdirs();

            if (rutaSalida == null || rutaSalida.isEmpty()) {
                rutaSalida = base + "Resumen_Credito_"
                           + cliente.getNombre().replaceAll("\\s+", "_") + ".pdf";
            
            }

        Document doc = new Document(PageSize.A4, 36, 36, 36, 36);
        PdfWriter.getInstance(doc, new FileOutputStream(rutaSalida));
        doc.open();

        /* ===== 1. Encabezado ===== */
        PdfPTable head = new PdfPTable(2); head.setWidthPercentage(100); head.setWidths(new int[]{3,2});
        PdfPCell left = new PdfPCell(); left.setBorder(Rectangle.NO_BORDER);
        left.addElement(new Phrase("AutoNova Group", fEmpresa));
        left.addElement(new Phrase("CRÉDITO AUTOMOTRIZ", fBold));
        head.addCell(left);
        PdfPCell right = new PdfPCell(); right.setBorder(Rectangle.NO_BORDER); right.setHorizontalAlignment(Element.ALIGN_RIGHT);
        right.addElement(new Phrase("Coches Nuevos y Seminuevos Garantizados", fNormal));
        right.addElement(new Phrase("\nFACTURA: " + "F" + cliente.getId() + "-" + LocalDate.now().getYear(), fNormal));
        head.addCell(right);
        doc.add(head);  doc.add(Chunk.NEWLINE);

        /* ===== 2. Datos del Cliente ===== */
        PdfPTable datos = cuadro("Datos del Cliente");
        datos.addCell(txt("Nombre: " + cliente.getNombre() + " " + cliente.getApellidoP() + " " + cliente.getApellidoM()));
        datos.addCell(txt("CURP: " + cliente.getCurp()));
        datos.addCell(txt("Teléfono: " + cliente.getTelefono()));
        datos.addCell(txt("Email: " + cliente.getCorreo()));
        datos.addCell(txt("Dirección: " + cliente.getCalle() + ", " + cliente.getColonia()
                          + ", " + cliente.getMunicipio() + ", " + cliente.getEstado()
                          + ", C.P. " + cliente.getCP()));
        doc.add(datos);  
        doc.add(Chunk.NEWLINE);

        /* ===== 3. Datos del Vehículo ===== */
        PdfPTable veh = cuadro("Vehículo a Financiar");
        veh.addCell(txt("Marca / Modelo: " + carro.getMarca() + " " + carro.getModelo()));
        veh.addCell(txt("Tipo / Color: " + carro.getCategoria() + " / " + carro.getColor()));
        veh.addCell(txt("Año: " + carro.getAnioFabricacion() + "      No. Serie: " + carro.getNoSerie()));
        veh.addCell(txt("Precio de Venta: $" + formato(carro.getPrecio())));
        doc.add(veh); doc.add(Chunk.NEWLINE);

        /* ===== 4. Condiciones Financieras ===== */
        PdfPTable fin = cuadro("Condiciones del Crédito");
        fin.addCell(txt("Monto del Crédito: $" + formato(monto)));
fin.addCell(txt("Porcentaje de Enganche Aplicado: " + credito.getPorcentajeEnganche()));
fin.addCell(txt("Enganche: $" + formato(enganche)));
fin.addCell(txt("Plazo: " + plazoMeses + " meses"));
fin.addCell(txt("Tasa de Interés Anual Aplicada: " + (tasaAnual * 100) + " %"));
fin.addCell(txt("Pago Mensual Estimado: $" + formato(pagoMensual)));
fin.addCell(txt("Costo Financiero Total (CFT): " + cft + " %"));
fin.addCell(txt("Tipo de Crédito: Crédito Estándar"));
//fin.addCell(txt("Número de Contrato: " + folioContrato));
//fin.addCell(txt("Método de Pago: " + credito.getMetodoPago()));
fin.addCell(txt("Fecha del Contrato: " +
                fechaContrato.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

        doc.add(fin); doc.add(Chunk.NEWLINE);

        /* ===== 5. Tabla Amortización (primer mes) ===== */
        PdfPTable amo = new PdfPTable(new float[]{2,2,2,2,2});
        amo.setWidthPercentage(100);
        for(String h : new String[]{"Mes", "Saldo Inicial", "Capital", "Interés", "Saldo Final"})
            amo.addCell(celdaCab(h));
        // Ejemplo fila 1
        amo.addCell(txt("1"));
        double interes = monto * (tasaAnual/100)/12;
        double capital = pagoMensual - interes;
        double saldoFin = monto - capital;
        amo.addCell(txt("$"+formato(monto)));
        amo.addCell(txt("$"+formato(capital)));
        amo.addCell(txt("$"+formato(interes)));
        amo.addCell(txt("$"+formato(saldoFin)));
        doc.add(amo); doc.add(Chunk.NEWLINE);

        /* ===== 6. Firmas ===== */
        PdfPTable firmas = new PdfPTable(2); firmas.setWidthPercentage(100); firmas.setSpacingBefore(20f);
        firmas.addCell(firma("EL CLIENTE"));
        firmas.addCell(firma("REPRESENTANTE AUTONOVA"));
        doc.add(firmas);

        doc.close();
    }catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al generar el PDF:\n" + e.getMessage());
        }
    }

    /* ===== Helpers ===== */
    private static PdfPTable cuadro(String titulo){
        PdfPTable t = new PdfPTable(1); t.setWidthPercentage(100);
        PdfPCell cab = celdaCab(titulo); cab.setHorizontalAlignment(Element.ALIGN_LEFT);
        t.addCell(cab); return t;
    }
    private static PdfPCell celdaCab(String txt){
        PdfPCell c = new PdfPCell(new Phrase(txt, fCab));
        c.setBackgroundColor(AZUL); c.setBorder(Rectangle.NO_BORDER); c.setPadding(4f);
        return c;
    }
    private static PdfPCell txt(String s){
        PdfPCell c = new PdfPCell(new Phrase(s, fNormal)); c.setBorder(Rectangle.NO_BORDER); return c;
    }
    private static PdfPCell firma(String quien){
        PdfPCell c = new PdfPCell();
        c.setBorder(Rectangle.NO_BORDER); c.setFixedHeight(60);
        c.addElement(new Phrase("______________________________", fNormal));
        c.addElement(new Phrase(quien, fBold));
        return c;
    }
    private static String formato(double v){ return new DecimalFormat("#,##0.00").format(v); }
    
}
