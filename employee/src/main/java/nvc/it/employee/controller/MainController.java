package nvc.it.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import lombok.experimental.PackagePrivate;
import nvc.it.employee.model.Department;
import nvc.it.employee.model.Employee;
import nvc.it.employee.model.Project;
import nvc.it.employee.repository.DepartmentRepository;
import nvc.it.employee.repository.ProjectRepository;
import nvc.it.employee.service.EmployeeService;






@Controller
public class MainController  {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ProjectRepository projectRepository;


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/employee")
    public ModelAndView Employee(){
        List<Employee> employees = employeeService.findAll();
        return new ModelAndView("employee", "employees", employees);
    }

    @GetMapping("/employee/name/{name}")
    public ModelAndView getEmployeeByName(@PathVariable("name") String name){
        List<Employee> employees = employeeService.findByName(name);
        return new ModelAndView("employee", "employees", employees);
    }
    

    @GetMapping("/employee/salary/{salary}")
    public ModelAndView getEmployeeBySalary(@PathVariable("salary") double salary){
        List<Employee> employees = employeeService.findBySalary(salary);
        return new ModelAndView("employee", "employees", employees);
    }

    @GetMapping("/department")
    public ModelAndView department(){
        List<Department> departments = departmentRepository.findAll();
        return new ModelAndView("department", "departments", departments);
    }


    @GetMapping("/project")
    public ModelAndView project(){
        List<Project> projects = projectRepository.findAll();
        return new ModelAndView("project", "projects", projects);
    }

}
