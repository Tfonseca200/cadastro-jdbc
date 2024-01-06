package br.com.cadastro.usuarioDao;

import br.com.cadastro.connection.Conexao;
import br.com.cadastro.usuario.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UsuarioDao {

    private Connection conexao;

    public void Cadastrar(Usuario usuario){

        PreparedStatement stmt = null;

        try {

            conexao = Conexao.getConexao();
            String sql = "INSERT INTO CAD_USUARIO(NOME,EMAIL,SENHA,DATA_CADASTRO) VALUES(?,?,?,?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            java.sql.Date data = new java.sql.Date(usuario.getData_cadastro().getTime());
            stmt.setDate(4,data);

            stmt.executeUpdate();

            System.out.println("Cadastrado");


        }catch (SQLException e){
            e.printStackTrace();

        }finally {

            try{
                stmt.close();
                conexao.close();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }



    }

}
