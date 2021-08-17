package com.tutorialproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorialproject.model.Cards;
@Repository
public interface CardRepo extends JpaRepository<Cards, Integer>{
	

}
