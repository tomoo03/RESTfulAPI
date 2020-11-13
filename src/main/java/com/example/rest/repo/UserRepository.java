package com.example.rest.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.rest.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
