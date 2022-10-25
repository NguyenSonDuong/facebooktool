package com.kit502.facebook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfor implements Serializable {
    private String id_user;
    private String gender;
    private String name;
    private String link;
    private String avatar_link;
    private String __typename;
}