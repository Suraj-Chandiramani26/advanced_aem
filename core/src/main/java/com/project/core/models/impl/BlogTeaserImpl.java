package com.project.core.models.impl;

import com.project.core.models.BlogTeaser;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,adapters = BlogTeaser.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BlogTeaserImpl implements BlogTeaser{

    @Inject
    String img;

    @Inject
    String title;

    @Inject
    String info;

    @Override
    public String getImage() {
        return img;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getInfo() {
        return info;
    }
}