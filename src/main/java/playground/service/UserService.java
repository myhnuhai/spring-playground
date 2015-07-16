package playground.service;


import playground.domain.User;

import java.util.List;

public interface UserService {

    public List<User> findAllUsers();

    public User findUserByName(String name);

}
