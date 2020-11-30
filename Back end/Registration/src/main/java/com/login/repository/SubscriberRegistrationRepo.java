package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.model.Subscriber;

public interface SubscriberRegistrationRepo extends JpaRepository<Subscriber, Integer> {
	public Subscriber findByEmailId(String emailId);


	public Subscriber findByEmailIdAndPassword(String email, String password);
}
 