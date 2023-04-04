package br.app.desafioadmin.service;

import br.app.desafioadmin.domain.TipoUsuario;
import br.app.desafioadmin.domain.Usuario;
import br.app.desafioadmin.domain.UsuarioDto;
import br.app.desafioadmin.domain.UsuarioResponse;
import br.app.desafioadmin.exception.UsuarioBusinessExcepetion;
import br.app.desafioadmin.exception.handler.ExceptionHandler;
import br.app.desafioadmin.mapper.MapperUsuario;
import br.app.desafioadmin.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository repository;


    public UsuarioResponse saveUser(UsuarioDto usuarioDto) {
        Usuario usuarioEntity = MapperUsuario.toUsuario(usuarioDto);
        UsuarioResponse response = MapperUsuario.toUsuarioResponse(usuarioEntity);
        UsuarioResponse response1 = validaEmailResponse(usuarioDto, response);

        if (response.getCpf() == "" || response.getCpf() == null) {

            throw new UsuarioBusinessExcepetion();

        }
        if (response.getEmail() == "" || response.getEmail() == null) {

            throw new UsuarioBusinessExcepetion();
        }

        repository.save(usuarioEntity);
        return response;
    }

    public List<Usuario> listaCadastro(String email) {
        List<Usuario> lista = repository.findAll();
        List<Usuario> retornoListaAdm = repository.logarUsuario(email);
        for (Usuario l : retornoListaAdm) {
            if (l.getTipo().equals(TipoUsuario.ADMIN)) {
                return lista;
            }
        }
        return List.of();
    }

    public void deletarCpf(String cpf, String email) {
        List<Usuario> lista = repository.logarUsuario(email);
        loginUsuarioDel(cpf, lista);
        if(cpf == "" || cpf == null){
            throw new UsuarioBusinessExcepetion();
        }
    }

    public UsuarioResponse alterarUsuario(String id, UsuarioDto usuarioDto, String email) {
//        List<Usuario> lista = repository.logarUsuario(email);
        Usuario usuarioEntity = MapperUsuario.toUsuarioupdate(usuarioDto, id);
        UsuarioResponse response = MapperUsuario.toUsuarioResponse(usuarioEntity);
        repository.save(usuarioEntity);

        return response;
    }

    private void loginUsuarioDel(String cpf, List<Usuario> lista) {
        if (lista.get(0).getTipo() == TipoUsuario.ADMIN) {
            repository.deleteCpf(cpf);
        } else {
            throw new UsuarioBusinessExcepetion();
        }
    }

    private static UsuarioResponse validaEmailResponse(UsuarioDto usuarioDto, UsuarioResponse response) {
        if (usuarioDto.getEmail() == "" || usuarioDto.getEmail() == null) {
            throw new UsuarioBusinessExcepetion();
        }
        return response;
    }


}