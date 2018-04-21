package jmx.example1;

public interface SystemConfigMBean { // MBean convention to avoid javax.management.NotCompliantMBeanException
    void setThreadCount(int noOfThreads);

    int getThreadCount();

    void setSchemaName(String schemaName);

    String getSchemaName();

    String doConfig();
}
