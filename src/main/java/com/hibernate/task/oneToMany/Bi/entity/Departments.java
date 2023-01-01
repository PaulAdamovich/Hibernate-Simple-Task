package com.hibernate.task.oneToMany.Bi.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments" , schema = "one_to_many")
@Getter
@Setter
public class Departments {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_salary")
    private Long maxSalary;

    @Column(name = "min_salary")
    private Long minSalary;

    @OneToMany(cascade = CascadeType.ALL
            , mappedBy = "department"
            , fetch = FetchType.LAZY )
    private List<Employees> employeeList;
    public Departments(String name, Long maxSalary, Long minSalary) {
        this.name = name;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public Departments() {
    }

    public void addEmployeeToDepartment(Employees employee){
        if(employeeList == null) {
            employeeList = new ArrayList<>();
        }
        employeeList.add(employee);
        employee.setDepartment(this);
        }

    @Override
    public String toString() {
        return "Departments{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }
}

