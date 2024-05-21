package com.example.t4td0.validator;

import com.example.t4td0.model.Tarefa;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component // Ccomponente Spring
public class TarefaValidator implements Validator {

    @Override
    public boolean supports(@SuppressWarnings("null") Class<?> clazz) {
        return Tarefa.class.equals(clazz);
    } // Validador sendo aplicado a classe tarefa

    @Override
    public void validate(@SuppressWarnings("null") Object target, @SuppressWarnings("null") Errors errors) {
        Tarefa tarefa = (Tarefa) target; // De objeto alvo para tarefa
        if (tarefa.getTitulo() == null || tarefa.getTitulo().isEmpty()) {
            errors.rejectValue("titulo", "titulo.obrigatorio", "Título é obrigatório");
        } // Adiciona erro se o título for nulo ou vazio
    }
}
