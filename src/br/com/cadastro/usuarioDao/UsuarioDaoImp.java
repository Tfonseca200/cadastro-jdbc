package br.com.cadastro.usuarioDao;

import br.com.cadastro.usuario.Usuario;

import java.util.List;

public interface UsuarioDaoImp {

    void Cadastrar(Usuario usuario);

    List<Usuario> ListarUsuarios();

    void AtualizarCadastro(Usuario usuario);

    Usuario BuscarPorId(int codigo);

    void RemoverUsuario(int codigoDelete);
}
