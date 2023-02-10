package com.beordie.activity.utl;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.PrimitiveIterator;
import java.util.concurrent.TimeUnit;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/6 15:34
 * @describe TODO
 */
@Configuration
public class ActivityListenerFactory {
    @Value("${dir}")
    private String monitorDir;
    @Autowired
    private ActivityListerner listenerService;

    public void startMonitor() {
        long interval = TimeUnit.SECONDS.toMillis(1);
        FileAlterationObserver observer = new FileAlterationObserver(new File(monitorDir));
        observer.addListener(listenerService);
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        try{
            monitor.start();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
