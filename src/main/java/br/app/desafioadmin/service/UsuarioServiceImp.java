package br.app.desafioadmin.service;

import br.app.desafioadmin.domain.*;
import br.app.desafioadmin.exception.UsuarioBusinessExcepetion;
import br.app.desafioadmin.mapper.MapperUsuario;
import br.app.desafioadmin.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository repository;


    public UsuarioResponse saveUser(UsuarioDto usuarioDto) {

        Usuario usuarioEntity = MapperUsuario.toUsuario(usuarioDto);
        UsuarioResponse response = MapperUsuario.toUsuarioResponse(usuarioEntity);

//        UsuarioResponse response1 = validaEmailResponse(usuarioDto, response);
//        if (response1 != null) return response1;

//        UsuarioResponse response2 = validaSenhaUsuario(usuarioDto, response);
//        if (response2 != null) return response2;

        repository.save(usuarioEntity);
        return response;
    }

    private static UsuarioResponse validaSenhaUsuario(UsuarioDto usuarioDto, UsuarioResponse response) {
        if (usuarioDto.getSenha() == "" || usuarioDto.getSenha() == null) {
            throw new UsuarioBusinessExcepetion();
        }
        return response;
    }

    private static UsuarioResponse validaEmailResponse(UsuarioDto usuarioDto, UsuarioResponse response) {
        if (usuarioDto.getEmail() == "" || usuarioDto.getEmail() == null) {
            throw new UsuarioBusinessExcepetion();
        }
        return response;
    }

    public List<Usuario> listaCadastro(String email, String senha) {

        ResponseList response = new ResponseList();

        List<Usuario> lista = repository.findAll();

        Optional<Usuario> retornoListaAdm = repository.logarUsuario(email, senha);

        if (logarUsuario(response, lista, retornoListaAdm)) return response.getLista1();
        return response.getLista1();
    }
    public void deletarCpf(String cpf, String email, String senha) {

        Optional<Usuario> lista = repository.logarUsuario(email, senha);

        loginUsuarioDel(cpf, lista);
    }

    private void loginUsuarioDel(String cpf, Optional<Usuario> lista) {
        if (lista.get().getTipo() == TipoUsuario.ADMIN) {
            repository.deleteCpf(cpf);
        } else {
            throw new UsuarioBusinessExcepetion();
        }
    }

    public UsuarioResponse alterarUsuario(String id, Usuario usuarioDto, String email, String senha) {
        Optional<Usuario> lista = repository.logarUsuario(email, senha);
        Usuario usuarioEntity = MapperUsuario.toUsuarioupdate(usuarioDto, id);
        UsuarioResponse response = MapperUsuario.toUsuarioResponse(usuarioEntity);
        repository.save(usuarioEntity);
        if (lista.get().getTipo() == TipoUsuario.ADMIN) {
            repository.save(usuarioEntity);
            return response;
        }
        return null;
    }

    private static boolean logarUsuario(ResponseList response, List<Usuario> lista, Optional<Usuario> retornoListaAdm) {
        if (retornoListaAdm.get().getTipo() == TipoUsuario.ADMIN) {

            response.setLista1(lista);

            return true;

        }
        return false;
    }
}
