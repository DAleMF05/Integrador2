package modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    @Id
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private char genero;
    private String ciudad;
    private String numLibretaUni;

    @OneToMany(mappedBy = "estudiante")
    private List<Inscripcion> inscripciones = new ArrayList<>();



    // getters y setters
}
