package com.project.core.models.impl;

import com.project.core.models.CAConfig;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class CAConfigImplTest {

    AemContext aemContext = new AemContext();
    CAConfig caConfig;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/CAConfig.json","/content");
    }

    @Test
    void getSiteCountry() {
//        Resource json = aemContext.currentResource("/content/card");
//       // Resource json = aemContext.resourceResolver().getResource("/content/card");
//        caConfig = aemContext.request().adaptTo(CAConfig.class);
//        assertEquals("us",caConfig.getSiteCountry());
    }

    @Test
    void getSiteLocale() {
//        Resource json = aemContext.resourceResolver().getResource("/content/card");
//        caConfig = json.adaptTo(CAConfig.class);
//        assertEquals("es",caConfig.getSiteLocale());
    }
}