package com.project.core.services.impl;

import com.day.cq.commons.date.DateUtil;
import com.project.core.config.SchedulerConfiguration;
import com.project.core.services.DateUpdate;
import com.project.core.utils.ResolverUtils;
import org.apache.sling.api.resource.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.Logger;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.LoggerFactory;

import javax.jcr.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component(immediate = true,service = DateUpdate.class)
@Designate(ocd = SchedulerConfiguration.class)
public class DateUpdateImpl implements DateUpdate{


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    Date d = new Date();
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());


    //private static final Logger LOG = (Logger) LoggerFactory.getLogger(DateUpdateImpl.class);

    @Reference
    ResourceResolverFactory resourceResolverFactory;


    @Override
    public void updateDate() {
        try{
            ResourceResolver serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory);
            Session session = serviceResourceResolver.adaptTo(Session.class);
            Resource resource = serviceResourceResolver.getResource("/content/project/us/en/blde/jcr:content/root/container/container/schedulerdemo");
            Node node = resource.adaptTo(Node.class);

            node.setProperty("time" , DateUtil.parseISO8601(DateUtil.getISO8601Date(new Date())));


            session.save();
            session.logout();
        } catch (Exception e) {

        }
    }
}
