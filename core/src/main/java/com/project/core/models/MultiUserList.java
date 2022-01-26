package com.project.core.models;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface MultiUserList {
    public List<Map<String,String>> getUssers() throws JSONException, IOException;
    public String getUrl(String initialPath);

}