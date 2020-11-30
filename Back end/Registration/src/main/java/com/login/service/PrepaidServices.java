package com.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.Prepaid;
import com.login.repository.PrepaidRepo;
@Service
public class PrepaidServices {
@Autowired
	private PrepaidRepo repo;
	public Prepaid saveUser(Prepaid  user) 
	{
	return repo.save(user);
	}
public Prepaid  fetchUserByEmailid(String email) {
return	repo.findByEmailId(email);
	
	
}

public Prepaid  fetchUserByEmailIdAndPassword(String email, String password) {
return repo.findByEmailIdAndPassword(email, password);


}
public List<Prepaid > fetchbyuserList() {
	// TODO Auto-generated method stub
	return repo.findAll() ;
}
public Optional<Prepaid > fetchUserById(int id) {
	
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












































