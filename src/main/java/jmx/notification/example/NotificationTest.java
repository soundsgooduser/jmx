package jmx.notification.example;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class NotificationTest extends NotificationBroadcasterSupport implements NotificationTestMBean {
    private static final int DEFAULT_CACHE_SIZE = 200;
    private int cacheSize = DEFAULT_CACHE_SIZE;
    private long sequenceNumber = 1;

    public int getCacheSize() {
        return this.cacheSize;
    }

    public synchronized void setCacheSize(final int size) {
        int oldSize = this.cacheSize;
        this.cacheSize = size;
        final Notification n = new AttributeChangeNotification(this,
                sequenceNumber++,
                System.currentTimeMillis(),
                String.format("CacheSize changed from %s to %s.", oldSize, size),
                "CacheSize",
                "int",
                oldSize,
                this.cacheSize);
        sendNotification(n);
    }
}
