package com.example.t4td0.validator;

import com.example.t4td0.model.Tarefa;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TarefaValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Tarefa.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Tarefa tarefa = (Tarefa) target;
        if (tarefa.getTitulo() == null || tarefa.getTitulo().isEmpty()) {
            errors.rejectValue("titulo", "titulo.obrigatorio", "Título é obrigatório");
        }
    }
}
