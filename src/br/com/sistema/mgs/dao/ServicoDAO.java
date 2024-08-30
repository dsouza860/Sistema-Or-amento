
package br.com.sistema.mgs.dao;

import br.com.sistema.mgs.jdbc.ConnectionFactory;
import br.com.sistema.mgs.model.Cliente;
import br.com.sistema.mgs.model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ServicoDAO {
     private Connection conn;

    public ServicoDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    public void cadastrarServicos(Servico obj) {
        try {
            String sql = "insert into servicos(cliente_id, equipamento, marca, modelo, descricao, servico_prestado, valor, data_servico)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getEquipamento());
            stmt.setString(3, obj.getMarca());
            stmt.setString(4, obj.getModelo());
            stmt.setString(5, obj.getDescricao());
            stmt.setString(6, obj.getServico_prestado());
            stmt.setDouble(7, obj.getValor());
            stmt.setString(8, obj.getData_servico());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }
    public void editarServico(Servico obj){
        try {
            String sql = "update servicos set cliente_id=?, equipamento=?, marca=?, modelo=?, descricao=?, servico_prestado=?, valor=?, data_servico=? where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getEquipamento());
            stmt.setString(3, obj.getMarca());
            stmt.setString(4, obj.getModelo());
            stmt.setString(5, obj.getDescricao());
            stmt.setString(6, obj.getServico_prestado());
            stmt.setDouble(7, obj.getValor());
            stmt.setString(8, obj.getData_servico());
            stmt.setInt(9, obj.getId());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Serviço alterado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }
    public void excluirServicos(Servico obj){
        try {
            String sql = "delete from servicos where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, obj.getId());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Serviço excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }
    public List<Servico> listarServicos() {
        try {
            List<Servico> lista = new ArrayList<>();

            String sql = "SELECT s.id, c.id, c.nome, s.equipamento, s.marca, s.modelo, s.descricao, s.servico_prestado, s.valor, date_format(s.data_servico, '%d/%m/%y') as data_formatada FROM servicos AS s "
                    + "INNER JOIN clientes AS c ON (s.cliente_id = c.id)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Servico obj = new Servico();
                Cliente c = new Cliente();
                obj.setId(rs.getInt("s.id"));
                c.setId(rs.getInt("c.id"));
                c.setNome(rs.getString("c.nome"));
                obj.setCliente(c);
                obj.setEquipamento(rs.getString("s.equipamento"));
                obj.setMarca(rs.getString("s.marca"));
                obj.setModelo(rs.getString("s.modelo"));
                obj.setDescricao(rs.getString("s.descricao"));
                obj.setDescricao(rs.getString("s.descricao"));
                obj.setServico_prestado(rs.getString("s.servico_prestado"));
                obj.setValor(rs.getDouble("s.valor"));
                obj.setData_servico(rs.getString("data_formatada"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            return null;
        }
    }
    
}
