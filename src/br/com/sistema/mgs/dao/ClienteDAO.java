
package br.com.sistema.mgs.dao;

import br.com.sistema.mgs.jdbc.ConnectionFactory;
import br.com.sistema.mgs.model.Cliente;
import br.com.sistema.mgs.model.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {
    
    private Connection conn;
    
    public ClienteDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }
    
     public void cadastrarCliente(Cliente obj) {
        try {
            String sql = "insert into clientes(nome,logradouro, numero, bairro, cidade, cep, estado, cnpj,"
                    + "cpf, inscricao_estadual, email, telefone, celular) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getLogradouro());
            stmt.setInt(3, obj.getNumero());
            stmt.setString(4, obj.getBairro());
            stmt.setString(5, obj.getCidade());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEstado());
            stmt.setString(8, obj.getCnpj());
            stmt.setString(9, obj.getCpf());
            stmt.setString(10, obj.getInscricao_estadual());
            stmt.setString(11, obj.getEmail());
            stmt.setString(12, obj.getTelefone());
            stmt.setString(13, obj.getCelular());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
    }

    public void editarCliente(Cliente obj) {
        try {
            String sql = "update clientes set nome=?,logradouro=?, numero=?, bairro=?, cidade=?, cep=?, estado=?, cnpj=?,"
                    + "cpf=?, inscricao_estadual=?, email=?, telefone=?, celular=? where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getLogradouro());
            stmt.setInt(3, obj.getNumero());
            stmt.setString(4, obj.getBairro());
            stmt.setString(5, obj.getCidade());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEstado());
            stmt.setString(8, obj.getCnpj());
            stmt.setString(9, obj.getCpf());
            stmt.setString(10, obj.getInscricao_estadual());
            stmt.setString(11, obj.getEmail());
            stmt.setString(12, obj.getTelefone());
            stmt.setString(13, obj.getCelular());
            stmt.setInt(14, obj.getId());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public void excluirClientes(Cliente obj) {
        try {
            String sql = "delete from clientes where id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public List<Cliente> listaClientes() {
        try {
            List<Cliente> lista = new ArrayList<>();

            String sql = "select * from clientes";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setCep(rs.getString("cep"));
                obj.setEstado(rs.getString("estado"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setCpf(rs.getString("cpf"));
                obj.setInscricao_estadual(rs.getString("inscricao_estadual"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            return null;
        }
    }

    public List<Cliente> listarClientesPorNome(String nome) {
        try {
            List<Cliente> lista = new ArrayList<>();

            String sql = "select * from clientes where nome like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setCep(rs.getString("cep"));
                obj.setEstado(rs.getString("estado"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setCpf(rs.getString("cpf"));
                obj.setInscricao_estadual(rs.getString("inscricao_estadual"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            return null;
        }
    }

    public Cliente buscaCep(String cep) {
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        Cliente obj = new Cliente();

        if (webServiceCep.wasSuccessful()) {
            obj.setLogradouro(webServiceCep.getLogradouro());
            obj.setBairro(webServiceCep.getBairro());
            obj.setCidade(webServiceCep.getCidade());
            obj.setEstado(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Cep não encontrado!");
            return null;
        }
    }

    public Cliente consultaPorCodigo(int codigo) {
        try {
            String sql = "select * from clientes where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            Cliente obj = new Cliente();
            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setCep(rs.getString("cep"));
                obj.setEstado(rs.getString("estado"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setCpf(rs.getString("cpf"));
                obj.setInscricao_estadual(rs.getString("inscricao_estadual"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));

            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }

    public Cliente consultaPorNome(String nome) {
        try {
            String sql = "select * from clientes where nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Cliente obj = new Cliente();
            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setCep(rs.getString("cep"));
                obj.setEstado(rs.getString("estado"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setCpf(rs.getString("cpf"));
                obj.setInscricao_estadual(rs.getString("inscricao_estadual"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }
    
}
