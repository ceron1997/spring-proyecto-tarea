package frm1023.proyectoFinal.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import frm1023.proyectoFinal.Models.Tarea;
import frm1023.proyectoFinal.Models.DTOS.TareaDTO;



@Component
public class TareaEntityConverter {
      public List<TareaDTO> toResponseAll(List<Tarea> obj) {
        List<TareaDTO> TareaDTOs = new ArrayList<>();
        for (Tarea read : obj) {
            TareaDTO tareaDTO = TareaDTO.builder()
            .nombreTarea(read.getNombreTarea())
            .estado(read.getEstado())
            .fechaVencimiento(read.getFechaVencimiento())
            .idProyecto(read.getProyecto().getIdProyecto())
            .build();

            TareaDTOs.add(tareaDTO);
        }
        return TareaDTOs;
    }

    public TareaDTO toTareaDTO(Tarea tarea) {
        TareaDTO tareaDTO = TareaDTO.builder()
                .nombreTarea(tarea.getNombreTarea())
                .estado(tarea.getEstado())
                .fechaVencimiento(tarea.getFechaVencimiento())
                .idProyecto(tarea.getProyecto().getIdProyecto())
                .build();
        return tareaDTO;
    }
}



// private String nombreTarea;
// private String estado;
// private Date fechaVencimiento;