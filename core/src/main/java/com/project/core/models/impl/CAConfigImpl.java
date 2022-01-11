package com.project.core.models.impl;

import com.day.cq.wcm.api.Page;
import com.project.core.config.PersonalCAConfig;
import com.project.core.models.CAConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.caconfig.ConfigurationResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;


import javax.annotation.PostConstruct;

@Model(adaptables = {SlingHttpServletRequest.class},
        adapters = {CAConfig.class},
        resourceType = {CAConfigImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class CAConfigImpl implements CAConfig {
    protected static final String RESOURCE_TYPE = "project/components/content/card";

    @SlingObject
    ResourceResolver resourceResolver;

    @ScriptVariable
    Page currentPage;

    @OSGiService
    ConfigurationResolver configurationResolver;

    private String siteCountry;
    private String siteLocale;
    private String siteAdmin;
    private String siteSection;

    @Override
    public String getSiteCountry() {
        return siteCountry;
    }

    @Override
    public String getSiteLocale() {
        return siteLocale;
    }

    @Override
    public String getSiteAdmin() {
        return siteAdmin;
    }

    @Override
    public String getSiteSection() {
        return siteSection;
    }

    @PostConstruct
    public void postConstruct() {
        PersonalCAConfig caConfig = getContextAwareConfig(currentPage.getPath(), resourceResolver);
        siteCountry = caConfig.siteCountry();
        siteLocale = caConfig.siteLocale();
        siteAdmin = caConfig.siteAdmin();
        siteSection = caConfig.siteSection();

    }

    private PersonalCAConfig getContextAwareConfig(String currentPage, ResourceResolver resourceResolver) {
        String currentPath = StringUtils.isNotBlank(currentPage) ? currentPage : StringUtils.EMPTY;
        Resource contentResource = resourceResolver.getResource(currentPath);
        if (contentResource != null){
            ConfigurationBuilder configurationBuilder = contentResource.adaptTo(ConfigurationBuilder.class);
            if (configurationBuilder != null){
                return configurationBuilder.as(PersonalCAConfig.class);
            }
        }
        return null;
    }

}