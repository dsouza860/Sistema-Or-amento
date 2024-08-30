
package br.com.sistema.mgs.teste;

import br.com.sistema.mgs.jdbc.ConnectionFactory;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Mgs {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + e);
        }
    }
}
