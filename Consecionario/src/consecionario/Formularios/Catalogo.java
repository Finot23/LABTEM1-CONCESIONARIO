/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package consecionario.Formularios;
import BD.ConexionBD;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author andre
 */
public class Catalogo extends javax.swing.JPanel {
   
  
    
    
    private Catalogo catalogoRef;
    private String imagePath; 
    
    

    /**
     * Creates new form Catalogo
     */
    
    
    
    public void PersonalizarTabla(){
        jTable1.setRowHeight(40); // Altura de cada fila
        jTable1.setGridColor(Color.decode("#00263A")); // Color de las líneas

// Cambiar fuente del contenido
jTable1.setFont(new Font("Segoe UI", Font.PLAIN, 14));

// Cambiar fondo y texto de la tabla
jTable1.setBackground(new Color(245, 245, 245));
jTable1.setForeground(Color.BLACK);

// Encabezados personalizados
JTableHeader header = jTable1.getTableHeader();
header.setFont(new Font("Segoe UI", Font.BOLD, 14));
header.setBackground(new Color(60, 63, 65));
header.setForeground(Color.WHITE);
    }
    private void cargarTodosLosAutos() {
    try {
        Connection conn = ConexionBD.conn();
        if (conn != null) {
            String query = "SELECT * FROM almacen";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0); // Limpiar tabla

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

            conn.close();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar los autos: " + e.getMessage());
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
    public Catalogo(String tipoUsuario,Catalogo catalogoRef) {
        
        initComponents();
        pnlDatosAuto.setVisible(false);
        this.catalogoRef = catalogoRef;
        PersonalizarTabla();
        
        
        if (tipoUsuario.equals("Vendedor")) {
         btnAEauto.setVisible(false);
            jButton1.setVisible(false); // Ocultar panel de administración
   
    }
       
         cargarTodosLosAutos();
    } 
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        bgFiltrosAñadirCarro = new javax.swing.JPanel();
        bgFiltros = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        Filtrar = new javax.swing.JButton();
        lblSeleccionarCategoria = new javax.swing.JLabel();
        bgAgregarCarro = new javax.swing.JPanel();
        almacenAdmin = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnAEauto = new javax.swing.JButton();
        pnlDatosAuto = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        fieldModelo = new javax.swing.JTextField();
        fieldMarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldColor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboEstadoAuto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldValorAuto = new javax.swing.JTextField();
        fieldKm = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fieldAnio = new javax.swing.JTextField();
        btnAgergarImagen = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        pnlBgTabla = new javax.swing.JPanel();
        bgTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(810, 520));
        setLayout(new java.awt.BorderLayout());

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblTitle.setText("Inventario");
        bg.add(lblTitle, java.awt.BorderLayout.NORTH);

        bgFiltrosAñadirCarro.setBackground(new java.awt.Color(255, 255, 255));

        bgFiltros.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hatchback ", "Sedan", "SUV", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        Filtrar.setBackground(new java.awt.Color(255, 153, 51));
        Filtrar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Filtrar.setForeground(new java.awt.Color(0, 0, 0));
        Filtrar.setText("Filtrar");
        Filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarActionPerformed(evt);
            }
        });

        lblSeleccionarCategoria.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblSeleccionarCategoria.setForeground(new java.awt.Color(0, 0, 0));
        lblSeleccionarCategoria.setText("Escoge tu categoria preferida");

        javax.swing.GroupLayout bgFiltrosLayout = new javax.swing.GroupLayout(bgFiltros);
        bgFiltros.setLayout(bgFiltrosLayout);
        bgFiltrosLayout.setHorizontalGroup(
            bgFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Filtrar)
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(bgFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgFiltrosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(bgFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblSeleccionarCategoria)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        bgFiltrosLayout.setVerticalGroup(
            bgFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgFiltrosLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(Filtrar)
                .addContainerGap())
            .addGroup(bgFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgFiltrosLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(lblSeleccionarCategoria)
                    .addGap(14, 14, 14)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(47, Short.MAX_VALUE)))
        );

        bgAgregarCarro.setBackground(new java.awt.Color(255, 255, 255));

        almacenAdmin.setBackground(new java.awt.Color(245, 245, 245));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Eliminar Auto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAEauto.setBackground(new java.awt.Color(255, 153, 51));
        btnAEauto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnAEauto.setForeground(new java.awt.Color(0, 0, 0));
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
                .addGap(19, 19, 19)
                .addGroup(almacenAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAEauto)
                    .addComponent(jButton1))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        almacenAdminLayout.setVerticalGroup(
            almacenAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, almacenAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAEauto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );

        pnlDatosAuto.setBackground(new java.awt.Color(245, 245, 245));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DATOS DEL AUTO");

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Modelo");

        fieldModelo.setPreferredSize(new java.awt.Dimension(120, 22));

        fieldMarca.setPreferredSize(new java.awt.Dimension(120, 22));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Marca");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Precio");

        fieldColor.setPreferredSize(new java.awt.Dimension(70, 22));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Color");

        comboTipo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        comboTipo.setForeground(new java.awt.Color(0, 0, 0));
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hatchback", "Sedan", "SUV" }));
        comboTipo.setPreferredSize(new java.awt.Dimension(120, 22));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Categoria");

        comboEstadoAuto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        comboEstadoAuto.setForeground(new java.awt.Color(0, 0, 0));
        comboEstadoAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo", "Usado" }));
        comboEstadoAuto.setPreferredSize(new java.awt.Dimension(120, 22));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Estado del auto");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Año");

        fieldValorAuto.setPreferredSize(new java.awt.Dimension(70, 22));

        fieldKm.setPreferredSize(new java.awt.Dimension(40, 22));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Km");

        fieldAnio.setPreferredSize(new java.awt.Dimension(45, 22));
        fieldAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAnioActionPerformed(evt);
            }
        });

        btnAgergarImagen.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnAgergarImagen.setForeground(new java.awt.Color(0, 0, 0));
        btnAgergarImagen.setText("Agregar imagen");
        btnAgergarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgergarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel8))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(fieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fieldValorAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(comboEstadoAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAgergarImagen))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldValorAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEstadoAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgergarImagen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregar.setBackground(new java.awt.Color(255, 153, 51));
        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosAutoLayout = new javax.swing.GroupLayout(pnlDatosAuto);
        pnlDatosAuto.setLayout(pnlDatosAutoLayout);
        pnlDatosAutoLayout.setHorizontalGroup(
            pnlDatosAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosAutoLayout.createSequentialGroup()
                .addGroup(pnlDatosAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosAutoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(pnlDatosAutoLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnAgregar))
                    .addGroup(pnlDatosAutoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlDatosAutoLayout.setVerticalGroup(
            pnlDatosAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosAutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregar)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgAgregarCarroLayout = new javax.swing.GroupLayout(bgAgregarCarro);
        bgAgregarCarro.setLayout(bgAgregarCarroLayout);
        bgAgregarCarroLayout.setHorizontalGroup(
            bgAgregarCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
            .addGroup(bgAgregarCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgAgregarCarroLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(bgAgregarCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(almacenAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlDatosAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        bgAgregarCarroLayout.setVerticalGroup(
            bgAgregarCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
            .addGroup(bgAgregarCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgAgregarCarroLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(almacenAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(pnlDatosAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout bgFiltrosAñadirCarroLayout = new javax.swing.GroupLayout(bgFiltrosAñadirCarro);
        bgFiltrosAñadirCarro.setLayout(bgFiltrosAñadirCarroLayout);
        bgFiltrosAñadirCarroLayout.setHorizontalGroup(
            bgFiltrosAñadirCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgFiltrosAñadirCarroLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(bgFiltrosAñadirCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bgAgregarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bgFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgFiltrosAñadirCarroLayout.setVerticalGroup(
            bgFiltrosAñadirCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgFiltrosAñadirCarroLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(bgFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bgAgregarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        bg.add(bgFiltrosAñadirCarro, java.awt.BorderLayout.WEST);

        pnlBgTabla.setBackground(new java.awt.Color(255, 255, 255));

        bgTabla.setBackground(new java.awt.Color(255, 255, 255));

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
                "ID", "Modelo", "Año de Fabricación", "Precio", "Color", "Estado", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout bgTablaLayout = new javax.swing.GroupLayout(bgTabla);
        bgTabla.setLayout(bgTablaLayout);
        bgTablaLayout.setHorizontalGroup(
            bgTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgTablaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bgTablaLayout.setVerticalGroup(
            bgTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgTablaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlBgTablaLayout = new javax.swing.GroupLayout(pnlBgTabla);
        pnlBgTabla.setLayout(pnlBgTablaLayout);
        pnlBgTablaLayout.setHorizontalGroup(
            pnlBgTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBgTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bgTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(557, 557, 557))
        );
        pnlBgTablaLayout.setVerticalGroup(
            pnlBgTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBgTablaLayout.createSequentialGroup()
                .addComponent(bgTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 59, Short.MAX_VALUE))
        );

        bg.add(pnlBgTabla, java.awt.BorderLayout.CENTER);

        add(bg, java.awt.BorderLayout.CENTER);
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
        
        pnlDatosAuto.setVisible(true);
        //InterfaceEA dialog = new InterfaceEA(this); 
        //dialog.setCatalogoReference(this);
        //dialog.setVisible(true);
    }//GEN-LAST:event_btnAEautoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        eliminarAutoSeleccionado();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fieldAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAnioActionPerformed

    private void btnAgergarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgergarImagenActionPerformed
        // TODO add your handling code here:
        // Crear un JFileChooser para seleccionar la imagen
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Imagen");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de Imagen", "jpg", "jpeg", "png"));

        // Mostrar el cuadro de diálogo
        int result = fileChooser.showOpenDialog(this);

        // Si se selecciona una imagen, realizar el proceso
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File selectedFile = fileChooser.getSelectedFile();

            // Definir el destino donde guardar la imagen en el proyecto
            String projectImagesPath = "src/consecionario/Imagenes/"; // Asegúrate de que esta carpeta exista
            File destinationFile = new File(projectImagesPath + selectedFile.getName());

            try {
                // Copiar la imagen seleccionada a la carpeta del proyecto
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(this, "Imagen guardada con éxito.");

                // Extraer la ruta para subirla a la base de datos
                String imagePath = destinationFile.getAbsolutePath();

                // Aquí podrías guardar la ruta en una variable o directamente en la base de datos
                // Por ejemplo, guardar la ruta en un campo de texto:
                JOptionPane.showMessageDialog(this, "Imagen seleccionada: " + imagePath);
                // O también podrías usarla al momento de insertar en la base de datos como se muestra más abajo
                this.imagePath = "/consecionario/imagenes/" + selectedFile.getName();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al guardar la imagen: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnAgergarImagenActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (fieldMarca.getText().isEmpty() || fieldModelo.getText().isEmpty() || fieldAnio.getText().isEmpty() ||
            fieldValorAuto.getText().isEmpty() || fieldColor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos obligatorios.");
            return;
        }

        try {
            java.sql.Connection conn = ConexionBD.conn();
            String sql = "INSERT INTO almacen (marca, modelo, anio_fabricacion,no_serie, precio, color, estado, categoria, imagen, descripcion,kilometraje) VALUES (? ,? ,?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, fieldMarca.getText());
            ps.setString(2, fieldModelo.getText());
            ps.setString(3, fieldAnio.getText());
            ps.setString(4, "3N1AB7AP3KY215678");
            ps.setInt(5, Integer.parseInt(fieldValorAuto.getText()));
            ps.setString(6, fieldColor.getText());
            ps.setString(7, comboEstadoAuto.getSelectedItem().toString());
            ps.setString(8, comboTipo.getSelectedItem().toString());
            ps.setString(9, imagePath); // imagen vacía
            ps.setString(10, ""); // descripción vacía
            ps.setInt(11, Integer.parseInt(fieldKm.getText()));

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Auto agregado exitosamente.");

            if (catalogoRef != null) {
                catalogoRef.recargarTabla();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar auto: " + e.getMessage());
        }
        pnlDatosAuto.setVisible(false);
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Filtrar;
    private javax.swing.JPanel almacenAdmin;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel bgAgregarCarro;
    private javax.swing.JPanel bgFiltros;
    private javax.swing.JPanel bgFiltrosAñadirCarro;
    private javax.swing.JPanel bgTabla;
    private javax.swing.JButton btnAEauto;
    private javax.swing.JButton btnAgergarImagen;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> comboEstadoAuto;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JTextField fieldAnio;
    private javax.swing.JTextField fieldColor;
    private javax.swing.JTextField fieldKm;
    private javax.swing.JTextField fieldMarca;
    private javax.swing.JTextField fieldModelo;
    private javax.swing.JTextField fieldValorAuto;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblSeleccionarCategoria;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBgTabla;
    private javax.swing.JPanel pnlDatosAuto;
    // End of variables declaration//GEN-END:variables
}
