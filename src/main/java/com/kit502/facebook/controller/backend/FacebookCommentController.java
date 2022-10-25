package com.kit502.facebook.controller.backend;

import com.google.gson.JsonObject;
import com.kit502.facebook.IController;
import com.kit502.facebook.service.FacebookCommentService;
import com.kit502.facebook.service.PaymentHistoryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/facebook-comment")
public class FacebookCommentController implements IController {

    public FacebookCommentService facebookCommentService;

    public FacebookCommentController() {
        this.facebookCommentService = new FacebookCommentService();
    }

    @Override
    public ResponseEntity Create(JsonObject obj) {
        return facebookCommentService.Create(obj);
    }

    @Override
    public ResponseEntity Read(JsonObject obj) {
        return facebookCommentService.Read(obj);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity Read(@PathVariable String id){
        return facebookCommentService.Read(id);
    }

    @RequestMapping(value = "/comment/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity Read(@RequestParam String id_group, @RequestParam String id_post){
        return facebookCommentService.Read(id_group,id_post);
    }

    @Override
    public ResponseEntity Update(JsonObject obj) {
        return facebookCommentService.Update(obj);
    }

    @Override
    public ResponseEntity Delete(JsonObject obj) {
        return facebookCommentService.Delete(obj);
    }
}
