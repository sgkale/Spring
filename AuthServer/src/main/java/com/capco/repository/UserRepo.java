package com.capco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.enities.AppUser;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Integer>{
	
	public AppUser findByUsername(String username);

}
