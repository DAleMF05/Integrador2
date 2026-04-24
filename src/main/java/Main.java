import dto.CarreraDTO;
import dto.EstudianteDTO;
import dto.InscripcionDTO;
import modelo.Estudiante;
import modelo.Inscripcion;
import repository.CarreraRepository;
import repository.EstudianteRepository;
import repository.InscripcionRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EstudianteRepository estudiante = new EstudianteRepository();
        CarreraRepository carrera = new CarreraRepository();
        InscripcionRepository inscripcion = new InscripcionRepository();

        estudiante.insertarDesdeCSV("src/main/resources/estudiantes.csv");
        carrera.insertarDesdeCSV("src/main/resources/carreras.csv");
        inscripcion.insertarDesdeCSV("src/main/resources/estudianteCarrera.csv");


        System.out.println("Lista de carrreras: ");
        List<CarreraDTO> carreraDTOS= carrera.buscarTodos();
        for (CarreraDTO carre: carreraDTOS) {
            System.out.println(carre);
        }



        //Estudiante e = new Estudiante("23455667","Ale","Lopez",40,'M',"Loberia","321");
        //estudiante.insertarEstudiante(e);

        System.out.println("Lista de estudiantes: ");
        List<EstudianteDTO> estudianteDTOS= estudiante.buscarTodos();
        for (EstudianteDTO est : estudianteDTOS){
            System.out.println(est);
        }


        System.out.println("Lista de  inscripciones: ");
        List<InscripcionDTO> inscripcionDTOS= inscripcion.buscarTodos();
        for (InscripcionDTO insc : inscripcionDTOS){
            System.out.println(insc);
        }




    }
}
