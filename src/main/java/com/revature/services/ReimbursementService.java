package com.revature.services;

import com.revature.DAOs.ReimbursementDAO;
import com.revature.DAOs.UserDAO;
import com.revature.models.DTOs.IncomingReimbursementDTO;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReimbursementService {

    private ReimbursementDAO rDAO;
    private UserDAO uDAO;

    @Autowired
    public ReimbursementService(ReimbursementDAO rDAO, UserDAO uDAO) {
        this.rDAO = rDAO;
        this.uDAO = uDAO;
    }

    public Reimbursement addReimbursement(IncomingReimbursementDTO newReimbursement){
       Reimbursement reimbursement = new Reimbursement(0, newReimbursement.getDescription(),
               newReimbursement.getAmount(), newReimbursement.getStatus(), null);

       Optional<User> u = uDAO.findById(newReimbursement.getUserId());

       if(u.isPresent()){
           reimbursement.setUser(u.get());
           Reimbursement r = rDAO.save(reimbursement);
           return r;
       }else{
           return null;
       }
    }

    public List<Reimbursement> getAllReimbursements(){
        return rDAO.findAll();
    }

    public void deleteReimbursementById(int id){
        Reimbursement reimbursement = rDAO.findById(id).get();

        reimbursement.getUser().getReimbursements().remove(reimbursement);

        rDAO.deleteById(id);
    }

    public List<Reimbursement> getReimbursementsByUserId(int userId){
        return rDAO.findByUserUserId(userId);

    }


}
