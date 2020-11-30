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
import org.springframework.web.bind.annotation.RestController;

import com.login.SmtpMailSender;
import com.login.model.Dongle;
import com.login.repository.DongleRepo;
import com.login.service.DongleServices;




@RestController
public class DongleController {


	@Autowired
    private DongleRepo ur;
	@Autowired
	private  DongleServices service;
	
	@Autowired
    private SmtpMailSender smtpMailSender; 
	
	@RequestMapping("/mail1111")
	@CrossOrigin(origins ="http://localhost:4200")
	public void sendmail() throws MessagingException
	{
//	smtpMailSender.send("", "Voizfonica Registration", " you have successfully registered with VoizFonica");
	System.out.println("hi afrru");
	}
	
	
	
	@PostMapping("/addplan3")
@CrossOrigin(origins ="http://localhost:4200")
public Dongle registerUser(@RequestBody Dongle user) throws Exception {
		String tempEmailId=user.getEmailId();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			Dongle userobj=	service.fetchUserByEmailid(tempEmailId);
if(userobj !=null) {
	throw new Exception("User with "+tempEmailId+"is already exists");
	}
}
		Dongle userObj=null;
	userObj=service.saveUser(user);
	
	//smtpMailSender.send(tempEmailId, "voiseFonica registration", "You have successfully registered with VoizFonica");
	
	return userObj;
}
	
	@PostMapping("/loginplan3")
	@CrossOrigin(origins ="http://localhost:4200")

	public Dongle loginUser(@RequestBody Dongle user) throws Exception {
	String tempEmailId	=user.getEmailId();
	String tempPass		=user.getPassword();
	Dongle userObj=null;
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
@GetMapping("/prepaidplans3")
@CrossOrigin(origins ="http://localhost:4200")
	public List<Dongle>fetchUsersList(){
		List <Dongle>users=new ArrayList<Dongle>();
		//logic to fetch from database
		users=service.fetchbyuserList();
		return users;
		
	}
//update
@GetMapping("/editprepaid3/{id}")
@CrossOrigin(origins ="http://localhost:4200")
public Dongle fetchUserById(@PathVariable int id) {
	return service.fetchUserById(id).get();
	 
	
}
//delete maping
@DeleteMapping("/deletebyidprepaid3/{id}")
@CrossOrigin(origins ="http://localhost:4200")
public String DeleteUserById(@PathVariable int id) {
	return service.deleteUserById(id);
}
}



















































