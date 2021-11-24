package com.project.core.models.impl;

import com.project.core.models.HomeBanner;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class HomeBannerImplTest {

    private final AemContext aemContext = new AemContext();
    private HomeBanner homeBanner;
    @BeforeEach
    void setUp() {
        Resource json = aemContext.load().json("/HomeBanner.json","/content");
    }

    @Test
    void getBio() {
        /*
        //        aemContext.resourceResolver().getResource("/content");
        Resource json = aemContext.resourceResolver().getResource("/content");
        homeBanner = json.adaptTo(HomeBanner.class);
        final String e = "This is Me";
        String a = homeBanner.getBio();
        assertEquals(e,a);*/

        Resource json = aemContext.resourceResolver().getResource("/content/homebanner");
        homeBanner = json.adaptTo(HomeBanner.class);
        assertEquals("This is Me", homeBanner.getBio());
    }

    @Test
    void getFullName() {
        Resource json = aemContext.resourceResolver().getResource("/content/homebanner");
        homeBanner = json.adaptTo(HomeBanner.class);
        assertEquals("PHILIP GILBERT", homeBanner.getFullName());
    }

    @Test
    void getIntro() {
        Resource json = aemContext.resourceResolver().getResource("/content/homebanner");
        homeBanner = json.adaptTo(HomeBanner.class);
        assertEquals("You will begin to realise why this exercise is called the Dickens Pattern with reference to the ghost showing Scrooge some different futures.", homeBanner.getIntro());
    }

    @Test
    void getButton() {
        Resource json = aemContext.resourceResolver().getResource("/content/homebanner");
        homeBanner = json.adaptTo(HomeBanner.class);
        assertEquals("Discover Now", homeBanner.getButton());
    }

    @Test
    void getPath() {
        Resource json = aemContext.resourceResolver().getResource("/content/homebanner");
        homeBanner = json.adaptTo(HomeBanner.class);
        assertEquals("/content/project/us/en/about", homeBanner.getPath());
    }

    @Test
    void getImage() {
        Resource json = aemContext.resourceResolver().getResource("/content/homebanner");
        homeBanner = json.adaptTo(HomeBanner.class);
        assertEquals("/content/dam/project/hero-img.png", homeBanner.getImage());
    }
}