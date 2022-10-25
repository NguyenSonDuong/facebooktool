package com.kit502.facebook.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FirebaseService {
    private static final String TOKEN_GOOGLE_FILE = "kit502-e615e16fa91f.json";
    private static final String DATABASE_URL = "https://kit502-default-rtdb.firebaseio.com";

    public static final String COLLECTION_PAYMENT_NAME = "facebookcomment";
    public static boolean Init(){
        FirebaseOptions options = null;
        try {
            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(HelpService.getResourceFileAsInputStream("kit502-e615e16fa91f.json")))
                    .setDatabaseUrl("https://kit502-default-rtdb.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);
            return true;
        } catch (IOException e) {
            HelpService.Logger("Init",e.getMessage());
            return false;
        }
    }

    public static boolean Create(String collection,Object obj){
        Firestore firestore = FirestoreClient.getFirestore();
        try {
            firestore.collection(collection)
                    .document()
                    .create(obj);
            return true;
        } catch (Exception e) {
            HelpService.Logger("Create",e.getMessage());
            return false;
        }
    }
    public static boolean Create(String collection,String id,Object obj){
        Firestore firestore = FirestoreClient.getFirestore();
        try {
            System.out.println(id);
            firestore.collection(collection).document(id).create(obj);
            return true;
        } catch (Exception e) {
            HelpService.Logger("Create",e.getMessage());
            return false;
        }
    }
    public static Map<String, Object> Read(String collection, String docment_id){
        Firestore firestore = FirestoreClient.getFirestore();
        try {
            return firestore.collection(collection)
                    .document(docment_id).get().get().getData();
        } catch (Exception e) {
            HelpService.Logger("Create",e.getMessage());
            return null;
        }
    }

    public static Map<String, Object> ReadAll(String collection){
        Firestore firestore = FirestoreClient.getFirestore();
        Map<String, Object> map_data = new HashMap<>();
        try {
            firestore.collection(collection).listDocuments().forEach((documentReference -> {
                try {
                    map_data.put(
                            documentReference.getId(),
                            documentReference.get().get().getData());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }));
            return map_data;
        } catch (Exception e) {
            HelpService.Logger("Create",e.getMessage());
            return null;
        }
    }
    public static QuerySnapshot Search(String collection){
        Firestore firestore = FirestoreClient.getFirestore();
        try {
            return firestore.collection(collection).get().get();
        } catch (Exception e) {
            HelpService.Logger("Create",e.getMessage());
            return null;
        }
    }
    public static boolean Update(){
        return true;
    }

}
