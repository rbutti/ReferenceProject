package com.indorse.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indorse.phonebook.model.ResponseDTO;
import com.indorse.phonebook.model.UserDTO;
import com.indorse.phonebook.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @SuppressWarnings("rawtypes")
@PostMapping("/create")
  public ResponseEntity createUser(@RequestBody UserDTO newUser) {
    userService.createNewUser(newUser);
    return ResponseEntity.ok(new ResponseDTO("User Created!"));
  }

  /**
   * login user
   * @param userDTO
   * @return
   */
  @SuppressWarnings("rawtypes")
@PostMapping("/login")
  public ResponseEntity login(@RequestBody UserDTO userDTO) {
    return ResponseEntity.ok(userService.login(userDTO.getUsername(), userDTO.getPassword()));

  }

  /**
   * search for users
   * @param firstName
   * @param lastName
   * @param userName
   * @return
   */
  @SuppressWarnings("rawtypes")
@GetMapping("/search")
  public ResponseEntity search(
      @RequestParam(value = "firstname", required = false) String firstName,
      @RequestParam(value = "lastname", required = false) String lastName,
      @RequestParam(value = "username", required = false) String userName) {

    return ResponseEntity.ok(userService.search(firstName, lastName, userName));

  }

  /**
   * add a friend
   * @param userId
   * @param friendUserName
   * @return
   */
  @SuppressWarnings("rawtypes")
@PostMapping("/add-friend")
  public ResponseEntity addFriend(
      @RequestParam(value = "user_id") Long userId,
      @RequestParam(value = "friend_username") String friendUserName) {

    String message = userService.addFriend(userId, friendUserName);
    return ResponseEntity.ok(new ResponseDTO(message));
  }

  /**
   * remove a friend
   * @param userId
   * @param friendUserName
   * @return
   */
  @SuppressWarnings("rawtypes")
@PostMapping("/remove-friend")
  public ResponseEntity removeFriend(
      @RequestParam(value = "user_id") Long userId,
      @RequestParam(value = "friend_username") String friendUserName) {
    String message = userService.removeFriend(userId, friendUserName);
    return ResponseEntity.ok(new ResponseDTO(message));
  }






}
