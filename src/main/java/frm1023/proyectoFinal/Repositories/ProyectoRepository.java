package frm1023.proyectoFinal.Repositories;

import org.springframework.stereotype.Repository;

import frm1023.proyectoFinal.Models.EstadoProyecto;
import frm1023.proyectoFinal.Models.Proyecto;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.sql.Date;



@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto,Integer>{
    
    List<Proyecto> findByEstado(EstadoProyecto estado);
    Proyecto findByidProyecto(int idProyecto);
    List<Proyecto> findByFechaFin(Date fechaFin);
}
