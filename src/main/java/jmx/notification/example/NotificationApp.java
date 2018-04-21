package jmx.notification.example;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class NotificationApp {
    public static void main(String[] args) throws Exception {
        // Get the Platform MBean Server
        final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // Construct the ObjectName for the NotificationTest MBean we will register
        final ObjectName mbeanName = new ObjectName("jmx.notification.example:type=NotificationTest");

        // Create the Hello World MBean
        final NotificationTest mbean = new NotificationTest();

        // Register the Hello World MBean
        mbs.registerMBean(mbean, mbeanName);

        // Wait forever
        System.out.println("Waiting for incoming requests...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
