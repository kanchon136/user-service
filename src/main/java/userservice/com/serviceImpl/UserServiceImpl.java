package userservice.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import userservice.com.dto.Department;
import userservice.com.dto.UserResponseTemplateVo;
import userservice.com.entity.User;
import userservice.com.repository.UserRepository;
import userservice.com.service.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		 log.info("user save service class");
		return userRepo.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		 
		return null;
	}

	@Override
	public User findUserById(Long userId) {
		 
		return null;
	}

	@Override
	public UserResponseTemplateVo findUserWithDepartment(Long userId) {
	    UserResponseTemplateVo vo = new UserResponseTemplateVo();
	    User user = userRepo.findById(userId).orElse(null);

	    if (user == null) {
	        // Handle the case where the user with the given ID is not found
	        return vo;
	    }

	    vo.setUser(user);
	    
	    System.out.println("=========="+user.getDepartmentId());

	    try {
	        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department-service/department/findDepartmentById/" + user.getDepartmentId(), Department.class);
	        vo.setDepartment(department);
	    } catch (Exception e) {
	        // Handle the exception (e.g., log it or return a default department)
	        e.printStackTrace(); // Log the exception or use a logging framework
	        // Optionally, set a default department or handle the error in another way
	    }

	    return vo;
	}

}
