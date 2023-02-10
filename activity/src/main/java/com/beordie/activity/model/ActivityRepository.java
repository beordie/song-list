package com.beordie.activity.model;

import com.beordie.activity.config.ActivityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/6 16:30
 * @describe TODO
 */
@Component
public class ActivityRepository {
    @Autowired
    private ActivityConfig config;
    private List<Activity> activities;

    public List<Activity> getActivities() {
        return this.activities;
    }

    @PostConstruct
    public void updateActivities() {
        this.activities.clear();
        Properties properties = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(new File(config.getMonitorDir() + "activity.properties"));
            // 使用properties对象加载输入流
            properties.load(in);
            String activityList = properties.getProperty("activity");
            for (String resource: activityList.split(",")) {
                String[] split = resource.split(":");
                Activity activity = new Activity();
                activity.setName(split[0]);
                activity.setUrl(split[1]);
                activities.add(activity);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ActivityRepository() {
        this.activities = new ArrayList<>();
    }
}
