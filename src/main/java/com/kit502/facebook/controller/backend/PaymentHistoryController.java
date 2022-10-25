package com.kit502.facebook.controller.backend;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.kit502.facebook.IController;
import com.kit502.facebook.model.PaymentHistory;
import com.kit502.facebook.service.PaymentHistoryService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment-history")
public class PaymentHistoryController implements IController {

    PaymentHistoryService paymentHistoryService;

    public PaymentHistoryController() {
        this.paymentHistoryService = new PaymentHistoryService();
    }

    @Override
    public ResponseEntity Create(JsonObject obj) {
        return paymentHistoryService.Create(obj);
    }

    @Override
    public ResponseEntity Read(JsonObject obj) {
        return paymentHistoryService.Read(obj);
    }

    @Override
    public ResponseEntity Update(JsonObject obj) {
        return paymentHistoryService.Update(obj);
    }

    @Override
    public ResponseEntity Delete(JsonObject obj) {
        return paymentHistoryService.Delete(obj);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity ReadAll(JsonObject obj) {
        return paymentHistoryService.ReadAll(obj);
    }
}
