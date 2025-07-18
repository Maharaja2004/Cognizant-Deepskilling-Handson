package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qu_id") 
    private int id;

    @Column(name = "qu_text") 
    private String text;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuizOption> options;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<QuizOption> getOptions() {
        return options;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOptions(List<QuizOption> options) {
        this.options = options;
    }
}
