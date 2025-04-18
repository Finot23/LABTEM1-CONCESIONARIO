/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package consecionario.Formularios;

import BD.CatalogoBD;
import consecionario.Clases.CatalogoCarros;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Finot
 */
public class CatalogoSUV extends javax.swing.JPanel {

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
      CatalogoBD catalogoBD = new CatalogoBD();
    List<CatalogoCarros> lista = catalogoBD.obtenerPorCategoria("SUV");

    if (lista.isEmpty()) {
        System.out.println("No se encontraron autos hatchback.");
        return;
    }

    // Establece máximo de 3 imágenes
    if (lista.size() >= 1) {
        SetImageLabel(txtImagen1, lista.get(0).getImagen());
        txtCaracteristicas1.setText("<html>" + lista.get(0).getDescripcion() + "</html>");
        txtMarca.setText(lista.get(0).getMarca() +"   •  ");
        txtModelo.setText(lista.get(0).getModelo());
        //txtAnio.setText(lista.get(0).getAnioFabricacion());
        txtPrecio.setText("$" + lista.get(0).getPrecio());
    }

    if (lista.size() >= 2) {
        SetImageLabel(txtImagen2, lista.get(1).getImagen());
        txtCaracteristicas2.setText("<html>" + lista.get(1).getDescripcion() + "</html>");
        txtMarca1.setText(lista.get(1).getMarca() +"   •  ");
        txtModelo1.setText(lista.get(1).getModelo());
        //txtAnio1.setText(lista.get(1).getAnioFabricacion());
        txtPrecio1.setText("$" + lista.get(1).getPrecio());
    }

