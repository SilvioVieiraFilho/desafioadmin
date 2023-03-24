package br.app.desafioadmin.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
public class Usuario {

    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Id
    private String id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoUsuario tipo;

    @Column(name = "funcao")
    private String funcao;

    @Column(name = "senha")
    private String senha;


    public Usuario() {

    }


    public Usuario(String id, String nome, String cpf, String telefone, String email, TipoUsuario tipo, String funcao, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.tipo = tipo;
        this.funcao = funcao;
        this.senha = senha;
    }
}
