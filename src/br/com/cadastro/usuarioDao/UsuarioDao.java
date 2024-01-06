package br.com.cadastro.usuarioDao;

import br.com.cadastro.connection.Conexao;
import br.com.cadastro.usuario.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDao {

    private Connection conexao;

    public void Cadastrar(Usuario usuario){

        //Usando a interface PreparedStatement
        PreparedStatement stmt = null;

        try {

            //puxando o método de conexão statico
            conexao = Conexao.getConexao();

            //comando sql pra inserir os dados no MySql
            String sql = "INSERT INTO CAD_USUARIO(NOME , EMAIL , ENDERECO , NUM_ENDERECO ,DATA_CADASTRO) VALUES(?,?,?,?,?)";
            stmt = conexao.prepareStatement(sql);

            //Usando os parametros do PreparedStatement
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getEndereco());
            stmt.setInt(4, usuario.getNum_endereco());
            java.sql.Date data = new java.sql.Date(usuario.getData_cadastro().getTime());
            stmt.setDate(5,data);

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

    public List<Usuario> Listar(){

        //Criando uma lista de usuario
        List<Usuario> lista = new ArrayList<Usuario>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConexao();

            String sql = "SELECT*FROM CAD_USUARIO";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){

                int id = rs.getInt("ID_USUARIO");
                String nome = rs.getString("NOME");
                String email = rs.getString("EMAIL");
                String endereco= rs.getString("ENDERECO");
                int num_endereco = rs.getInt("NUM_ENDERECO");
                java.sql.Date data_contratacao = rs.getDate("DATA_CADASTRO");

                Usuario usuario = new Usuario(id, nome , email, endereco , num_endereco, data_contratacao );

                lista.add(usuario);

            }
        }catch (SQLException e){
            e.printStackTrace();

        }finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return lista;

    }

}