    if (lista.size() >= 3) {
        SetImageLabel(txtImagen3, lista.get(2).getImagen());
        txtCaracteristicas3.setText("<html>" + lista.get(2).getDescripcion() + "</html>");
        txtMarca2.setText(lista.get(2).getMarca() +"   •  ");
        txtModelo2.setText(lista.get(2).getModelo());
        //txtAnio2.setText(lista.get(2).getAnioFabricacion());
        txtPrecio2.setText("$" + lista.get(2).getPrecio());
    }

       
    }
    
    
    /**
     * Creates new form CatalogoHatchback
     */
    public void VentanaInicio(){
        
        JPanelVentana3.setVisible(false);
        JPanelVentana1.setVisible(true);
        JPanelVentana2.setVisible(false); 
        
    }
    public CatalogoSUV() {
        initComponents();
          
        txtImagen1.addComponentListener(new java.awt.event.ComponentAdapter() {
        @Override
        public void componentResized(java.awt.event.ComponentEvent evt) {
            CargarImagen();
            VentanaInicio(); 
        }
    });
         
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanelCoche1 = new javax.swing.JPanel();
        txtImagen1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtMarca = new javax.swing.JLabel();
        txtModelo = new javax.swing.JLabel();
        txtAnio = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtPrecio = new javax.swing.JLabel();
        txtPrecioDesde = new javax.swing.JLabel();
        jPanelCoche2 = new javax.swing.JPanel();
        txtImagen2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtMarca1 = new javax.swing.JLabel();
        txtModelo1 = new javax.swing.JLabel();
        txtAnio1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtPrecio1 = new javax.swing.JLabel();
        txtPrecioDesde1 = new javax.swing.JLabel();
        jPanelCoche3 = new javax.swing.JPanel();
        txtImagen3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtMarca2 = new javax.swing.JLabel();
        txtModelo2 = new javax.swing.JLabel();
        txtAnio2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtPrecio2 = new javax.swing.JLabel();
        txtPrecioDesde2 = new javax.swing.JLabel();
        JPanelVentana3 = new javax.swing.JPanel();
        btnSiguienteV3 = new javax.swing.JButton();
        txtCaracteristicas3 = new javax.swing.JLabel();
        JPanelVentana2 = new javax.swing.JPanel();
        btnSiguienteV2 = new javax.swing.JButton();
        txtCaracteristicas2 = new javax.swing.JLabel();
        JPanelVentana1 = new javax.swing.JPanel();
        btnSeleccionar = new javax.swing.JButton();
        txtCaracteristicas1 = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(500, 199));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCoche1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCoche1MouseClicked(evt);
            }
        });

        txtImagen1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtImagen1.setText("IMagen Coche");
        txtImagen1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtImagen1.setMaximumSize(new java.awt.Dimension(296, 169));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtMarca.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtMarca.setText("Marca");

        txtModelo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtModelo.setText("Modelo");

        txtAnio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAnio.setText("Anio");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnio)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPrecio.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        txtPrecio.setText("Precio");

        txtPrecioDesde.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtPrecioDesde.setText("Precio desde");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio)
                    .addComponent(txtPrecioDesde))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtPrecioDesde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelCoche1Layout = new javax.swing.GroupLayout(jPanelCoche1);
        jPanelCoche1.setLayout(jPanelCoche1Layout);
        jPanelCoche1Layout.setHorizontalGroup(
            jPanelCoche1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCoche1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(txtImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelCoche1Layout.setVerticalGroup(
            jPanelCoche1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoche1Layout.createSequentialGroup()
                .addComponent(txtImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        bg.add(jPanelCoche1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 298, 384));

        jPanelCoche2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCoche2MouseClicked(evt);
            }
        });

        txtImagen2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtImagen2.setText("Coche");
        txtImagen2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtMarca1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtMarca1.setText("Marca");

        txtModelo1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtModelo1.setText("Modelo");

        txtAnio1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAnio1.setText("Anio");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnio1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtMarca1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnio1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPrecio1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        txtPrecio1.setText("Precio");

        txtPrecioDesde1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtPrecioDesde1.setText("Precio desde");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio1)
                    .addComponent(txtPrecioDesde1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtPrecioDesde1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelCoche2Layout = new javax.swing.GroupLayout(jPanelCoche2);
        jPanelCoche2.setLayout(jPanelCoche2Layout);
        jPanelCoche2Layout.setHorizontalGroup(
            jPanelCoche2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCoche2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(txtImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanelCoche2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCoche2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelCoche2Layout.setVerticalGroup(
            jPanelCoche2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoche2Layout.createSequentialGroup()
                .addComponent(txtImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        bg.add(jPanelCoche2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 298, 384));

        jPanelCoche3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCoche3MouseClicked(evt);
            }
        });

        txtImagen3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtImagen3.setText("Coche");
        txtImagen3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtMarca2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtMarca2.setText("Marca");

        txtModelo2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtModelo2.setText("Modelo");

        txtAnio2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAnio2.setText("Anio");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnio2)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtMarca2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnio2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPrecio2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        txtPrecio2.setText("Precio");

        txtPrecioDesde2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtPrecioDesde2.setText("Precio desde");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio2)
                    .addComponent(txtPrecioDesde2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtPrecioDesde2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelCoche3Layout = new javax.swing.GroupLayout(jPanelCoche3);
        jPanelCoche3.setLayout(jPanelCoche3Layout);
        jPanelCoche3Layout.setHorizontalGroup(
            jPanelCoche3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCoche3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(txtImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanelCoche3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCoche3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelCoche3Layout.setVerticalGroup(
            jPanelCoche3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoche3Layout.createSequentialGroup()
                .addComponent(txtImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        bg.add(jPanelCoche3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 298, 384));

        btnSiguienteV3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnSiguienteV3.setText("Siguiente");
        btnSiguienteV3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteV3ActionPerformed(evt);
            }
        });

        txtCaracteristicas3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCaracteristicas3.setText("jLabel1");

        javax.swing.GroupLayout JPanelVentana3Layout = new javax.swing.GroupLayout(JPanelVentana3);
        JPanelVentana3.setLayout(JPanelVentana3Layout);
        JPanelVentana3Layout.setHorizontalGroup(
            JPanelVentana3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelVentana3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPanelVentana3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelVentana3Layout.createSequentialGroup()
                        .addComponent(btnSiguienteV3)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelVentana3Layout.createSequentialGroup()
                        .addComponent(txtCaracteristicas3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        JPanelVentana3Layout.setVerticalGroup(
            JPanelVentana3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelVentana3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(txtCaracteristicas3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnSiguienteV3)
                .addGap(17, 17, 17))
        );

        bg.add(JPanelVentana3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 490, 270, 220));

        btnSiguienteV2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnSiguienteV2.setText("Siguiente");
        btnSiguienteV2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteV2ActionPerformed(evt);
            }
        });

        txtCaracteristicas2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCaracteristicas2.setText("jLabel1");

        javax.swing.GroupLayout JPanelVentana2Layout = new javax.swing.GroupLayout(JPanelVentana2);
        JPanelVentana2.setLayout(JPanelVentana2Layout);
        JPanelVentana2Layout.setHorizontalGroup(
            JPanelVentana2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelVentana2Layout.createSequentialGroup()
                .addGroup(JPanelVentana2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelVentana2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnSiguienteV2))
                    .addGroup(JPanelVentana2Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(txtCaracteristicas2)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        JPanelVentana2Layout.setVerticalGroup(
            JPanelVentana2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelVentana2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(txtCaracteristicas2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnSiguienteV2)
                .addGap(70, 70, 70))
        );

        bg.add(JPanelVentana2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 550, 310, 190));

        btnSeleccionar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnSeleccionar.setText("Seleccionar");

        txtCaracteristicas1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCaracteristicas1.setText("Caracteristicas");

        btnSiguiente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelVentana1Layout = new javax.swing.GroupLayout(JPanelVentana1);
        JPanelVentana1.setLayout(JPanelVentana1Layout);
        JPanelVentana1Layout.setHorizontalGroup(
            JPanelVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelVentana1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(JPanelVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCaracteristicas1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addGap(39, 39, 39)
                .addComponent(btnSiguiente)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        JPanelVentana1Layout.setVerticalGroup(
            JPanelVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelVentana1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCaracteristicas1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(JPanelVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar)
                    .addComponent(btnSiguiente))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        bg.add(JPanelVentana1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 390, 230));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 40, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelCoche1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCoche1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelCoche1MouseClicked

    private void jPanelCoche2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCoche2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelCoche2MouseClicked

    private void jPanelCoche3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCoche3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelCoche3MouseClicked

    private void btnSiguienteV3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteV3ActionPerformed
        // TODO add your handling code here:
        JPanelVentana1.setVisible(true);
        JPanelVentana3.setVisible(false);
    }//GEN-LAST:event_btnSiguienteV3ActionPerformed

    private void btnSiguienteV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteV2ActionPerformed
        // TODO add your handling code here:
        JPanelVentana2.setVisible(false);
        JPanelVentana3.setVisible(true);
    }//GEN-LAST:event_btnSiguienteV2ActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:

        JPanelVentana1.setVisible(false);
        JPanelVentana2.setVisible(true);
    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelVentana1;
    private javax.swing.JPanel JPanelVentana2;
    private javax.swing.JPanel JPanelVentana3;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnSiguienteV2;
    private javax.swing.JButton btnSiguienteV3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelCoche1;
    private javax.swing.JPanel jPanelCoche2;
    private javax.swing.JPanel jPanelCoche3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel txtAnio;
    private javax.swing.JLabel txtAnio1;
    private javax.swing.JLabel txtAnio2;
    private javax.swing.JLabel txtCaracteristicas1;
    private javax.swing.JLabel txtCaracteristicas2;
    private javax.swing.JLabel txtCaracteristicas3;
    private javax.swing.JLabel txtImagen1;
    private javax.swing.JLabel txtImagen2;
    private javax.swing.JLabel txtImagen3;
    private javax.swing.JLabel txtMarca;
    private javax.swing.JLabel txtMarca1;
    private javax.swing.JLabel txtMarca2;
    private javax.swing.JLabel txtModelo;
    private javax.swing.JLabel txtModelo1;
    private javax.swing.JLabel txtModelo2;
    private javax.swing.JLabel txtPrecio;
    private javax.swing.JLabel txtPrecio1;
    private javax.swing.JLabel txtPrecio2;
    private javax.swing.JLabel txtPrecioDesde;
    private javax.swing.JLabel txtPrecioDesde1;
    private javax.swing.JLabel txtPrecioDesde2;
    // End of variables declaration//GEN-END:variables
}
