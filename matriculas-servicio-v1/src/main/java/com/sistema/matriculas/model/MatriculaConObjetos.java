package com.sistema.matriculas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatriculaConObjetos {
    private Long id;
    private Object estudiante;
    private Object profesor;
    private Object materia;
}
