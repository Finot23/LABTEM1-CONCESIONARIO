/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package consecionario.Formularios;


import BD.ClienteDB;
import BD.ConexionBD;

import consecionario.Clases.AdministradorPanel;
import consecionario.Clases.CatalogoCarros;
import consecionario.Clases.Cliente;
import consecionario.Clases.GeneradorPDF;
import java.sql.Connection;
import consecionario.Formularios.Principal;
import consecionario.Formularios.Seguros;
import java.awt.Color;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author antoniosalinas
 */

public class Ventas extends javax.swing.JPanel {
    
     private void registrarHistorial(Cliente cliente, String tipoDocumento, String rutaArchivo) {
    Connection con = ConexionBD.conn();
    
    if (con != null) {
        try {
            String sql = "INSERT INTO historial_documentos (id_cliente, nombre_cliente, tipo_documento, ruta_archivo, fecha_registro) VALUES (?, ?, ?, ?, NOW())";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNombre() + " " + cliente.getApellidoP() + " " + cliente.getApellidoM());
            ps.setString(3, tipoDocumento);
            ps.setString(4, rutaArchivo);
            
            ps.executeUpdate();
            ps.close();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar historial: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos para registrar historial.");
    }
    }
     
    private CatalogoCarros carroSeleccionado;
   

    String placeholderApellidoP = "Apellido Paterno";
    String placeholderApellidoM ="Apellido Materno";
    String placeholderNombre ="Nombre (s)";
    String placeholderCURP = "CURP";
    String placeholderEdad = "Edad";
    String placeholderLicencia = "No. Licencia";
    String placeholderCorreo ="Correo Electrónico";
    String placeholderTelefono ="Teléfono Celular";
    String placeholderCalle ="Calle";
    String placeholderColonia ="Colonia";
    String placeholderMunicipio ="Población, Alcaldía o Municipio";
    
    String placeholderEstado ="Estado";
    String placeholderCP ="Código Postal";
    String placeholderMarca ="Marca";
    String placeholderModelo ="Modelo";
    String placeholderTipo ="Tipo";
    String placeholderColorCarro ="Color";
    String placeholderAnio ="Año";
    String placeholderEstados ="Condición";
    String placeholderNoSerie = "Número de Serie";
    
    Color placeholderColor= Color.GRAY;
    Color normalColor = Color.BLACK;
   
    private JPanel jPanelContenido;
    

