package com.project.core.models.impl;

import com.project.core.models.BlogTeaser;
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
class BlogTeaserImplTest {

    AemContext aemContext = new AemContext();
    BlogTeaser blogTeaser;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Blog.json","/content");
    }

    @Test
    void getImage() {
        Resource json = aemContext.resourceResolver().getResource("/content/blog");
        blogTeaser = json.adaptTo(BlogTeaser.class);
        assertEquals("/content/dam/project/p1.jpg",blogTeaser.getImage());
    }

    @Test
    void getTitle() {
        Resource json = aemContext.resourceResolver().getResource("/content/blog");
        blogTeaser = json.adaptTo(BlogTeaser.class);
        assertEquals("a",blogTeaser.getTitle());
    }

    @Test
    void getInfo() {
        Resource json = aemContext.resourceResolver().getResource("/content/blog");
        blogTeaser = json.adaptTo(BlogTeaser.class);
        assertEquals("b",blogTeaser.getInfo());
    }
}