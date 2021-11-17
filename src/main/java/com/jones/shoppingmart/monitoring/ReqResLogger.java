package com.jones.shoppingmart.monitoring;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class ReqResLogger extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String TraceId = Optional.ofNullable(request.getHeader("TraceId")).orElse(UUID.randomUUID().toString());
		MDC.put("TraceId", TraceId);
		filterChain.doFilter(request, response);
		MDC.clear();
	}

}
