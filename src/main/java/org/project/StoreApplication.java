package org.project;

import org.project.business.RandomDataService;
import org.project.business.ReloadDataService;
import org.project.infrastructure.configuration.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StoreApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        ReloadDataService reloadDataService = applicationContext.getBean(ReloadDataService.class);
        reloadDataService.loadRandomData();
    }
}
