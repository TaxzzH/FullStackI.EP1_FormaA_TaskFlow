package com.TaskFlow.FixNow.Model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tarea {
    @NotNull
    private Long id;

    @NotBlank(message="El titulo no puede quedar en blanco")
    private String titulo;

    @NotBlank(message="La descripcion no puede quedar en blanco")
    private String descripcion;
    
    @NotBlank(message="El estado no puede quedar en blanco")
    private Estado estado;

    @NotBlank(message="La prioridad no puede quedar en blanco")
    private Prioridad prioridad;

    @NotBlank(message="Debe haber un responsable")
    private String responsable;

    //Auto
    private LocalDate fechaCreacion;

    @NotNull
    private LocalDate fechaLimite;
}
