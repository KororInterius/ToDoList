package com.koror.app.api.repository;

import com.koror.app.entity.User;

import java.util.List;

public interface IUserRepository {

    void registerUser(User user);

    void loadUser(User user);

    void deleteUserById(String id);

    List<User> getUserList();

    User getById(String id);

    User getByLogin(String login);

}
