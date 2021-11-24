package com.project.core.models.impl;

import com.adobe.cq.wcm.core.components.models.Page;
import com.project.core.models.ServiceDemo;
import org.apache.jackrabbit.api.security.user.QueryBuilder;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import java.util.Iterator;

@Model(adaptables = Resource.class,
        adapters = ServiceDemo.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ServiceDemoImpl implements ServiceDemo {

    @Override
    public QueryBuilder getUser() {
        return null;
    }
}
