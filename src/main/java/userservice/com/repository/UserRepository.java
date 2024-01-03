package userservice.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import userservice.com.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
