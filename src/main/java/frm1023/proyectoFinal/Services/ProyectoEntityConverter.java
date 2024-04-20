package frm1023.proyectoFinal.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import frm1023.proyectoFinal.Models.Proyecto;
import frm1023.proyectoFinal.Models.DTOS.ProyectoDTO;

@Component
public class ProyectoEntityConverter {

    public List<ProyectoDTO> toResponseAll(List<Proyecto> obj) {
        List<ProyectoDTO> proyectoDTOs = new ArrayList<>();
        
        for (Proyecto read : obj) {
            ProyectoDTO proyectoDTO = ProyectoDTO.builder()
                    .descripcion(read.getDescripcion())
                    .fechaInicio(read.getFechaInicio())
                    .fechaFin(read.getFechaFin())
                    .estado( read.getEstado() )  
                    .tareas(read.getTareas())
                    .build();
            proyectoDTOs.add(proyectoDTO);
        }
    
        return proyectoDTOs;
    }
    

    public ProyectoDTO toProyectoDTO(Proyecto proyecto) {
        ProyectoDTO proyectoDTO = ProyectoDTO.builder()
                .descripcion(proyecto.getDescripcion())
                .fechaInicio(proyecto.getFechaInicio())
                .fechaFin(proyecto.getFechaFin())
                .estado(proyecto.getEstado())
                .build();
        return proyectoDTO;
    }

}

// private String descripcion;
// private Date fechaInicio;
// private Date fechaFin;
// private String estado; proyecto dto tiene estas propiedades
