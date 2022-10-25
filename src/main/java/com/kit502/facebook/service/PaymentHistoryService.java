package com.kit502.facebook.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kit502.facebook.model.PaymentHistory;
import com.kit502.facebook.model.responsive.ResponsiveBody;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public class PaymentHistoryService implements IPaymentHistoryService {

    @Override
    public ResponseEntity Create(JsonObject paymentHistory) {
        PaymentHistory history = new PaymentHistory(paymentHistory);
        if(FirebaseService.Create(FirebaseService.COLLECTION_PAYMENT_NAME,history))
        {
            return ResponsiveBody.Success(0,"Create success",paymentHistory);
        }else{
            return ResponsiveBody.Error(1000,"Create error");
        }
    }

    @Override
    public ResponseEntity Read(JsonObject paymentHistory) {
        return null;
    }

    @Override
    public ResponseEntity Update(JsonObject paymentHistory) {
        return null;
    }

    @Override
    public ResponseEntity Delete(JsonObject paymentHistory) {
        return null;
    }

    public ResponseEntity ReadAll(JsonObject obj) {
        Map<String, Object> history = FirebaseService.ReadAll(FirebaseService.COLLECTION_PAYMENT_NAME);
        if(history != null)
        {
            return ResponsiveBody.Success(0,"Read success", history);
        }else{
            return ResponsiveBody.Error(1000,"Read error");
        }
    }
}
