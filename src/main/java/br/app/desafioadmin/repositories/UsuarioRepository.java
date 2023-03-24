package br.app.desafioadmin.repositories;

import br.app.desafioadmin.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface UsuarioRepository  extends JpaRepository<Usuario,String> {



    @Query(value = "SELECT i FROM Usuario i WHERE i.email = :email and i.senha = :senha")
    Optional<Usuario> abc(@Param("email") String email,@Param("senha") String  senha);

    Optional<Usuario> findByTipo(String tipo);

    Optional<Usuario> deleteByCpf(String cpf);
}
