package com.project.core.models.impl;

import com.project.core.models.FactArea;
import com.project.core.models.Testimonial;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class FactAreaImplTest {

    private AemContext aemContext = new AemContext();
    private FactArea factArea;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/FactArea.json","/content");
    }

    @Test
    void getFactDetailsWithMap() {
        Resource json = aemContext.resourceResolver().getResource("/content/factDetailsMap");
        //Resource json = aemContext.currentResource("/content/factDetailsMap");
        factArea = aemContext.request().adaptTo(FactArea.class);
        List<Map<String,String>> factDetailsWithMap = new ArrayList<>();
        assertNotNull(factArea.getFactDetailsWithMap());
    }
}