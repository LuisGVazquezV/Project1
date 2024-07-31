package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User registerUser(User newUser) {

        User u = userDAO.save(newUser);
        return u;
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public User getUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public User updateUser( String newUsername, int userId) {
        Optional<User> existingUser = userDAO.findById(userId);

        if(existingUser.isPresent()){
            User u = existingUser.get();
            u.setUserName(newUsername);
            return userDAO.save(u);
        }else{
            System.out.println("User not found");
            return null;
        }
    }


}
