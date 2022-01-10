package com.project.core.servlets;

import com.adobe.cq.commerce.common.ValueMapDecorator;
import com.adobe.granite.ui.components.Field;
import com.adobe.granite.ui.components.ds.DataSource;
import com.adobe.granite.ui.components.ds.SimpleDataSource;
import com.adobe.granite.ui.components.ds.ValueMapResource;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component(

        service = Servlet.class,
        property = {
                "sling.servlet.resourceTypes=" + "/apps/dropdown3"
        })
public class dropDownDemo extends SlingSafeMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        ResourceResolver resourceResolver = request.getResourceResolver();
        ValueMap fieldProps = (ValueMap) request.getAttribute(Field.class.getName());
        String[] fieldVal = fieldProps.get("value", new String[0]);
        String value = "";
        if (fieldVal.length > 0) {
            value = fieldVal[0];
        }

        ValueMap vm = new ValueMapDecorator(new java.util.HashMap<String, Object>());
        vm.put("value", value);
        List<Resource> resourceList = new ArrayList<Resource>();
        resourceList.add(new ValueMapResource(resourceResolver, new ResourceMetadata(), "nt:unstructured", vm));
        request.setAttribute(DataSource.class.getName(), new SimpleDataSource(resourceList.iterator()));
    }

}