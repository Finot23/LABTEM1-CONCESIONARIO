/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package consecionario.Formularios;
import BD.ConexionBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author andre
 */
public class Catalogo extends javax.swing.JPanel {

    /**
     * Creates new form Catalogo
     */
    public Catalogo() {
        initComponents();
      
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
                fila[2] = rs.getInt("año_fabricacion");
                fila[3] = rs.getDouble("precio");
                fila[4] = rs.getString("color");
                fila[5] = rs.getString("estado");
                fila[6] = rs.getString("Categoria");

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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        cat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        Filtrar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(810, 520));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cat.setText("FormsCatalogos");
        bg.add(cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -20, 150, 100));

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
                "id", "modelo", "año_fabricacion", "precio", "color", "estado", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 420, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hatchback ", "Seadan", "SUV", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        bg.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        Filtrar.setText("Filtrar");
        Filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarActionPerformed(evt);
            }
        });
        bg.add(Filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

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

        String[] categorias = {"Hatchback", "Seadan", "SUV"};
      JComboBox<String> categoriaComboBox = new JComboBox<>(categorias);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void FiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarActionPerformed
       filtrarPorCategoria();
    }//GEN-LAST:event_FiltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Filtrar;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel cat;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
