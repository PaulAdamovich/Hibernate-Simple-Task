package com.hibernate.task.manyToMany.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children", schema = "many_to_many")
@Getter
@Setter
public class Children {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "children_section", schema = "many_to_many", catalog = "general_hibernate"
            , joinColumns = @JoinColumn(name = "children_id")
            , inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private List<Section> sectionList;

    public Children(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Children() {
    }

    @Override
    public String toString() {
        return "Children{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void addSectionToChild(Section section) {
        if (sectionList == null) {
            sectionList = new ArrayList<>();
        }
        sectionList.add(section);
    }
}
