package cl.usach.dminute.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.dto.UserInfoOauth;
import cl.usach.dminute.entity.Acta;
import cl.usach.dminute.util.Utilitario;

@Component("apiDminuteDb")
public class ApiDminuteDb {

	@Autowired
	@Qualifier("restTemplateApiComun")
    private RestTemplateApiComun restTemplateApiComun;
	
    @Autowired
    @Qualifier("apiConfiguration")
    private ApiConfiguration apiConfiguration;
    
    @Autowired
    @Qualifier("utilitario")
    private Utilitario utilitario;

    public UserInfoOauth userInfoGoogle(String token) {
    	
        String urlApi = apiConfiguration.getUserInfoUriGoogle();
        
        HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(Constants.HEADER_STRING, Constants.TOKEN_PREFIX + " " + token);
		cabecera.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        
        HttpEntity<?> entity = new HttpEntity<>(cabecera);
        
        ResponseEntity<UserInfoOauth> response = restTemplateApiComun.exchange(
        		urlApi,
                HttpMethod.GET,
                entity,
                UserInfoOauth.class
        );
        return response.getBody();
    }
    
    
    public Acta findByActaId(Long actaId) {
    	
        String urlApi = apiConfiguration.getMsUrlBase() + apiConfiguration.getFindByActaId();
        
        HttpEntity<?> entity = new HttpEntity<>(utilitario.createHeaderAutorization());

        String formatted_URL = urlApi + actaId;
        
        ResponseEntity<Acta> response = restTemplateApiComun.exchange(
        		formatted_URL,
                HttpMethod.GET,
                entity,
                Acta.class
        );
        return response.getBody();
    }
    
    public Acta save(Acta guardar) {
    	
        String urlApi = apiConfiguration.getMsUrlBase() + apiConfiguration.getSaveActa();
        
        HttpEntity<?> entity = new HttpEntity<>(guardar, utilitario.createHeaderAutorization());
        
        ResponseEntity<Acta> response = restTemplateApiComun.exchange(
        		urlApi,
                HttpMethod.POST,
                entity,
                Acta.class
        );
        return response.getBody();
    }
    
    
	
}
