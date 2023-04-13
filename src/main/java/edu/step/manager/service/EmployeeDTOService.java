package edu.step.manager.service;

import edu.step.manager.model.Employee;
import edu.step.manager.model.EmployeeDTO;

public class EmployeeDTOService {
    public static EmployeeDTO convertToDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO (employee.getId(), employee.getName(), employee.getSurname(), employee.getBirthdate(), employee.getSalary());
        return employeeDTO;
    }
}
