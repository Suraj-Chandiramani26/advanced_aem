package com.project.core.models.impl;

import com.project.core.models.HomeBanner;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
    @Model(
            adaptables = Resource.class,
            adapters = HomeBanner.class,
            defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
    )
    public class HomeBannerImpl implements HomeBanner {
        @Inject
        String bio;

        @Inject
        String fullName;

        @Inject
        String intro;

        @Inject
        String button;


        @ValueMapValue
        String fileReference;

        @Inject
        String path;

        @Override
        public String getBio() {
            return bio;
        }

        @Override
        public String getFullName() {
            return fullName;
        }

        @Override
        public String getIntro() {
            return intro;
        }

        @Override
        public String getButton() {
            return button;
        }

        @Override
        public String getPath(){
            return path;
        }

        @Override
        public String getImage() {
            return fileReference;
        }
    }