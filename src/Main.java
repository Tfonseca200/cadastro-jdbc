import br.com.cadastro.connection.Conexao;
import br.com.cadastro.usuario.Usuario;
import br.com.cadastro.usuarioDao.UsuarioDao;

import java.sql.Connection;
import java.util.List;
import java.util.Date;


public class Main {
    public static void main(String[] args) {


        Connection conexao = Conexao.getConexao();

        Usuario usuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();


        dao.RemoverUsuario(3);


        }
    }
