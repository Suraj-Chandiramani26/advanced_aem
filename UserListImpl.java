package com.project.core.models.impl;

import com.project.core.models.UserList;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import javax.inject.Inject;
import javax.jcr.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.day.cq.search.result.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Model(adaptables = SlingHttpServletRequest.class,
        adapters = UserList.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class UserListImpl implements UserList {
    private static final Logger LOG = LoggerFactory.getLogger(UserListImpl.class);
    @Inject
    ResourceResolver resolver;

    @Inject
    QueryBuilder queryBuilder;

    @Override
    public String getUsers() {
        LOG.info("\n Printing LOGS from inside CLass");

        String listofusers = "";

        Map<String, String> map = new HashMap<>();
        map.put("path", "/home/users");
        map.put("property", "jcr:primaryType");
        map.put("property.value", "rep:User");
        map.put("p.hits", "selective");
        map.put("p.properties", "rep:principalName");
        map.put("type", "rep:User");

        try {

            Session session = resolver.adaptTo(Session.class);
            Query listQuery = queryBuilder.createQuery(PredicateGroup.create(map), session);
            SearchResult result = listQuery.getResult();
            List<Hit> Hits = result.getHits();
            for(Hit hit : Hits){
                listofusers = listofusers+ "\r\n" + hit.getProperties().get("rep:principalName", String.class);

            }

        }catch(Exception e){
            LOG.info("\n exception",e.getMessage());
        }
        return listofusers;
    }
}