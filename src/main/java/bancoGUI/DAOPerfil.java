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

public class DAOPerfil {
    Connection conexao = Connect.criarConexao();

    //salvar
    public int salvarPerfil(Perfil perfil) {
        // Instrução SQL que será executada no banco
        String sql = "INSERT "
                + "INTO "
                + "tb_perfil (nome, descricao)"
                + "VALUES (?, ?)";
        try {
            PreparedStatement preparacaoDaInstrucao = conexao.prepareStatement(sql);
            preparacaoDaInstrucao.setString(1, perfil.getNome());
            preparacaoDaInstrucao.setString(2, perfil.getDescricao());

            return preparacaoDaInstrucao.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    //listar perfil
    public List<Perfil> listarPerfil() {
        List<Perfil> listaParaRetorno = new ArrayList<Perfil>();
        String sql = "SELECT * FROM tb_perfil ORDER BY nome ASC";

        try {
            PreparedStatement instrucaoSelecao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucaoSelecao.executeQuery();

            while (resultado.next()) {
                Perfil perfil = new Perfil();
                perfil.setIdPerfil(resultado.getInt("id_perfil"));
                perfil.setNome(resultado.getString("nome"));
                perfil.setDescricao(resultado.getString("descricao"));
                listaParaRetorno.add(perfil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return listaParaRetorno;
    }


    //SELECT nome(tb_usuario), sobrenome, nome(tb_perfil) FROM tb_usuario INNER
    //JOIN tb_perfil ON
    //tb_usuario.id_usu = tb_perfil.id_perfil

    //excluir
    public void excluirPerfil(Perfil perfil) {
        String sql = "DELETE FROM tb_perfil WHERE id_perfil=?";

        try {
            PreparedStatement conectar = conexao.prepareStatement(sql);
            conectar.setInt(1, perfil.getIdPerfil());
            conectar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Perfil removido com sucesso");
            conectar.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //atualizar
    public void editarPerfil(Perfil perfil) {
        String sql = "UPDATE tb_perfil SET nome=?, descricao=? WHERE id_perfil=?";

        try {
            PreparedStatement conectar = conexao.prepareStatement(sql);
            conectar.setString(1, perfil.getNome());
            conectar.setString(2, perfil.getDescricao());
            conectar.setInt(3, perfil.getIdPerfil());
            conectar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Perfil alterado com sucesso!");
            conectar.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
