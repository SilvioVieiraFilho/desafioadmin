package br.app.desafioadmin;

import br.app.desafioadmin.domain.TipoUsuario;
import br.app.desafioadmin.domain.Usuario;

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
}