package com.project.core.services.impl;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.project.core.services.UserNameService;
import com.project.core.utils.ResolverUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(service = UserNameService.class,immediate = true)
public class UserNameServiceImpl implements UserNameService {
    private static final Logger LOG = LoggerFactory.getLogger(UserNameServiceImpl.class);

    @Activate
    public void activate(){
        LOG.info("\n ==============INSIDE ACTIVATE================");
    }

    @PostConstruct
    protected void init(){
        LOG.info("\n printing logs");
    }

    @SlingObject
    ResourceResolver resourceResolver;

    @Inject
    ResourceResolverFactory resourceResolverFactory;

    @Inject
    QueryBuilder queryBuilder;

    String user="";

    @Override
    public String getUsernames() {
        LOG.info("\n Inside Getusername of service ");
        List<String> usernames = new ArrayList<>();
        Map<String, String> userMap = new HashMap<>();
        userMap.put("p.hits", "selective");
        userMap.put("p.limit", "-1");
        userMap.put("property", "jcr:primaryType");
        userMap.put("property.value", "rep:User");
        userMap.put("path", "/home/users");
        userMap.put("type", "rep:User");
        userMap.put("p.properties", "rep:principalName");
        try{
            LOG.info("\n Inside Try..");
            ResourceResolver serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory);
            LOG.info("\n resolver hit "+serviceResourceResolver.getUserID());
            Session session = serviceResourceResolver.adaptTo(Session.class);
            LOG.info("\n Result "+session.getUserID());
            Query userQuery = queryBuilder.createQuery(PredicateGroup.create(userMap), session);
            LOG.info("Query "+userQuery);
            SearchResult result = userQuery.getResult();
            LOG.info("Result "+result);
            List<Hit> Hits = result.getHits();
            for (Hit hit : Hits) {
                LOG.info("Hitsssss"+hit);
                //usernames.add((String) hit.getProperties().get("rep:principalName"));
                //Resource hitresults = hit.getResource();
                //usernames.add(hitresults.getName());
                user = user + "\r\n" + hit.getProperties().get("rep:principalName", String.class);
                System.out.println(user);
            }
        } catch (LoginException | RepositoryException e) {
            LOG.info("Service User ERROR",e.getMessage());
        }
        return user;
    }
}