package com.kit502.facebook.service;

import com.google.gson.JsonObject;
import com.kit502.facebook.model.PaymentHistory;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;

public interface IPaymentHistoryService {
    public ResponseEntity Create(JsonObject paymentHistory);
    public ResponseEntity Read(JsonObject paymentHistory);
    public ResponseEntity Update(JsonObject paymentHistory);
    public ResponseEntity Delete(JsonObject paymentHistory);
}
