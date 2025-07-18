package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aq_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "aq_at_id")
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "aq_qu_id") 
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion", cascade = CascadeType.ALL)
    private List<AttemptOption> attemptOptions;

    public int getId() {
        return id;
    }

    public Attempt getAttempt() {
        return attempt;
    }

    public Question getQuestion() {
        return question;
    }

    public List<AttemptOption> getAttemptOptions() {
        return attemptOptions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAttempt(Attempt attempt) {
        this.attempt = attempt;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setAttemptOptions(List<AttemptOption> attemptOptions) {
        this.attemptOptions = attemptOptions;
    }
}
