package com.jones.shoppingmart.monitoring;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.eventbus.EventBus;

@Aspect
@Component
public class ShoppingMonitor {
	
	private static final String POINTCUTS = "productApis()";
	private EventBus eventBus;
	
	@Autowired
	public ShoppingMonitor(EventBus eventBus) {
		this.eventBus = eventBus;
	}
	
	@Pointcut("execution(* com.jones.shoppingmart.controller.ProductController.*(..))")
	public void productApis() {
	}
	
	
	@Around(POINTCUTS)
	public Object recordApi(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
				.currentRequestAttributes()).getRequest();
		String method = proceedingJoinPoint.getSignature().getName();
		String className = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
		Object response = null;
		try {
			response = proceedingJoinPoint.proceed();
			LoggingEntity loggingEntity = LoggingEntity.builder().message("Product service call is success for Api" + request.getRequestURI().toString())
					.level(LoggingEntity.Level.INFO).status(LoggingEntity.Status.SUCCESS).method(className + "." + method).build();
			eventBus.post(loggingEntity);
		} catch (Exception e) {
			LoggingEntity loggingEntity = LoggingEntity.builder().message("Service call is success" + request)
					.level(LoggingEntity.Level.ERROR).status(LoggingEntity.Status.FAILURE).method(method).build();
			eventBus.post(loggingEntity);
		}
		return response;
	}
	
	
	
	

}
