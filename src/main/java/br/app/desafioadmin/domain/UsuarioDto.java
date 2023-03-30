package br.app.desafioadmin.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UsuarioDto {

    String cpf;
    String email;
    String telefone;
    String nome;

    TipoUsuario tipo;

    String funcao;

    String senha;



}
