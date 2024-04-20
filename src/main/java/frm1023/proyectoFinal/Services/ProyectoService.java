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
import frm1023.proyectoFinal.Models.DTOS.ProyectoDTO;
import frm1023.proyectoFinal.Models.DTOS.TareaDTO;
import frm1023.proyectoFinal.Repositories.ProyectoRepository;

@Service
public class ProyectoService {
    @Autowired
    ProyectoRepository proyectoRepository;

    @Autowired
    ProyectoEntityConverter proyectoEntityConverter;

    @Autowired
    TareaEntityConverter tareaEntityConverter;
    @Autowired 
    TareaService tareaService;

    // public ResponseEntity<ProyectoDTO> save(ProyectoDTO proyectoDTO) {

    //     EstadoProyecto estadoProyecto =  proyectoDTO.getEstado();

    //     Proyecto proyecto = Proyecto.builder()
    //             .descripcion(proyectoDTO.getDescripcion())
    //             .estado(estadoProyecto)
    //             .fechaInicio(proyectoDTO.getFechaInicio())
    //             .fechaFin(proyectoDTO.getFechaFin())
    //             .build();

    //     this.proyectoRepository.saveAndFlush(proyecto);
    //     return new ResponseEntity<>(proyectoDTO, HttpStatus.OK);
    // }
      public ResponseEntity<ProyectoDTO> save( ProyectoDTO proyectoDTO) {

       
        Proyecto proyecto = Proyecto.builder()
                .descripcion(proyectoDTO.getDescripcion())
                .estado(proyectoDTO.getEstado())
                .fechaInicio(proyectoDTO.getFechaInicio())
                .fechaFin(proyectoDTO.getFechaFin())
                .build();

        Proyecto proyectoGuardado = this.proyectoRepository.saveAndFlush(proyecto);

        System.out.println("se ha guardado el proyecto");
        // Asociar las tareas al proyecto
        List<Tarea> tareas = proyectoDTO.getTareas();
        if (tareas != null && !tareas.isEmpty()) {
            for (Tarea tarea : tareas) {
                tarea.setProyecto(proyectoGuardado);
               TareaDTO tareaDTO = this.tareaEntityConverter.toTareaDTO(tarea);
                tareaService.save(tareaDTO);
            }
        }

        return new ResponseEntity<>(proyectoDTO, HttpStatus.OK);
    }

    public ResponseEntity<List<ProyectoDTO>> getAllByEstado(EstadoProyecto estado) {
        List<Proyecto> proyectos = this.proyectoRepository.findByEstado(estado);
        List<ProyectoDTO> proyectosDTO = this.proyectoEntityConverter.toResponseAll(proyectos);
        return new ResponseEntity<>(proyectosDTO, HttpStatus.OK);
    }
    

    public ResponseEntity<List<ProyectoDTO>> getAll() {
        List<Proyecto> proyectos = this.proyectoRepository.findAll();
        List<ProyectoDTO> proyectosDTO = this.proyectoEntityConverter.toResponseAll(proyectos);
        return new ResponseEntity<>(proyectosDTO, HttpStatus.OK);
    }

    public ResponseEntity<ProyectoDTO> getById(int id) {
        Optional<Proyecto> optionalProyecto = this.proyectoRepository.findById(id);

        if (optionalProyecto.isPresent()) {
            ProyectoDTO proyectoDTO = this.proyectoEntityConverter.toProyectoDTO(optionalProyecto.get());
            return new ResponseEntity<>(proyectoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    public ResponseEntity<String> delete(int id) {
        Proyecto proyecto = this.proyectoRepository.findById(id).orElse(null);

        if (proyecto != null) {
            this.proyectoRepository.delete(proyecto);
            return new ResponseEntity<>("Proyecto eliminado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Proyecto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ProyectoDTO> update(ProyectoDTO proyectoDTO, int id) {
        EstadoProyecto estadoProyecto = proyectoDTO.getEstado();
        Proyecto proyecto = this.proyectoRepository.findByidProyecto(id);
        Proyecto newProyecto = Proyecto.builder()
                .idProyecto(proyecto.getIdProyecto())
                .descripcion(proyectoDTO.getDescripcion())
                .estado(estadoProyecto)
                .fechaInicio(proyectoDTO.getFechaInicio())
                .fechaFin(proyectoDTO.getFechaFin())
                .build();
        this.proyectoRepository.saveAndFlush(newProyecto);
        return new ResponseEntity<>(proyectoDTO, HttpStatus.OK);
    }

}
