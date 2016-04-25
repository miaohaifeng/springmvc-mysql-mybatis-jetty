package com.madhoue.dsp.uadata;

import com.google.common.util.concurrent.AbstractIdleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class Bootstrap extends AbstractIdleService {

    private final static Logger log = LoggerFactory.getLogger(Bootstrap.class);

    private ClassPathXmlApplicationContext context;

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.startAsync();
        try {
            Object lock = new Object();
            synchronized (lock) {
                while (true) {
                    lock.wait();
                }
            }
        } catch (InterruptedException ex) {
            log.error("ignore interruption");
        }
    }

    /**
     * Start the service.
     */
    @Override
    protected void startUp() throws Exception {
        String profile = System.getProperty("spring.active.profile");
        String activeProfile = "dev";
        if (!StringUtils.isEmpty(profile)) {
            activeProfile = profile;
        }
        System.setProperty("spring.profiles.active", activeProfile);
        context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/spring-mvc.xml"});
        context.getEnvironment().setActiveProfiles(activeProfile);
        context.start();
        context.registerShutdownHook();
        log.info(">> spring active profile is {}", activeProfile);
        log.info(">> service started successfully");
        System.out.println(">> service started successfully");
    }

    /**
     * Stop the service.
     */
    @Override
    protected void shutDown() throws Exception {
        context.stop();
        log.info(">> service stopped successfully");
    }
}
