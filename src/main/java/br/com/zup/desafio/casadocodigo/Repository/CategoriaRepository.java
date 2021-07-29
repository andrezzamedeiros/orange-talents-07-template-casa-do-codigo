package br.com.zup.desafio.casadocodigo.Repository;

import br.com.zup.desafio.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria>findByNome(String nome);
}
