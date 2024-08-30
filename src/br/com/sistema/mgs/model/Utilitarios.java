package br.com.sistema.mgs.model;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Utilitarios {

    public void LimpaTela(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextComponent) component).setText(null);
            }
        }
    }

    public void InserirIcone(JFrame frm) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/logomgs.png"));
            frm.setIconImage(icon.getImage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
