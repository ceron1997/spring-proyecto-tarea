package frm1023.proyectoFinal.Models.DTOS;

import java.sql.Date;

import frm1023.proyectoFinal.Models.EstadoProyecto;
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
public class TareaDTO {

    private String nombreTarea;
    private EstadoProyecto estado;
    private Date fechaVencimiento;
    private int idProyecto; // no necesito todo el objeto en dto
}
