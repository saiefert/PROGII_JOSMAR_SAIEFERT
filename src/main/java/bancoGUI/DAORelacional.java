package bancoGUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAORelacional {

    Connection conexao = Connect.criarConexao();

    public List<PerfilUsuario> listarPerfilUsuario() {
        List<PerfilUsuario> listaParaRetorno = new ArrayList<PerfilUsuario>();
        String sql = "SELECT nome, sobrenome, nome_perfil FROM tb_usuario INNER JOIN tb_perfil ON tb_usuario.id_usu = tb_perfil.id_perfil";

        try {
            PreparedStatement instrucaoSelecao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucaoSelecao.executeQuery();

            while (resultado.next()) {
                PerfilUsuario perfil = new PerfilUsuario();
                perfil.setNome(resultado.getString("nome"));
                perfil.setSobrenome(resultado.getString("sobrenome"));
                perfil.setNomePerfil(resultado.getString("nome_perfil"));
                listaParaRetorno.add(perfil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return listaParaRetorno;
    }
}
