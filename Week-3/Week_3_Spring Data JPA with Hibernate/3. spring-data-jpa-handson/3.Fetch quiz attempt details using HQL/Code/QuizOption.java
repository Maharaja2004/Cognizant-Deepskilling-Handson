package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz_option")
public class QuizOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private int id;

    @Column(name = "op_text")
    private String text;

    @Column(name = "op_score")
    private double score;

    @ManyToOne
    @JoinColumn(name = "op_qu_id")
    private Question question;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public double getScore() {
        return score;
    }

    public Question getQuestion() {
        return question;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
