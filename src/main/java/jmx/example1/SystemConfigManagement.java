package jmx.example1;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class SystemConfigManagement {
    private static final int DEFAULT_NO_THREADS = 10;
    private static final String DEFAULT_SCHEMA = "default";

    public static void main(String[] args) throws MalformedObjectNameException, InterruptedException,
            InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        SystemConfig mBean = new SystemConfig(DEFAULT_NO_THREADS, DEFAULT_SCHEMA);
        ObjectName name = new ObjectName("jmx.example1:type=SystemConfig");
        mbs.registerMBean(mBean, name);
        do {
            Thread.sleep(3000);
            System.out.println("Thread Count=" + mBean.getThreadCount() + ":::Schema Name=" + mBean.getSchemaName());
        } while (mBean.getThreadCount() != 0);

    }
}