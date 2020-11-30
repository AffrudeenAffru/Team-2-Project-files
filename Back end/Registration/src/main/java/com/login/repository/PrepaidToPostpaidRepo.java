package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.model.PrepaidToPostpaid;



public interface PrepaidToPostpaidRepo extends JpaRepository<PrepaidToPostpaid, Integer> {
	public PrepaidToPostpaid findByEmailId(String emailId);


	public PrepaidToPostpaid findByEmailIdAndPassword(String email, String password);
}
 