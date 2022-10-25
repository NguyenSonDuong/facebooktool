package com.kit502.facebook.service;

import com.google.gson.JsonObject;
import org.springframework.http.ResponseEntity;

public interface IFacebookCommentService {
    public ResponseEntity Create(JsonObject facebookComment);
    public ResponseEntity Read(JsonObject facebookComment);
    public ResponseEntity Update(JsonObject facebookComment);
    public ResponseEntity Delete(JsonObject facebookComment);
}
