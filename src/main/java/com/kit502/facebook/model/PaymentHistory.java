package com.kit502.facebook.model;


import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentHistory implements Serializable{

    public PaymentHistory(JsonObject obj) {
        this.type = obj.get("type") == null ? null: obj.get("type").getAsString();
        this.price = obj.get("price") == null ? -1 : obj.get("price").getAsDouble();
        this.comparison = obj.get("comparison") == null ? null: obj.get("comparison").getAsString();
        this.note = obj.get("note") == null ? null: obj.get("note").getAsString();
        this.create_at = new Date();
        this.update_at = new Date();
    }


    private String type;
    private double price;
    private String comparison;
    private String note;
    private Date create_at;
    private Date update_at;

    public void setType(String type) {
        this.update_at = new Date();
        this.type = type;
    }

    public void setPrice(double price) {
        this.update_at = new Date();
        this.price = price;
    }

    public void setComparison(String comparison) {
        this.update_at = new Date();
        this.comparison = comparison;
    }

    public void setNote(String note) {
        this.update_at = new Date();
        this.note = note;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }
}
