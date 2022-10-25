package com.kit502.facebook.model;


import com.google.cloud.firestore.annotation.DocumentId;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FacebookPost implements Serializable {

    public FacebookPost(JsonObject jsonObject){
        this.id_groups = jsonObject.get("id_groups").getAsString();
        this.name_groups = jsonObject.get("name_groups").getAsString();
        this.id_post = jsonObject.get("id_post").getAsString();
        this.post_create_time = new Date(jsonObject.get("create_time").getAsLong()*1000);
        this.comments = new ArrayList<>();
        JsonArray jsonArray = jsonObject.getAsJsonArray("comments");
        for (JsonElement itemComment :
                jsonArray) {
            FacebookComment facebookComment = new FacebookComment(itemComment.getAsJsonObject());
            this.comments.add(facebookComment);
        }
    }

    private String id_groups;
    private String name_groups;
    private String id_post;
    private ArrayList<FacebookComment> comments;
    private Date post_create_time;

    @Override
    public String toString() {
        return comments.size()+"" +
                "";
    }
}
