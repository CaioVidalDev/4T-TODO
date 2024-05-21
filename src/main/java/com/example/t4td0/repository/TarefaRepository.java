package com.example.t4td0.repository;

import com.example.t4td0.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Repositório Spring
public interface TarefaRepository extends JpaRepository<Tarefa, Long> { 
} // Interface que herda JPA, informando tarefa (Entidade) e o tipo do ID (Long)