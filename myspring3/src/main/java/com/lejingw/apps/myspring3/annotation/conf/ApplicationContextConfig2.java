package com.lejingw.apps.myspring3.annotation.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration("ctxConfig2")
@Import({ApplicationContextConfig.class})
public class ApplicationContextConfig2 {
    
    @Bean(name = {"message2"})
    public String message() {
        return "hello";
    }
}
