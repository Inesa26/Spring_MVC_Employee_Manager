package edu.step.manager.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EmployeeDTO { // data transfer object
    private Long id;
    private String name;
    private String surname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    private Double salary;

    public EmployeeDTO(Long id, String name, String surname, LocalDate birthdate, Double salary) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.salary = salary;
    }

    public EmployeeDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}