package frm1023.proyectoFinal.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import frm1023.proyectoFinal.Models.EstadoProyecto;
import frm1023.proyectoFinal.Models.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

    List<Tarea> findByEstado(EstadoProyecto estado);

    Tarea findByIdTarea(int idTarea);
}
