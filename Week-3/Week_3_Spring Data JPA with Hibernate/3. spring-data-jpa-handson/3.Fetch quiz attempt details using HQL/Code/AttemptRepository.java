package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
    
    @Query("SELECT a FROM Attempt a " +
           "JOIN FETCH a.user u " +
           "JOIN FETCH a.attemptQuestions aq " +
           "JOIN FETCH aq.question q " +
           "JOIN FETCH aq.attemptOptions ao " +
           "JOIN FETCH ao.option o " +
           "WHERE u.id = :userId AND a.id = :attemptId")
    Optional<Attempt> getAttempt(int userId, int attemptId);
}
