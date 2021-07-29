package br.com.zup.desafio.casadocodigo.Repository;

import br.com.zup.desafio.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

   Optional<Autor> findByEmail(String email);
}