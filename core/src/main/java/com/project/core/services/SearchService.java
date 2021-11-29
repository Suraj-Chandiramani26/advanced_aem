package com.project.core.services;
import org.json.JSONObject;

public interface SearchService {
    public JSONObject searchResult(String searchText,int startResult,int resultPerPage);
}
