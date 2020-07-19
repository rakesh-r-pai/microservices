package com.banking.service.zuulapigatewayserver.logging;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class);
	
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}, request port -> {}", 
				request, request.getRequestURI(), request.getServerPort());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
