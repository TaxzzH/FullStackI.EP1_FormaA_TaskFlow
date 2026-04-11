package com.TaskFlow.FixNow.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.TaskFlow.FixNow.Model.Tarea;

@Repository
public class TareaRepository {

    //BDD
    private List<Tarea> listaTareas = new ArrayList<>();
    native 

    //DDP
    public TareaRepository() {
        listaTareas.add(new Tarea(1, "Tarea 1", "Esta es la tarea 1", "PENDIENTE"
        ,"ALTA", "Juanito", LocalDate.now(), "2026-10-04"));
    }

}
