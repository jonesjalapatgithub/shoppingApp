package com.jones.shoppingmart.monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class MetricsListener {

	private MeterRegistry meterRegistry;

	@Autowired
	public MetricsListener(EventBus eventBus, MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
		eventBus.register(this);
	}

	@Subscribe
	public void metricsEvent(LoggingEntity loggingEntity) {
		incrementCounter(loggingEntity);
	}

	public void incrementCounter(LoggingEntity loggingEntity) {
		Counter counter = null;
		String[] method = loggingEntity.getMethod().split("\\.");
		if (LoggingEntity.Status.SUCCESS.equals(loggingEntity.getStatus())) {
			counter = Counter.builder("shoppingservice").tag(method[0], method[1]).tag("status", "success")
					.register(meterRegistry);
		} else if (LoggingEntity.Status.FAILURE.equals(loggingEntity.getStatus())) {
			counter = Counter.builder("shoppingservice").tag(method[0], method[1]).tag("status", "failure")
					.register(meterRegistry);
		} else {
			return;
		}
		//counter.increment(1.0);
	}

}
