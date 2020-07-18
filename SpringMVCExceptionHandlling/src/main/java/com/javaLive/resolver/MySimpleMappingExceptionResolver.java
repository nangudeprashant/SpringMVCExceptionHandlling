package com.javaLive.resolver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;


public class MySimpleMappingExceptionResolver extends
		SimpleMappingExceptionResolver {
	public MySimpleMappingExceptionResolver() {
	    // Enable logging by providing the name of the logger to use
	    setWarnLogCategory(MySimpleMappingExceptionResolver.class.getName());
	  }
	//private static final Logger logger = LoggerFactory.getLogger(MySimpleMappingExceptionResolver.class);
	@Override
	public String buildLogMessage(Exception ex, HttpServletRequest request) {
		logger.error("Generic Exception Occured:: URL="+request.getRequestURL());
        //return "Spring MVC exception: " + ex.getLocalizedMessage();
		return "Spring MVC exception: " + ex.getMessage();
    }
	
	//To make additional information available to the error view by overriding doResolveException
	/*@Override
	  protected ModelAndView doResolveException(HttpServletRequest req,
	        HttpServletResponse resp, Object handler, Exception ex) {
	    // Call super method to get the ModelAndView
	    ModelAndView mav = super.doResolveException(req, resp, handler, ex);
	        
	    // Make the full URL available to the view - note ModelAndView uses
	    // addObject() but Model uses addAttribute(). They work the same. 
	    mav.addObject("url", request.getRequestURL());
	    return mav;
	  }*/
}
