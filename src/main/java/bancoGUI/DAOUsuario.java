package bancoGUI;

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
        // Instrução SQL que será executada no banco
        String sql = "INSERT "
                + "INTO "
                + "tb_usuario (nome, sobrenome)"
                + "VALUES (?, ?)";
        try {
            // Objeto PreparedStatement é um objeto que prepara a instrução de sql
            // ou seja, preenche os valores
            PreparedStatement preparacaoDaInstrucao = conexao.prepareStatement(sql);
            //De acordo com a posicao do ponto de interrogacao na SQL e o tipo do dado
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
        String sql = "SELECT * FROM tb_usuario";

        try {
            PreparedStatement instrucaoSelecao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucaoSelecao.executeQuery();

            while (resultado.next()) {
                Usuario usu = new Usuario();
                usu.setNome(resultado.getString("nome"));
                usu.setSobrenome(resultado.getString("Sobrenome"));
                listaParaRetorno.add(usu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return listaParaRetorno;
    }

    //excluir
    public boolean excluirUsuario(Usuario usuario) {
        return false;
    }
    //atualizar
    public boolean atualizarUsuario(Usuario usuario) {
        return false;
    }
}


