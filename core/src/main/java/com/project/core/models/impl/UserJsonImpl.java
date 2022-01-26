package com.project.core.models.impl;
import com.project.core.models.UserJson;
import com.project.core.services.SingleUserOsgi;
import com.project.core.utils.JSONLoaders;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = UserJson.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserJsonImpl implements UserJson {

    @OSGiService
    SingleUserOsgi singleUserOsgi;

    final Logger LOG = LoggerFactory.getLogger(UserJson.class);
    @Inject
    String url;

    @Override
    public String getUrl(String initialPath){
        return initialPath+url;
    }
    @Override
    public String getMessage() {

        return JSONLoaders.readJson(getUrl(singleUserOsgi.getUserLinkData()));    }

}