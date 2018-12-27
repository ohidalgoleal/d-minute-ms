package cl.usach.dminute.component;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component("apiConfiguration")
public class ApiConfiguration {

    @Value("${api-ms-base.url}")
    private String msUrlBase;
    
    @Value("${acta.findByActaId}")
    private String findByActaId;
    
    @Value("${acta.saveActa}")
    private String saveActa;
    
    @Value("${security.oauth2.resource.userInfoUri}")
    private String userInfoUriGoogle;

}
