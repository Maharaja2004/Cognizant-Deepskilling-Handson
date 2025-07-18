package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "attempt")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @Column(name = "at_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private User user;

    @OneToMany(mappedBy = "attempt", cascade = CascadeType.ALL)
    private Set<AttemptQuestion> attemptQuestions;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public Set<AttemptQuestion> getAttemptQuestions() {
        return attemptQuestions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAttemptQuestions(Set<AttemptQuestion> attemptQuestions) {
        this.attemptQuestions = attemptQuestions;
    }
}
