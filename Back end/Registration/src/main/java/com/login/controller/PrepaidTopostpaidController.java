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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.SmtpMailSender;
import com.login.model.PrepaidToPostpaid;
import com.login.repository.PrepaidToPostpaidRepo;
import com.login.service.PrepaidToPostpaidServices;


@RestController
public class PrepaidTopostpaidController {

	@Autowired
    private PrepaidToPostpaidRepo ur;
	
	@Autowired
	private  PrepaidToPostpaidServices service;
	

	@Autowired
    private SmtpMailSender smtpMailSender; 
	
	@RequestMapping("/sendmailptop")
	@CrossOrigin(origins ="http://localhost:4200")
	public void sendmail() throws MessagingException
	{
//smtpMailSender.send(this.tempEmailId, "Voizfonica Registration", " you have successfully registered with VoizFonica");
	System.out.println("hi chandru");
	}
	
	
	
	@PostMapping("/regsubptop")
@CrossOrigin(origins ="http://localhost:4200")
public PrepaidToPostpaid registerUser(@RequestBody PrepaidToPostpaid user) throws Exception {
		String tempEmailId=user.getEmailId();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			PrepaidToPostpaid userobj=	service.fetchUserByEmailid(tempEmailId);
if(userobj !=null) {
	throw new Exception("User with "+tempEmailId+"is already exists");
	}
}
		PrepaidToPostpaid userObj=null;
	userObj=service.saveUser(user);
	smtpMailSender.send(tempEmailId, "voiseFonica registration", "You have successfully registered with VoizFonica");
	return userObj;
}
	
	@PostMapping("/loginsubptop")
	@CrossOrigin(origins ="http://localhost:4200")

	public PrepaidToPostpaid loginUser(@RequestBody PrepaidToPostpaid user) throws Exception {
	String tempEmailId	=user.getEmailId();
	String tempPass		=user.getPassword();
	PrepaidToPostpaid userObj=null;
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
@GetMapping("/subscribersptop")
@CrossOrigin(origins ="http://localhost:4200")
	public List<PrepaidToPostpaid>fetchUsersList(){
		List <PrepaidToPostpaid>users=new ArrayList<PrepaidToPostpaid>();
		//logic to fetch from database
		users=service.fetchbyuserList();
		return users;
		
	}
//update
@GetMapping("/editsubptop/{id}")
@CrossOrigin(origins ="http://localhost:4200")
public PrepaidToPostpaid fetchUserById(@PathVariable int id) {
	return service.fetchUserById(id).get();
	 
	
}
//delete maping
@DeleteMapping("/deletebyidsubptop/{id}")
@CrossOrigin(origins ="http://localhost:4200")
public String DeleteUserById(@PathVariable int id) {
	return service.deleteUserById(id);
}//////////////////////////maillllllllllll

//@RequestMapping(value = "/testEmail/{email}", method= RequestMethod.GET)
@GetMapping("/testEmailptop/{email}")
@CrossOrigin(origins ="http://localhost:4200")
@ResponseBody
public String Subscriber1 (@PathVariable("email") String email) throws MessagingException
{
	System.out.println("TheParsedMailI"+email);
smtpMailSender.send(email, "voiseFonica ", "Your current plan is going to end please recharge to enjoy the servives");

	return "MailSent";
}

}
