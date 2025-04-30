package consecionario.Clases;

public class Credito {
    private String Nombre;
    private String Apellido_p;
    private String Apellido_m;
    private String Modelo;
    private String Marca;
    private double Valor_auto;
    private String PorcentajeEnganche;
    private double Enganche;
    private double Credito;
    private int Meses;
    private double Tasa_interes;
    private double Pago_mensual;
    private String metodoPago;


    public Credito(){
        
    }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public double calcularEnganche() {
        double porcentaje = Double.parseDouble(this.PorcentajeEnganche.replace("%", "")) / 100.0;
        this.Enganche = this.Valor_auto * porcentaje;
        return this.Enganche;
}

// Método para calcular el monto del crédito aprobado
public double creditoAprobado() {
    this.Credito = this.Valor_auto - this.Enganche;
    return this.Credito;
}

//para calcular el pago mensual
public double pagoMensual(double montoCredito, int meses) {
    double tasaMensual = this.Tasa_interes / 12.0;
    double pago = (montoCredito * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -meses));
    return pago;
}

    public Credito(String Nombre, String Apellido_p, String Apellido_m, String Modelo, String Marca, double Valor_auto, String PorcentajeEnganche, double Enganche, double Credito, int Meses, double Tasa_interes, double Pago_mensual) {
        this.Nombre = Nombre;
        this.Apellido_p = Apellido_p;
        this.Apellido_m = Apellido_m;
        this.Modelo = Modelo;
        this.Marca = Marca;
        this.Valor_auto = Valor_auto;
        this.PorcentajeEnganche = PorcentajeEnganche;
        this.Enganche = Enganche;
        this.Credito = Credito;
        this.Meses = Meses;
        this.Tasa_interes = Tasa_interes;
        this.Pago_mensual = Pago_mensual;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido_p() {
        return Apellido_p;
    }

    public String getApellido_m() {
        return Apellido_m;
    }

    public String getModelo() {
        return Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public double getValor_auto() {
        return Valor_auto;
    }

    public String getPorcentajeEnganche() {
        return PorcentajeEnganche;
    }

    public double getEnganche() {
        return Enganche;
    }

    public double getCredito() {
        return Credito;
    }

    public int getMeses() {
        return Meses;
    }

    public double getTasa_interes() {
        return Tasa_interes;
    }

    public double getPago_mensual() {
        return Pago_mensual;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido_p(String Apellido_p) {
        this.Apellido_p = Apellido_p;
    }

    public void setApellido_m(String Apellido_m) {
        this.Apellido_m = Apellido_m;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setValor_auto(double Valor_auto) {
        this.Valor_auto = Valor_auto;
    }

    public void setPorcentajeEnganche(String PorcentajeEnganche) {
        this.PorcentajeEnganche = PorcentajeEnganche;
    }

    public void setEnganche(double Enganche) {
        this.Enganche = Enganche;
    }

    public void setCredito(double Credito) {
        this.Credito = Credito;
    }

    public void setMeses(int Meses) {
        this.Meses = Meses;
    }

    public void setTasa_interes(double Tasa_interes) {
        this.Tasa_interes = Tasa_interes;
    }

    public void setPago_mensual(double Pago_mensual) {
        this.Pago_mensual = Pago_mensual;
    }


}