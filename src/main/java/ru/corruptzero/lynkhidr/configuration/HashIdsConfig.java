package ru.corruptzero.lynkhidr.configuration;

import org.hashids.Hashids;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HashIdsConfig {

    @Bean
    public Hashids hashids(){
        return new Hashids("definetely not a pepper");
    }
}
