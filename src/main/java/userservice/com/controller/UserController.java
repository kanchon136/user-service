package userservice.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import userservice.com.dto.UserResponseTemplateVo;
import userservice.com.entity.User;
import userservice.com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

@PostMapping("/saveUser")
private User saveUser(@RequestBody User user) {
	
	return userService.saveUser(user);
	
}

@GetMapping("/findUserByid/{userId}")
public ResponseEntity<?> findUserById(@PathVariable("userId") Long userId) {
	User  user = userService.findUserById(userId);
       return  new ResponseEntity<>(user, HttpStatus.OK)  ; 
}

@GetMapping("/findUserWithDepartment/{userId}")
public ResponseEntity<?> findUserByIdwithDepartment(@PathVariable("userId") Long userId){
	
	UserResponseTemplateVo vo = userService.findUserWithDepartment(userId);
	return new ResponseEntity<>(vo,HttpStatus.OK);
	
}

@GetMapping("/")
public String test() {
	return "Testing is successfull....!";
}
	

}
