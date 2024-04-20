package frm1023.proyectoFinal.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import frm1023.proyectoFinal.Models.EstadoProyecto;
import frm1023.proyectoFinal.Models.DTOS.ProyectoDTO;
import frm1023.proyectoFinal.Services.ProyectoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/Proyecto")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @Operation(summary = "Obtener todos los proyectos")
    @GetMapping
    public ResponseEntity<List<ProyectoDTO>> getAll() {
        return ResponseEntity.ok(this.proyectoService.getAll().getBody());
    }

    @Operation(summary = "Obtener todos los proyectos segun su estado, que puede ser  PENDIENTE, EN_PROGRESO,  COMPLETADA")
    @GetMapping("byEstado/{estado}")
    public ResponseEntity<List<ProyectoDTO>> getAllByEstado(@PathVariable String estado) {
        if (!estado.equals("PENDIENTE") && !estado.equals("EN_PROGRESO") && !estado.equals("COMPLETADA")) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
        EstadoProyecto estadoProyecto = EstadoProyecto.valueOf(estado);
        return ResponseEntity.ok(this.proyectoService.getAllByEstado(estadoProyecto).getBody());
    }
   

    @Operation(summary = "Obtener proyecto segun su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO> getById(@PathVariable @Valid int id) {
        return this.proyectoService.getById(id);
    }

    @Operation(summary = "Guarda un nuevo proyecto y recibe un json en el body del request con la informacion del proyecto opcionalmente puede guardar tareas asociadas a este proyecto")
    @PostMapping
    public ResponseEntity<ProyectoDTO> save(@RequestBody ProyectoDTO proyectoDTO) {
        return this.proyectoService.save(proyectoDTO);
    }

    @Operation(summary = "Actualiza la informacion de un proyecto y recibe su id como parametro y un json en el body de la peticion")
    @PutMapping("/{id}")
    public ResponseEntity<ProyectoDTO> update(@PathVariable int id, @RequestBody ProyectoDTO proyectoDTO) {
        return this.proyectoService.update(proyectoDTO, id);
    }

    @Operation(summary = "Elimina un proyecto recibe como parametro el id a eliminar")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return this.proyectoService.delete(id);
    }

}
