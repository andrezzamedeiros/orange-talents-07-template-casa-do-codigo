package br.com.zup.desafio.casadocodigo.Repository;

import br.com.zup.desafio.casadocodigo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}
