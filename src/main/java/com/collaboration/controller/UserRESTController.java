package com.collaboration.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.collaboration.model.User;
import com.collaboration.service.UserService;

@RestController
public class UserRESTController {

	@Autowired
   private UserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user) {
	
	

		boolean result = userService.saveOrUpdate(user);
		if (result) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			Error error = new Error("unable to register user ");
			return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/************************Login***********************************/
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User users,HttpSession session)
	{ 
	    System.out.println("Is Session New For" + users.getUserName() + session.isNew());
	    User validUser=userService.login(users);
	    if(validUser==null)

	    {
		    Error error=new Error("Invalid username and password.. please enter valid credentials");
		    return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}	   
	    else	
	    {
	        validUser.setIsonline(true);
		    validUser=userService.updateUser(validUser);
		    session.setAttribute("user", validUser);
		    return new ResponseEntity<User>(validUser,HttpStatus.OK);    
		}
	}
	/************************Logout ***********************************/
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ResponseEntity<?> logout(HttpSession session)
	{ 
	  
		User validUser=(User) session.getAttribute("user");
	    if(validUser==null)

	    {
	    	Error error=new Error("Unauthorized user");
		    return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}	   
	    else	
	    {
	        validUser.setIsonline(false);
	        userService.updateUser(validUser);
		    session.removeAttribute("user");
		    session.invalidate();
		    return new ResponseEntity<User>(validUser,HttpStatus.OK);    
		}
	}
	

}
