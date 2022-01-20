package com.project.core.models.impl;

import com.project.core.models.MenuNav;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = MenuNav.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class MenuNavImpl implements MenuNav {

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