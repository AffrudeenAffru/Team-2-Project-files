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
import com.login.model.Postpaid;
import com.login.repository.PostpaidRepo;
import com.login.service.PostpaidServices;




@RestController
public class PostpaidController {


	@Autowired
    private PostpaidRepo ur;
	@Autowired
	private  PostpaidServices service;
	
	@Autowired
    private SmtpMailSender smtpMailSender; 
	
	@RequestMapping("/mail111")
	@CrossOrigin(origins ="http://localhost:4200")
	public void sendmail() throws MessagingException
	{
//	smtpMailSender.send("", "Voizfonica Registration", " you have successfully registered with VoizFonica");
	System.out.println("hi chandru");
	}
	
	
	
	@PostMapping("/addplan2")
@CrossOrigin(origins ="http://localhost:4200")
public Postpaid registerUser(@RequestBody Postpaid user) throws Exception {
		String tempEmailId=user.getEmailId();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			Postpaid userobj=	service.fetchUserByEmailid(tempEmailId);
if(userobj !=null) {
	throw new Exception("User with "+tempEmailId+"is already exists");
	}
}
		Postpaid userObj=null;
	userObj=service.saveUser(user);
	
	//smtpMailSender.send(tempEmailId, "voiseFonica registration", "You have successfully registered with VoizFonica");
	
	return userObj;
}
	
	@PostMapping("/loginplan2")
	@CrossOrigin(origins ="http://localhost:4200")

	public Postpaid loginUser(@RequestBody Postpaid user) throws Exception {
	String tempEmailId	=user.getEmailId();
	String tempPass		=user.getPassword();
	Postpaid userObj=null;
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
@GetMapping("/prepaidplans2")
@CrossOrigin(origins ="http://localhost:4200")
	public List<Postpaid>fetchUsersList(){
		List <Postpaid>users=new ArrayList<Postpaid>();
		//logic to fetch from database
		users=service.fetchbyuserList();
		return users;
		
	}
//update
@GetMapping("/editprepaid2/{id}")
@CrossOrigin(origins ="http://localhost:4200")
public Postpaid fetchUserById(@PathVariable int id) {
	return service.fetchUserById(id).get();
	 
	
}
//delete maping
@DeleteMapping("/deletebyidprepaid2/{id}")
@CrossOrigin(origins ="http://localhost:4200")
public String DeleteUserById(@PathVariable int id) {
	return service.deleteUserById(id);
}
}



















































