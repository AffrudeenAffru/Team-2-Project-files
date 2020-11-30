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
import com.login.model.Prepaid;
import com.login.repository.PrepaidRepo;
import com.login.service.PrepaidServices;


@RestController
public class PrepaidConttroller {


	@Autowired
    private PrepaidRepo ur;
	@Autowired
	private  PrepaidServices service;
	
	@Autowired
    private SmtpMailSender smtpMailSender; 
	
	@RequestMapping("/mail")
	@CrossOrigin(origins ="http://localhost:4200")
	public void sendmail() throws MessagingException
	{
//	smtpMailSender.send("", "Voizfonica Registration", " you have successfully registered with VoizFonica");
	System.out.println("hi chandru");
	}
	
	
	
	@PostMapping("/addplan")
@CrossOrigin(origins ="http://localhost:4200")
public Prepaid registerUser(@RequestBody Prepaid user) throws Exception {
		String tempEmailId=user.getEmailId();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			Prepaid userobj=	service.fetchUserByEmailid(tempEmailId);
if(userobj !=null) {
	throw new Exception("User with "+tempEmailId+"is already exists");
	}
}
		Prepaid userObj=null;
	userObj=service.saveUser(user);
	
	//smtpMailSender.send(tempEmailId, "voiseFonica registration", "You have successfully registered with VoizFonica");
	
	return userObj;
}
	
	@PostMapping("/loginplan")
	@CrossOrigin(origins ="http://localhost:4200")

	public Prepaid loginUser(@RequestBody Prepaid user) throws Exception {
	String tempEmailId	=user.getEmailId();
	String tempPass		=user.getPassword();
	Prepaid userObj=null;
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
@GetMapping("/prepaidplans")
@CrossOrigin(origins ="http://localhost:4200")
	public List<Prepaid>fetchUsersList(){
		List <Prepaid>users=new ArrayList<Prepaid>();
		//logic to fetch from database
		users=service.fetchbyuserList();
		return users;
		
	}
//update
@GetMapping("/editprepaid/{id}")
@CrossOrigin(origins ="http://localhost:4200")
public Prepaid fetchUserById(@PathVariable int id) {
	return service.fetchUserById(id).get();
	 
	
}
//delete maping
@DeleteMapping("/deletebyidprepaid/{id}")
@CrossOrigin(origins ="http://localhost:4200")
public String DeleteUserById(@PathVariable int id) {
	return service.deleteUserById(id);
}
}



















































