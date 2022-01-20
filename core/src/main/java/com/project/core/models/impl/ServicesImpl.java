package com.project.core.models.impl;

import com.project.core.models.Services;
import org.apache.sling.api.resource.Resource;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;


@Model(
        adaptables = Resource.class,
        adapters = Services.class,
//resourceType =HomeAbout.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ServicesImpl implements Services {


    @Inject
    String servicestitle;

    @Inject
    String servicesdescription;

    @Override
    public String getServicesTitle(){
        return servicestitle;
    }

    @Override
    public String getServicesdescription(){
        return servicesdescription;
    }

}
