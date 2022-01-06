package com.project.core.models.impl;

import com.project.core.models.TitleText;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TitleTextImplTest {

    private final AemContext aemContext = new AemContext();
    TitleText titleText;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/TitleText.json","/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.resourceResolver().getResource("/content/titletext");
        titleText = json.adaptTo(TitleText.class);
        assertEquals("qwertyuio", titleText.getTitle());
    }

    @Test
    void getInfo() {
        Resource json = aemContext.resourceResolver().getResource("/content/titletext");
        titleText = json.adaptTo(TitleText.class);
        assertEquals("asdfghjkl", titleText.getInfo());
    }

    @Test
    void getSectionGap() {
        Resource json = aemContext.resourceResolver().getResource("/content/titletext");
        titleText = json.adaptTo(TitleText.class);
        assertEquals(true ,titleText.getSectionGap());
    }

    @Test
    void getPaddingBottom() {
        //Resource resource = aemContext.currentResource("/content/titletext");
        Resource json = aemContext.resourceResolver().getResource("/content/titletext");
        titleText = json.adaptTo(TitleText.class);
        assertEquals(true, titleText.getPaddingBottom());
    }
}