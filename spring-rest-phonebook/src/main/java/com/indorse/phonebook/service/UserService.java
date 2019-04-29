package com.indorse.phonebook.service;

import java.util.List;

import com.indorse.phonebook.model.UserDTO;


public interface UserService {

  void createNewUser(UserDTO newUser);

  UserDTO login(String username, String password);

  List<UserDTO> search(String firstName, String lastName, String userName);

  String addFriend(Long userId, String friendUserName);

  String removeFriend(Long userId, String friendUserName);
}
