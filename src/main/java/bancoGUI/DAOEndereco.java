package bancoGUI;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEndereco {
    Connection conexao = Connect.criarConexao();

    //salvar
    public int salvarEndereco(Endereco endereco) {
        // Instrução SQL que será executada no banco
        String sql = "INSERT "
                + "INTO "
                + "tb_endereco (logradouro, complemento, bairro, numero, cep)"
                + "VALUES (?, ?, ? ,? ,?)";
        try {
            // Objeto PreparedStatement é um objeto que prepara a instrução de sql
            // ou seja, preenche os valores
            PreparedStatement pega = conexao.prepareStatement(sql);
            //De acordo com a posicao do ponto de interrogacao na SQL e o tipo do dado
            pega.setString(1, endereco.getLogradouro());
            pega.setString(2, endereco.getComplemento());
            pega.setString(3, endereco.getBairro());
            pega.setString(4, endereco.getNumero());
            pega.setString(5, endereco.getCep());

            return pega.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    //listar
    public List<Endereco> listarEnderecos() {
        List<Endereco> listaParaRetorno = new ArrayList<Endereco>();
        String sql = "SELECT * FROM tb_endereco";

        try {
            PreparedStatement instrucaoSelecao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucaoSelecao.executeQuery();

            while (resultado.next()) {
                Endereco endereco = new Endereco();
                endereco.setIdEndereco(resultado.getInt("id_endereco"));
                endereco.setLogradouro(resultado.getString("logradouro"));
                endereco.setComplemento(resultado.getString("complemento"));
                endereco.setBairro(resultado.getString("bairro"));
                endereco.setNumero(resultado.getString("numero"));
                endereco.setCep(resultado.getString("cep"));
                listaParaRetorno.add(endereco);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return listaParaRetorno;
    }

    //excluir
    public void excluirEndereco(Endereco endereco) {
        String sql = "DELETE FROM tb_endereco WHERE id_endereco=?";

        try {
            PreparedStatement conectar = conexao.prepareStatement(sql);
            conectar.setInt(1, endereco.getIdEndereco());
            conectar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Endereço removido com sucesso");
            conectar.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //atualizar
    public void editarEndereco(Endereco endereco) {
        String sql = "UPDATE tb_endereco SET logradouro=?, complemento=?, bairro=?, numero=?, cep=? WHERE id_endereco=?";
        try {
            PreparedStatement conectar = conexao.prepareStatement(sql);
            conectar.setString(1, endereco.getLogradouro());
            conectar.setString(2, endereco.getComplemento());
            conectar.setString(3, endereco.getBairro());
            conectar.setString(4, endereco.getNumero());
            conectar.setString(5, endereco.getCep());
            conectar.setInt(6, endereco.getIdEndereco());
            conectar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Endereco alterado com sucesso!");
            conectar.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

