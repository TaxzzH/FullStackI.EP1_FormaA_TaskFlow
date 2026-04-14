package com.TaskFlow.FixNow.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.TaskFlow.FixNow.Model.Estado;
import com.TaskFlow.FixNow.Model.Prioridad;
import com.TaskFlow.FixNow.Model.Tarea;

@Repository
public class TareaRepository {

    //BDD
    @SuppressWarnings("FieldMayBeFinal")
    private List<Tarea> listaTareas = new ArrayList<>();

    //DDP
    public TareaRepository() {
        listaTareas.add(new Tarea(1L, "Tarea 1", "Esta es la tarea 1", Estado.PENDIENTE,
        Prioridad.ALTA, "Juanito", LocalDate.now(), LocalDate.of(2026, 04, 13)));

        listaTareas.add(new Tarea(2L, "Tarea 2", "Esta es la tarea 2", Estado.EN_PROGRESO,
        Prioridad.URGENTE, "Juanito", LocalDate.now(), LocalDate.of(2026, 04, 13)));

        listaTareas.add(new Tarea(3L, "Tarea 3", "Esta es la tarea 3", Estado.CANCELADA,
        Prioridad.BAJA, "Jaime", LocalDate.now(), LocalDate.of(2026, 04, 13)));
    }

    //Endpoints a desarrollar (Para "REPOSITORY" -> "find")
        //1) Retornar lista completa (GET)
    public List<Tarea> findAll() {
        return listaTareas;
    }

        //2) Retornar por ID (GET)
    public Optional<Tarea> findById(Long id) {
        return listaTareas.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

        //3) Registrar nueva tarea (POST)
    public void save(Tarea tarea) {
        listaTareas.add(tarea);
    }

        //4) Actulizar datos de una tarea (PUT)
    public Tarea updateDatos(Long id, String titulo, String descripcion, Estado estado, 
    Prioridad prioridad, String responsable, LocalDate fechaLimite) {
                                    
        int pos = 0;

        for (int i = 0; i < listaTareas.size(); i++) {
            if (listaTareas.get(i).getId().equals(id)) {
                listaTareas.get(i).setTitulo(titulo);
                listaTareas.get(i).setDescripcion(descripcion);
                listaTareas.get(i).setEstado(estado);
                listaTareas.get(i).setPrioridad(prioridad);
                listaTareas.get(i).setResponsable(responsable);
                listaTareas.get(i).setFechaLimite(fechaLimite);
                pos = i;
                break;
            }
        }
        return listaTareas.get(pos);
    }
    
        //5) Eliminar una tarea (DELETE)
    public boolean delete(Long id) {
        return listaTareas.removeIf(t -> t.getId().equals(id));
    }

        //6) Retornar por Estado (Usar filtro) (GET)
    public void findByEstado(Estado estado) {
        listaTareas.stream().filter(t -> t.getEstado().equals(estado));
    }
}
