package com.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.Postpaid;
import com.login.repository.PostpaidRepo;



@Service
public class PostpaidServices {
@Autowired
	private PostpaidRepo repo;
	public Postpaid saveUser(Postpaid  user) 
	{
	return repo.save(user);
	}
public Postpaid  fetchUserByEmailid(String email) {
return	repo.findByEmailId(email);
	
	
}

public Postpaid  fetchUserByEmailIdAndPassword(String email, String password) {
return repo.findByEmailIdAndPassword(email, password);


}
public List<Postpaid > fetchbyuserList() {
	// TODO Auto-generated method stub
	return repo.findAll() ;
}
public Optional<Postpaid > fetchUserById(int id) {
	
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












































