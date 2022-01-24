package com.project.core.models;

import org.json.JSONException;

import java.io.IOException;

public interface FetchingSingleUser {
    public String getMessage() throws JSONException, IOException;
    public String getUrl();
    public String getFname();
    public String getLname();
    public String getEmail();
    public String getAvatar();

}