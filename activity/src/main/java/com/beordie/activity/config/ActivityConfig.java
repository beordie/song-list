package com.beordie.activity.config;

import com.beordie.activity.model.Activity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/6 13:33
 * @describe TODO
 */
@Data
@Configuration
public class ActivityConfig {
    @Value("${dir}")
    private String monitorDir;
}
