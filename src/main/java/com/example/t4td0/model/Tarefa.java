package com.example.t4td0.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Classe é uma entidade JPA
public class Tarefa {

    @Id // ID é uma chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração do ID
    private Long id;

    private String titulo; // Titulo da tarefa

    public Tarefa() { // Construtor
    }

    public Tarefa(String titulo) { // Construtor que incia o título da tarefa
        this.titulo = titulo; 
    }

    public Long getId() { // Getter para o ID
        return id;
    }

    public void setId(Long id) { // Setter para o ID
        this.id = id;
    }

    public String getTitulo() { // Getter para o Titulo
        return titulo;
    }

    public void setTitulo(String titulo) { // Setter para o Titulo
        this.titulo = titulo;
    }
}

