package me.dio.SantanderJava.service;

import me.dio.SantanderJava.model.User;

public interface UserService {

    User findById(Long id);
    User create(User userToCreate);


}
