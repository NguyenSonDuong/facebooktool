package com.kit502.facebook.service;

import com.google.cloud.firestore.QuerySnapshot;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kit502.facebook.model.FacebookComment;
import com.kit502.facebook.model.FacebookPost;
import com.kit502.facebook.model.responsive.ResponsiveBody;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FacebookCommentService implements IFacebookCommentService{
    @Override
    public ResponseEntity Create(JsonObject facebookComment) {
        FacebookPost facebook = new FacebookPost(facebookComment);
        boolean isSuccess = FirebaseService.Create(FirebaseService.COLLECTION_PAYMENT_NAME,facebook);
        if(isSuccess)
            return ResponsiveBody.Success(0,"Tạo thành công","http://localhost:8080/facebook/view/"+isSuccess);
        else
            return ResponsiveBody.Error(-1000,"Tạo thất bại");
    }

    @Override
    public ResponseEntity Read(JsonObject facebookComment) {
        return null;
    }

    public ResponseEntity Read(String id){
        Map<String, Object> abc = FirebaseService.Read(FirebaseService.COLLECTION_PAYMENT_NAME,id);
        return ResponseEntity.ok(abc.get("comments"));
    }

    @Override
    public ResponseEntity Update(JsonObject facebookComment) {
        return null;
    }

    @Override
    public ResponseEntity Delete(JsonObject facebookComment) {
        return null;
    }

    public ResponseEntity Read(String id_group, String id_post) {
        QuerySnapshot query = FirebaseService.Search(FirebaseService.COLLECTION_PAYMENT_NAME);
        HashMap<String, Object> ids = new HashMap<>();
        query.getDocuments().forEach((search)->{
            if(search.get("id_groups").equals(id_group) && search.get("id_post").equals(id_post)){
                ids.put("id",search.getId());
                ids.put("data",search.getData());
            }
        });
        return ResponseEntity.ok(ids);
    }
}
