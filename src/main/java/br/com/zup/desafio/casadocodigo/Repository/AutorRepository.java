package br.com.zup.desafio.casadocodigo.Repository;

import br.com.zup.desafio.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
