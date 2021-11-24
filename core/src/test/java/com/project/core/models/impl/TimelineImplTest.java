package com.project.core.models.impl;

import com.project.core.models.Timeline;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TimelineImplTest {

    private final AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);
    private Timeline timeline = new TimelineImpl();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Timeline.json","/content");
    }

    @Test
    void getTimelineDetailsWithMap() {
        Resource json = aemContext.currentResource("/content");
        //List<Map<String,String>> timelinedetails = new ArrayList<>();
        assertNotNull(timeline.getTimelineDetailsWithMap());
    }
}