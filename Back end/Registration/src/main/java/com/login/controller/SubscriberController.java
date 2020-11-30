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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.SmtpMailSender;
import com.login.model.Subscriber;
import com.login.repository.SubscriberRegistrationRepo;
import com.login.service.SubscriberRegistrationServices;

@RestController
public class SubscriberController {

	@Autowired
    private SubscriberRegistrationRepo ur;
	
	@Autowired
	private  SubscriberRegistrationServices service;
	

	@Autowired
    private SmtpMailSender smtpMailSender; 
	
	@RequestMapping("/sendmail12")
	@CrossOrigin(origins ="http://localhost:4200")
	public void sendmail() throws MessagingException
	{
//smtpMailSender.send(this.tempEmailId, "Voizfonica Registration", " you have successfully registered with VoizFonica");
	System.out.println("hi chandru");
	}
	
	
	
	@PostMapping("/regsub")
@CrossOrigin(origins ="http://localhost:4200")
public Subscriber registerUser(@RequestBody Subscriber user) throws Exception {
		String tempEmailId=user.getEmailId();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			Subscriber userobj=	service.fetchUserByEmailid(tempEmailId);
if(userobj !=null) {
	throw new Exception("User with "+tempEmailId+"is already exists");
	}
}
		Subscriber userObj=null;
	userObj=service.saveUser(user);
	smtpMailSender.send(tempEmailId, "voiseFonica registration", "You have successfully registered with VoizFonica");
	return userObj;
}
	
	@PostMapping("/loginsub")
	@CrossOrigin(origins ="http://localhost:4200")

	public Subscriber loginUser(@RequestBody Subscriber user) throws Exception {
	String tempEmailId	=user.getEmailId();
	String tempPass		=user.getPassword();
	Subscriber userObj=null;
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
@GetMapping("/subscribers")
@CrossOrigin(origins ="http://localhost:4200")
	public List<Subscriber>fetchUsersList(){
		List <Subscriber>users=new ArrayList<Subscriber>();
		//logic to fetch from database
		users=service.fetchbyuserList();
		return users;
		
	}
//update
@GetMapping("/editsub/{id}")
@CrossOrigin(origins ="http://localhost:4200")
public Subscriber fetchUserById(@PathVariable int id) {
	return service.fetchUserById(id).get();
	 
	
}
//delete maping
@DeleteMapping("/deletebyidsub/{id}")
@CrossOrigin(origins ="http://localhost:4200")
public String DeleteUserById(@PathVariable int id) {
	return service.deleteUserById(id);
}//////////////////////////maillllllllllll

//@RequestMapping(value = "/testEmail/{email}", method= RequestMethod.GET)
@GetMapping("/testEmail/{email}")
@CrossOrigin(origins ="http://localhost:4200")
@ResponseBody
public String Subscriber1 (@PathVariable("email") String email) throws MessagingException
{
	System.out.println("TheParsedMailI"+email);
smtpMailSender.send(email, "voiseFonica ", "Your current plan is going to end please recharge to enjoy the servives");

	return "MailSent";
}
//forget password
@PutMapping("/updatepassword/{id}")
@CrossOrigin(origins = "http://localhost:4200")
public Subscriber updateUserPassword(@PathVariable("id") String id,@RequestBody String pass) {
	//String newPass=user.getPassword();
	return service.upUserProfe(id, pass);
}



}
