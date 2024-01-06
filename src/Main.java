import br.com.cadastro.connection.Conexao;
import br.com.cadastro.usuario.Usuario;
import br.com.cadastro.usuarioDao.UsuarioDao;

import java.sql.Connection;



public class Main {
    public static void main(String[] args) {


        Connection conexao = Conexao.getConexao();

        Usuario usuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();

        usuario.setNome("thiago");
        usuario.setEmail("thiagoteste@gmail.com");
        usuario.setSenha("thi123");
        usuario.setData_cadastro(new java.sql.Date(new java.util.Date().getTime()));

        dao.Cadastrar(usuario);

        }
    }
