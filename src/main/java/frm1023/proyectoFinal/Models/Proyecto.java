package frm1023.proyectoFinal.Models;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PROYECTOS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROYECTO")
    private int idProyecto;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;

    @Column(name = "FECHA_FIN")
    private Date fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO")
    private EstadoProyecto estado;

    @OneToMany(mappedBy ="proyecto", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tarea> tareas; 

  
}
