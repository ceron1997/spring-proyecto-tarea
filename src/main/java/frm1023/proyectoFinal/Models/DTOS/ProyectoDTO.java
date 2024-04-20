package frm1023.proyectoFinal.Models.DTOS;

import java.sql.Date;
import java.util.List;

import frm1023.proyectoFinal.Models.EstadoProyecto;
import frm1023.proyectoFinal.Models.Tarea;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProyectoDTO {
  
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private EstadoProyecto estado;
    private List<Tarea> tareas; 
   
}
