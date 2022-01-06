package com.project.core.models.impl;

import com.project.core.models.PortfolioTeaser;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class PortfolioTeaserImplTest {

    AemContext aemContext = new AemContext();
    PortfolioTeaser portfolioTeaser;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Portfolio.json","/content");
    }

    @Test
    void getImage() {
        Resource json = aemContext.resourceResolver().getResource("/content/portfolio");
        portfolioTeaser = json.adaptTo(PortfolioTeaser.class);
        assertEquals("A",portfolioTeaser.getImage());
    }

    @Test
    void getTitle() {
        Resource json = aemContext.resourceResolver().getResource("/content/portfolio");
        portfolioTeaser = json.adaptTo(PortfolioTeaser.class);
        assertEquals("B",portfolioTeaser.getTitle());
    }

    @Test
    void getInfo() {
        Resource json = aemContext.resourceResolver().getResource("/content/portfolio");
        portfolioTeaser = json.adaptTo(PortfolioTeaser.class);
        assertEquals("C",portfolioTeaser.getInfo());
    }
}