package com.jones.shoppingmart.monitoring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.eventbus.EventBus;

@Configuration
public class EventBusFactory {
	  
	
	@Bean
    public EventBus getEventBus() {
        return new EventBus();
    }


}
