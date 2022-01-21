package nvc.it.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double salary;


    @ManyToOne
    @JoinColumn(name = "departmentId", nullable = false)
    private Department department;
    
    @ManyToOne
    @JoinColumn(name = "projectId", nullable = false)
    private Project project;
    
}
