package br.com.zup.desafio.casadocodigo.validacao.annotations;

import br.com.zup.desafio.casadocodigo.validacao.ExistsIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({ElementType.FIELD})
public @interface ExistsId {

    String message()default "{br.com.zup.desafio.casadocodigo.beanvalidation.uniquevalue}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default{ };

    String fieldName();

    Class<?> domainClass();

}
