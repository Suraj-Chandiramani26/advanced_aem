package com.project.core.models.impl;

import com.project.core.models.TitleText;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

@Model(
        adaptables = Resource.class,
        adapters = TitleText.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TitleTextImpl implements TitleText{

    @Inject
    String title;

    @Inject
    String info;

    @ValueMapValue
    Boolean paddingbottom;

    @ValueMapValue
    Boolean sectiongap;

    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public String getInfo(){
        return info;
    }

    @Override
    public Boolean getSectionGap(){
        return sectiongap;
    }

    @Override
    public Boolean getPaddingBottom(){
        return paddingbottom;
    }
}
