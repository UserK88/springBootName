package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.user;
import com.example.demo.Repository.userRepository;

@Service
public class userService {
    
    @Autowired
    private userRepository userRepo;

    public String addUser(user us){
        String passWord = generatePassword(us.getFirstName(), us.getMiddleName(), us.getLastName());
        us.setPassword(passWord);
        userRepo.save(us);
        return "User added successfully";
    }

    public List<user> showUsers(){
        return userRepo.findAll();
    }

    public String generatePassword(String firstName, String middleName, String lastName){
        String str = firstName.substring(0,2)+middleName.substring(0,2)+lastName.substring(0,2);
        int randomNumber = 100 + (int)(Math.random() * 900);

        String password = str+randomNumber;
        return password;
    }
}
