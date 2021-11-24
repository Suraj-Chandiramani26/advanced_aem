package com.project.core.models.impl;

import com.project.core.models.MenuNav;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
@Model(adaptables = SlingHttpServletRequest.class,
        adapters = MenuNav.class,
        //resourceType = HomeBannerImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class MenuNavImpl implements MenuNav {
        private static final Logger LOG = LoggerFactory.getLogger(MenuNavImpl.class);
        //final protected static String RESOURCE_TYPE="personalproject/components/content/menunav";

        @ValueMapValue
        private String title;

        @ValueMapValue
        private String path;

        @Override
        public String getTitle() {
                return title;
        }

        @Override
        public String getPath() {
                return path;
        }
}