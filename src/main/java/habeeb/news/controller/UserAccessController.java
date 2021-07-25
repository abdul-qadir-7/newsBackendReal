package habeeb.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import habeeb.news.dao.UserAccessDao;
import habeeb.news.models.Access;

@RestController
@RequestMapping("/api/user")
public class UserAccessController {

	@Autowired
	UserAccessDao dao;
	@PostMapping(value="/access",produces="application/json")
	public void giveOrRevokeAccess(@RequestBody Access access) {
		if(dao.accessAlreadyExist(access) && !access.getAccess()) {
			dao.revokeAccess(access);
		}else if(!dao.accessAlreadyExist(access) && access.getAccess()){
			dao.giveAccess(access);
		}
	}
	@GetMapping(value="/getAll",produces="application/json")
	public List<Access> getAllAccess() {
		return dao.getAllAccess();
	}
	@PostMapping(value="/getAllAccessOfAnUser",produces="application/json")
	public List<Access> getAllAccessOfAnUser(@RequestBody Access access) {
		
		return dao.getAllAccessOfAnUser(access.getEmail());
	}
}
