package com.example.t4td0.dtos; 

import jakarta.validation.constraints.NotBlank; 

public record RecordDto(@NotBlank String titulo) {} // Cria e escolhe a classe RecordDto como um record com um campo titulo que deve ser NotBlank (não vazio)
