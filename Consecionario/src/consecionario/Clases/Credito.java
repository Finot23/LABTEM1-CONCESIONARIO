package consecionario.Clases;

public class Credito {
    private String nombre;
    private String apellido_p;
    private String apellido_m;
    private String modelo;
    private String marca;
    private double valor_auto;
    private String porcentajeEnganche;
    private double enganche;
    private double credito;
    private int meses;
    private double tasa_interes;
    private double pago_mensual;

    public Credito(String nombre, String apellido_p, String apellido_m, String modelo, String marca, double valor_auto,
                   String porcentajeEnganche, double enganche, double credito, int meses, double tasa_interes, double pago_mensual) {
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.modelo = modelo;
        this.marca = marca;
        this.valor_auto = valor_auto;
        this.porcentajeEnganche = porcentajeEnganche;
        this.enganche = enganche;
        this.credito = credito;
        this.meses = meses;
        this.tasa_interes = tasa_interes;
        this.pago_mensual = pago_mensual;
    }

    public Credito(Cliente cliente, CatalogoCarros carro) {
        this.nombre = cliente.getNombre();
        this.apellido_p = cliente.getApellidoP();
        this.apellido_m = cliente.getApellidoM();
        this.modelo = carro.getModelo();
        this.marca = carro.getMarca();
        this.valor_auto = carro.getPrecio();
        this.porcentajeEnganche = "10%";
        this.enganche = 0;
        this.credito = 0;
        this.meses = 0;
        this.tasa_interes = 0;
        this.pago_mensual = 0;
    }

    // Getters y setters con tu estilo
    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getapellido_p() {
        return apellido_p;
    }

    public void setapellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getapellido_m() {
        return apellido_m;
    }

    public void setapellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public String getmodelo() {
        return modelo;
    }

    public void setmodelo(String modelo) {
        this.modelo = modelo;
    }

    public String getmarca() {
        return marca;
    }

    public void setmarca(String marca) {
        this.marca = marca;
    }

    public double getvalor_auto() {
        return valor_auto;
    }

    public void setvalor_auto(double valor_auto) {
        this.valor_auto = valor_auto;
    }

    public String getporcentajeEnganche() {
        return porcentajeEnganche;
    }

    public void setporcentajeEnganche(String porcentajeEnganche) {
        this.porcentajeEnganche = porcentajeEnganche;
    }

    public double getenganche() {
        return enganche;
    }

    public void setenganche(double enganche) {
        this.enganche = enganche;
    }

    public double getcredito() {
        return credito;
    }

    public void setcredito(double credito) {
        this.credito = credito;
    }

    public int getmeses() {
        return meses;
    }

    public void setmeses(int meses) {
        this.meses = meses;
    }

    public double gettasa_interes() {
        return tasa_interes;
    }

    public void settasa_interes(double tasa_interes) {
        this.tasa_interes = tasa_interes;
    }

    public double getpago_mensual() {
        return pago_mensual;
    }

    public void setpago_mensual(double pago_mensual) {
        this.pago_mensual = pago_mensual;
    }

    public double calcularEnganche(){
        switch (this.porcentajeEnganche) {
            case "10%":
                enganche = valor_auto * 0.1;
                break;
            case "20%":
                enganche = valor_auto * 0.2;
                break;
            case "30%":
                enganche = valor_auto * 0.3;
                break;
            case "50%":
                enganche = valor_auto * 0.5;
                break;
            default:
                enganche = valor_auto * 0.1;
        }
        return enganche;
    }

    public double creditoAprobado(){
        credito = valor_auto - enganche;
        return credito;
    }

    public double pagoMensual(double credito, int meses) {
    // Asegurarse de que el valor del crédito sea positivo
    if (credito <= 0) {
        throw new IllegalArgumentException("El monto del crédito no puede ser negativo o cero.");
    }

    // Si el crédito es válido, calcular el pago mensual con una fórmula de amortización
    double tasaInteresMensual = tasa_interes / 12; // Convertir la tasa anual a mensual
    double pagoMensual = (credito * tasaInteresMensual) / (1 - Math.pow(1 + tasaInteresMensual, -meses));
    
    return pagoMensual;
}
}



   /* @Override
    public String toString() {
        return "Credito{" + "nombre=" + nombre + ", apellido_p=" + apellido_p + ", apellido_m=" + apellido_m + ", modelo=" + modelo + ", marca=" + marca + ", valor_auto=" + valor_auto + ", enganche=" + enganche + ", credito=" + credito + ", meses=" + meses + ", tasa_interes=" + tasa_interes + ", pago_mensual=" + pago_mensual + '}';
    }
    
    
}*/
