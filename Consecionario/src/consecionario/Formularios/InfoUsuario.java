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

        gb = new javax.swing.JPanel();
        IconUser2 = new javax.swing.JLabel();
        txtBienvenida = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(810, 520));

        gb.setBackground(new java.awt.Color(255, 255, 255));
        gb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IconUser2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consecionario/Imagenes/iconoUsuario.png"))); // NOI18N
        gb.add(IconUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 6, -1, -1));

        txtBienvenida.setBackground(new java.awt.Color(0, 0, 0));
        txtBienvenida.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtBienvenida.setForeground(new java.awt.Color(0, 0, 0));
        gb.add(txtBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 136, 540, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconUser2;
    private javax.swing.JPanel gb;
    private javax.swing.JLabel txtBienvenida;
    // End of variables declaration//GEN-END:variables
}
