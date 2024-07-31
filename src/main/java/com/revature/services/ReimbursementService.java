package com.revature.services;

import com.revature.DAOs.ReimbursementDAO;
import com.revature.DAOs.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class ReimbursementService {

    private ReimbursementDAO rDAO;
    private UserDAO uDAO;

    public ReimbursementService(ReimbursementDAO rDAO, UserDAO uDAO) {
        this.rDAO = rDAO;
        this.uDAO = uDAO;
    }


}
