package net.uchoice.conveyor.modules.sys.listener;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;

import net.uchoice.conveyor.modules.sys.service.SystemService;

public class WebContextListener extends org.springframework.web.context.ContextLoaderListener {
	
	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		if (!SystemService.printKeyLoadMessage()){
			return null;
		}
		SystemService.checkLicence();
		return super.initWebApplicationContext(servletContext);
	}
}
