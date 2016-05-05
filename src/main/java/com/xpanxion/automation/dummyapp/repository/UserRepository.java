package com.xpanxion.automation.dummyapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.xpanxion.automation.dummyapp.model.User;

public interface UserRepository  extends Repository<User, String> {
	
	List<User> findAll();
	
	@Query("SELECT u FROM User u WHERE u.client IN (SELECT id FROM Client WHERE email = ?1) OR stylist IN (SELECT licNum FROM Stylist WHERE email = ?1) OR salon = ?1 OR email = ?1")
	User findByUsername(String username);
}
