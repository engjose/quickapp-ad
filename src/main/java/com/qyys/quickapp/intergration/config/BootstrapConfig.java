package com.qyys.quickapp.intergration.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : Yuan.Pan 2020/8/10 8:45 PM
 */
@Configuration
@Import({DataSourceConfig.class, IdWorkerConfig.class})
public class BootstrapConfig {
}
