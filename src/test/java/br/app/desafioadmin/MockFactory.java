package br.app.desafioadmin;

import br.app.desafioadmin.domain.TipoUsuario;
import br.app.desafioadmin.domain.Usuario;
import br.app.desafioadmin.domain.UsuarioDto;
import br.app.desafioadmin.domain.UsuarioResponse;

import java.util.ArrayList;
import java.util.List;

public class MockFactory {

    public static List<Usuario> usuarioLista() {

        List<Usuario> lista = new ArrayList<>();
        Usuario user = new Usuario();
        user.setNome("sad");
        user.setEmail("nino_silvio@abc.com");
        user.setSenha("abc");
        user.setCpf("00000-0000");
        user.setFuncao("trabaiador");
        user.setTipo(TipoUsuario.ADMIN);
        user.setTelefone("00000-0000");
        user.setId("203de448-13b6-4193-b09e-2343a13f2564");

        lista.add(user);
        return lista;
    }

    public static UsuarioResponse usuarioResponseMock() {

        UsuarioResponse usuarioResponse = new UsuarioResponse();

        usuarioResponse.setNome("teste_nome");
        usuarioResponse.setCpf("teste_cpf");
        usuarioResponse.setTelefone("teste_telefone");
        usuarioResponse.setEmail("teste_email");
        usuarioResponse.setFuncao("teste_funcao");
        usuarioResponse.setTipo(TipoUsuario.ADMIN);
        usuarioResponse.setSenha("teste_senha");
        usuarioResponse.setId("abfdhfhsdfhsadfdasdgsd");

        return usuarioResponse;

    }

    public static Usuario usuarioMock() {

        Usuario usuario = new Usuario();

        usuario.setNome("teste_nome");
        usuario.setCpf("teste_cpf");
        usuario.setTelefone("teste_telefone");
        usuario.setEmail("teste_email");
        usuario.setFuncao("teste_funcao");
        usuario.setTipo(TipoUsuario.ADMIN);
        usuario.setSenha("teste_senha");
        usuario.setId("abfdhfhsdfhsadfdasdgsd");

        return usuario;

    }


    public static UsuarioDto usuarioDtoMock() {

        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setNome("teste_nome");
        usuarioDto.setCpf("teste_cpf");
        usuarioDto.setTelefone("teste_telefone");
        usuarioDto.setEmail("teste_email");
        usuarioDto.setFuncao("teste_funcao");
        usuarioDto.setTipo(TipoUsuario.ADMIN);
        usuarioDto.setSenha("teste_senha");


        return usuarioDto;
    }
}