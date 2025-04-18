package consecionario.Formularios;

import BD.CreditosBD;
import consecionario.Clases.CatalogoCarros;
import consecionario.Clases.Cliente;
import consecionario.Clases.Credito;
import javax.swing.JOptionPane;

public class Creditos extends javax.swing.JPanel {
    
    private Cliente cliente;
    private CatalogoCarros carro;

    public Creditos() {
        
        initComponents();
        cargarDatosClienteyAuto(); 
        throw new UnsupportedOperationException("Usa el constructor con parámetros");
    }
    
    public Creditos(Cliente cliente, CatalogoCarros carro) {
        initComponents();
        this.cliente = cliente;
        this.carro = carro;
        cargarDatosClienteyAuto(); // Esta función pone la info en las etiquetas
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        etInteres = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboPorcentaje = new javax.swing.JComboBox<>();
        etEnganche = new javax.swing.JLabel();
        etCredito = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboMeses = new javax.swing.JComboBox<>();
        etPagoMensual = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        etValorAuto = new javax.swing.JLabel();
        etCliente = new javax.swing.JLabel();
        etAuto = new javax.swing.JLabel();
        btnAprobarCredito = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(550, 270));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("FORM CREDITOS");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(197, 0, 57));

        etInteres.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Porcentaje de Enganche");

        comboPorcentaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10%", "20%", "30%", "50%" }));
        comboPorcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPorcentajeActionPerformed(evt);
            }
        });

        etEnganche.setText("Pago de Enganche:");

        etCredito.setText("Monto de Credito:");

        jLabel7.setText("Tasa de Interes Anual:");

        jLabel8.setText("Plazo (Numero de meses)");

        comboMeses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "24", "36", "48", "60" }));
        comboMeses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMesesActionPerformed(evt);
            }
        });

        etPagoMensual.setText("Pago Mensual:");

        javax.swing.GroupLayout etInteresLayout = new javax.swing.GroupLayout(etInteres);
        etInteres.setLayout(etInteresLayout);
        etInteresLayout.setHorizontalGroup(
            etInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(etInteresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(etInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etCredito)
                    .addGroup(etInteresLayout.createSequentialGroup()
                        .addGroup(etInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(etInteresLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(30, 30, 30)
                                .addComponent(comboPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(etInteresLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(etInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(etEnganche)))
                    .addComponent(etPagoMensual))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        etInteresLayout.setVerticalGroup(
            etInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(etInteresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(etInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etEnganche))
                .addGap(18, 18, 18)
                .addComponent(etCredito)
                .addGap(18, 18, 18)
                .addGroup(etInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etPagoMensual)
                .addGap(10, 10, 10))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        etValorAuto.setText("Precio del Auto:");

        etCliente.setText("Cliente:");

        etAuto.setText("Automovil:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etValorAuto)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(etCliente)
                        .addGap(176, 176, 176)
                        .addComponent(etAuto)))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etCliente)
                    .addComponent(etAuto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etValorAuto)
                .addContainerGap())
        );

        btnAprobarCredito.setBackground(new java.awt.Color(255, 255, 51));
        btnAprobarCredito.setText("Aprobar Credito");
        btnAprobarCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprobarCreditoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAprobarCredito)
                .addGap(224, 224, 224))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etInteres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAprobarCredito)
                .addGap(6, 6, 6))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 540, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cargarDatosClienteyAuto() {
        etCliente.setText("Cliente: " + cliente.getNombre() + " " + cliente.getApellidoP());
        etAuto.setText("Automóvil: " + carro.getMarca() + " " + carro.getModelo());
        etValorAuto.setText("Precio del auto: $" + carro.getPrecio());
}
    
    private void comboMesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMesesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMesesActionPerformed

    private void btnAprobarCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprobarCreditoActionPerformed
        // TODO add your handling code here:
        String porcentajeSeleccionado = comboPorcentaje.getSelectedItem().toString();
        int meses = Integer.parseInt(comboMeses.getSelectedItem().toString());

        Credito credito = new Credito(cliente, carro);
        credito.setporcentajeEnganche(porcentajeSeleccionado); // ✅ CORREGIDO
        credito.setvalor_auto(carro.getPrecio()); // ✅ tu setter usa "setvalor_auto"

        double enganche = credito.calcularEnganche();
        double montoCredito = credito.creditoAprobado();

        credito.setmeses(meses);
        double tasaAnual = 0.15;
        credito.settasa_interes(tasaAnual); // ✅ CORREGIDO

        double pagoMensual = credito.pagoMensual(montoCredito, meses);
        credito.setpago_mensual(pagoMensual);

        System.out.println("Enganche: " + enganche);
        System.out.println("Monto del Crédito: " + montoCredito);
        System.out.println("Pago mensual: " + pagoMensual);

        etEnganche.setText("Enganche: $" + String.format("%.2f", enganche));
        etCredito.setText("Monto del crédito: $" + String.format("%.2f", montoCredito));
        etPagoMensual.setText("Pago mensual: $" + String.format("%.2f", pagoMensual));

        CreditosBD dao = new CreditosBD();
        boolean registrado = dao.RegistrarCredito(credito);

        if (registrado) {
            JOptionPane.showMessageDialog(this, "Crédito aprobado y registrado con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el crédito.");
        }
    }//GEN-LAST:event_btnAprobarCreditoActionPerformed

    private void comboPorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPorcentajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPorcentajeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAprobarCredito;
    private javax.swing.JComboBox<String> comboMeses;
    private javax.swing.JComboBox<String> comboPorcentaje;
    private javax.swing.JLabel etAuto;
    private javax.swing.JLabel etCliente;
    private javax.swing.JLabel etCredito;
    private javax.swing.JLabel etEnganche;
    private javax.swing.JPanel etInteres;
    private javax.swing.JLabel etPagoMensual;
    private javax.swing.JLabel etValorAuto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
