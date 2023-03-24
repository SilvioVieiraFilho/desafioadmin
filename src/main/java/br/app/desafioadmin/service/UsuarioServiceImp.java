package br.app.desafioadmin.service;

import br.app.desafioadmin.domain.Response;
import br.app.desafioadmin.domain.TipoUsuario;
import br.app.desafioadmin.domain.Usuario;
import br.app.desafioadmin.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioRepository repository;


    public String saveUser(Usuario usuario) {


        Usuario user = new Usuario();
        String mensagem;


        user.setNome(usuario.getNome());
        user.setCpf(usuario.getCpf());
        user.setTelefone(usuario.getTelefone());
        user.setEmail(usuario.getEmail());
        user.setFuncao(usuario.getFuncao());
        user.setTipo(usuario.getTipo());
        user.setSenha(usuario.getSenha());


        if (user.getEmail() == "" || user.getEmail() == null) {

            ResponseEntity.status(HttpStatus.BAD_REQUEST);
            return mensagem = "ERRO POR FAVOR INSIRA UM EMAIL";

        }

        if (user.getSenha() == "" || user.getSenha() == null) {

            ResponseEntity.status(HttpStatus.BAD_REQUEST);
            return mensagem = "ERRO POR FAVOR INSIRA UMA SENHA ";


        }


        repository.save(user);
        return mensagem = "200 OK CADASTRO SALVO";


    }

    public List<Usuario> listaCadastro(String email, String senha) {

        List<Usuario> lista = repository.findAll();

        Response response = new Response();

        Optional<Usuario> lista1 = repository.abc(email, senha);


        if (lista1.get().getTipo() == TipoUsuario.ADMIN) {

            response.setLista1(lista);

            return response.getLista1();

        }


        return response.getLista1();

    }

    public String deletarCpf(String id, String email, String senha) {

        Optional<Usuario> lista = repository.abc(email, senha);

        String message;

        if (lista.get().getTipo() == TipoUsuario.ADMIN) {
            repository.deleteById(id);


            message = "deletado com sucesso";

            return message;
        }
        message = "Usuario não possui esse nivel de acesso";
        return message;
    }


    public String alterarUsuario(String id, Usuario request, String email, String senha) {

        Optional<Usuario> lista = repository.abc(email, senha);

        String message;

        Usuario usuario = new Usuario();

        if (lista.get().getTipo() == TipoUsuario.ADMIN) {


            usuario.setId(id);
            usuario.setNome(request.getNome());
            usuario.setCpf(request.getCpf());
            usuario.setTipo(request.getTipo());
            usuario.setTelefone(request.getTelefone());
            usuario.setFuncao(request.getFuncao());
            usuario.setSenha(request.getSenha());

            repository.save(usuario);

            message = "Alteracao realizada com sucesso";

            return message;

        }

        message = "Usuario não possui esse nivel de acesso";
        return message;
    }


}
