import fr.uge.hibernate.employees.Employee;
import fr.uge.hibernate.employees.EmployeeRepository;
import fr.uge.hibernate.employees.PersistenceUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class  Application {
    public static void main(String[] args) {
        var repoEmployee = new EmployeeRepository();

        var idBob = repoEmployee.create("Bob","Moran",500);
        var idBob1 = repoEmployee.create("Bob","Dylan",600);
        var idLisa = repoEmployee.create("Lisa","Simpson",100);
        var idMarge = repoEmployee.create("Marge", "Simpson", 1000);
        var idHomer = repoEmployee.create("Homer", "Simpson", 450);

        System.out.println(repoEmployee.delete(idLisa));

        System.out.println(repoEmployee.update(idHomer, 550));

        System.out.println(repoEmployee.getAll());
    }
}