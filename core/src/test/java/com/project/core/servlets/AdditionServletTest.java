package com.project.core.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class AdditionServletTest {

    @Mock
    private AdditionServlet additionServlet = new AdditionServlet();

    @BeforeEach
    void setUp() {

    }

    @Test
    void doGet(AemContext aemContext) throws ServletException, IOException {
        MockSlingHttpServletRequest request = aemContext.request();
        MockSlingHttpServletResponse response = aemContext.response();
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("num1", 11);
        parameterMap.put("num2", 11);
        request.setParameterMap(parameterMap);
        additionServlet.doGet(request, response);
        assertEquals(22,Integer.parseInt(response.getOutputAsString()));
    }
}