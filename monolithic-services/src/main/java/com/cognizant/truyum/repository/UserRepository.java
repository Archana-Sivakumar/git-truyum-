package com.cognizant.truyum.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.truyum.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	Users findByUserName(String name);
	
	
}

