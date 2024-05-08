package com.example.t4td0.validator;

import com.example.t4td0.model.Tarefa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TarefaValidatorTest {

    @Autowired
    private TarefaValidator tarefaValidator;

    @Test
    void TesteValidarComTituloVazio() {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("");

        Errors errors = new BeanPropertyBindingResult(tarefa, "tarefa");
        tarefaValidator.validate(tarefa, errors);

        assertTrue(errors.hasErrors());
        assertEquals("Título é obrigatório", errors.getFieldError("titulo").getDefaultMessage());
    }

    @Test
    void TesteValidarComTituloNaoVazio() {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Tarefa de teste");

        Errors errors = new BeanPropertyBindingResult(tarefa, "tarefa");
        tarefaValidator.validate(tarefa, errors);

        assertFalse(errors.hasErrors());
    }
}