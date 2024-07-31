package com.revature.controllers;

import com.revature.DAOs.UserDAO;
import com.revature.models.DTOs.IncomingReimbursementDTO;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reimbursements")
public class ReimbursementController {

    private ReimbursementService rs;
    private UserDAO uDAO;
    private UserService us;

    @Autowired
    public ReimbursementController(ReimbursementService rs, UserDAO uDAO, UserService us) {
        this.rs = rs;
        this.uDAO = uDAO;
        this.us = us;
    }

    @PostMapping
    public ResponseEntity<Object> addReimbursement(@RequestBody IncomingReimbursementDTO newReimbursement){
        Reimbursement r = rs.addReimbursement(newReimbursement);

        if(r ==null){
            return ResponseEntity.status(400).body("Couldn't find user with ID: " + newReimbursement.getUserId());
        }
        return ResponseEntity.status(201).body(r);

    }

}
