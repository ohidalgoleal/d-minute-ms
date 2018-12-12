package cl.usach.dminute.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cl.usach.dminute.component.RequestTimeInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{

	 @Override
	 public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/*")
	            .allowedOrigins("*")
	            .allowedMethods("PUT", "DELETE", "OPTIONS", "GET", "POST");
	 }
	 
	 @Autowired
		@Qualifier("requestTimeInterceptor")
		private RequestTimeInterceptor requestTimeInterceptor;
		
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(requestTimeInterceptor);
		}
}
