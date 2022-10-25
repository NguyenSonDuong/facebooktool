package com.kit502.facebook.model;


import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacebookComment implements Serializable {

    public FacebookComment(JsonObject jsonObject){
        this.author = new UserInfor();
        this.author.set__typename(jsonObject.getAsJsonObject("author").get("__typename").getAsString());
        this.author.setId_user(jsonObject.getAsJsonObject("author").get("id").getAsString());
        this.author.setName(jsonObject.getAsJsonObject("author").get("name").getAsString());
        this.author.setLink(jsonObject.getAsJsonObject("author").get("link").getAsString());
        this.author.setGender(jsonObject.getAsJsonObject("author").get("gender").getAsString());
        this.author.setAvatar_link(jsonObject.getAsJsonObject("author").get("avatar").getAsString());
        this.url = jsonObject.get("url").getAsString();
        this.message = jsonObject.get("message").getAsString();
        this.__typename = jsonObject.get("__typename").getAsString();
        this.comment_created_time = new Date(jsonObject.get("created_time").getAsLong()*1000);
    }

    private UserInfor author;
    private String message;
    private String url;
    private String __typename;
    private Date comment_created_time;
}
