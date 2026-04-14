package com.TaskFlow.FixNow.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskFlow.FixNow.Model.Estado;
import com.TaskFlow.FixNow.Model.Prioridad;
import com.TaskFlow.FixNow.Model.Tarea;
import com.TaskFlow.FixNow.Repository.TareaRepository;

@Service
public class TareaService {

    @Autowired
    private TareaRepository repository;

    //Traer desde repository (Para SERVICE -> "list")
        //1) Retornar lista completa (GET)
    public List<Tarea> listAll() {
        return repository.findAll();
    }

        //2) Retornar por ID (GET)
    public Optional<Tarea> listByID(Long id) {
        return repository.findById(id);
    }

        //3) Registrar nueva tarea (POST)
    public void save(Tarea tarea) {
        repository.save(tarea);
    }

        //4) Actulizar datos de una tarea (PUT)
    public int updateDatos(Long id, String titulo, String descripcion, Estado estado, 
    Prioridad prioridad, String responsable, LocalDate fechaLimite) {

        Optional<Tarea> tOpt = repository.findById(id);           
            
        if (tOpt.isEmpty()) {
            return 0;
        }

        Tarea tarea = tOpt.get();
        
        if(tarea.getTitulo().length() > 100) {
            return 1;
        }

        repository.updateDatos(id, titulo,
        descripcion, estado, prioridad, responsable, fechaLimite);
        return 2;
    }

        //5) Eliminar una tarea (DELETE)
    public boolean delete(Long id) {
        return repository.delete(id);
    }

        //6) Retornar por Estado (Usar filtro) (GET)
    public void listByEstado(Estado estado) {
        repository.findByEstado(estado);
    }
}
