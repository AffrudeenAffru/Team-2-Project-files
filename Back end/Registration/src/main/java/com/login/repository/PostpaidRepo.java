package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.model.Postpaid;




public interface PostpaidRepo extends JpaRepository<Postpaid, Integer> {
	public Postpaid findByEmailId(String emailId);


	public Postpaid findByEmailIdAndPassword(String email, String password);
}
 