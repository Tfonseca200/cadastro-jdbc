   package br.com.cadastro.connection;

   import java.sql.Connection;
   import java.sql.DriverManager;
   import java.sql.SQLException;

   public class Conexao {

      // Driver do banco de dados
      private static final String url = "jdbc:mysql://localhost:3306/bd_usuario";

      // Usuario do banco de dados
      private static final String user = "root";

      //Senha do banco de dados
      private static final String password = "bd001";

      private static Connection conexao = null;

      public static Connection getConexao() {

         try {
            // Conectado com o banco de dados
            return DriverManager.getConnection(url, user, password);

         } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("NÃO CONECTADO AO BANCO DE DADOS");
            return null;

         }
      }

      public static void fecharConexao(Connection conexao){
         if(conexao != null){
            try{
               conexao.close();

            }catch(SQLException e ){
               e.printStackTrace();
               System.out.println("Erro ao fechar conexao");
            }
         }
      }
   }