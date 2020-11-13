package com.example.rest.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.rest.bean.User;
import com.example.rest.repo.UserRepository;

@RestController
public class UserController {

  @Autowired
  UserRepository userRepository;
  
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public List<User> userGet() {
    List<User> list = userRepository.findAll();
    return list;
  }
  
  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public List<User> userPost(
      @RequestBody List<User> userList) {
    List<User> result = userRepository.saveAll(userList);
    return result;
  }
  
  @RequestMapping(value = "/user", method = RequestMethod.PUT)
  public User userPut(@RequestBody User user) {
    Optional<User> target = userRepository.findById(user.getId());
    if (target.isEmpty()) {
      return null;
    } else {
      userRepository.save(user);
      return target.get();
    }
  }
  
  @RequestMapping(value = "/user", method = RequestMethod.DELETE)
  public User userDelete(@RequestBody User user) {
    Optional<User> target =userRepository.findById(user.getId());
    if (target.isEmpty()) {
      return null;
    } else {
      userRepository.deleteById(target.get().getId());
      return target.get();
    }
  }
}