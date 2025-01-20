package fr.uge.hibernate.employees;

import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {

    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();

    /**
     * Create an employee with the given information
     * @param firstName
     * @param lastName
     * @param salary
     * @return the id of the newly created employee
     */
    public long create(String firstName, String lastName, int salary) {
        return PersistenceUtils.inTransaction(em -> {
            var employee = new Employee(firstName, lastName, salary);
            em.persist(employee);
            return employee.getId();
        });
    }

    /**
     * Remove the employee with the given id from the DB
     * @param id
     * @return true if the removal was successful
     */

    public boolean delete(long id) {
        PersistenceUtils.inTransaction(em -> {
            var employee = em.find(Employee.class, id);
            if(employee == null){
                throw new IllegalArgumentException();
            }
            em.remove(employee);
            return true;
        });
        return false;
    }

    /**
     * Update the salary of the employee with the given id
     * @param id
     * @param salary
     * @return true if the removal was successful
     */

    public boolean update(long id, int salary) {
        PersistenceUtils.inTransaction(em -> {
            var student = em.find(Employee.class, id);
            if(student != null){
                student.setSalary(salary);
            }
            return true;
        });
        return false;
    }

    /**
     * Retrieve the employee with the given id
     * @param id
     * @return the employee wrapped in an {@link Optional}
     */

    public Optional<Employee> get(long id) {
        return PersistenceUtils.inTransaction(em -> {
            var student = em.find(Employee.class, id);
            if(student != null){
                return Optional.of(student);
            }
            return Optional.empty();
        });
    }

    /**
     * Return the list of the employee in the DB
     */

    public List<Employee> getAll() {
        return PersistenceUtils.inTransaction(em -> {
            var q = "SELECT e FROM Employee e";
            var query = em.createQuery(q, Employee.class);
            var results = query.getResultList();
            return results;
        });
    }

    public boolean updateAllSalary(long id){
        return false;
    }

    public List<Employee> getAllFirstName(){
        return null;
    }
}