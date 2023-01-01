package com.hibernate.task.oneToMany.Uni.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department_uni", schema = "one_to_many_uni", catalog = "general_hibernate")
@Getter
@Setter
public class DepartmentUni {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_salary")
    private Integer maxSalary;

    @Column(name = "min_salary")
    private Integer minSalary;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentuni_id")
    private List<EmplyeeUni> emplyeeList;

    public DepartmentUni(String name, Integer maxSalary, Integer minSalary) {
        this.name = name;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public DepartmentUni() {
    }

    public void addEmployeeToDepartment(EmplyeeUni emplyee){
        if(emplyeeList == null){
            emplyeeList = new ArrayList<>();
        }
        emplyeeList.add(emplyee);
    }

    @Override
    public String toString() {
        return "DepartmentUni{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }
}
