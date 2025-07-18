package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id")
    private int id;

    @Column(name = "us_name")
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Attempt> attempts;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Attempt> getAttempts() {
        return attempts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttempts(Set<Attempt> attempts) {
        this.attempts = attempts;
    }
}
