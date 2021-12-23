package com.project.core.models.impl;
import com.project.core.models.OSGIConfigDemo;
import com.project.core.services.OSGIConfig;
//import com.project.core.models.ServiceDemo;
//import com.project.core.services.OSGiConfigModule;
//import com.project.core.services.OSGiFactoryConfig;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import java.util.List;
@Model(adaptables = SlingHttpServletRequest.class,
        adapters = OSGIConfigDemo.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class OSGIConfigDemoImpl implements OSGIConfigDemo{

    @OSGiService
    OSGIConfig oSGiConfig;

    @Override
    public String getServiceName() {
        return oSGiConfig.getServiceName();
    }

    @Override
    public int getServiceCount() {
        return oSGiConfig.getServiceCount();
    }

    @Override
    public boolean isLiveData() {
        return oSGiConfig.isLiveData();
    }

    @Override
    public String[] getCountries() {
        return oSGiConfig.getCountries();
    }

    @Override
    public String getRunModes() {
        return oSGiConfig.getRunModes();
    }

}

