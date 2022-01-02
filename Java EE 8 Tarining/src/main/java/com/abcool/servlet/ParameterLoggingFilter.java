package com.abcool.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.jboss.logging.Logger;

/**
 * Servlet Filter implementation class ParameterLoggingFilter
 */
@WebFilter(urlPatterns="/*",asyncSupported = true)
public class ParameterLoggingFilter implements Filter {
	
	private static final Logger logger = Logger.getLogger(ParameterLoggingFilter.class);

    /**
     * Default constructor. 
     */
    public ParameterLoggingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.getParameterMap().entrySet().stream().forEach(entity->{
			logger.info(entity.getKey() +": " + entity.getValue()[0]);
			//System.out.println();
		});

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
