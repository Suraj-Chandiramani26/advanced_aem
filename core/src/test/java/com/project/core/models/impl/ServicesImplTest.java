package com.project.core.models.impl;

import com.project.core.models.Services;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class ServicesImplTest {

    AemContext aemContext = new AemContext();
    Services services;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Services.json","/content");
    }

    @Test
    void getServicesTitle() {
        Resource json = aemContext.resourceResolver().getResource("/content/services");
        services = json.adaptTo(Services.class);
        assertNotNull("abcd",services.getServicesTitle());
    }

    @Test
    void getServicesdescription() {
        Resource json = aemContext.resourceResolver().getResource("/content/services");
        services = json.adaptTo(Services.class);
        assertEquals("efgh",services.getServicesdescription());
    }
}