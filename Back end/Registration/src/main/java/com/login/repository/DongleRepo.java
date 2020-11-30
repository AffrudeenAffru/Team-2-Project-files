package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.model.Dongle;






public interface DongleRepo extends JpaRepository<Dongle, Integer> {
	public Dongle findByEmailId(String emailId);


	public Dongle findByEmailIdAndPassword(String email, String password);
}
 