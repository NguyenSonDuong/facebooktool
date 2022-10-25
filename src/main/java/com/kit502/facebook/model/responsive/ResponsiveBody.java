package com.kit502.facebook.model.responsive;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

public class ResponsiveBody {
        public static ResponseEntity Success(int code,String title,Object content){
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status","success");
            jsonObject.put("code",code);
            jsonObject.put("title",title);
            jsonObject.put("content", content);
            return ResponseEntity.ok(jsonObject.toString());
        }catch (Exception exx){
            return Error(2000,exx.getMessage());
        }

    }

    public static ResponseEntity Error(int code,String title){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status","error");
        jsonObject.addProperty("code",code);
        jsonObject.addProperty("title",title);
        jsonObject.add("content",null);
        return ResponseEntity.badRequest().body(jsonObject);
    }
}
