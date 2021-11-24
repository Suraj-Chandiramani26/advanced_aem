package com.project.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "project/components/page"
)
public class ResourceServlet extends SlingSafeMethodsServlet {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(ResourceServlet.class);
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        final ResourceResolver resourceResolver = request.getResourceResolver();
        Page page = resourceResolver.adaptTo(PageManager.class).getPage("/content/project/us/en");
        List pagesList = new ArrayList();
        Iterator<Page> childPages = page.listChildren();
        while (childPages.hasNext()) {
            Page childPage = childPages.next();
            String pageName;
            pageName =childPage.getTitle();
            pagesList.add(pageName);
            LOG.info(pageName);
        }
/*
        response.setContentType("text/html");
        response.getWriter().print(pagesList);*/
    }
}