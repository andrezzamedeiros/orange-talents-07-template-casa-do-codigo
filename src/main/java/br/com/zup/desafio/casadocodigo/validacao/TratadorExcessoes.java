package br.com.zup.desafio.casadocodigo.validacao;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class TratadorExcessoes {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDto> handle(MethodArgumentNotValidException exception) {

        List<ErroDto> erros = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(x ->
                erros.add(new ErroDto(x.getField(), messageSource.getMessage(x, LocaleContextHolder.getLocale())))
        );
        return erros;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<ErroDto> handleViolation(ConstraintViolationException exception) {

        List<ErroDto> erros = new ArrayList<>();
        exception.getConstraintViolations().forEach(x ->
                erros.add(new ErroDto(x.getMessage()))
        );
        return erros;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErroDto handleViolation(NotFoundException exception, HttpServletRequest request) {
        return new ErroDto(request.getRequestURI(),exception.getMessage());
    }
}
