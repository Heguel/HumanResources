package com.humanresources.api.service;

import com.humanresources.api.model.Employee;
import com.humanresources.api.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Data
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void updateEmployee(Long id, Employee employee){
        Employee existingData = employeeRepository.findById(id).get();
        existingData.setFirstName(employee.getFirstName());
        existingData.setLastName(employee.getLastName());
        existingData.setEmail(employee.getEmail());
        existingData.setPassword(employee.getPassword());
        employeeRepository.save(existingData);
    }

    public void deleteEmployee(Long id) {
       employeeRepository.deleteById(id);
    }


}
