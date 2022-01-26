package com.project.core.models.impl;

import com.project.core.models.MultiUserList;
import com.project.core.services.MultipleUserOsgi;
import com.project.core.utils.JSONLoaders;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;

@Model(adaptables = Resource.class,adapters = MultiUserList.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultipleUserListImpl implements MultiUserList{

    private static final Logger log = (Logger) LoggerFactory.getLogger(MultipleUserListImpl.class);

    @Inject
    String url;

    @Override
    public List<Map<String, String>> getUssers() throws JSONException, IOException {
        String response = JSONLoaders.readJson(getUrl("https://reqres.in/api/users?page="));
        JSONObject jsonObject =  new JSONObject(response);

        log.info(String.valueOf(jsonObject));

        JSONArray jsonArray1 = jsonObject.getJSONArray("data");
        log.info("==============="+jsonArray1);
        log.info("==============="+jsonArray1.length());

        List<Map<String, String>> userList = new ArrayList<>();
        for (int i=0;i<jsonArray1.length();i++){
            Map<String,String> user =new HashMap<>();
            user.put("fname",jsonArray1.getJSONObject(i).getString("first_name"));
            user.put("lname",jsonArray1.getJSONObject(i).getString("last_name"));
            user.put("email",jsonArray1.getJSONObject(i).getString("email"));
            user.put("avatar",jsonArray1.getJSONObject(i).getString("avatar"));
            userList.add(user);
        }
        log.info("===list===\n"+userList);
        return userList;
    }

    @Override
    public String getUrl(String initialPath) {
        return initialPath +url;
    }
}