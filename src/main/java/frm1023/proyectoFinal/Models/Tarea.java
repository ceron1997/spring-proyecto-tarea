package frm1023.proyectoFinal.Models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TAREAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA")
    private int idTarea;
    @Column(name = "NOMBRE_TAREA")
    private String nombreTarea;
    @Column(name = "ESTADO")
    private EstadoProyecto estado;
    @Column(name = "FECHA_VENCIMIENTO")
    private Date fechaVencimiento;
    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO", nullable = false )
    @JsonBackReference
    private Proyecto proyecto;
  
}
