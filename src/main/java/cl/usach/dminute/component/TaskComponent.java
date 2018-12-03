package cl.usach.dminute.component;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("taskComponent")
public class TaskComponent {
	
	@Scheduled(fixedDelay=50000)
	public void doTastk() {
		
		if(log.isInfoEnabled()) {
			log.info("TaskComponent.doTastk.INI");
			
			log.info("TaskComponent.doTastk.fecha: " + new Date());
		}
	}

}
