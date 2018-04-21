package jmx.spring.config.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class ConfigExample {
    private static Logger LOGGER = Logger.getLogger(ConfigExample.class.getCanonicalName());

    private static final String MSG_INFO_LOGGING = "INFO LEVEL logging ..... test";
    private static final String MSG_SEVERE_LOGGING = "SEVERE LEVEL logging ..... test";
    private static final String MSG_MODIFIED_CONFIG = "Modified config content: %s";
    private static final String MSG_CURRENT_CONFIG = "Current config content: %s";
    private static final String MSG_STOPPED = "App stopped";

    private static final String CONFIG_SPRING_XML = "spring-config.xml";
    private static final String CONFIG_BEAN_NAME = "config";
    private static final int APP_PAUSE_MILLIS = 10000;

    public static void main(final String[] args) throws InterruptedException {
        final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_SPRING_XML);
        final Config config = context.getBean(Config.class, CONFIG_BEAN_NAME);

        LOGGER.info(String.format(MSG_CURRENT_CONFIG, config.toString()));
        String timeout = config.getTimeout();
        String poolSize = config.getPoolSize();
        while (!config.isStopApp()) {

            LOGGER.info(MSG_INFO_LOGGING);
            Thread.sleep(APP_PAUSE_MILLIS);
            LOGGER.severe(MSG_SEVERE_LOGGING);

            if (!timeout.equalsIgnoreCase(config.getTimeout())
                    || !poolSize.equalsIgnoreCase(config.getPoolSize())) {
                LOGGER.info(String.format(MSG_MODIFIED_CONFIG, config.toString()));
                timeout = config.getTimeout();
                poolSize = config.getPoolSize();
            }
        }

        context.close();
        System.out.println(MSG_STOPPED);
    }
}
