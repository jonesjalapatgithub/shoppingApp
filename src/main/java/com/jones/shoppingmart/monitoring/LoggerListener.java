package com.jones.shoppingmart.monitoring;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.apache.logging.log4j.Logger;

@Component
public class LoggerListener {

	private static final Logger LOGGER = LogManager.getLogger(LoggerListener.class);

	@Autowired
	public LoggerListener(EventBus eventBus) {
		eventBus.register(this);
	}

	@Subscribe
	public void loggingEvent(LoggingEntity loggingEntity) {
		String message = "msg=" + loggingEntity.getMessage() + ", method=" + loggingEntity.getMethod();
		if (LoggingEntity.Level.INFO.equals(loggingEntity.getLevel())) {
			LOGGER.info(message + ", level=" + loggingEntity.getLevel());
		} else if (LoggingEntity.Level.ERROR.equals(loggingEntity.getLevel())) {
			LOGGER.error(message + ", level=" + loggingEntity.getLevel());
		} else {
			return;
		}
	}

}
