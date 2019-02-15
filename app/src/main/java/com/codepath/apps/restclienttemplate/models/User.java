package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class User {

    public String name;
    public long uid;
    public String screenName;
    public String profileImageURL;
    public String userName;
    public String createdAt;

    // empty constructor needed by the Parceler library
    public User() {
    }

    public static User from(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.name = jsonObject.getString("name");
        user.uid = jsonObject.getLong("id");
        user.screenName = jsonObject.getString("screen_name");
        user.userName = jsonObject.getString("name");
        user.profileImageURL = jsonObject.getString("profile_image_url_https");
        return user;
    }
}
