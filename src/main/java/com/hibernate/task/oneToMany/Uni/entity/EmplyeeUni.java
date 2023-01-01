package com.hibernate.task.oneToMany.Uni.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Table(name = "emplyee_uni", schema = "one_to_many_uni", catalog = "general_hibernate")
@Getter
@Setter
public class EmplyeeUni {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "salary")
    private Integer salary;

    public EmplyeeUni() {
    }

    public EmplyeeUni(String name, String surname, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmplyeeUni{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
