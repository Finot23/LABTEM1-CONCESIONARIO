/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package consecionario.Formularios;

/**
 *
 * @author antoniosalinas
 */
public class InfoUsuario extends javax.swing.JPanel {

    /**
     * Creates new form InfoUsuario
     */
    public InfoUsuario() {
        initComponents();
    }
    //txtBienvenida.setText("Bienvendido de nuevo, " +rolUsuario);
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IconUser2 = new javax.swing.JLabel();
        txtBienvenida = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(810, 520));

        IconUser2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consecionario/Imagenes/iconoUsuario.png"))); // NOI18N

        txtBienvenida.setBackground(new java.awt.Color(0, 0, 0));
        txtBienvenida.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtBienvenida.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(IconUser2))
                    .addComponent(txtBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(IconUser2)
                .addGap(34, 34, 34)
                .addComponent(txtBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(297, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconUser2;
    private javax.swing.JLabel txtBienvenida;
    // End of variables declaration//GEN-END:variables
}
