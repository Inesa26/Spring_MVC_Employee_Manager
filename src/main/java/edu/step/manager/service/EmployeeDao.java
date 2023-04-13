package edu.step.manager.service;

import edu.step.manager.model.Employee;
import edu.step.manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeDao {

    @Autowired
    EmployeeRepository repository;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findById(Long id) {
        Optional<Employee> byId = repository.findById(id);
        if(byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public List<Employee> findByName(String name) {
        return repository.findAllByNameEquals(name);
    }

    public void create(String name, String surname, LocalDate birthdate, Double salary) {
        Employee entity = new Employee();
        entity.setName(name);
        entity.setSurname(surname);
        entity.setBirthdate(birthdate);
        entity.setSalary(salary);
        repository.save(entity);
    }

    public void create(List<Employee> employees) {
        repository.saveAll(employees);
    }

  //  public void create(Employee e){
    //    repository.save(e);
  //  }

    public void update(Long id, String name, String surname, LocalDate birthdate, Double salary) {
        Optional<Employee> employee = repository.findById(id);
        if(employee.isPresent()) {
            Employee emp = employee.get();
            emp.setName(name);
            emp.setSurname(surname);
            emp.setSalary(salary);
            emp.setBirthdate(birthdate);
            repository.save(emp);
        } else {
            System.out.println("N-am putut gasi obiectul cu id=" + id);
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Employee filter(String name) {
        return repository.findOneByNameEquals(name);
    }
    public Page<Employee> findPage(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.repository.findAll(pageable);
    }
}
