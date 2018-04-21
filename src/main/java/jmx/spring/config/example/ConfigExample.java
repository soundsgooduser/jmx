package jmx.spring.config.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigExample {
    private static final String SPRING_CONFIG_XML = "spring-config.xml";
    private static final String CONFIG_BEAN_NAME = "config";
    private static final int PAUSE_MILLIS = 10000;

    public static void main(final String[] args) throws InterruptedException {
        final ConfigurableApplicationContext beanFactory = new ClassPathXmlApplicationContext(SPRING_CONFIG_XML);
        final Config config = (Config) beanFactory.getBean(CONFIG_BEAN_NAME);

        System.out.println("Current config content: " + config.toString());
        String timeout = config.getTimeout();
        String poolSize = config.getPoolSize();
        while (!config.isStopApp()) {
            Thread.sleep(PAUSE_MILLIS);
            if (!timeout.equalsIgnoreCase(config.getTimeout())
                    || !poolSize.equalsIgnoreCase(config.getPoolSize())) {
                System.out.println("Modified config content: " + config.toString());
                timeout = config.getTimeout();
                poolSize = config.getPoolSize();
            }
        }
        beanFactory.close();
        System.out.println("stopped");
    }
}
