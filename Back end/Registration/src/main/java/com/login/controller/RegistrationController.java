package com.login.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.login.SmtpMailSender;
import com.login.model.User;
import com.login.repository.RegistrationRepo;
import com.login.service.RegistrationServices;

@RestController
public class RegistrationController {

	@Autowired
	private  RegistrationServices service;
	
	@Autowired
    private SmtpMailSender smtpMailSender; 
	
	@RequestMapping("/sendmail")
	@CrossOrigin(origins ="http://localhost:4200")
	public void sendmail() throws MessagingException
	{
	smtpMailSender.send("", "Voizfonica Registration", " you have successfully registered with VoizFonica");
	System.out.println("hi chandru");
	}
	
	
	
	@PostMapping("/registeruser")
@CrossOrigin(origins ="http://localhost:4200")
public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailId();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
		User userobj=	service.fetchUserByEmailid(tempEmailId);
if(userobj !=null) {
	throw new Exception("User with "+tempEmailId+"is already exists");
	}
}
	User userObj=null;
	userObj=service.saveUser(user);
	
	smtpMailSender.send(tempEmailId, "voiseFonica registration", "You have successfully registered with VoizFonica");
	
	return userObj;
}
	
	@PostMapping("/login")
	@CrossOrigin(origins ="http://localhost:4200")

	public User loginUser(@RequestBody User user) throws Exception {
	String tempEmailId	=user.getEmailId();
	String tempPass		=user.getPassword();
		User userObj=null;
			if(tempEmailId !=null && tempPass !=null) 
			{
				userObj=service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
			}
	if(userObj == null) {
			throw new Exception("Bad credentials username and paswword miss match ");
	}
		return userObj;
	
}
	//show list of users
@GetMapping("/users")
@CrossOrigin(origins ="http://localhost:4200")
	public List<User>fetchUsersList(){
		List <User>users=new ArrayList<User>();
		//logic to fetch from database
		users=service.fetchbyuserList();
		return users;
		
	}
//update
@GetMapping("/edit/{id}")
@CrossOrigin(origins ="http://localhost:4200")
public User fetchUserById(@PathVariable int id) {
	return service.fetchUserById(id).get();
	 
	
}
//delete maping
@DeleteMapping("/deletebyid/{id}")
@CrossOrigin(origins ="http://localhost:4200")
public String DeleteUserById(@PathVariable int id) {
	return service.deleteUserById(id);
}
}



















































