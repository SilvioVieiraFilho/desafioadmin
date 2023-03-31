package br.app.desafioadmin.repositories;

import br.app.desafioadmin.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Transactional
    @Modifying
    @Query(value = "delete from Usuario i where i.cpf=:cpf")
    void deleteCpf(@Param("cpf") String cpf);

    @Query(value = "SELECT i FROM Usuario i WHERE i.email = :email")
    List<Usuario> logarUsuario(@Param("email") String email);


}
