package br.app.desafioadmin;

import br.app.desafioadmin.domain.TipoUsuario;
import br.app.desafioadmin.domain.Usuario;
import br.app.desafioadmin.repositories.UsuarioRepository;
import br.app.desafioadmin.service.UsuarioServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class Service {

    String name = TipoUsuario.ADMIN.name();
    TipoUsuario mode = TipoUsuario.valueOf(name);




    @Mock
    UsuarioRepository repository;
    @Autowired
    UsuarioServiceImp service;


    UUID uuid = UUID.randomUUID();


    @InjectMocks
    UsuarioServiceImp serviceImp;
    Usuario usuario;

    @Captor
    ArgumentCaptor<Usuario> captor;

    @Test
    @DisplayName("Deve salvar cadastro com sucesso")
    void salvarComSucesso() {

        String name = TipoUsuario.ADMIN.name();
        TipoUsuario mode = TipoUsuario.valueOf(name);

        Usuario request = new Usuario();

        request.setNome("teste_nome");
        request.setCpf("teste_cpf");
        request.setTelefone("teste_telefone");
        request.setEmail("teste_email");
        request.setFuncao("teste_funcao");
        request.setTipo(mode);
        request.setSenha("teste_senha");
        request.setId(uuid.toString());


        service.saveUser(request);

        verify(repository).save(captor.capture());
        Usuario agendaSalva = captor.getValue();


        assertEquals(request.getEmail() != null, Boolean.TRUE);

        assertEquals(request.getSenha() != null, Boolean.TRUE);

        Assertions.assertThat(agendaSalva.getNome()).isNotNull();
        Assertions.assertThat(agendaSalva.getSenha()).isNotNull();
        Assertions.assertThat(agendaSalva.getCpf()).isNotNull();
        Assertions.assertThat(agendaSalva.getTelefone()).isNotNull();
        Assertions.assertThat(agendaSalva.getEmail()).isNotNull();
        Assertions.assertThat(agendaSalva.getFuncao()).isNotNull();
        Assertions.assertThat(agendaSalva.getTipo()).isNotNull();


    }

    @DisplayName("Listar Usuario Admin")
    @Test
    public void listaUsuario() {
// Arrange


        Usuario user = MockFactory.usuarioLista().get(0);


        when(serviceImp.listaCadastro(user.getEmail(), user.getSenha())).thenReturn(MockFactory.usuarioLista());
        when(repository.findAll()).thenReturn(List.of(MockFactory.usuarioLista().get(0)));



        assertEquals(TipoUsuario.ADMIN, user);
//        assertNotNull(response);
//        assertEquals(user.getNome(), response.get(0).getNome());
//        assertEquals(user.getEmail(), response.get(0).getEmail());
//        assertEquals(user.getSenha(), response.get(0).getSenha());
//        assertEquals(user.getCpf(), response.get(0).getTelefone());
//        assertEquals(user.getFuncao(), response.get(0).getFuncao());
//        assertEquals(user.getTipo(), response.get(0).getTipo());
//        assertEquals(user.getTelefone(), response.get(0).getTelefone());
//        assertEquals(user.getId(), response.get(0).getId());


    }

    @DisplayName("Deletar Usuario")
    @Test
    public void deletarUser() {
        // given


        Usuario user = new Usuario();


//        String mensagem = "DELETOU";

        List<Usuario> list;


        Mockito.when(repository.findById(user.getId())).thenReturn(Optional.of(user));
        Mockito.doNothing().when(repository).deleteById(Mockito.any());
        service.deletarCpf(user.getId(), user.getEmail(), user.getSenha());
        verify(repository, Mockito.times(1)).deleteById(user.getId());
    }


}


//    @Test
//    void saveUserusuario(@mockito) {
//
//
//        Usuario request = new Usuario();
//
//        String name = TipoUsuario.ADMIN.name();
//        TipoUsuario mode = TipoUsuario.valueOf(name);
//
//        request.setNome("teste_nome");
//        request.setCpf("teste_cpf");
//        request.setTelefone("teste_telefone");
//        request.setEmail("teste_email");
//        request.setFuncao("teste_funcao");
//        request.setTipo(mode);
//        request.setSenha("teste_senha");
//        request.setId(uuid.toString());
//
//        String response = service.saveUser(request);
//
//        Mockito.verify()
//    }
//
//    @Test
//
//    void listarGet(){
//
//
//        String email = "nino_silvio@abc.com";
//        String senha = "abc";
//
//      List<Usuario> user =   service.listaCadastro(email,senha);
//
//      List <Usuario> listadeusuario = user;
//
//
//        Assertions.assertEquals(user,listadeusuario);
//
//    }
//MOCKTIO

