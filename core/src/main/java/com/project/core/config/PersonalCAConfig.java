package com.project.core.config;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(label="Personal - Context aware configuration", description = "Context aware configuration for personal project")
public @interface PersonalCAConfig {

    @Property(label = "Personal Country Site",
                description = "Personal Site Name")
    String siteCountry() default "us";

    @Property(label = "Personal Site Locale",
            description = "Personal Site Name for Different Languages")
    String siteLocale() default "en";

    @Property(label = "Personal Site Admin",
            description = "Admin for updating the country site")
    String siteAdmin() default "personal-project";

    @Property(label = "Site Section",
            description = "Site Section for personal site")
    String siteSection() default "personal";
}
