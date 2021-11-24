package com.project.core.models.impl;

import com.project.core.models.Footer;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
@Model(adaptables = Resource.class,
        adapters = Footer.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class FooterImpl implements Footer{

        @Inject
        String heading1;
        @Inject
        String heading2;
        @Inject
        String heading3;
        @Inject
        String text1;
        @Inject
        String text2;
        @Inject
        String text3;


        @Override
        public String getHeading1() {
            return heading1;
        }

        @Override
        public String getHeading2() {
            return heading2;
        }

        @Override
        public String getHeading3() {
            return heading3;
        }

        @Override
        public String getText1() {
            return text1;
        }

        @Override
        public String getText2() {
            return text2;
        }

        @Override
        public String getText3() {
            return text3;
        }
    }
