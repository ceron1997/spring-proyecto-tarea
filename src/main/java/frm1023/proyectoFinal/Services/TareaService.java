package frm1023.proyectoFinal.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import frm1023.proyectoFinal.Models.EstadoProyecto;
import frm1023.proyectoFinal.Models.Proyecto;
import frm1023.proyectoFinal.Models.Tarea;
import frm1023.proyectoFinal.Models.DTOS.TareaDTO;
import frm1023.proyectoFinal.Repositories.ProyectoRepository;
import frm1023.proyectoFinal.Repositories.TareaRepository;

@Service
public class TareaService {
    

      @Autowired
    TareaRepository tareaRepository;
    @Autowired
    ProyectoRepository proyectoRepository;
    // @Autowired
    // ProyectoService proyectoService;
    @Autowired
    TareaEntityConverter tareaEntityConverter;


    //    public ResponseEntity<TareaDTO> save(TareaDTO tareaDTO) {

  
    //     Tarea tarea = Tarea.builder()
    //             .nombreTarea(tareaDTO.getNombreTarea())
    //             .estado(tareaDTO.getEstado())
    //             .fechaVencimiento(tareaDTO.getFechaVencimiento())
    //             .proyecto(tareaDTO.getProyecto())
    //             .build();

    //     this.tareaRepository.saveAndFlush(tarea);
    //     return new ResponseEntity<>(tareaDTO, HttpStatus.OK);
    // }
     public ResponseEntity<TareaDTO> save( TareaDTO tareaDTO) {

        // Validar que el idProyecto proporcionado existe en la base de datos
        int idProyecto = tareaDTO.getIdProyecto();
        Proyecto proyecto = proyectoRepository.findByidProyecto(idProyecto);
        if (proyecto == null) {
            return new ResponseEntity<>( null, HttpStatus.NOT_FOUND);
        }

        Tarea tarea = Tarea.builder()
                .nombreTarea(tareaDTO.getNombreTarea())
                .estado(tareaDTO.getEstado())
                .fechaVencimiento(tareaDTO.getFechaVencimiento())
                .proyecto(proyecto)
                .build();
        this.tareaRepository.saveAndFlush(tarea);
        return new ResponseEntity<>(tareaDTO, HttpStatus.OK);
    }

        public ResponseEntity<List<TareaDTO>> getAllByEstado(EstadoProyecto estado) {
        List<Tarea> tarea = this.tareaRepository.findByEstado(estado);
        List<TareaDTO> tareaDTOs = this.tareaEntityConverter.toResponseAll(tarea);
        return new ResponseEntity<>(tareaDTOs, HttpStatus.OK);
    }

    public ResponseEntity<List<TareaDTO>> getAll() {
        List<Tarea> tareas = this.tareaRepository.findAll();
        List<TareaDTO> tareaDTOs = this.tareaEntityConverter.toResponseAll(tareas);
        return new ResponseEntity<>(tareaDTOs, HttpStatus.OK);
    }

     public ResponseEntity<TareaDTO> getById(int id) {
        Optional<Tarea> optionalTarea = this.tareaRepository.findById(id);

        if (optionalTarea.isPresent()) {
            TareaDTO tareaDTO = this.tareaEntityConverter.toTareaDTO(optionalTarea.get());
            return new ResponseEntity<>(tareaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    public ResponseEntity<String> delete(int id) {
        Tarea tarea = this.tareaRepository.findById(id).orElse(null);

        if (tarea != null) {
            this.tareaRepository.delete(tarea);
            return new ResponseEntity<>("Registro eliminado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<TareaDTO> update(TareaDTO tareaDTO, int id) {
        Tarea tarea = this.tareaRepository.findByIdTarea(id);
        // Validar que el idProyecto proporcionado existe en la base de datos
        int idProyecto = tareaDTO.getIdProyecto();
        Proyecto proyecto = proyectoRepository.findByidProyecto(idProyecto);
        if (proyecto == null) {
            return new ResponseEntity<>( null, HttpStatus.NOT_FOUND);
        }
        Tarea tarea_NEW = Tarea.builder()
        .idTarea(tarea.getIdTarea())
        .nombreTarea(tareaDTO.getNombreTarea())
        .estado(tareaDTO.getEstado())
        .fechaVencimiento(tareaDTO.getFechaVencimiento())
        .proyecto(proyecto)
        .build();
        this.tareaRepository.saveAndFlush(tarea_NEW);
        return new ResponseEntity<>(tareaDTO, HttpStatus.OK);
    }

}
