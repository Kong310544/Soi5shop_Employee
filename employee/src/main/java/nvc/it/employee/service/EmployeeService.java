package nvc.it.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.employee.model.Employee;
import nvc.it.employee.repository.EmployeeRepository;





@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }


    public List<Employee> findByName(String name){
        return employeeRepository.findByNameContaining(name);
    }

    public List<Employee> findBySalary(double salary){
        return employeeRepository.findBySalaryLessThanEqual(salary);
    }
    
}