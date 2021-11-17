package com.jones.shoppingmart.monitoring;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoggingEntity {
	 	
	
	@Builder.Default
	private String message = "";
	@Builder.Default
	private String method = "";
	@Builder.Default
	private Status status = Status.NA;
	@Builder.Default
	private Level level = Level.NA;
	
	public static enum Status {
		SUCCESS, FAILURE, NA;
	}
	
	public static enum Level {
		DEBUG, INFO, WARN, ERROR, NA;
	}

}

