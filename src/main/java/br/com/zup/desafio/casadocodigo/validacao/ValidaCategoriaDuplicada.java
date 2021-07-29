package br.com.zup.desafio.casadocodigo.validacao;

import br.com.zup.desafio.casadocodigo.Repository.CategoriaRepository;
import br.com.zup.desafio.casadocodigo.model.Autor;
import br.com.zup.desafio.casadocodigo.model.Categoria;
import br.com.zup.desafio.casadocodigo.model.form.AutorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidaCategoriaDuplicada implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return Categoria.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        Categoria request = (Categoria) target;
        Optional<Categoria> categoria = categoriaRepository.findByNome(request.getNome());
        if(categoria.isPresent()){
            errors.rejectValue("nome", null, "Categoria já cadastrada!");
        }
    }
}
