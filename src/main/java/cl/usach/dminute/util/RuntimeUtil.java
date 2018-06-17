package cl.usach.dminute.util;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class RuntimeUtil implements ApplicationListener<EmbeddedServletContainerInitializedEvent>{

	private static int port;
	
	public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
		port = event.getEmbeddedServletContainer().getPort();
	}
	
	public static int getPort(){
		return port;
	}
}
