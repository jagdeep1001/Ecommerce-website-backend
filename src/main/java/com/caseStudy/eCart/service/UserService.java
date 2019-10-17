package com.caseStudy.eCart.service;


import com.caseStudy.eCart.model.Users;
import com.caseStudy.eCart.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public Users addUser(Users user) { return usersRepository.save(user); }

    public Long getUserId(Principal principal) {
        String email = principal.getName();
        return usersRepository.findByEmail(email).getUserId();
    }

    public Users callUser(Principal principal) {
        return usersRepository.findByEmail(principal.getName());
    }

    public Users changeUserDetails(Users users) {
        Users oldUser = usersRepository.findByUserId(users.getUserId());
        oldUser.setUserId(users.getUserId());
        oldUser.setName(users.getName());
        oldUser.setEmail(users.getEmail());
        oldUser.setPassword(users.getPassword());
        oldUser.setName(users.getName());
        oldUser.setMobileNo(users.getMobileNo());
        oldUser.setAddress(users.getAddress());
        usersRepository.saveAndFlush(oldUser);
        return oldUser;
    }
}
