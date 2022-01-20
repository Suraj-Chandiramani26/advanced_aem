package com.project.core.utils;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.util.Map;

public class ResolverUtils {

    private ResolverUtils() {

    }
    public static final String SERVICE_USER = "project";

    public static ResourceResolver newResolver(ResourceResolverFactory resourceResolverFactory) throws LoginException {
        final Logger LOG = LoggerFactory.getLogger(ResolverUtils.class);
        final Map <String, Object > param = Collections.singletonMap(ResourceResolverFactory.SUBSERVICE,  SERVICE_USER);
        ResourceResolver resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);
        LOG.info("\n inside ResolverUtils");
        LOG.info("\n inside ResolverUtils");
        return resourceResolver;
    }
}