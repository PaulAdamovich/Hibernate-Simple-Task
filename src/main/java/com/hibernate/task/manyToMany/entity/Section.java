package com.hibernate.task.manyToMany.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section", schema = "many_to_many")
@Getter
@Setter
public class Section {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "children_section", schema = "many_to_many", catalog = "general_hibernate"
            , joinColumns = @JoinColumn(name = "section_id")
            , inverseJoinColumns = @JoinColumn(name = "children_id")
    )
    private List<Children> childrenList;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public void addChildToSection(Children children) {
        if (childrenList == null) {
            childrenList = new ArrayList<>();
        }
        childrenList.add(children);
    }
}

