package ru.students.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table (name="students")
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="name",length = 512,unique = false)
    private String name;

    @Column (name= "surname",length = 512,unique = false)
    private String surname;

    @Column (name="patronymic",length = 512,unique = false)
    private String patronymic;

    @Column (name= "group_name")
    private String group;

    @Column (name="is_active")
    private Boolean isActive;

}
