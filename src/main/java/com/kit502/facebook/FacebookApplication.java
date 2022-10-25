package com.kit502.facebook;

import com.kit502.facebook.service.FirebaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacebookApplication.class, args);
        if(FirebaseService.Init()){
            System.out.println("Success");
        }else{
            System.out.println("Error");
        }
    }

}
