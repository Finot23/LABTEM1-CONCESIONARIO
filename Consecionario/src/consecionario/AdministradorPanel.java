/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author antoniosalinas
 */
public class AdministradorPanel {
    
    private JPanel contenedor;

    public AdministradorPanel(JPanel contenedor) {
        this.contenedor = contenedor;
    }

    public void mostrarPanel(JPanel info) {
        info.setSize(834, 840);
        info.setLocation(0, 0);

        contenedor.removeAll();
        contenedor.add(info, BorderLayout.CENTER);
        contenedor.revalidate();
        contenedor.repaint();
    }
}