package com.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.Subscriber;
import com.login.repository.*;
@Service
public class SubscriberRegistrationServices {
@Autowired
	private SubscriberRegistrationRepo repo;
	public Subscriber saveUser(Subscriber user) 
	{
	return repo.save(user);
	}
public Subscriber fetchUserByEmailid(String email) {
return	repo.findByEmailId(email);
	
	
}

public Subscriber fetchUserByEmailIdAndPassword(String email, String password) {
return repo.findByEmailIdAndPassword(email, password);


}
public List<Subscriber> fetchbyuserList() {
	// TODO Auto-generated method stub
	return repo.findAll() ;
}
public Optional<Subscriber> fetchUserById(int id) {
	
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
 //forget password
public Subscriber upUserProfe(String id, String pass) {
	Subscriber db=repo.findByEmailId(id);	 
	db.setPassword(pass);
	Subscriber rd =repo.save(db);
	return rd;
	}

}












































