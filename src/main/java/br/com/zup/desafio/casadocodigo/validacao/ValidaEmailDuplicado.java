package br.com.zup.desafio.casadocodigo.validacao;

import br.com.zup.desafio.casadocodigo.Repository.AutorRepository;
import br.com.zup.desafio.casadocodigo.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ValidaEmailDuplicado {

    @Autowired
    private AutorRepository autorRepository;

    public boolean valida(Autor autor) throws Exception {
        try {
            Optional<Autor> autorOptional = autorRepository.findByEmail(autor.getEmail());
            if (autorOptional.isPresent()){
                return true;
            }
                return false;
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro inesperado");
        }
    }
}