 public Ventas() {
        initComponents();
        
        txtApellidoP.setText(placeholderApellidoP);
        txtApellidoP.setForeground(placeholderColor);
        
        txtApellidoM.setText(placeholderApellidoM);
        txtApellidoM.setForeground(placeholderColor);
        
        txtNombreCliente.setText(placeholderNombre);
        txtNombreCliente.setForeground(placeholderColor);
        
        txtCURP.setText(placeholderCURP);
        txtCURP.setForeground(placeholderColor);
        
        txtEdad.setText(placeholderEdad);
        txtEdad.setForeground(placeholderColor);
        
        txtNoLicencia.setText(placeholderLicencia);
        txtNoLicencia.setForeground(placeholderColor);
        
        txtTelefonoCliente.setText(placeholderTelefono);
        txtTelefonoCliente.setForeground(placeholderColor);
        
        txtCalle.setText(placeholderCalle);
        txtCalle.setForeground(placeholderColor);
        
        txtColonia.setText(placeholderColonia);
        txtColonia.setForeground(placeholderColor);
        
        txtCorreo.setText(placeholderCorreo);
        txtCorreo.setForeground(placeholderColor);
                
        txtMunicipio.setText(placeholderMunicipio);
        txtMunicipio.setForeground(placeholderColor);
        
       
        txtEstado.setText(placeholderEstado);
        txtEstado.setForeground(placeholderColor);
        
        txtCP.setText(placeholderCP);
        txtCP.setForeground(placeholderColor);
        
        txtMarca.setText(placeholderMarca);
        txtMarca.setForeground(placeholderColor);
        
        txtModelo.setText(placeholderModelo);
        txtModelo.setForeground(placeholderColor);
        
        txtTipoCarro.setText(placeholderTipo);
        txtTipoCarro.setForeground(placeholderColor);
        
        txtColorCarro.setText(placeholderColorCarro);
        txtColorCarro.setForeground(placeholderColor);
        
        txtAnioCarro.setText(placeholderAnio);
        txtAnioCarro.setForeground(placeholderColor);
        
        txtEstadoCarro.setText(placeholderEstados);
        txtEstadoCarro.setForeground(placeholderColor);
        
        txtNoSerie.setText(placeholderNoSerie);
        txtNoSerie.setForeground(placeholderColor);
       txtEdad.setInputVerifier(new InputVerifier() {
        @Override
        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;
            String text = textField.getText();
            try {
                if (text.isEmpty() || Integer.parseInt(text) > 0) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "La edad debe ser un número positivo.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese una edad válida (número).", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        @Override
        public boolean shouldYieldFocus(JComponent input) {
            return verify(input);
        }
    });

    } 
    
    public Ventas(JPanel jPanelContenido) {
        this.jPanelContenido = jPanelContenido;
    }   
    private DecimalFormat df = new DecimalFormat("#,##0.00");

    public Ventas(CatalogoCarros carro) {
    initComponents();
    this.carroSeleccionado = carro;
    
    txtMarca.setText(carro.getMarca());
    txtModelo.setText(carro.getModelo());
    txtColorCarro.setText(carro.getColor());
    txtEstadoCarro.setText(carro.getEstado());
    txtTipoCarro.setText(carro.getCategoria());
    txtAnioCarro.setText(String.valueOf(carro.getAnioFabricacion()));
    
     txtPrecioCarro.setText(df.format(carro.getPrecio()));

    txtNoSerie.setText(String.valueOf(carro.getNoSerie()));

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
        lblSolicitudCompra = new javax.swing.JLabel();
        jPanelDatosCliente = new javax.swing.JPanel();
        bgDatosComprador = new javax.swing.JPanel();
        lblDatosComprador = new javax.swing.JLabel();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtCURP = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cbGenero = new javax.swing.JComboBox<>();
        txtEdad = new javax.swing.JTextField();
        txtNoLicencia = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        jPanelDireccion = new javax.swing.JPanel();
        bgDomicilio = new javax.swing.JPanel();
        lblDomicilio = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtMunicipio = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtCP = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JPanel();
        bgCarro = new javax.swing.JPanel();
        lblCarro = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtTipoCarro = new javax.swing.JTextField();
        txtColorCarro = new javax.swing.JTextField();
        txtAnioCarro = new javax.swing.JTextField();
        txtEstadoCarro = new javax.swing.JTextField();
        txtPrecioCarro = new javax.swing.JTextField();
        txtNoSerie = new javax.swing.JTextField();
        btnContinuar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(834, 768));

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bg.setMinimumSize(new java.awt.Dimension(1024, 768));
        bg.setPreferredSize(new java.awt.Dimension(834, 768));

        lblSolicitudCompra.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblSolicitudCompra.setForeground(new java.awt.Color(0, 38, 58));
        lblSolicitudCompra.setText("Solicitud de compra");

        jPanelDatosCliente.setBackground(new java.awt.Color(245, 245, 245));
        jPanelDatosCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 38, 58), 3));

        bgDatosComprador.setBackground(new java.awt.Color(0, 38, 58));
        bgDatosComprador.setForeground(new java.awt.Color(255, 255, 255));
        bgDatosComprador.setFont(new java.awt.Font("Roboto", 1, 8)); // NOI18N

        lblDatosComprador.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblDatosComprador.setForeground(new java.awt.Color(255, 255, 255));
        lblDatosComprador.setText("DATOS DEL COMPRADOR");

        javax.swing.GroupLayout bgDatosCompradorLayout = new javax.swing.GroupLayout(bgDatosComprador);
        bgDatosComprador.setLayout(bgDatosCompradorLayout);
        bgDatosCompradorLayout.setHorizontalGroup(
            bgDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgDatosCompradorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatosComprador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgDatosCompradorLayout.setVerticalGroup(
            bgDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgDatosCompradorLayout.createSequentialGroup()
                .addComponent(lblDatosComprador)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        txtApellidoP.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtApellidoP.setForeground(new java.awt.Color(153, 153, 153));
        txtApellidoP.setText("Apellido Paterno");
        txtApellidoP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidoPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidoPFocusLost(evt);
            }
        });
        txtApellidoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPActionPerformed(evt);
            }
        });

        txtApellidoM.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtApellidoM.setForeground(new java.awt.Color(153, 153, 153));
        txtApellidoM.setText("Apellido Materno");
        txtApellidoM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidoMFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidoMFocusLost(evt);
            }
        });
        txtApellidoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMActionPerformed(evt);
            }
        });

        txtNombreCliente.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtNombreCliente.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreCliente.setText("Nombre (s)");
        txtNombreCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreClienteFocusLost(evt);
            }
        });
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });

        txtCURP.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtCURP.setForeground(new java.awt.Color(153, 153, 153));
        txtCURP.setText("CURP");
        txtCURP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCURPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCURPFocusLost(evt);
            }
        });
        txtCURP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCURPActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 38, 58));
        jSeparator1.setForeground(new java.awt.Color(0, 38, 58));

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Género", "Masculino", "Femenino" }));
        cbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGeneroActionPerformed(evt);
            }
        });

        txtEdad.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(153, 153, 153));
        txtEdad.setText("Edad");
        txtEdad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEdadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEdadFocusLost(evt);
            }
        });

        txtNoLicencia.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtNoLicencia.setForeground(new java.awt.Color(153, 153, 153));
        txtNoLicencia.setText("No. Licencia");
        txtNoLicencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNoLicenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNoLicenciaFocusLost(evt);
            }
        });

        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(153, 153, 153));
        txtCorreo.setText("Correo Electrónico");
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });

        txtTelefonoCliente.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtTelefonoCliente.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefonoCliente.setText("Teléfono Celular");
        txtTelefonoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoClienteFocusLost(evt);
            }
        });
        txtTelefonoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosClienteLayout = new javax.swing.GroupLayout(jPanelDatosCliente);
        jPanelDatosCliente.setLayout(jPanelDatosClienteLayout);
        jPanelDatosClienteLayout.setHorizontalGroup(
            jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgDatosComprador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(txtApellidoP)
                        .addGap(18, 18, 18)
                        .addComponent(txtApellidoM)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreCliente)
                        .addGap(18, 18, 18)
                        .addComponent(txtCURP)
                        .addGap(149, 149, 149))
                    .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(cbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEdad)
                        .addGap(18, 18, 18)
                        .addComponent(txtNoLicencia)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorreo)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefonoCliente)
                        .addGap(27, 27, 27))))
        );
        jPanelDatosClienteLayout.setVerticalGroup(
            jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                .addComponent(bgDatosComprador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jPanelDireccion.setBackground(new java.awt.Color(245, 245, 245));
        jPanelDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 38, 58), 3));

        bgDomicilio.setBackground(new java.awt.Color(0, 38, 58));
        bgDomicilio.setForeground(new java.awt.Color(255, 255, 255));
        bgDomicilio.setFont(new java.awt.Font("Roboto", 1, 8)); // NOI18N

        lblDomicilio.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblDomicilio.setForeground(new java.awt.Color(255, 255, 255));
        lblDomicilio.setText("DOMICILIO");

        javax.swing.GroupLayout bgDomicilioLayout = new javax.swing.GroupLayout(bgDomicilio);
        bgDomicilio.setLayout(bgDomicilioLayout);
        bgDomicilioLayout.setHorizontalGroup(
            bgDomicilioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgDomicilioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDomicilio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgDomicilioLayout.setVerticalGroup(
            bgDomicilioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgDomicilioLayout.createSequentialGroup()
                .addComponent(lblDomicilio)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        txtCalle.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtCalle.setForeground(new java.awt.Color(153, 153, 153));
        txtCalle.setText("Calle");
        txtCalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCalleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCalleFocusLost(evt);
            }
        });

        txtColonia.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtColonia.setForeground(new java.awt.Color(153, 153, 153));
        txtColonia.setText("Colonia");
        txtColonia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtColoniaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtColoniaFocusLost(evt);
            }
        });
        txtColonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColoniaActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 38, 58));
        jSeparator2.setForeground(new java.awt.Color(0, 38, 58));

        txtMunicipio.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtMunicipio.setForeground(new java.awt.Color(153, 153, 153));
        txtMunicipio.setText("Población, Alcaldía o Municipio");
        txtMunicipio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMunicipioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMunicipioFocusLost(evt);
            }
        });
        txtMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMunicipioActionPerformed(evt);
            }
        });

        txtEstado.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtEstado.setForeground(new java.awt.Color(153, 153, 153));
        txtEstado.setText("Estado");
        txtEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEstadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEstadoFocusLost(evt);
            }
        });
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        txtCP.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtCP.setForeground(new java.awt.Color(153, 153, 153));
        txtCP.setText("Código Postal");
        txtCP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCPFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanelDireccionLayout = new javax.swing.GroupLayout(jPanelDireccion);
        jPanelDireccion.setLayout(jPanelDireccionLayout);
        jPanelDireccionLayout.setHorizontalGroup(
            jPanelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanelDireccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDireccionLayout.createSequentialGroup()
                        .addComponent(txtCalle)
                        .addGap(22, 22, 22)
                        .addComponent(txtColonia))
                    .addGroup(jPanelDireccionLayout.createSequentialGroup()
                        .addComponent(txtMunicipio, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                        .addGap(57, 57, 57)
                        .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addGap(53, 53, 53)
                        .addComponent(txtCP, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                        .addGap(354, 354, 354)))
                .addContainerGap())
        );
        jPanelDireccionLayout.setVerticalGroup(
            jPanelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDireccionLayout.createSequentialGroup()
                .addComponent(bgDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        txtPrecio.setBackground(new java.awt.Color(245, 245, 245));
        txtPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 38, 58), 3));

        bgCarro.setBackground(new java.awt.Color(0, 38, 58));
        bgCarro.setForeground(new java.awt.Color(255, 255, 255));
        bgCarro.setFont(new java.awt.Font("Roboto", 1, 8)); // NOI18N

        lblCarro.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblCarro.setForeground(new java.awt.Color(255, 255, 255));
        lblCarro.setText("DATOS DEL VEHÍCULO");

        javax.swing.GroupLayout bgCarroLayout = new javax.swing.GroupLayout(bgCarro);
        bgCarro.setLayout(bgCarroLayout);
        bgCarroLayout.setHorizontalGroup(
            bgCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgCarroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCarro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgCarroLayout.setVerticalGroup(
            bgCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgCarroLayout.createSequentialGroup()
                .addComponent(lblCarro)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        txtMarca.setEditable(false);
        txtMarca.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtMarca.setText("Marca");
        txtMarca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMarcaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMarcaFocusLost(evt);
            }
        });

        txtModelo.setEditable(false);
        txtModelo.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtModelo.setText("Modelo");
        txtModelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtModeloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtModeloFocusLost(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(0, 38, 58));
        jSeparator3.setForeground(new java.awt.Color(0, 38, 58));

        txtTipoCarro.setEditable(false);
        txtTipoCarro.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtTipoCarro.setText("Tipo");
        txtTipoCarro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTipoCarroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTipoCarroFocusLost(evt);
            }
        });
        txtTipoCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoCarroActionPerformed(evt);
            }
        });

        txtColorCarro.setEditable(false);
        txtColorCarro.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtColorCarro.setText("Color");
        txtColorCarro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtColorCarroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtColorCarroFocusLost(evt);
            }
        });

        txtAnioCarro.setEditable(false);
        txtAnioCarro.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtAnioCarro.setText("Año");
        txtAnioCarro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAnioCarroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAnioCarroFocusLost(evt);
            }
        });
        txtAnioCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioCarroActionPerformed(evt);
            }
        });

        txtEstadoCarro.setEditable(false);
        txtEstadoCarro.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtEstadoCarro.setText("Condición");
        txtEstadoCarro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEstadoCarroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEstadoCarroFocusLost(evt);
            }
        });

        txtPrecioCarro.setEditable(false);
        txtPrecioCarro.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtPrecioCarro.setText("Precio");
        txtPrecioCarro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioCarroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioCarroFocusLost(evt);
            }
        });

        txtNoSerie.setEditable(false);
        txtNoSerie.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtNoSerie.setText("Numero de Serie");
        txtNoSerie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNoSerieFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNoSerieFocusLost(evt);
            }
        });
        txtNoSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoSerieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtPrecioLayout = new javax.swing.GroupLayout(txtPrecio);
        txtPrecio.setLayout(txtPrecioLayout);
        txtPrecioLayout.setHorizontalGroup(
            txtPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgCarro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(txtPrecioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtPrecioLayout.createSequentialGroup()
                        .addComponent(txtMarca)
                        .addGap(32, 32, 32)
                        .addComponent(txtModelo)
                        .addGap(31, 31, 31)
                        .addComponent(txtTipoCarro)
                        .addGap(46, 46, 46)
                        .addComponent(txtColorCarro)
                        .addGap(30, 30, 30))
                    .addGroup(txtPrecioLayout.createSequentialGroup()
                        .addComponent(txtAnioCarro)
                        .addGap(113, 113, 113)
                        .addComponent(txtEstadoCarro)
                        .addGap(88, 88, 88)
                        .addComponent(txtPrecioCarro)
                        .addGap(34, 34, 34)
                        .addComponent(txtNoSerie)))
                .addGap(231, 231, 231))
        );
        txtPrecioLayout.setVerticalGroup(
            txtPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtPrecioLayout.createSequentialGroup()
                .addComponent(bgCarro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColorCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnioCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        btnContinuar.setBackground(new java.awt.Color(255, 153, 51));
        btnContinuar.setForeground(new java.awt.Color(0, 38, 58));
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(204, 204, 204))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(btnContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(424, 424, 424))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(204, 204, 204))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSolicitudCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(318, 318, 318))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSolicitudCompra)
                .addGap(125, 125, 125)
                .addComponent(jPanelDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanelDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(btnContinuar)
                .addGap(253, 253, 253))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtAnioCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioCarroActionPerformed

    private void txtMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMunicipioActionPerformed

    private void txtApellidoPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoPFocusGained
        // TODO add your handling code here:

        if (txtApellidoP.getText().equals(placeholderApellidoP)) {
                    txtApellidoP.setText("");
                    txtApellidoP.setForeground(normalColor);
                }
            

        
    }//GEN-LAST:event_txtApellidoPFocusGained

    private void txtApellidoPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoPFocusLost
        // TODO add your handling code here:
        if (txtApellidoP.getText().isEmpty()) {
                    txtApellidoP.setText(placeholderApellidoP);
                    txtApellidoP.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtApellidoPFocusLost

    private void txtTelefonoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoClienteActionPerformed

    private void txtApellidoMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoMFocusGained
        // TODO add your handling code here:
        if (txtApellidoM.getText().equals(placeholderApellidoM)) {
                    txtApellidoM.setText("");
                    txtApellidoM.setForeground(normalColor);
                }
    }//GEN-LAST:event_txtApellidoMFocusGained

    private void txtApellidoMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoMFocusLost
        // TODO add your handling code here:
       
        if (txtApellidoM.getText().isEmpty()) {
                    txtApellidoM.setText(placeholderApellidoM);
                    txtApellidoM.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtApellidoMFocusLost


    private void txtNombreClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreClienteFocusGained
        // TODO add your handling code here:
        if (txtNombreCliente.getText().equals(placeholderNombre)) {
                    txtNombreCliente.setText("");
                    txtNombreCliente.setForeground(normalColor);
                }
        
    }//GEN-LAST:event_txtNombreClienteFocusGained

    private void txtNombreClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreClienteFocusLost
        // TODO add your handling code here:
        if (txtNombreCliente.getText().isEmpty()) {
                    txtNombreCliente.setText(placeholderNombre);
                    txtNombreCliente.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtNombreClienteFocusLost

    private void txtTelefonoClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoClienteFocusGained
        // TODO add your handling code here:
        if ( txtTelefonoCliente.getText().equals(placeholderTelefono)) {
                     txtTelefonoCliente.setText("");
                     txtTelefonoCliente.setForeground(normalColor);
                }
               
       

    }//GEN-LAST:event_txtTelefonoClienteFocusGained

    private void txtTelefonoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoClienteFocusLost
        // TODO add your handling code here:
         if (txtTelefonoCliente.getText().isEmpty()) {
                    txtTelefonoCliente.setText(placeholderTelefono);
                    txtTelefonoCliente.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtTelefonoClienteFocusLost

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        // TODO add your handling code here:
        if (txtCorreo.getText().equals(placeholderCorreo)) {
                    txtCorreo.setText("");
                    txtCorreo.setForeground(normalColor);
                }
    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        // TODO add your handling code here:
        if (txtCorreo.getText().isEmpty()) {
                    txtCorreo.setText(placeholderCorreo);
                    txtCorreo.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtCalleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCalleFocusGained
        // TODO add your handling code here:
        if (txtCalle.getText().equals(placeholderCalle)) {
                    txtCalle.setText("");
                    txtCalle.setForeground(normalColor);
                }
        
    }//GEN-LAST:event_txtCalleFocusGained

    private void txtCalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCalleFocusLost
        // TODO add your handling code here:
        if (txtCalle.getText().isEmpty()) {
                    txtCalle.setText(placeholderCalle);
                    txtCalle.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtCalleFocusLost

    private void txtColoniaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtColoniaFocusGained
        // TODO add your handling code here:
        if (txtColonia.getText().equals(placeholderColonia)) {
                    txtColonia.setText("");
                    txtColonia.setForeground(normalColor);
                }

    }//GEN-LAST:event_txtColoniaFocusGained

    private void txtColoniaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtColoniaFocusLost
        // TODO add your handling code here:
        if (txtColonia.getText().isEmpty()) {
                    txtColonia.setText(placeholderColonia);
                    txtColonia.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtColoniaFocusLost

    private void txtMunicipioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMunicipioFocusGained
        // TODO add your handling code here:
        if (txtMunicipio.getText().equals(placeholderMunicipio)) {
                    txtMunicipio.setText("");
                    txtMunicipio.setForeground(normalColor);
                }
        
    }//GEN-LAST:event_txtMunicipioFocusGained

    private void txtMunicipioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMunicipioFocusLost
        // TODO add your handling code here:
        if (txtMunicipio.getText().isEmpty()) {
                    txtMunicipio.setText(placeholderMunicipio);
                    txtMunicipio.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtMunicipioFocusLost

    private void txtEstadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstadoFocusGained
        // TODO add your handling code here:
        if (txtEstado.getText().equals(placeholderEstado)) {
                    txtEstado.setText("");
                    txtEstado.setForeground(normalColor);
                }
        
    }//GEN-LAST:event_txtEstadoFocusGained

    private void txtEstadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstadoFocusLost
        // TODO add your handling code here:
        if (txtEstado.getText().isEmpty()) {
                    txtEstado.setText(placeholderEstado);
                    txtEstado.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtEstadoFocusLost

    private void txtCPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFocusGained
        // TODO add your handling code here:
        if (txtCP.getText().equals(placeholderCP)) {
                    txtCP.setText("");
                    txtCP.setForeground(normalColor);
                }
        
    }//GEN-LAST:event_txtCPFocusGained

    private void txtCPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFocusLost
        // TODO add your handling code here:
        if (txtCP.getText().isEmpty()) {
                    txtCP.setText(placeholderCP);
                    txtCP.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtCPFocusLost

    private void txtMarcaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMarcaFocusGained
        // TODO add your handling code here:
        if (txtMarca.getText().equals(placeholderMarca)) {
                    txtMarca.setText("");
                    txtMarca.setForeground(normalColor);
                }
       
    }//GEN-LAST:event_txtMarcaFocusGained

    private void txtMarcaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMarcaFocusLost
        // TODO add your handling code here:
         if (txtMarca.getText().isEmpty()) {
                    txtMarca.setText(placeholderMarca);
                    txtMarca.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtMarcaFocusLost

    private void txtModeloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtModeloFocusGained
        // TODO add your handling code here:
        if (txtModelo.getText().equals(placeholderModelo)) {
                    txtModelo.setText("");
                    txtModelo.setForeground(normalColor);
                }
        
    }//GEN-LAST:event_txtModeloFocusGained

    private void txtModeloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtModeloFocusLost
        // TODO add your handling code here:
        if (txtModelo.getText().isEmpty()) {
                    txtModelo.setText(placeholderModelo);
                    txtModelo.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtModeloFocusLost

    private void txtTipoCarroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoCarroFocusGained
        // TODO add your handling code here:
        if (txtTipoCarro.getText().equals(placeholderTipo)) {
                    txtTipoCarro.setText("");
                    txtTipoCarro.setForeground(normalColor);
                }
        
    }//GEN-LAST:event_txtTipoCarroFocusGained

    private void txtTipoCarroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoCarroFocusLost
        // TODO add your handling code here:
        if (txtTipoCarro.getText().isEmpty()) {
                    txtTipoCarro.setText(placeholderTipo);
                    txtTipoCarro.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtTipoCarroFocusLost

    private void txtColorCarroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtColorCarroFocusGained
        // TODO add your handling code here:
        if (txtColorCarro.getText().equals(placeholderColorCarro)) {
                    txtColorCarro.setText("");
                    txtColorCarro.setForeground(normalColor);
                }
        
    }//GEN-LAST:event_txtColorCarroFocusGained

    private void txtColorCarroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtColorCarroFocusLost
        // TODO add your handling code here:
        if (txtColorCarro.getText().isEmpty()) {
                    txtColorCarro.setText(placeholderColorCarro);
                    txtColorCarro.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtColorCarroFocusLost

    private void txtAnioCarroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAnioCarroFocusGained
        // TODO add your handling code here:
        if (txtAnioCarro.getText().equals(placeholderAnio)) {
                    txtAnioCarro.setText("");
                    txtAnioCarro.setForeground(normalColor);
                }
        
    }//GEN-LAST:event_txtAnioCarroFocusGained

    private void txtAnioCarroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAnioCarroFocusLost
        // TODO add your handling code here:
        if (txtAnioCarro.getText().isEmpty()) {
                    txtAnioCarro.setText(placeholderAnio);
                    txtAnioCarro.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtAnioCarroFocusLost

    private void txtEstadoCarroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstadoCarroFocusGained
        // TODO add your handling code here:
        if (txtEstadoCarro.getText().equals(placeholderEstados)) {
                    txtEstadoCarro.setText("");
                    txtEstadoCarro.setForeground(normalColor);
                }
        
    }//GEN-LAST:event_txtEstadoCarroFocusGained

    private void txtEstadoCarroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstadoCarroFocusLost
        // TODO add your handling code here:
        if (txtEstadoCarro.getText().isEmpty()) {
                    txtEstadoCarro.setText(placeholderEstados);
                    txtEstadoCarro.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtEstadoCarroFocusLost

    private void txtTipoCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoCarroActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTipoCarroActionPerformed

    private void txtApellidoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPActionPerformed

   
    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
                
        String textoEdad = txtEdad.getText().trim();

        // Validación de número
        if (!textoEdad.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "La edad debe ser un número entero.");
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(textoEdad);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido en el campo de edad.");
            return;
        }

    // Si llegamos aquí, la edad es válida
    Cliente cliente = new Cliente();

    cliente.setApellidoP(txtApellidoP.getText());
    cliente.setApellidoM(txtApellidoM.getText());
    cliente.setNombre(txtNombreCliente.getText());
    cliente.setCurp(txtCURP.getText());
    cliente.setGenero(cbGenero.getSelectedItem().toString());
    cliente.setEdad(edad);
    cliente.setLicencia(txtNoLicencia.getText());

    try {
        long telefono = Long.parseLong(txtTelefonoCliente.getText().trim());
        cliente.setTelefono(telefono);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Por favor, ingresa un número de teléfono válido.");
        return;
    }

    cliente.setCorreo(txtCorreo.getText());
    cliente.setCalle(txtCalle.getText());
    cliente.setColonia(txtColonia.getText());
    cliente.setMunicipio(txtMunicipio.getText());
    cliente.setEstado(txtEstado.getText());
    cliente.setCP(txtCP.getText());

    ClienteDB dao = new ClienteDB();
    if (dao.RegistrarClientes(cliente)) {
        JOptionPane.showMessageDialog(this, "Cliente registrado con éxito");
    // limpiarCampos();
    }else {
        JOptionPane.showMessageDialog(this, "Error al registrar cliente");
        return;
    }
    // Mostrar opciones de qué desea hacer
    Object[] opciones = {"Solo Seguro", "Solo Crédito", "Ambos", "Solo Venta" , "Cancelar"};
int seleccion = JOptionPane.showOptionDialog(null, "¿Qué desea hacer a continuación?", "Opciones de Compra", 
                                              JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

Principal ventanaPrincipal = (Principal) javax.swing.SwingUtilities.getWindowAncestor(this);



switch (seleccion) {
    case 0: // Solo Seguro
        Seguros segurosPanel = new Seguros(cliente, carroSeleccionado, false);
        segurosPanel.setClienteYaExiste(true);  
        ventanaPrincipal.setPanelContenido(segurosPanel);
        break;
    case 1: // Solo Crédito
        Creditos creditosPanel = new Creditos(cliente, carroSeleccionado);
        ventanaPrincipal.setPanelContenido(creditosPanel);
        break;
    case 2: // Ambos
        Seguros ambosSegurosPanel = new Seguros(cliente, carroSeleccionado, true);
        ambosSegurosPanel.setClienteYaExiste(true); 
        ventanaPrincipal.setPanelContenido(ambosSegurosPanel);
        break;
        
   case 3: // Solo Venta
   //Genera PDF
GeneradorPDF.generarResumenVenta(cliente, carroSeleccionado, null);

String rutaFactura = "src/consecionario/Facturas/Ventas/Resumen_Venta_" + cliente.getNombre().replaceAll("\\s+", "_") + ".pdf";
registrarHistorial(cliente, "Venta", rutaFactura);
    break;

    default:
        JOptionPane.showMessageDialog(this, "Operación cancelada.");
        break;
}

    }//GEN-LAST:event_btnContinuarActionPerformed

    private void txtColoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColoniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColoniaActionPerformed

    private void txtApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMActionPerformed

    private void txtCURPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCURPFocusGained
        // TODO add your handling code here:
        if (txtCURP.getText().equals(placeholderCURP)) {
                    txtCURP.setText("");
                    txtCURP.setForeground(normalColor);
                }
    }//GEN-LAST:event_txtCURPFocusGained

    private void txtCURPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCURPFocusLost
        // TODO add your handling code here:
         if (txtCURP.getText().isEmpty()) {
                    txtCURP.setText(placeholderCURP);
                    txtCURP.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtCURPFocusLost

    private void txtCURPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCURPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCURPActionPerformed

    private void txtEdadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdadFocusGained
        // TODO add your handling code here:
        if (txtEdad.getText().equals(placeholderEdad)) {
                    txtEdad.setText("");
                    txtEdad.setForeground(normalColor);
                }
    }//GEN-LAST:event_txtEdadFocusGained

    private void txtEdadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdadFocusLost
        // TODO add your handling code here:
         if (txtEdad.getText().isEmpty()) {
                    txtEdad.setText(placeholderEdad);
                    txtEdad.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtEdadFocusLost

    private void txtNoLicenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNoLicenciaFocusGained
        // TODO add your handling code here:
        if (txtNoLicencia.getText().equals(placeholderLicencia)) {
                    txtNoLicencia.setText("");
                    txtNoLicencia.setForeground(normalColor);
                }
    }//GEN-LAST:event_txtNoLicenciaFocusGained

    private void txtNoLicenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNoLicenciaFocusLost
        // TODO add your handling code here:
         if (txtNoLicencia.getText().isEmpty()) {
                    txtNoLicencia.setText(placeholderLicencia);
                    txtNoLicencia.setForeground(placeholderColor);
                }
    }//GEN-LAST:event_txtNoLicenciaFocusLost

    private void cbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGeneroActionPerformed
        // TODO add your handling code here:
    
    
    }//GEN-LAST:event_cbGeneroActionPerformed

    private void txtPrecioCarroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioCarroFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCarroFocusGained

    private void txtPrecioCarroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioCarroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCarroFocusLost

    private void txtNoSerieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNoSerieFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoSerieFocusGained

    private void txtNoSerieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNoSerieFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoSerieFocusLost

    private void txtNoSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoSerieActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel bgCarro;
    private javax.swing.JPanel bgDatosComprador;
    private javax.swing.JPanel bgDomicilio;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JPanel jPanelDatosCliente;
    private javax.swing.JPanel jPanelDireccion;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCarro;
    private javax.swing.JLabel lblDatosComprador;
    private javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblSolicitudCompra;
    private javax.swing.JTextField txtAnioCarro;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtColorCarro;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtEstadoCarro;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNoLicencia;
    private javax.swing.JTextField txtNoSerie;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JPanel txtPrecio;
    private javax.swing.JTextField txtPrecioCarro;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTipoCarro;
    // End of variables declaration//GEN-END:variables
}
