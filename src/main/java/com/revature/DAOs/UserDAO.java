package com.revature.DAOs;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserDAO {


    @Repository
    public interface userDAO extends JpaRepository<User, Integer> {

    }
}
