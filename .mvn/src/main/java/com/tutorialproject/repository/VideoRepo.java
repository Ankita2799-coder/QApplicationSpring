package com.tutorialproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorialproject.model.Cards;
import com.tutorialproject.model.Video;

public interface VideoRepo extends JpaRepository<Video, Integer>
{

	List<Video> findByCard(Optional<Cards> card);
	
}
