import fr.uge.hibernate.employees.Employee;
import fr.uge.hibernate.employees.PersistenceUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class  Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = PersistenceUtils.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            var harry = new Employee("Harry","Potter", 2000);
            em.persist(harry);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}