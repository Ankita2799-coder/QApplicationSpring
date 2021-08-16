package com.tutorialproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorialproject.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
