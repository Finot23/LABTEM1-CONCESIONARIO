/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package consecionario.Formularios;
import BD.ConexionBD;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.table.DefaultTableModel;
/**
 *
 * @author andre
 */
public class Catalogo extends javax.swing.JPanel {
    
    

    /**
     * Creates new form Catalogo
     */
    public Catalogo(String tipoUsuario) {
        
        initComponents();
         if (tipoUsuario.equals("Vendedor")) {
            almacenAdmin.setVisible(false); // Ocultar el panel para vendedores
        } else {
            almacenAdmin.setVisible(true); // Mostrar el panel para administradores
        }
       
    } 
    
    private void filtrarPorCategoria() {
    try {
        Connection conn = ConexionBD.conn();
        if (conn != null) {
              String categoria = (String) jComboBox1.getSelectedItem();

            String query = "SELECT * FROM almacen WHERE Categoria = '" + categoria + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);

            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("modelo");
                fila[2] = rs.getInt("anio_fabricacion");
                fila[3] = rs.getDouble("precio");
                fila[4] = rs.getString("color");
                fila[5] = rs.getString("estado");
                fila[6] = rs.getString("categoria");

                modelo.addRow(fila);
            }

            conn.close(); // Cerrar la conexión
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al filtrar autos: " + e.getMessage());
    }
}
    
    private void eliminarAutoSeleccionado() {
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor selecciona un auto para eliminar.");
        return;
    }

    int id = (int) jTable1.getValueAt(filaSeleccionada, 0);

    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este auto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
    if (confirmacion != JOptionPane.YES_OPTION) {
        return;
    }

    try {
        Connection conn = ConexionBD.conn();
        String sql = "DELETE FROM almacen WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(this, "Auto eliminado correctamente.");

            // 🔁 Recargar la tabla
            recargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el auto.");
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar el auto: " + e.getMessage());
    }
}
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        cat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        Filtrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        almacenAdmin = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnAEauto = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(810, 520));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cat.setText("ALMACEN");
        bg.add(cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, -30, 150, 100));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "modelo", "anio_fabricacion", "precio", "color", "estado", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 480, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hatchback ", "Sedan", "SUV", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        bg.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        Filtrar.setText("Filtrar");
        Filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarActionPerformed(evt);
            }
        });
        bg.add(Filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, -1));

        jLabel1.setText("Escoge tu categoria preferida");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, -1));

        almacenAdmin.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Eliminar Auto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAEauto.setText("Agregar Auto");
        btnAEauto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAEautoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout almacenAdminLayout = new javax.swing.GroupLayout(almacenAdmin);
        almacenAdmin.setLayout(almacenAdminLayout);
        almacenAdminLayout.setHorizontalGroup(
            almacenAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(almacenAdminLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(almacenAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAEauto)
                    .addComponent(jButton1))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        almacenAdminLayout.setVerticalGroup(
            almacenAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, almacenAdminLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(btnAEauto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );

        bg.add(almacenAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 230, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        String[] categorias = {"Hatchback", "Sedan", "SUV"};
      JComboBox<String> categoriaComboBox = new JComboBox<>(categorias);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void FiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarActionPerformed
       filtrarPorCategoria();
    }//GEN-LAST:event_FiltrarActionPerformed

    public void recargarTabla() {
    filtrarPorCategoria(); // ya tienes este método que llena la JTable
}
    
    private void btnAEautoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAEautoActionPerformed
        // TODO add your handling code here:
        InterfaceEA dialog = new InterfaceEA(this); 
        //dialog.setCatalogoReference(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAEautoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        eliminarAutoSeleccionado();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Filtrar;
    private javax.swing.JPanel almacenAdmin;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAEauto;
    private javax.swing.JLabel cat;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
