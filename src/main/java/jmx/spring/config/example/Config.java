package jmx.spring.config.example;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource
public class Config {
    private String timeout;
    private String poolSize;
    private boolean stopApp;

    public Config() {
    }

    public Config(String timeout, String poolSize, boolean stopApp) {
        setTimeout(timeout);
        setPoolSize(poolSize);
        setStopApp(stopApp);
    }

    @ManagedAttribute
    public String getTimeout() {
        return timeout;
    }

    @ManagedAttribute
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @ManagedAttribute
    public String getPoolSize() {
        return poolSize;
    }

    @ManagedAttribute
    public void setPoolSize(String poolSize) {
        this.poolSize = poolSize;
    }

    @ManagedAttribute
    public boolean isStopApp() {
        return stopApp;
    }

    @ManagedAttribute
    public void setStopApp(boolean stopApp) {
        this.stopApp = stopApp;
    }

    @Override
    @ManagedOperation
    public String toString() {
        return "Config{" +
                "timeout='" + timeout + '\'' +
                ", poolSize='" + poolSize + '\'' +
                '}';
    }
}
