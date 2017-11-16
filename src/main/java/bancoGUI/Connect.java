package bancoGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static final String URL_BANCO = "jdbc:postgresql://localhost:5432/trab_prog_ii";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "toor";

    private static String status = "Não conectado ...";

    public static Connection criarConexao() {
        Connection conexao = null;

        try {
            conexao = DriverManager.getConnection(URL_BANCO, USUARIO, SENHA);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (conexao != null)
            status = "Conectado";
        else
            status = "Não conectado";
        return conexao;
    }

    public String getStatus() {
        return status;
    }

}
