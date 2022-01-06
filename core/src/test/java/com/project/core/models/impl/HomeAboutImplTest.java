package com.project.core.models.impl;

import com.project.core.models.HomeAbout;
import com.project.core.models.HomeBanner;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class HomeAboutImplTest {

    private final AemContext aemContext = new AemContext();
    private HomeAbout homeAbout = new HomeAboutImpl();

    @BeforeEach
    void setUp() {
        //Resource json = aemContext.load().json("/HomeAbout.json","/content");
        Resource json = aemContext.load().json("/HomeAbout.json","/content");
    }

    @Test
    void getBio() {
        Resource json = aemContext.resourceResolver().getResource("/content/homeabout");
        homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("About Me", homeAbout.getBio());
    }

    @Test
    void getDetails() {
        Resource json = aemContext.resourceResolver().getResource("/content/homeabout");
        homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("PERSONAL DETAILS",homeAbout.getDetails());
    }

    @Test
    void getIntro() {
        Resource json = aemContext.resourceResolver().getResource("/content/homeabout");
        homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("Here, I focus on a range of items and features that we use in life without giving them a second thought. such as Coca Cola. Dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.", homeAbout.getIntro());
    }

    @Test
    void getButton() {
        Resource json = aemContext.resourceResolver().getResource("/content/homeabout");
        homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("View Full Details", homeAbout.getButton());
    }

    @Test
    void getImage() {
        Resource json = aemContext.currentResource("/content/homeabout");
        homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("/content/dam/project/about-img.png", homeAbout.getImage());
    }

    @Test
    void getPath() {
        Resource json = aemContext.resourceResolver().getResource("/content/homeabout");
        homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("/content/project/us/en/about", homeAbout.getPath());
    }
}