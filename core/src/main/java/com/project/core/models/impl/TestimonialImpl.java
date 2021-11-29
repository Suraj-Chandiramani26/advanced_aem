package com.project.core.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.core.models.Testimonial;
import com.project.core.models.TitleText;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Model(
        adaptables = Resource.class,
        adapters = Testimonial.class,
        resourceType =TestimonialImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

@Exporter(name = "jackson",extensions = "json",selector = "testimonial")
public class TestimonialImpl implements Testimonial {
    private static final Logger LOG = LoggerFactory.getLogger(TestimonialImpl.class);
    final protected static String RESOURCE_TYPE="/apps/project/components/content/testimonial";

    @ChildResource
    Resource testimonialdetailswithmap;

    @Override
    public List<Map<String, String>> getTestimonialDetailsWithMap() {
        List<Map<String, String>> testimonialDetailsMap=new ArrayList<>();
        try {
          //  Resource testimonialDetail=componentResource.getChild("testimonialdetailswithmap");
            if(testimonialdetailswithmap!=null){
                for (Resource testimonial : testimonialdetailswithmap.getChildren()) {
                    Map<String,String> testimonialMap =new HashMap<>();
                    testimonialMap.put("title",testimonial.getValueMap().get("title",String.class));
                    testimonialMap.put("heading",testimonial.getValueMap().get("heading",String.class));
                    testimonialMap.put("description",testimonial.getValueMap().get("description",String.class));
                    testimonialDetailsMap.add(testimonialMap);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Fact Details {} ",e.getMessage());
        }
        LOG.info("\n SIZE {} ",testimonialDetailsMap.size());
        return testimonialDetailsMap;
    }

    @JsonProperty(value = "Author-Name")
    public String authorName(){
       return "Something";
    }

}
