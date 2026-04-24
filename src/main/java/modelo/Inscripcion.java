package modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inscripcion {

    @Id
    private int idInscripcion;
    private int fechaInsc;
    private int fechaGrad;
    private int antiguedad;

    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "idCarrera")
    private Carrera carrera;

    // getters y setters
}