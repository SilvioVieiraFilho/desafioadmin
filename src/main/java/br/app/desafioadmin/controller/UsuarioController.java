package br.app.desafioadmin.controller;

import br.app.desafioadmin.domain.Usuario;
import br.app.desafioadmin.domain.UsuarioDto;
import br.app.desafioadmin.domain.UsuarioResponse;
import br.app.desafioadmin.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;


    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody UsuarioDto usuario) {

        UsuarioResponse user = service.saveUser(usuario);

        return ResponseEntity.created(null).body(user);

    }

    @GetMapping

    public ResponseEntity<List<Usuario>> listarUsuario(@RequestParam String email){
        List<Usuario> listalogin = service.listaCadastro(email);
        return ResponseEntity.ok().body(listalogin);
    }

    @DeleteMapping(path = "/{cpf}")
    public ResponseEntity deletarUsuario(@PathVariable String cpf, @RequestParam String email) {
        service.deletarCpf(cpf, email);
        return new ResponseEntity<>(cpf, HttpStatus.OK);

    }

    @PutMapping(path = "/alterarusuario/{id}")
    public ResponseEntity<UsuarioResponse> alteraUsuario(@PathVariable String id, @RequestBody UsuarioDto usuarioDto, @RequestParam String email) {

        UsuarioResponse user = service.alterarUsuario(id, usuarioDto, email);

        return ResponseEntity.ok().body(user);

    }

}
