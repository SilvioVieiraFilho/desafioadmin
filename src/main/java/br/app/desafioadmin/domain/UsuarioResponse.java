package br.app.desafioadmin.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse  {

    String cpf;
    String email;
    String senha;
    String nome;
    String telefone;

    String funcao;
    TipoUsuario tipo;
    String id;

}
