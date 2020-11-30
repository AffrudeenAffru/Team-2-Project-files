package com.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.Dongle;
import com.login.repository.DongleRepo;





@Service
public class DongleServices {
@Autowired
	private DongleRepo repo;
	public Dongle saveUser(Dongle  user) 
	{
	return repo.save(user);
	}
public Dongle  fetchUserByEmailid(String email) {
return	repo.findByEmailId(email);
	
	
}

public Dongle  fetchUserByEmailIdAndPassword(String email, String password) {
return repo.findByEmailIdAndPassword(email, password);


}
public List<Dongle> fetchbyuserList() {
	// TODO Auto-generated method stub
	return repo.findAll() ;
}
public Optional<Dongle > fetchUserById(int id) {
	
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












































