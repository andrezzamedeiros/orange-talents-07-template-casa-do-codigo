package br.com.zup.desafio.casadocodigo.validacao;

import br.com.zup.desafio.casadocodigo.Repository.AutorRepository;
import br.com.zup.desafio.casadocodigo.model.Autor;
import br.com.zup.desafio.casadocodigo.model.form.AutorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidaEmailDuplicado implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        AutorForm request = (AutorForm) target;
        Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());
        if(autor.isPresent()){
            errors.rejectValue("email", null, "Email já cadastrado!");
        }

    }
}
