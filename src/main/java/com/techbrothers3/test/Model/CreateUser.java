package com.techbrothers3.test.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class CreateUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String username;
    private int totalAnswered = 0;
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;

    public CreateUser() {}

    public CreateUser(String username) {
        this.username = username;
    }
    //getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    //setters
    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalAnswered() {
        return totalAnswered;
    }

    public void setTotalAnswered(int totalAnswered) {
        this.totalAnswered = totalAnswered;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public void incrementCorrect() {
        correctAnswers++;
        totalAnswered++;
    }
    public void incrementIncorrect() {
        incorrectAnswers++;
        totalAnswered++;
    }
}
