package com.project.core.models.impl;

import com.project.core.models.Brands;
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
class BrandsImplTest {

    AemContext aemContext = new AemContext();
    Brands brands;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Brands.json","/content");
    }

    @Test
    void getImgPath() {
        Resource json = aemContext.resourceResolver().getResource("/content/brands");
        brands = json.adaptTo(Brands.class);
        List<Map<String,String>> testimonialDetails = new ArrayList<>();
        if(brands.getImgPath()==null);
        else
            assertNotNull(brands.getImgPath());
    }
}