package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "attempt_option")
public class AttemptOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ao_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ao_aq_id")
    private AttemptQuestion attemptQuestion;

    @ManyToOne
    @JoinColumn(name = "ao_op_id")
    private QuizOption option;

    @Column(name = "ao_selected")
    private boolean selected;

    public int getId() {
        return id;
    }

    public AttemptQuestion getAttemptQuestion() {
        return attemptQuestion;
    }

    public QuizOption getOption() {
        return option;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAttemptQuestion(AttemptQuestion attemptQuestion) {
        this.attemptQuestion = attemptQuestion;
    }

    public void setOption(QuizOption option) {
        this.option = option;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
