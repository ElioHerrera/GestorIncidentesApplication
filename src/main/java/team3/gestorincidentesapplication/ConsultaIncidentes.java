package team3.gestorincidentesapplication;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.List;

public class ConsultaIncidentes {
/*
    public static void ConsultaMasIncidentes(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("incidentesapp"); // Nombre de la unidad de Persistencia?
        EntityManager em = emf.createEntityManager();

        // Iniciar transacción
        em.getTransaction().begin();

        try {
            String consulta = "SELECT i.tecnico, COUNT(i) " +
                    "FROM incidente i " +
                    "WHERE i.estado = 'RESUELTO' " + //Esto no se si esta correcto
                    "GROUP BY i.tecnico " +
                    "ORDER BY COUNT(i) DESC";

            Query<Object[]> query = em.createQuery(consulta, Object[].class);
            query.setMaxResults(1); // Obtener solo el primero (el que más incidentes tiene resueltos)

            List<Object[]> resultados = query.getResultList();

            if (!resultados.isEmpty()) {
                Object[] resultado = resultados.get(0);
                Tecnico tecnico = (Tecnico) resultado[0];
                Long cantidadIncidentesResueltos = (Long) resultado[1];

                System.out.println("El técnico con ID " + tecnico.getId() +
                        " tiene la mayor cantidad de incidentes resueltos: " + cantidadIncidentesResueltos);
            } else {
                System.out.println("No hay resultados.");
            }

            // Confirmar transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            // Manejar excepciones
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar EntityManager y EntityManagerFactory
            em.close();
            emf.close();
        }
    }
    public static void ConsultaIncidentesEspecial(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NombreDeTuUnidadDePersistencia");
        EntityManager em = emf.createEntityManager();

        // Iniciar transacción
        em.getTransaction().begin();

        try {
            String especialidadBuscada = "EspecialidadDeseada";
            int ultimosDias = 7; // Número de días deseados

            String consulta = "SELECT i.tecnico, COUNT(i) " +
                    "FROM Incidente i " +
                    "WHERE i.estado = 'resuelto' " +
                    "AND i.especialidad = :especialidad " +
                    "AND i.fechaResolucion >= :fechaLimite " +
                    "GROUP BY i.tecnico " +
                    "ORDER BY COUNT(i) DESC";

            Query<Object[]> query = em.createQuery(consulta, Object[].class);
            query.setParameter("especialidad", especialidadBuscada);
            query.setParameter("fechaLimite", LocalDate.now().minusDays(ultimosDias));

            query.setMaxResults(1); // Obtener solo el primero (el que más incidentes tiene resueltos)

            List<Object[]> resultados = query.getResultList();

            if (!resultados.isEmpty()) {
                Object[] resultado = resultados.get(0);
                Tecnico tecnico = (Tecnico) resultado[0];
                Long cantidadIncidentesResueltos = (Long) resultado[1];

                System.out.println("El técnico con ID " + tecnico.getId() +
                        " tiene la mayor cantidad de incidentes resueltos en la especialidad " +
                        especialidadBuscada + " en los últimos " + ultimosDias + " días: " +
                        cantidadIncidentesResueltos);
            } else {
                System.out.println("No hay resultados.");
            }

            // Confirmar transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            // Manejar excepciones
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar EntityManager y EntityManagerFactory
            em.close();
            emf.close();
        }
    }


        public static void ConsultaMasRapido(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("NombreDeTuUnidadDePersistencia");
            EntityManager em = emf.createEntityManager();

            // Iniciar transacción
            em.getTransaction().begin();

            try {
                String consulta = "SELECT i.tecnico, AVG(i.tiempoResolucion) " +
                        "FROM Incidente i " +
                        "WHERE i.estado = 'resuelto' " +
                        "AND i.tiempoResolucion IS NOT NULL " +
                        "GROUP BY i.tecnico " +
                        "ORDER BY AVG(i.tiempoResolucion) ASC";

                Query<Object[]> query = em.createQuery(consulta, Tuple.class);

                query.setMaxResults(1); // Obtener solo el primero (el que menos tiempo promedio de resolución tiene)

                List<Object[]> resultados = query.getResultList();

                if (!resultados.isEmpty()) {
                    Object[] resultado = resultados.get(0);
                    Tecnico tecnico = (Tecnico) resultado[0];
                    Double tiempoPromedioResolucion = (Double) resultado[1];

                    System.out.println("El técnico con ID " + tecnico.getId() +
                            " tiene el menor tiempo promedio de resolución: " + tiempoPromedioResolucion + " horas");
                } else {
                    System.out.println("No hay resultados.");
                }

                // Confirmar transacción
                em.getTransaction().commit();
            } catch (Exception e) {
                // Manejar excepciones
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                e.printStackTrace();
            } finally {
                // Cerrar EntityManager y EntityManagerFactory
                em.close();
                emf.close();
            }
        }
    }

 */
}