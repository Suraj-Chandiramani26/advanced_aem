package com.project.core.models.impl;

import com.project.core.models.MenuNav;
import com.project.core.models.MenuNav;
import com.project.core.models.BlogTeaser;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class MenuNavImplTest {
    private final AemContext aemContext = new AemContext();
    private MenuNav menuNav;
    @BeforeEach
    void setUp() {
        aemContext.load().json("/MenuNav.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/menuNav");
        menuNav = aemContext.request().adaptTo(MenuNav.class);
        assertEquals("About Me", menuNav.getTitle());
    }

//    @Test
//    void getText() {
//        Resource json = aemContext.currentResource("/content/bannernav");
//        menuNav = json.adaptTo(MenuNav.class);
//        assertEquals("Home", menuNav.getText());
//    }
//
//    @Test
//    void getNavText() {
//        Resource json = aemContext.currentResource("/content/bannernav");
//        menuNav = json.adaptTo(MenuNav.class);
//        assertEquals("About", menuNav.getNavText());
//    }

    @Test
    void getPath() {
        Resource json = aemContext.currentResource("/content/menuNav");
        menuNav = aemContext.request().adaptTo(MenuNav.class);
        assertEquals("/content/project/us/en/home", menuNav.getPath());
    }
}