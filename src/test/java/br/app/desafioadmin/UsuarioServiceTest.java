package br.app.desafioadmin;

import br.app.desafioadmin.domain.TipoUsuario;
import br.app.desafioadmin.domain.Usuario;
import br.app.desafioadmin.domain.UsuarioDto;
import br.app.desafioadmin.domain.UsuarioResponse;
import br.app.desafioadmin.repositories.UsuarioRepository;
import br.app.desafioadmin.service.UsuarioServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {
    @Mock
    UsuarioRepository repository;
    @Autowired
    UsuarioServiceImp service;

//    @InjectMocks
//    UsuarioServiceImp serviceImp;


    @Test
    @DisplayName("Deve salvar cadastro com sucesso")
    void salvarComSucesso() {
        UsuarioDto usuarioDto = MockFactory.usuarioDtoMock();
        UsuarioResponse request = MockFactory.usuarioResponseMock();
        service.saveUser(usuarioDto);
        assertNotNull(request);
    }
//    @DisplayName("Listar Usuario Admin")
//    @Test
//    public void listaUsuario() {
//// Arrange
//        List<Usuario> listaUsuario = MockFactory.usuarioLista();
//
//        Optional<Usuario> listaUsuarioAdm = Optional.of(listaUsuario.get(0));
//        when(repository.logarUsuario(listaUsuario.get(0).getEmail() , listaUsuario.get(0).getSenha())).thenReturn(listaUsuarioAdm);
//        when(service.listaCadastro(listaUsuarioAdm.get().getEmail(),listaUsuarioAdm.get().getSenha())).thenReturn(listaUsuario);
//        when(repository.findAll()).thenReturn(listaUsuario);
//
//        assertEquals("00000-0000",listaUsuario.get(0).getCpf());
//
//
//
//    }

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

}