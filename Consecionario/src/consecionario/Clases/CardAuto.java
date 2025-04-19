/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario.Clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author antoniosalinas
 */
public class CardAuto extends JPanel{
     
        private JLabel lblImagen; // Declaramos lblImagen como variable de instancia

    public CardAuto(String imagenResourcePath, String marca, String modelo, int anioFabricacion, long kilometraje, double precio) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        setPreferredSize(new Dimension(250, 350)); //tamaño de cada card

        JPanel pnlImagen = new JPanel(new BorderLayout());
        lblImagen = new JLabel();
        SetImageLabel(lblImagen, imagenResourcePath, 250, 200); // Ajusta el tamaño de la imagen
        pnlImagen.add(lblImagen, BorderLayout.CENTER);
        pnlImagen.setPreferredSize(new Dimension(250, 200)); //ajusta el marco de la imagen
        
        JPanel pnlInfo = new JPanel(new GridLayout(4, 1, 5, 5)); // 4 filas, 1 columna, espaciado
        pnlInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margenes internos

        JLabel lblTitulo = new JLabel(marca + " · " + modelo);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        pnlInfo.add(lblTitulo);

        JLabel lblDetalles = new JLabel(anioFabricacion + " · " + String.format("%,d km", kilometraje));
        lblDetalles.setFont(new Font("Arial", Font.PLAIN, 12));
        lblDetalles.setForeground(Color.GRAY);
        lblDetalles.setHorizontalAlignment(SwingConstants.LEFT);
        pnlInfo.add(lblDetalles);

        JLabel lblPrecioDesde = new JLabel("Precio desde");
        lblPrecioDesde.setFont(new Font("Arial", Font.PLAIN, 11));
        lblPrecioDesde.setForeground(Color.DARK_GRAY);
        lblPrecioDesde.setHorizontalAlignment(SwingConstants.LEFT);
        pnlInfo.add(lblPrecioDesde);

        JLabel lblPrecio = new JLabel("$" + String.format("%,.0f", precio));
        lblPrecio.setFont(new Font("Arial", Font.BOLD, 18));
        lblPrecio.setForeground(new Color(34, 139, 34)); // Verde
        lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
        pnlInfo.add(lblPrecio);

        add(pnlImagen, BorderLayout.NORTH);
        add(pnlInfo, BorderLayout.SOUTH);
    }

    public void SetImageLabel (JLabel labelName, String resourcePath, int width, int height) {
        java.net.URL imgURL = getClass().getResource(resourcePath);
        if (imgURL == null) {
            System.err.println("No se encontró la imagen en: " + resourcePath);
            labelName.setText("Imagen no encontrada");
            return;
        }
        ImageIcon imageIcon = new ImageIcon(imgURL);
        Image scaledImage = imageIcon.getImage().getScaledInstance(
                width,
                height,
                Image.SCALE_SMOOTH
        );
        labelName.setIcon(new ImageIcon(scaledImage));
    }
}
