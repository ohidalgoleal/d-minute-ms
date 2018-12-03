package cl.usach.dminute.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cl.usach.dminute.configuration.JwtTokenUtil;
import cl.usach.dminute.repository.LogRepository;
import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/** The Constant log. */
@Slf4j
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	/** The jwt token util. */
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	
	/** The log repository. */
	@Autowired
	@Qualifier("logRepository")
	private LogRepository logRepository;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	
		if(log.isInfoEnabled()) {
			log.info("RequestTimeInterceptor.afterCompletion.INI");
		}
		
		//long startTime = (long)request.getAttribute("startTime");
		
		String userName = jwtTokenUtil.getUserToken(request);
		
		if (userName == null) {
			userName = "login";
		}
		
		if(log.isInfoEnabled()) {
			log.info("RequestTimeInterceptor.afterCompletion.userName: "+ userName);
		}
			
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		cl.usach.dminute.entity.Log logtb =new cl.usach.dminute.entity.Log();
		
		logtb.setDetalle(auth.getDetails().toString());
		logtb.setFecha(new Date());
		logtb.setUrl(request.getRequestURL().toString());
		logtb.setUsername(userName);
		
		if(log.isInfoEnabled()) {
			log.info("RequestTimeInterceptor.afterCompletion.LOG: "+ log);
		}
		
		logRepository.save(logtb);
		
	}
	
	
 	
}
