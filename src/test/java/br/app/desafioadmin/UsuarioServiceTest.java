package br.app.desafioadmin;

import br.app.desafioadmin.domain.Usuario;
import br.app.desafioadmin.domain.UsuarioDto;
import br.app.desafioadmin.domain.UsuarioResponse;
import br.app.desafioadmin.repositories.UsuarioRepository;
import br.app.desafioadmin.service.UsuarioServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

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

    @DisplayName("Listar Usuario Admin")
    @Test
    public void listaUsuario(){
// Arrange
        List<Usuario> listaUsuario = MockFactory.usuarioLista();
        List<Usuario> linha = service.listaCadastro(listaUsuario.get(0).getEmail());

        assertNotNull(linha);
        assertEquals("nino_silvio@abc.com", listaUsuario.get(0).getEmail());

//        List<Usuario> listaUsuarioAdm = List.of(listaUsuario.get(0));
//        when(repository.logarUsuario(listaUsuario.get(0).getEmail())).thenReturn(listaUsuarioAdm);
//        when(repository.findAll()).thenReturn(listaUsuario);
//        when(service.listaCadastro(listaUsuario.get(0).getEmail())).thenReturn(listaUsuario);
//        assertEquals("nino_silvio@abc.com", listaUsuario.get(0).getEmail());
    }

//    @DisplayName("Deletar Usuario")
//    @Test
//    public void deletarUser() {
//        // given
//
//        Usuario user = new Usuario();
//
////        String mensagem = "DELETOU";
//
//        List<Usuario> lista = MockFactory.usuarioLista();
//
//        when(repository.deleteCpf(lis));
//        doNothing().when(repository).deleteById(any());
//        service.deletarCpf(lista.get(0).getCpf(), lista.get(0).getEmail());
//        verify(repository, times(1)).deleteById(user.getId());
//    }


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