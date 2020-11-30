package com.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.User;
import com.login.repository.*;
@Service
public class RegistrationServices {
@Autowired
	private RegistrationRepo repo;
	public User saveUser(User user) 
	{
	return repo.save(user);
	}
public User fetchUserByEmailid(String email) {
return	repo.findByEmailId(email);
	
	
}

public User fetchUserByEmailIdAndPassword(String email, String password) {
return repo.findByEmailIdAndPassword(email, password);


}
public List<User> fetchbyuserList() {
	// TODO Auto-generated method stub
	return repo.findAll() ;
}
public Optional<User> fetchUserById(int id) {
	
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












































