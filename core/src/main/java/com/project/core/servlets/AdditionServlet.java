package com.project.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)

@SlingServletPaths(value = "/bin/pages")
public class AdditionServlet extends SlingAllMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        int int1 = Integer.parseInt(request.getParameter("num1"));
        int int2 = Integer.parseInt(request.getParameter("num2"));
        int num3=int1+int2;
        response.getWriter().print(num3);
    }
}
