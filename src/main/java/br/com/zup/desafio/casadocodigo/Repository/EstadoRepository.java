package br.com.zup.desafio.casadocodigo.Repository;

import br.com.zup.desafio.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
