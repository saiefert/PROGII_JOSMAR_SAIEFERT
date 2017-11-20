package bancoGUI;

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
            // Objeto PreparedStatement é um objeto que prepara a instrução de sql
            // ou seja, preenche os valores
            PreparedStatement preparacaoDaInstrucao = conexao.prepareStatement(sql);
            //De acordo com a posicao do ponto de interrogacao na SQL e o tipo do dado
            preparacaoDaInstrucao.setString(1, perfil.getNome());
            preparacaoDaInstrucao.setString(2, perfil.getDescricao());

            return preparacaoDaInstrucao.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    //listar
    public List<Perfil> listarPerfil() {
        List<Perfil> listaParaRetorno = new ArrayList<Perfil>();
        String sql = "SELECT * FROM tb_perfil";

        try {
            PreparedStatement instrucaoSelecao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucaoSelecao.executeQuery();

            while (resultado.next()) {
                Perfil perfil = new Perfil();
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

    //excluir
    public boolean excluirPerfil(Perfil perfil) {
        return false;
    }
    //atualizar
    public boolean atualizarPerfil(Perfil perfil) {
        return false;
    }
}
