package frm1023.proyectoFinal.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import frm1023.proyectoFinal.Models.EstadoProyecto;
import frm1023.proyectoFinal.Models.DTOS.TareaDTO;
import frm1023.proyectoFinal.Services.TareaService;
import io.swagger.v3.oas.annotations.Operation;
@RestController
@RequestMapping("/Tarea")
public class TareasController {
     @Autowired
    TareaService tareaService;

    @Operation(summary = "Obtener todos los tareas")
    @GetMapping
    public ResponseEntity<List<TareaDTO>> getAll() {
        return ResponseEntity.ok(this.tareaService.getAll().getBody());
    }

    
    @Operation(summary = "Obtener todos los tareas segun su estado, que puede ser  PENDIENTE, EN_PROGRESO,  COMPLETADA")
    @GetMapping("byEstado/{estado}")
    public ResponseEntity<List<TareaDTO>> getAllByEstado(@PathVariable String estado) {

        if (!estado.equals("PENDIENTE") && !estado.equals("EN_PROGRESO") && !estado.equals("COMPLETADA")) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
          EstadoProyecto estadoProyecto = EstadoProyecto.valueOf(estado);
        return ResponseEntity.ok(this.tareaService.getAllByEstado(estadoProyecto).getBody());
    }

    

    
    @Operation(summary = "Obtener tarea segun su ID")
    @GetMapping("/{id}")
    public ResponseEntity<TareaDTO> getById(@PathVariable int id) {
        return this.tareaService.getById(id);
    }

    
    @Operation(summary = "Guarda un nuevo tarea y recibe un json en el body del request con la informacion de la tarea, tambien es requerido el id de un proyecto existente ")
    @PostMapping
    public ResponseEntity<TareaDTO> save(@RequestBody TareaDTO tareaDTO) {
        return this.tareaService.save(tareaDTO);
    }

    
    @Operation(summary = "Actualiza la informacion de un tarea y recibe su id como parametro y un json en el body de la peticion")
    @PutMapping("/{id}")
    public ResponseEntity<TareaDTO> update(@PathVariable int id, @RequestBody TareaDTO tareaDTO) {
        return this.tareaService.update(tareaDTO, id);
    }

    
    @Operation(summary = "Elimina una tarea recibe como parametro el id a eliminar")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return this.tareaService.delete(id);
    }
}
