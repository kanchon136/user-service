package userservice.com.service;

import java.util.List;

import userservice.com.dto.UserResponseTemplateVo;
import userservice.com.entity.User;

public interface UserService {
	User saveUser(User user);
	List<User> findAllUsers();
	User findUserById(Long userId);
	UserResponseTemplateVo findUserWithDepartment(Long userId);
	 
	

}
