/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package consecionario.Formularios;

import java.awt.BorderLayout;
import javax.swing.JPanel;


//prueba push

/**
 *
 * @author antoniosalinas
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     * 
     */
    
  
    public Principal(String rolUsuario, String usuario) {
        initComponents();
        this.setLocationRelativeTo(this);
        
        rsscalelabel.RSScaleLabel.setScaleLabel(iconUserMain, "src/consecionario/Imagenes/iconoUsuarioSmall.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(iconCredito, "src/consecionario/Imagenes/iconoCredito.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(iconHistorial, "src/consecionario/Imagenes/iconoHistorial.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(iconHome, "src/consecionario/Imagenes/iconoHome.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(iconSeguro, "src/consecionario/Imagenes/iconoSeguro.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(iconVenta, "src/consecionario/Imagenes/iconoVenta.png");
        
        InitContent();
   
     
        
    //txtBienvenida.setText("Bienvendido de nuevo, " +rolUsuario);
    txtNombreUsuario.setText(""+usuario);    
        
    }

    private void InitContent(){
        
        MostrarJpanel(new InfoUsuario());
        
        
        

    }
    private void MostrarJpanel(JPanel info){
        
        info.setSize(810, 520);
        info.setLocation(0, 0);
        
        jPanelContenido.removeAll();
        jPanelContenido.add(info, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();
    }
 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        iconUserMain = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JLabel();
        jPanelPaginaPrincipal = new javax.swing.JPanel();
        iconHome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanelSeguros = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        iconSeguro = new javax.swing.JLabel();
        jPanelHistorial = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        iconHistorial = new javax.swing.JLabel();
        jPanelCredito = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        iconCredito = new javax.swing.JLabel();
        jPanelVentas = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        iconVenta = new javax.swing.JLabel();
        jPanelContenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(208, 211, 212));

        iconUserMain.setBackground(new java.awt.Color(255, 255, 255));

        txtNombreUsuario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jPanelPaginaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelPaginaPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelPaginaPrincipalMouseClicked(evt);
            }
        });

        iconHome.setText("Página principal");

        jLabel1.setText("Página principal");

        javax.swing.GroupLayout jPanelPaginaPrincipalLayout = new javax.swing.GroupLayout(jPanelPaginaPrincipal);
        jPanelPaginaPrincipal.setLayout(jPanelPaginaPrincipalLayout);
        jPanelPaginaPrincipalLayout.setHorizontalGroup(
            jPanelPaginaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPaginaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconHome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanelPaginaPrincipalLayout.setVerticalGroup(
            jPanelPaginaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPaginaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPaginaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iconHome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelSeguros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelSeguros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelSegurosMouseClicked(evt);
            }
        });

        jLabel2.setText("Seguros");

        iconSeguro.setText("Seguros");

        javax.swing.GroupLayout jPanelSegurosLayout = new javax.swing.GroupLayout(jPanelSeguros);
        jPanelSeguros.setLayout(jPanelSegurosLayout);
        jPanelSegurosLayout.setHorizontalGroup(
            jPanelSegurosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSegurosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanelSegurosLayout.setVerticalGroup(
            jPanelSegurosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSegurosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelSegurosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(iconSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanelHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelHistorialMouseClicked(evt);
            }
        });

        jLabel3.setText("Historial");

        iconHistorial.setText("Historial");

        javax.swing.GroupLayout jPanelHistorialLayout = new javax.swing.GroupLayout(jPanelHistorial);
        jPanelHistorial.setLayout(jPanelHistorialLayout);
        jPanelHistorialLayout.setHorizontalGroup(
            jPanelHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHistorialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanelHistorialLayout.setVerticalGroup(
            jPanelHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHistorialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(iconHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCredito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCreditoMouseClicked(evt);
            }
        });

        jLabel4.setText("Credito");

        iconCredito.setText("Creditos");

        javax.swing.GroupLayout jPanelCreditoLayout = new javax.swing.GroupLayout(jPanelCredito);
        jPanelCredito.setLayout(jPanelCreditoLayout);
        jPanelCreditoLayout.setHorizontalGroup(
            jPanelCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreditoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanelCreditoLayout.setVerticalGroup(
            jPanelCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreditoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iconCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
        );

        jPanelVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelVentasMouseClicked(evt);
            }
        });

        jLabel5.setText("Ventas");

        iconVenta.setText("Ventas");

        javax.swing.GroupLayout jPanelVentasLayout = new javax.swing.GroupLayout(jPanelVentas);
        jPanelVentas.setLayout(jPanelVentasLayout);
        jPanelVentasLayout.setHorizontalGroup(
            jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanelVentasLayout.setVerticalGroup(
            jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(iconVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(iconUserMain, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelPaginaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSeguros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanelCredito, jPanelHistorial, jPanelPaginaPrincipal, jPanelSeguros, jPanelVentas});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconUserMain, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelPaginaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanelSeguros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jPanelHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(jPanelCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jPanelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 560));

        jPanelContenido.setSize(new java.awt.Dimension(810, 520));

        javax.swing.GroupLayout jPanelContenidoLayout = new javax.swing.GroupLayout(jPanelContenido);
        jPanelContenido.setLayout(jPanelContenidoLayout);
        jPanelContenidoLayout.setHorizontalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        jPanelContenidoLayout.setVerticalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 810, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelPaginaPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPaginaPrincipalMouseClicked
        MostrarJpanel(new InfoUsuario());
    }//GEN-LAST:event_jPanelPaginaPrincipalMouseClicked

    private void jPanelSegurosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSegurosMouseClicked
        MostrarJpanel(new Seguros());
    }//GEN-LAST:event_jPanelSegurosMouseClicked

    private void jPanelHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelHistorialMouseClicked
        MostrarJpanel(new Historial());
    }//GEN-LAST:event_jPanelHistorialMouseClicked

    private void jPanelCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCreditoMouseClicked
        MostrarJpanel(new Creditos());
    }//GEN-LAST:event_jPanelCreditoMouseClicked

    private void jPanelVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVentasMouseClicked
        MostrarJpanel(new Ventas());
    }//GEN-LAST:event_jPanelVentasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        }};

    */
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconCredito;
    private javax.swing.JLabel iconHistorial;
    private javax.swing.JLabel iconHome;
    private javax.swing.JLabel iconSeguro;
    private javax.swing.JLabel iconUserMain;
    private javax.swing.JLabel iconVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelCredito;
    private javax.swing.JPanel jPanelHistorial;
    private javax.swing.JPanel jPanelPaginaPrincipal;
    private javax.swing.JPanel jPanelSeguros;
    private javax.swing.JPanel jPanelVentas;
    private javax.swing.JLabel txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
