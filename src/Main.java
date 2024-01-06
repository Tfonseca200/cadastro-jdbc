import br.com.cadastro.connection.Conexao;
import br.com.cadastro.usuario.Usuario;
import br.com.cadastro.usuarioDao.UsuarioDao;

import java.sql.Connection;
import java.util.List;


public class Main {
    public static void main(String[] args) {


        Connection conexao = Conexao.getConexao();

        Usuario usuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();

        List<Usuario> lista = dao.Listar();

            for (Usuario dados : lista){
                System.out.println(
                        "\nId:" + dados.getId()
                        +"\nNome: " + dados.getNome()
                        +"\nEmail:" + dados.getEmail()
                        +"\nEndereço: " + dados.getEndereco()
                        +"\nNumero de endereço: " + dados.getNum_endereco()
                        +"\nData de cadastro: " +dados.getData_cadastro()
                        +"\n-----------------------------------------------------");
            }



        }
    }
