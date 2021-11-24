package com.project.core.models.impl;

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
class TestimonialImplTest {

    private AemContext aemContext = new AemContext();
    private Testimonial testimonial;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Testimonial.json","/content");
    }

    @Test
    void getTestimonialDetailsWithMap() {
        Resource json = aemContext.resourceResolver().getResource("/content/testimonial");
        testimonial = json.adaptTo(Testimonial.class);
        List<Map<String,String>> testimonialDetails = new ArrayList<>();
        assertNotNull(testimonial.getTestimonialDetailsWithMap());
        //assertEquals("Associate Software Engineer",testimonial.getTestimonialDetailsWithMap().get(1));
    }

}