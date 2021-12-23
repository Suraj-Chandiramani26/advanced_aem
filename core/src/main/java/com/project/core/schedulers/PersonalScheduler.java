package com.project.core.schedulers;

import com.project.core.config.SchedulerConfiguration;
import com.project.core.services.DateUpdate;
//import com.project.core.services.impl.DateUpdateImpl;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service = Runnable.class)
@Designate(ocd = SchedulerConfiguration.class)
public class PersonalScheduler implements Runnable {
    //private static final Logger LOG = LoggerFactory.getLogger(PersonalScheduler.class);

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    @Reference
    DateUpdate dateUpdate;

    private int schedulerId;


    @Reference
    private Scheduler scheduler;

    @Activate
    protected void activate(SchedulerConfiguration config) {
        schedulerId = config.schedulerName().hashCode();
        addScheduler(config);
    }

    @Deactivate
    protected void deactivate(SchedulerConfiguration config) {
        removeScheduler();
    }

    private void removeScheduler() {
        scheduler.unschedule(String.valueOf(schedulerId));
    }

    private void addScheduler(SchedulerConfiguration config) {
        ScheduleOptions scheduleOptions = scheduler.EXPR(config.cronExpression());
        scheduleOptions.name(String.valueOf(schedulerId));
        scheduleOptions.canRunConcurrently(true);
        scheduler.schedule(this, scheduleOptions);

        //LOG.info("\n ---------Scheduler added----------");
        /*ScheduleOptions scheduleOptionsNow = scheduler.NOW(1,5);
        scheduler.schedule(this, scheduleOptionsNow);*/
    }
    @Override
    public void run() {
        /*LOG.info("\n  RUN METHOD  ");
        try {
            Map<String,Object> param = new HashMap<>();
            param.put(ResourceResolverFactory.SUBSERVICE,"readService");

            ResourceResolver resourceResolver;
            resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);
            LOG.info("Inside RUN LOG "+Calendar.getInstance().toString());
            Resource resource = resourceResolver.getResource("/content/project/us/en/blde/jcr:content/root/container/container/schedulerdemo");
            assert resource != null;
            Node schedulerDemo = resource.adaptTo(Node.class);

            assert schedulerDemo != null;
            Property property = schedulerDemo.setProperty("time",Calendar.getInstance().toString());
            LOG.error(property.getString());
            Session session = resourceResolver.adaptTo(Session.class);
            assert session != null;
            session.save();
            session.logout();
        } catch (RepositoryException | LoginException  | NullPointerException e) {
            e.printStackTrace();
        }*/

        //LOG.info("Time has changed");
        dateUpdate.updateDate();

    }
}
