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
        return 1l;
    }

    /**
     * Remove the employee with the given id from the DB
     * @param id
     * @return true if the removal was successful
     */

    public boolean delete(long id) {
        return false;
    }

    /**
     * Update the salary of the employee with the given id
     * @param id
     * @param salary
     * @return true if the removal was successful
     */

    public boolean update(long id, int salary) {
        return false;
    }

    /**
     * Retrieve the employee with the given id
     * @param id
     * @return the employee wrapped in an {@link Optional}
     */

    public Optional<Employee> get(long id) {
        return null;
    }

    /**
     * Return the list of the employee in the DB
     */

    public List<Employee> getAll() {
        return null;
    }

}