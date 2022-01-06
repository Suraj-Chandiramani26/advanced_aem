package com.project.core.models.impl;

import com.project.core.models.Footer;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class FooterImplTest {

    AemContext aemContext = new AemContext();
    Footer footer;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Footer.json","/content");
    }

    @Test
    void getHeading1() {
        Resource json = aemContext.resourceResolver().getResource("/content/footer");
        footer = json.adaptTo(Footer.class);
        assertEquals("A",footer.getHeading1());
    }

    @Test
    void getHeading2() {
        Resource json = aemContext.resourceResolver().getResource("/content/footer");
        footer = json.adaptTo(Footer.class);
        assertEquals("A",footer.getHeading2());
    }

    @Test
    void getHeading3() {
        Resource json = aemContext.resourceResolver().getResource("/content/footer");
        footer = json.adaptTo(Footer.class);
        assertEquals("A",footer.getHeading3());
    }

    @Test
    void getText1() {
        Resource json = aemContext.resourceResolver().getResource("/content/footer");
        footer = json.adaptTo(Footer.class);
        assertEquals("A",footer.getText1());
    }

    @Test
    void getText2() {
        Resource json = aemContext.resourceResolver().getResource("/content/footer");
        footer = json.adaptTo(Footer.class);
        assertEquals("A",footer.getText2());
    }

    @Test
    void getText3() {
        Resource json = aemContext.resourceResolver().getResource("/content/footer");
        footer =  json.adaptTo(Footer.class);
        assertEquals("A",footer.getText3());
    }
}