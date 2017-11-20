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

public class DAOUsuario {
    Connection conexao = Connect.criarConexao();

    //salvar
    public int salvarUsuario(Usuario usuario) {
        String sql = "INSERT "
                + "INTO "
                + "tb_usuario (nome, sobrenome)"
                + "VALUES (?, ?)";
        try {

            PreparedStatement preparacaoDaInstrucao = conexao.prepareStatement(sql);
            preparacaoDaInstrucao.setString(1, usuario.getNome());
            preparacaoDaInstrucao.setString(2, usuario.getSobrenome());

            return preparacaoDaInstrucao.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    //listar
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaParaRetorno = new ArrayList<Usuario>();
        String sql = "SELECT * FROM tb_usuario ORDER BY id_usuario ASC";
        try {
            PreparedStatement instrucaoSelecao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucaoSelecao.executeQuery();

            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultado.getInt("id_usuario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setSobrenome(resultado.getString("sobrenome"));
                listaParaRetorno.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return listaParaRetorno;
    }

    //excluir
    public void excluirUsuario(Usuario usuario) {
        String sql = "DELETE FROM tb_usuario WHERE id_usuario=?";

        try {
            PreparedStatement conectar = conexao.prepareStatement(sql);
            conectar.setInt(1, usuario.getidUsuario());
            conectar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
            conectar.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //atualizar
    public void editarUsuario(Usuario usuario) {
        String sql = "UPDATE tb_usuario SET nome=?, sobrenome=? WHERE id_usuario=?";

        try {
            PreparedStatement conectar = conexao.prepareStatement(sql);
            conectar.setString(1, usuario.getNome());
            conectar.setString(2, usuario.getSobrenome());
            conectar.setInt(3, usuario.getidUsuario());
            conectar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
            conectar.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}