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
    private int valor;
    private int prima;
    
    // Nuevos campos para cálculos
    private int edadConductor;
    private String generoConductor;
    private int valorBaseAuto;
    
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
                 String periodo, String metodoP, int valor, int prima) {
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPrima() {
        return prima;
    }

    public void setPrima(int prima) {
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

    public int getValorBaseAuto() {
        return valorBaseAuto;
    }

    public void setValorBaseAuto(int valorBaseAuto) {
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
    public int calcularValorAsegurado() {
        // Usar el valor base del auto
        int valorAsegurado = this.valorBaseAuto;
        
        // Modificación según cobertura principal
        switch (this.cobertura) {
            case "Básica":
                // Sin cambios en el valor base
                break;
            case "Amplia":
                valorAsegurado = (int)(valorAsegurado * 1.15); // 15% adicional
                break;
            case "Total":
                valorAsegurado = (int)(valorAsegurado * 1.30); // 30% adicional
                break;
        }
        
        // Aplicar modificaciones por coberturas adicionales
        if (this.coberturaJuridico) {
            valorAsegurado = (int)(valorAsegurado * 1.04); // +4% por defensa jurídica
        }
        
        if (this.coberturaLlantas) {
            valorAsegurado = (int)(valorAsegurado * 1.03); // +3% por cobertura de llantas
        }
        
        if (this.coberturaPerdidaTotal) {
            valorAsegurado = (int)(valorAsegurado * 1.08); // +8% por pérdida total
        }
        
        if (this.coberturaRCA) {
            valorAsegurado = (int)(valorAsegurado * 1.06); // +6% por responsabilidad civil ampliada
        }
        
        if (this.coberturaRobo) {
            valorAsegurado = (int)(valorAsegurado * 1.07); // +7% por cobertura de robo
        }
        
        if (this.coberturaVial) {
            valorAsegurado = (int)(valorAsegurado * 1.02); // +2% por asistencia vial
        }
        
        // Factor de edad
        if (this.edadConductor < 25) {
            valorAsegurado = (int)(valorAsegurado * 0.95); // -5% para jóvenes
        } else if (this.edadConductor > 60) {
            valorAsegurado = (int)(valorAsegurado * 0.90); // -10% para mayores
        }
        
        // Factor de género
        if (this.generoConductor != null && this.generoConductor.equalsIgnoreCase("Masculino")) {
            valorAsegurado = (int)(valorAsegurado * 0.98); // -2% para hombres
        }
        
        // Actualizar el valor de la propiedad
        this.valor = valorAsegurado;
        return valorAsegurado;
    }
    
    /**
     * Calcula la prima a pagar según el período y cobertura
     * @return prima calculada
     */
    public int calcularPrima() {
        // Asegurarse que el valor asegurado esté calculado
        if (this.valor <= 0) {
            this.calcularValorAsegurado();
        }
        
        // Calcular prima base según cobertura
        double porcentajeBase;
        switch (this.cobertura) {
            case "Básica":
                porcentajeBase = 0.03; // 3% del valor asegurado
                break;
            case "Amplia":
                porcentajeBase = 0.05; // 5% del valor asegurado
                break;
            case "Total":
                porcentajeBase = 0.08; // 8% del valor asegurado
                break;
            default:
                porcentajeBase = 0.04; // Valor por defecto
        }
        
        int primaAnual = (int)(this.valor * porcentajeBase);
        
        // Ajustar según período
        int primaCalculada;
        switch (this.periodo.toLowerCase()) {
            case "mensual":
                primaCalculada = (int)(primaAnual / 12 * 1.1); // Mensual con 10% recargo
                break;
            case "semestral":
                primaCalculada = (int)(primaAnual / 2 * 1.05); // Semestral con 5% recargo
                break;
            case "anual":
                primaCalculada = primaAnual; // Sin recargo
                break;
            default:
                primaCalculada = primaAnual;
        }
        
        // Actualizar el valor de la propiedad
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