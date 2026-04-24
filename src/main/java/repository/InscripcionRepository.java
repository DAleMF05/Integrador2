package repository;

import com.opencsv.CSVReader;
import dto.EstudianteDTO;
import dto.InscripcionDTO;
import factory.JPAUtil;
import jakarta.persistence.EntityManager;
import modelo.Carrera;
import modelo.Estudiante;
import modelo.Inscripcion;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.List;

public class InscripcionRepository {


    public void insertarDesdeCSV(String rutaArchivo) {
        EntityManager em = JPAUtil.getEntityManager();

       try (CSVReader reader = new CSVReader(new FileReader(rutaArchivo))) {
            String[] linea;
          reader.readNext(); // salta cabecera

            em.getTransaction().begin();

           while ((linea = reader.readNext()) != null) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(Integer.parseInt(linea[0]));
               Estudiante estudiante= em.find(Estudiante.class, (linea[1]));
               inscripcion.setEstudiante(estudiante);
               Carrera carrera = em.find(Carrera.class, Integer.parseInt(linea[2]));
               inscripcion.setCarrera(carrera);
                inscripcion.setFechaInsc(Integer.parseInt(linea[3]));
               inscripcion.setFechaGrad(Integer.parseInt(linea[4]));
               inscripcion.setAntiguedad(Integer.parseInt(linea[5]));

               em.persist(inscripcion);
           }

           em.getTransaction().commit();
        } catch (Exception e) {
           e.printStackTrace();
       } finally {
           em.close();
        }
    }

    public List<InscripcionDTO> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<InscripcionDTO> inscripcionDTOS = em.createQuery("SELECT new dto.InscripcionDTO(i.idInscripcion, e.dni, c.idCarrera, i.fechaInsc, i.fechaGrad, i.antiguedad ) FROM Inscripcion i JOIN i.estudiante e JOIN i.carrera c ", InscripcionDTO.class).getResultList();
        em.close();
        return inscripcionDTOS;
    }
}
