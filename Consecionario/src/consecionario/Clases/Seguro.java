/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario.Clases;

/**
 * @author joms_
 */
public class Seguro {
    private String nombreS;
    private String apellidoP;
    private String autoResumen;
    private String cobertura;
    private String periodo;
    private String metodoP;
    private double valor;
    private double prima;
    
    // Nuevos campos para cálculos
    private int edadConductor;
    private String generoConductor;
    private double valorBaseAuto;
    
    // Coberturas adicionales específicas
    private boolean coberturaJuridico;
    private boolean coberturaLlantas;
    private boolean coberturaPerdidaTotal;
    private boolean coberturaRCA;  // Responsabilidad Civil Ampliada
    private boolean coberturaRobo;
    private boolean coberturaVial;

    public Seguro() {
        // Constructor vacío
    }
    
    public Seguro(String nombreS, String apellidoP, String autoResumen, String cobertura, 
                 String periodo, String metodoP, double valor, double prima) {
        this.nombreS = nombreS;
        this.apellidoP = apellidoP;
        this.autoResumen = autoResumen;
        this.cobertura = cobertura;
        this.periodo = periodo;
        this.metodoP = metodoP;
        this.valor = valor;
        this.prima = prima;
    }
    
    // Getters y setters existentes...

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getAutoResumen() {
        return autoResumen;
    }

    public void setAutoResumen(String autoResumen) {
        this.autoResumen = autoResumen;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getMetodoP() {
        return metodoP;
    }

    public void setMetodoP(String metodoP) {
        this.metodoP = metodoP;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }
    
    
    // Getters y setters para los campos adicionales
    public int getEdadConductor() {
        return edadConductor;
    }

    public void setEdadConductor(int edadConductor) {
        this.edadConductor = edadConductor;
    }

    public String getGeneroConductor() {
        return generoConductor;
    }

    public void setGeneroConductor(String generoConductor) {
        this.generoConductor = generoConductor;
    }

    public double getValorBaseAuto() {
        return valorBaseAuto;
    }

    public void setValorBaseAuto(double valorBaseAuto) {
        this.valorBaseAuto = valorBaseAuto;
    }

    // Getters y setters para las coberturas adicionales
    public boolean isCoberturaJuridico() {
        return coberturaJuridico;
    }

    public void setCoberturaJuridico(boolean coberturaJuridico) {
        this.coberturaJuridico = coberturaJuridico;
    }

    public boolean isCoberturaLlantas() {
        return coberturaLlantas;
    }

    public void setCoberturaLlantas(boolean coberturaLlantas) {
        this.coberturaLlantas = coberturaLlantas;
    }

    public boolean isCoberturaPerdidaTotal() {
        return coberturaPerdidaTotal;
    }

    public void setCoberturaPerdidaTotal(boolean coberturaPerdidaTotal) {
        this.coberturaPerdidaTotal = coberturaPerdidaTotal;
    }

    public boolean isCoberturaRCA() {
        return coberturaRCA;
    }

    public void setCoberturaRCA(boolean coberturaRCA) {
        this.coberturaRCA = coberturaRCA;
    }

    public boolean isCoberturaRobo() {
        return coberturaRobo;
    }

    public void setCoberturaRobo(boolean coberturaRobo) {
        this.coberturaRobo = coberturaRobo;
    }

    public boolean isCoberturaVial() {
        return coberturaVial;
    }

    public void setCoberturaVial(boolean coberturaVial) {
        this.coberturaVial = coberturaVial;
    }
    
    /**
     * Calcula el valor por el que estará asegurado el auto
     * @return valor asegurado calculado
     */
    
    public double calcularValorAsegurado() {
    if (this.valorBaseAuto <= 0) {
        return 0.0; // Evita cálculos con valores no inicializados
    }

    double valorAsegurado = this.valorBaseAuto;

    // Asegúrate de que 'cobertura' no sea null
    if (this.cobertura == null) {
        this.cobertura = "Básica"; // Valor por defecto
    }

    switch (this.cobertura) {
        case "Básica":
            break; // Sin cambios
        case "Amplia":
            valorAsegurado *= 1.15; // +15%
            break;
        case "Total":
            valorAsegurado *= 1.30; // +30%
            break;
        default:
            valorAsegurado *= 1.10; // +10% si la cobertura no coincide
    }

    // Aplicar coberturas adicionales (simplificado)
    if (this.coberturaJuridico) valorAsegurado *= 1.04;
    if (this.coberturaLlantas) valorAsegurado *= 1.03;
    if (this.coberturaPerdidaTotal) valorAsegurado *= 1.08;
    if (this.coberturaRCA) valorAsegurado *= 1.06;
    if (this.coberturaRobo) valorAsegurado *= 1.07;
    if (this.coberturaVial) valorAsegurado *= 1.02;

    // Ajustes por edad y género
    if (this.edadConductor < 25) {
        valorAsegurado *= 0.95; // -5% para jóvenes
    } else if (this.edadConductor > 60) {
        valorAsegurado *= 0.90; // -10% para mayores
    }

    if ("Masculino".equalsIgnoreCase(this.generoConductor)) {
        valorAsegurado *= 0.98; // -2% para hombres
    }

    this.valor = valorAsegurado;
    return valorAsegurado;
}

public double calcularPrima() {
    if (this.valor <= 0) {
        this.calcularValorAsegurado(); // Recalcula si es necesario
    }

    if (this.cobertura == null || this.periodo == null) {
        return 0.0; // Evita NullPointerException
    }

    double porcentajeBase;
    switch (this.cobertura) {
        case "Básica":
            porcentajeBase = 0.03; // 3%
            break;
        case "Amplia":
            porcentajeBase = 0.05; // 5%
            break;
        case "Total":
            porcentajeBase = 0.08; // 8%
            break;
        default:
            porcentajeBase = 0.04; // Por defecto
    }

    double primaAnual = this.valor * porcentajeBase;
    double primaCalculada;

    switch (this.periodo.toLowerCase()) {
        case "mensual":
            primaCalculada = primaAnual / 12 * 1.1; // +10%
            break;
        case "semestral":
            primaCalculada = primaAnual / 2 * 1.05; // +5%
            break;
        case "anual":
            primaCalculada = primaAnual; // Sin recargo
            break;
        default:
            primaCalculada = primaAnual; // Por defecto (anual)
    }

    this.prima = primaCalculada;
    return primaCalculada;
}
    
    /**
     * Genera un resumen formateado con los datos del auto
     * @param marca marca del auto
     * @param modelo modelo del auto
     * @param año año del auto
     * @param placa placa del auto (opcional)
     * @param color color del auto (opcional)
     * @return cadena con resumen formateado
     */
    public static String generarResumenAuto(String marca, String modelo, String año, 
                                          String placa, String color) {
        StringBuilder resumen = new StringBuilder();
        resumen.append(marca).append(" ").append(modelo).append(" (").append(año).append(")");
        
        if (color != null && !color.isEmpty()) {
            resumen.append(", Color: ").append(color);
        }
        
        if (placa != null && !placa.isEmpty()) {
            resumen.append(", Placa: ").append(placa);
        }
        
        return resumen.toString();
    }
}