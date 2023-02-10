package com.beordie.activity.utl;

import com.beordie.activity.config.ActivityConfig;
import com.beordie.activity.model.ActivityRepository;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/6 15:20
 * @describe TODO
 */
@Component
public class ActivityListerner extends FileAlterationListenerAdaptor {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void onFileCreate(File file) {
    }

    @Override
    public void onFileChange(File file) {
        activityRepository.updateActivities();
    }

    @Override
    public void onFileDelete(File file) {
    }

    @Override
    public void onDirectoryCreate(File directory) {
    }

    @Override
    public void onDirectoryChange(File directory) {
    }

    @Override
    public void onDirectoryDelete(File directory) {
    }

    @Override
    public void onStart(FileAlterationObserver observer) {
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
    }
}
