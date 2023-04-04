package br.app.desafioadmin.service;

import br.app.desafioadmin.domain.Usuario;
import br.app.desafioadmin.domain.UsuarioDto;
import br.app.desafioadmin.domain.UsuarioResponse;

import java.util.List;

public interface UsuarioService {

    public UsuarioResponse saveUser(UsuarioDto usuario);

    public List<Usuario> listaCadastro(String email);

    public void deletarCpf(String cpf,String email);

    public UsuarioResponse alterarUsuario(String id, UsuarioDto usuarioDto, String email);
}




