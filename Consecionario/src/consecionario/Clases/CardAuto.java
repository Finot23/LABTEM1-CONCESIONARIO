/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario.Clases;

import consecionario.Formularios.Principal;
import consecionario.Formularios.Ventas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class CardAuto extends JPanel {

    private JLabel lblImagen;
    private JLabel lblTitulo;
    private JLabel lblDetalles;
    private JLabel lblPrecio;

    private Border defaultBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
    private Border hoverBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(176, 217, 226), 2), //color Celeste grisáceo (#B0D9E2)
            BorderFactory.createEmptyBorder(3, 3, 3, 3)
    );

    private String marca, modelo, color, estado, categoria;
    private int anioFabricacion, id;
    private long kilometraje;
    private double precio;

    public CardAuto(String imagenResourcePath, String marca, String modelo, int anioFabricacion, long kilometraje, double precio,
                    String color, String estado, String categoria, int id) {

        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.kilometraje = kilometraje;
        this.precio = precio;
        this.color = color;
        this.estado = estado;
        this.categoria = categoria;
        this.id = id;
        setLayout(new BorderLayout());
        setBorder(defaultBorder);
        setPreferredSize(new Dimension(220, 330)); // Ancho reducido
        setBackground(Color.WHITE);

        // Panel imagen (Centrado)
        JPanel pnlImagen = new JPanel(new BorderLayout());
        lblImagen = new JLabel();
        SetImageLabel(lblImagen, imagenResourcePath, 200, 150); // Reducimos un poco el tamaño
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        pnlImagen.add(lblImagen, BorderLayout.CENTER);
        pnlImagen.setPreferredSize(new Dimension(250, 160));
        pnlImagen.setBackground(Color.WHITE);
        add(pnlImagen, BorderLayout.NORTH);

        // Panel info
        JPanel pnlInfo = new JPanel(new GridLayout(4, 1, 5, 5));
        pnlInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlInfo.setBackground(Color.WHITE);

        lblTitulo = new JLabel(marca + " · " + modelo);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setForeground(new Color(46, 46, 46)); // color Gris pizarra (#2E2E2E)
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInfo.add(lblTitulo);

        // Panel para el kilometraje con línea superior
        JPanel pnlKilometraje = new JPanel(new BorderLayout());
        pnlKilometraje.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY),
                BorderFactory.createEmptyBorder(5, 0, 0, 0)
        ));
        pnlKilometraje.setBackground(Color.WHITE); 
        lblDetalles = new JLabel(anioFabricacion + " · " + String.format("%,d km", kilometraje));
        lblDetalles.setFont(new Font("Arial", Font.PLAIN, 12));
        lblDetalles.setForeground(Color.GRAY);
        lblDetalles.setHorizontalAlignment(SwingConstants.CENTER);
        pnlKilometraje.add(lblDetalles, BorderLayout.CENTER);
        pnlInfo.add(pnlKilometraje);

        JLabel lblPrecioDesde = new JLabel("Precio desde");
        lblPrecioDesde.setFont(new Font("Arial", Font.PLAIN, 11));
        lblPrecioDesde.setForeground(Color.DARK_GRAY);
        lblPrecioDesde.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInfo.add(lblPrecioDesde);

        lblPrecio = new JLabel("$" + String.format("%,.0f", precio));
        lblPrecio.setFont(new Font("Arial", Font.BOLD, 18));
        lblPrecio.setForeground(new Color(43, 147, 72)); // Verde petróleo (#2B9348)
        lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInfo.add(lblPrecio);

        add(pnlInfo, BorderLayout.SOUTH);

        // Eventos de mouse para la card completa (hover)
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirPanelVentas();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(hoverBorder);
                setBackground(new Color(245, 245, 255));
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(defaultBorder);
                setBackground(Color.WHITE);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    public void SetImageLabel(JLabel labelName, String resourcePath, int width, int height) {
        java.net.URL imgURL = getClass().getResource(resourcePath);
        
        if (imgURL == null) {
            System.err.println("No se encontró la imagen en: " + resourcePath);
            labelName.setText("Imagen no encontrada");
            return;
        }
        ImageIcon imageIcon = new ImageIcon(imgURL);
        Image scaledImage = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH); 
        labelName.setIcon(new ImageIcon(scaledImage));
    }

    private void abrirPanelVentas() {
        CatalogoCarros carroSeleccionado = new CatalogoCarros();
        carroSeleccionado.setMarca(marca);
        carroSeleccionado.setModelo(modelo);
        carroSeleccionado.setAnioFabricacion(anioFabricacion);
        carroSeleccionado.setColor(color);
        carroSeleccionado.setEstado(estado);
        carroSeleccionado.setCategoria(categoria);
        carroSeleccionado.setKilometraje(kilometraje);
        carroSeleccionado.setId(id);
        carroSeleccionado.setPrecio(precio);

        Ventas ventasPanel = new Ventas(carroSeleccionado);

        Principal ventanaPrincipal = (Principal) SwingUtilities.getWindowAncestor(this);
        ventanaPrincipal.setPanelContenido(ventasPanel);
    }
}