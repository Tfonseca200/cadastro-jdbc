package br.com.cadastro.menu;

import br.com.cadastro.usuario.Usuario;
import br.com.cadastro.usuarioDao.UsuarioDao;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;


public class MenuAplicacao {



    public static void main(String[] args){


        Scanner imput = new Scanner(System.in);
        Usuario usuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        int opcao = 0;
        boolean repeticaoDoMenu = true;


        while(repeticaoDoMenu){

        System.out.println( "=================MENU DE CADASTRO======================="+
                            "\n1 - Cadastrar usuario " +
                            "\n2 - Listar Usuario " +
                            "\n3 - Atualizar cadastro " +
                            "\n4 - Buscar usuario por Id " +
                            "\n5 - Remover cadastro do usuario " +
                            "\n0 - Sair do sistema " +
                         "\n========================================================");

                            System.out.print("Digite a opção por favor: ");

        try {
            opcao = imput.nextInt();
            imput.nextLine();

            System.out.println( "\n========================================================");

        }catch (InputMismatchException e){
            System.err.println("Escolha uma opção valida por favor!");
        }



        switch(opcao) {

            case 1 :

                try {


                    System.out.println("Digite o nome: ");
                    String nome = imput.nextLine();

                    System.out.println("Digite o email: ");
                    String email = imput.nextLine();

                    System.out.println("Digite o endereço: ");
                    String endereco = imput.nextLine();

                    System.out.println("Digite o Numero de endereço: ");
                    int num_endereco = imput.nextInt();


                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setEndereco(endereco);
                    usuario.setNum_endereco(num_endereco);
                    usuario.setData_cadastro(new java.sql.Date(new java.util.Date().getTime()));



                    dao.Cadastrar(usuario);
                    System.out.println("Cadastro concluido!");

                }catch (InputMismatchException e){
                    System.err.println("Dados de cadastro incorretos, por favor tente novamente ");
                    e.getMessage();


                }
                break;


                case 2:

                    List<Usuario> lista = dao.ListarUsuarios();

                    for (Usuario dados: lista){
                        System.out.println(
                                        "=======================Usuario=============================="
                                        +"\nId:" + dados.getId()
                                        +"\nNome: " + dados.getNome()
                                        +"\nEmail:" + dados.getEmail()
                                        +"\nEndereço: " + dados.getEndereco()
                                        +"\nNumero de endereço: " + dados.getNum_endereco()
                                        +"\nData de cadastro: " +dados.getData_cadastro()
                                        +"\n========================================================\n");


                    }
                break;


                case 3:

                    try {

                        System.out.println("Digite o id do usuario que deseja altera os cadastro: ");
                        int id = imput.nextInt();
                        imput.nextLine();

                        //Usando o método verificar id, se retornar true é porque tem id do usúario
                        if (dao.verificarId(id) != false){

                            System.out.println("Digite o nome: ");
                            String nome = imput.nextLine();

                            System.out.println("Digite o email: ");
                            String email = imput.nextLine();

                            System.out.println("Digite o endereço: ");
                            String endereco = imput.nextLine();

                            System.out.println("Digite o Numero de endereço: ");
                            int num_endereco = imput.nextInt();

                            usuario.setNome(nome);
                            usuario.setEmail(email);
                            usuario.setEndereco(endereco);
                            usuario.setNum_endereco(num_endereco);
                            usuario.setData_cadastro(new java.sql.Date(new java.util.Date().getTime()));
                            usuario.setId(id);

                        dao.AtualizarCadastro(usuario);
                        System.out.println("Usuario atualizado com sucesso!");

                        }else{
                            System.out.println("Usuario não cadastrado!");
                        }



                    }catch (InputMismatchException e) {
                        System.err.println("Dados de cadastro incorretos, por favor tente novamente ");
                        e.getMessage();
                    }

                    break;


                case 4:

                    System.out.println("Digite o Id do usuario pra visualizar dados de cadastro: ");

                    try {
                        int id = imput.nextInt();

                        //Usando o método verificar id, se retornar true é porque tem id do usúario
                        if (dao.verificarId(id) != false){
                            dao.BuscarPorId(id);
                        }else{
                            System.out.println("Usuario não cadastrado!");
                        }


                    }catch ( InputMismatchException e){
                        System.err.println("Id invalido!");
                        e.printStackTrace();
                    }

                    break;


               case 5:

                   System.out.println("Digite o Id pra deletar o usuario: ");

                   try {
                       int id = imput.nextInt();

                       //Usando o método verificar id, se retornar true é porque tem id do usúario
                       if (dao.verificarId(id) != false){
                           dao.RemoverUsuario(id);
                            System.out.println("Usuario deletado com sucesso!");

                       }else{
                           System.out.println("Usuario não cadastrado!");
                       }



                   }catch ( InputMismatchException e){
                       System.err.println("Id invalido!");
                       e.printStackTrace();
                   }

                   break;


              case 0:
                  System.out.println("Sistema encerrado!");
                  repeticaoDoMenu = false;
                 break;


               default:
                   System.out.println("Opção invalida!");

                    break;



            }
        }
    }
}

