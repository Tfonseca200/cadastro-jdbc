   package br.com.cadastro.connection;

   import java.sql.Connection;
   import java.sql.DriverManager;
   import java.sql.SQLException;

   public class Conexao {

      private static final String url = "jdbc:mysql://localhost:3306/bd_usuario";
      private static final String user = "root";
      private static final String password = "bd001";

      private static Connection conexao = null;

      public static Connection getConexao(){

         try {

            if (conexao == null) {
               conexao = DriverManager.getConnection(url, user, password);
               System.out.println("CONECTADO AO BANCO DE DADOS");
               return conexao;

            }

         } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("NÃO CONECTADO AO BANCO DE DADOS");
            return null;

         }

         return conexao;
      }
   }