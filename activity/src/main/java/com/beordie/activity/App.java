package com.beordie.activity;

import com.beordie.activity.utl.ActivityListenerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class App {
    private  static ActivityListenerFactory filterFileConfig;

    @Autowired
    public void setFilterFileConfig(ActivityListenerFactory filterFileConfig) {
        this.filterFileConfig = filterFileConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        filterFileConfig.startMonitor();
    }
}