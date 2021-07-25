package habeeb.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import habeeb.news.dao.SignupLoginDao;
import habeeb.news.models.User;

@RestController
@RequestMapping("/api/credential")
public class SignupLoginController {
	@Autowired
	SignupLoginDao dao;
	@PostMapping(value="/signup",produces="application/json")
	public int signUp(@RequestBody User user) {
		//first check if user already exist then return 0, if it doesn't exist then dosignup and return 1;
		if(dao.userAlreadyExist(user)) {
			return 0;
		}
		return dao.signUp(user);
//		return false;
	}
	@PostMapping(value="/login",produces="application/json")
	public User login(@RequestBody User user) {
		if(dao.userAlreadyExist(user)) {
			return dao.checkPassword(user);
			
		}
		User outputUser = new User();
		outputUser.setOutput(2);
		return outputUser;
		// returns 0 on wrong password, 1 for correct password, 2 for account doesn't exist.
//		return false;
	}
}
