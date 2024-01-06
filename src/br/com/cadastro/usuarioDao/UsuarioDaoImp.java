package br.com.cadastro.usuarioDao;

import br.com.cadastro.usuario.Usuario;

import java.util.List;

public interface UsuarioDaoImp {

    void cadastrar(Usuario usuario);

    List<Usuario> buscarTodos();

    Usuario buscarPorId(int codigo);

    void atualizarCadastro(Usuario usuario);

    void remove (int codigo);
}
