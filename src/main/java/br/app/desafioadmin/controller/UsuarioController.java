package br.app.desafioadmin.controller;

import br.app.desafioadmin.domain.Usuario;
import br.app.desafioadmin.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;


    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody Usuario usuario) {

        String user = service.saveUser(usuario);


        return ResponseEntity.ok().body(user);
    }

    @GetMapping

    public ResponseEntity listarUsuario(@RequestParam String email, @RequestParam String senha) {

        List<Usuario> listalogin = service.listaCadastro(email, senha);


        return ResponseEntity.ok().body(listalogin);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletarUsuario(@PathVariable String id, @RequestParam String email, @RequestParam String senha) {

        String mensagem = service.deletarCpf(id, email, senha);


        return ResponseEntity.ok().body(mensagem);
    }

    @PutMapping(path = "/alterarusuario")
    public ResponseEntity alteraUsuario(@RequestParam String id, @RequestBody Usuario usuario, @RequestParam String email, @RequestParam String senha) {

        String user = service.alterarUsuario(id, usuario, email, senha);

        return ResponseEntity.ok().body(user);

    }

}
