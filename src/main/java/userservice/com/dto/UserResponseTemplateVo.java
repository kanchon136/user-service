package userservice.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import userservice.com.entity.User;

 

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponseTemplateVo {
	private User user;
	private Department department;

}
