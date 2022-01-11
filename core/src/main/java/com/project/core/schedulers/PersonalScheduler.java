package com.project.core.schedulers;

import com.project.core.config.SchedulerConfiguration;
import com.project.core.services.DateUpdate;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;

@Component(immediate = true, service = Runnable.class)
@Designate(ocd = SchedulerConfiguration.class)
public class PersonalScheduler implements Runnable {

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    @Reference
    DateUpdate dateUpdate;

    private int schedulerId;

    String path = "/content/project/us/en/blde/jcr:content/root/container/container/schedulerdemo";

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
    }
    @Override
    public void run() {
        dateUpdate.updateDate(path);
    }
}
