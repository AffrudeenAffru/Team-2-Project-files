package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.model.Prepaid;


public interface PrepaidRepo extends JpaRepository<Prepaid, Integer> {
	public Prepaid findByEmailId(String emailId);


	public Prepaid findByEmailIdAndPassword(String email, String password);
}
 