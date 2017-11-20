package bancoGUI;

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
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaParaRetorno = new ArrayList<Usuario>();
        String sql = "SELECT * FROM tb_usuario";

        try {
            PreparedStatement instrucaoSelecao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucaoSelecao.executeQuery();

            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setNome(resultado.getString("nome"));
                usuario.setSobrenome(resultado.getString("Sobrenome"));
                listaParaRetorno.add(usuario);
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

