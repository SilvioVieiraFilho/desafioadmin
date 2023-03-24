package br.app.desafioadmin.service;

import br.app.desafioadmin.domain.Usuario;

import java.util.List;

public interface UsuarioService {


    public String saveUser(Usuario usuario);

    public List <Usuario> listaCadastro(String email, String senha);

    public String deletarCpf(String id, String email, String senha);

    public String alterarUsuario(String id, Usuario request, String email, String senha);

}
