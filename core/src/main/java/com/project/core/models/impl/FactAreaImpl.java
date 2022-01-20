package com.project.core.models.impl;

import com.project.core.models.FactArea;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = FactArea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class FactAreaImpl implements FactArea{

    private static final Logger LOG = LoggerFactory.getLogger(FactAreaImpl.class);

    @ChildResource
    Resource factdetailswithmap;

    @Override
    public List<Map<String, String>> getFactDetailsWithMap() {
        List<Map<String, String>> factDetailsMap=new ArrayList<>();
        try {
            if(factdetailswithmap!=null){
                for (Resource fact : factdetailswithmap.getChildren()) {
                    Map<String,String> factMap=new HashMap<>();
                    factMap.put("factnumber",fact.getValueMap().get("factnumber",String.class));
                    factMap.put("factlabel",fact.getValueMap().get("factlabel",String.class));
                    factDetailsMap.add(factMap);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Fact Details {} ",e.getMessage());
        }
        LOG.info("\n SIZE {} ",factDetailsMap.size());
        return factDetailsMap;
    }
}