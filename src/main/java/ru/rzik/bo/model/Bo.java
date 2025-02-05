package ru.rzik.bo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bo")
public class Bo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

}
