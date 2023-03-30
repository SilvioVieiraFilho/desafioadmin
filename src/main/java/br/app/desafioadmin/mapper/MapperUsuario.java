package br.app.desafioadmin.mapper;

import br.app.desafioadmin.domain.Usuario;
import br.app.desafioadmin.domain.UsuarioDto;
import br.app.desafioadmin.domain.UsuarioResponse;

import java.util.ArrayList;
import java.util.List;

public class MapperUsuario {
    public static Usuario toUsuario(UsuarioDto request) {
        Usuario user = new Usuario();
        user.setCpf(request.getCpf());
        user.setNome(request.getNome());
        user.setTelefone(request.getTelefone());
        user.setEmail(request.getEmail());
        user.setTipo(request.getTipo());
        user.setFuncao(request.getFuncao());
        user.setSenha(request.getSenha());
        return user;
    }

    public static UsuarioResponse toUsuarioResponse(Usuario usuario) {
        UsuarioResponse user = new UsuarioResponse();
        user.setCpf(usuario.getCpf());
        user.setNome(usuario.getNome());
        user.setEmail(usuario.getEmail());
        user.setTelefone(usuario.getTelefone());
        user.setTipo(usuario.getTipo());
        user.setFuncao(usuario.getFuncao());
        user.setSenha(usuario.getSenha());
        return user;
    }

    public static List<UsuarioResponse> toListaResponse(List<Usuario> usuario) {
        List<UsuarioResponse> lista = new ArrayList<>();
        for (Usuario user : usuario) {
            lista.add(toUsuarioResponse(user));
        }
        return lista;
    }

    public static Usuario toUsuarioupdate(Usuario request, String id) {
        Usuario user = new Usuario();
        user.setCpf(request.getCpf());
        user.setNome(request.getNome());
        user.setTelefone(request.getTelefone());
        user.setEmail(request.getEmail());
        user.setTipo(request.getTipo());
        user.setFuncao(request.getFuncao());
        user.setSenha(request.getSenha());
        user.setId(id);
        return user;
    }
}


