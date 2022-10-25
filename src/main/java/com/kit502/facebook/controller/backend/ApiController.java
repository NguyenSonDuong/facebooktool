package com.kit502.facebook.controller.backend;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.kit502.facebook.model.PaymentHistory;
import com.kit502.facebook.service.PaymentHistoryService;
import netscape.javascript.JSObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.serializer.Serializer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


public class ApiController {

    PaymentHistoryService paymentHistoryService;

    public ApiController() {
        this.paymentHistoryService = new PaymentHistoryService();
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String Create(@RequestBody Object obj){
        return "paymentHistoryService.Create(obj)";
    }

    @RequestMapping(value = "/addData",method = RequestMethod.GET)
    public String Data(){
        Firestore firestore = FirestoreClient.getFirestore();
        try {
            return new ObjectMapper()
                    .writeValueAsString(
                            firestore
                                    .collection("kit502")
                                    .document("TlfASyLcW3i6mBmaXXCJ")
                                    .get()
                                    .get()
                                    .getData());
        } catch (InterruptedException e) {
            System.out.println(e);;
        } catch (ExecutionException e) {
            System.out.println(e);;
        } catch (JsonProcessingException e) {
            System.out.println(e);;
        }
        return "getResourceFileAsString(";
    }



}
