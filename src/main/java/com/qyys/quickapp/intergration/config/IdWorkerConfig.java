package com.qyys.quickapp.intergration.config;
import com.qyys.quickapp.intergration.id.IdWorker;
import com.qyys.quickapp.intergration.id.SimpleIdWorker;
import org.springframework.context.annotation.Bean;

/**
 * @author : Yuan.Pan 2020/8/12 11:25 PM
 */
public class IdWorkerConfig {
    @Bean
    public IdWorker idWorker() {
        return new SimpleIdWorker();
    }
}
