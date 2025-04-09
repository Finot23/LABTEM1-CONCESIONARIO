/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package consecionario.Formularios;

import consecionario.RedimencionarImagen;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author Finot
 */
public class CategoriaCarro extends javax.swing.JPanel {
  
    //Inicializa metodo para setear el tamano de la imagen al tamano del label
    public void SetImageLabel (JLabel labelName, String resourcePath){
        
        java.net.URL imgURL = getClass().getResource(resourcePath);
        if (imgURL == null) {
        System.err.println("No se encontró la imagen en: " + resourcePath);
        return;
    }
        ImageIcon imageIcon = new ImageIcon(imgURL);
        Image scaledImage = imageIcon.getImage().getScaledInstance(
        labelName.getWidth(),
        labelName.getHeight(),
        Image.SCALE_SMOOTH
    );

    labelName.setIcon(new ImageIcon(scaledImage));
}
    //inicializa el metodo para cargar la imagen deceada en el label decignado
    public void CargarImagen(){
     SetImageLabel(txtHatchback, "/consecionario/Imagenes/Hatchback.jpg");
     SetImageLabel(txtSedan, "/consecionario/Imagenes/Sedan.jpg");
     SetImageLabel(txtSUV, "/consecionario/Imagenes/SUV.jpg");
       
      
     
}
    /**
     * Creates new form CategoriaCarro
     */
    public CategoriaCarro() {
        initComponents();
        //System.out.println(getClass().getResource("/consecionario/Imagenes/iconoUsuarioSmall.png"));
      
        //Espera a que se carge el label antes de llamar al metodo Cargar imagen
      txtHatchback.addComponentListener(new java.awt.event.ComponentAdapter() {
        @Override
        public void componentResized(java.awt.event.ComponentEvent evt) {
            CargarImagen();
        }
    });

        
         
      
    
    
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHatchback = new javax.swing.JLabel();
        txtSedan = new javax.swing.JLabel();
        txtSUV = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Hatchback");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Sedan");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("SUV");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, -1, -1));

        txtHatchback.setText("jLabel4");
        txtHatchback.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtHatchback.setPreferredSize(new java.awt.Dimension(30, 40));
        txtHatchback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHatchbackMouseClicked(evt);
            }
        });
        bg.add(txtHatchback, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 240, 170));

        txtSedan.setText("jLabel5");
        txtSedan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        bg.add(txtSedan, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 240, 170));

        txtSUV.setText("jLabel6");
        txtSUV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        bg.add(txtSUV, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 240, 170));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Elige el tipo de Coche");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtHatchbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHatchbackMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtHatchbackMouseClicked

  
         
         
        
        //rsscalelabel.RSScaleLabel.setScaleLabel(iconHatchback, "src/consecionario/Imagenes/iconoUsuarioSmall.png");

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel txtHatchback;
    private javax.swing.JLabel txtSUV;
    private javax.swing.JLabel txtSedan;
    // End of variables declaration//GEN-END:variables
}