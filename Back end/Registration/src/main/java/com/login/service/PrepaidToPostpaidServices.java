package com.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.PrepaidToPostpaid;
import com.login.repository.PrepaidToPostpaidRepo;


@Service
public class PrepaidToPostpaidServices {
@Autowired
	private PrepaidToPostpaidRepo repo;
	public PrepaidToPostpaid saveUser(PrepaidToPostpaid user) 
	{
	return repo.save(user);
	}
public PrepaidToPostpaid fetchUserByEmailid(String email) {
return	repo.findByEmailId(email);
	
	
}

public PrepaidToPostpaid fetchUserByEmailIdAndPassword(String email, String password) {
return repo.findByEmailIdAndPassword(email, password);


}
public List<PrepaidToPostpaid> fetchbyuserList() {
	// TODO Auto-generated method stub
	return repo.findAll() ;
}
public Optional<PrepaidToPostpaid> fetchUserById(int id) {
	
	return repo.findById(id) ;
}
public String deleteUserById(int id) {
	{
		String result;
		try {
			repo.deleteById(id);
			result="user deleted sucessfully";
		}catch (Exception e) {
			result="user deleted sucessfully";
		}
		return result;
	}
	
	
}
  

}












































