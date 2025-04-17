/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario.Clases;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Finot
 */
public class RedimencionarImagen {
     public void setImageToLabel(JLabel label, String imageResourcePath) {
        // 1. Cargar imagen desde los recursos del proyecto (dentro de src/)
        ImageIcon originalIcon = new ImageIcon(getClass().getResource(imageResourcePath));

        // 2. Redimensionar al tamaño actual del JLabel
        Image scaledImage = originalIcon.getImage().getScaledInstance(
            label.getWidth(),
            label.getHeight(),
            Image.SCALE_SMOOTH
        );

        // 3. Asignar imagen escalada al JLabel
        label.setIcon(new ImageIcon(scaledImage));
}
}
