package fr.uge.hibernate.employees;

import jakarta.persistence.*;

@Entity
@Table(name = "Employees")
public class Employee {
    @Column(name = "EmployeeID")
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(){
    }

    public Employee(String firstName, String lastName, int salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}