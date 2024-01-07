package br.com.cadastro.usuarioDao;

import br.com.cadastro.connection.Conexao;
import br.com.cadastro.usuario.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDao implements UsuarioDaoImp {

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

            //Executando sql
            stmt.executeUpdate();

            System.out.println("Cadastrado com sucesso");


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

    public List<Usuario> ListarUsuarios(){

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

                //Percorrendo todos os registros encontrados

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


    public void AtualizarCadastro( Usuario usuario){


        PreparedStatement stmt = null;

        try{

            //atualizando cadastro com os parâmetros sql, pegando como referência o Id do usuario

            conexao = Conexao.getConexao();
            String sql = "UPDATE CAD_USUARIO SET NOME = ?, EMAIL = ?, ENDERECO = ?, NUM_ENDERECO = ? , DATA_CADASTRO = ? WHERE ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1,usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3,usuario.getEndereco());
            stmt.setInt(4,usuario.getNum_endereco());
            java.sql.Date data = new java.sql.Date(usuario.getData_cadastro().getTime());
            stmt.setDate(5, data);

             stmt.setInt(6,usuario.getId());

             stmt.executeUpdate();


            }catch (SQLException e ){
                e.printStackTrace();


            }finally {
                try {
                    stmt.close();
                    conexao.close();

                }catch (SQLException e){
                    e.printStackTrace();
            }
        }
    }


    public Usuario BuscarPorId(int codigoBusca){

        Usuario usuario = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{

            conexao = Conexao.getConexao();

            //Buscado o Id do usuario no banco de dados
            String sql = "SELECT * FROM CAD_USUARIO WHERE ID_USUARIO = ?";
            stmt.setInt(1, codigoBusca);
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            //Fazendo o loop pra encontrar o usuario correspodente do Id
            while (rs.next()){

                int id = rs.getInt("ID_CADASTRO");
                String nome =  rs.getString("NOME");
                String email = rs.getString("email");
                String endereco = rs.getString("ENDERECO");
                int num_endereco = rs.getInt("NUM_ENDERECO");
                java.sql.Date data = rs.getDate("DATA_CADASTRO");

                usuario = new Usuario(id, nome , email , endereco , num_endereco, data );

                //Printando dados encontrado do usuário do Id
                System.out.println("\nId: " + id
                                    +"\nNome: " + nome
                                    +"\nEmail: " + email
                                    +"\nEndereco: " + endereco
                                    +"\nNumero da residência: " + num_endereco
                                    +"\nData de cadastro: " + data);
            }


            }catch (SQLException e){
                e.printStackTrace();


            }finally{
                try{
                    stmt.close();
                    rs.close();
                    conexao.close();

            }catch (SQLException e ){
                e.printStackTrace();
            }
        }

        return usuario;
    }



    public void RemoverUsuario(int codigoDelete){

        PreparedStatement stmt = null ;

        try{


            conexao = Conexao.getConexao();

            //DELETANDO CADASTRO COM ID DO PARARÂMETRO DO MÉTODO

            String sql = "DELETE FROM CAD_USUARIO WHERE ID_USUARIO = ? ";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1,codigoDelete);
            stmt.executeUpdate();

            System.out.println("CADASTRO DELETADO COM SUCESSO");


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
