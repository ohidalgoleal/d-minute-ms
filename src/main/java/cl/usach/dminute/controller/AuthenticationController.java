package cl.usach.dminute.controller;

import cl.usach.dminute.component.ApiDminuteDb;
import cl.usach.dminute.configuration.JwtTokenUtil;
import cl.usach.dminute.dto.AuthTokenDto;
import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.dto.LoginUserDto;
import cl.usach.dminute.dto.SalidaDto;
import cl.usach.dminute.dto.UserInfoOauth;
import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.exception.ValidacionesException;
import cl.usach.dminute.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

	@Autowired
	@Qualifier("usuarioService")
    private UsuarioService usuarioService;
	
	@Autowired
	@Qualifier("apiDminuteDb")
    private ApiDminuteDb apiDminuteDb;
	

	@PostMapping(value = "/generate-token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody LoginUserDto loginUser) throws AuthenticationException {

    	if(log.isInfoEnabled()) {
			log.info("AuthenticationController.generate-token.INIT");
			log.info("AuthenticationController.generate-token.getUsername:" + loginUser.getUsername());
		}
    	
        return ResponseEntity.ok(new AuthTokenDto(validaGeneraToken(loginUser)));
    }
    
    @PostMapping(value="/usuarioGuardar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> usuarioGuardar(@RequestBody Usuario usuario){
    	if(log.isInfoEnabled()) {
			log.info("AuthenticationController.usuarioGuardar.INIT");
		}
        usuarioService.save(usuario);
        
        if(log.isInfoEnabled()) {
			log.info("AuthenticationController.usuarioGuardar.OK");
		}
        return ResponseEntity.ok(new SalidaDto());
    }
    
   @PostMapping(value = "/userOauth", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> userOauth(@RequestBody LoginUserDto loginUser) throws AuthenticationException, GeneralSecurityException, IOException {

    	if(log.isInfoEnabled()) {
			log.info("AuthenticationController.userOauth.INIT");
			log.info("AuthenticationController.userOauth.loginUser:" + loginUser.toString());
		}
    	
    	String tokenApp = validaGeneraToken(loginUser);
    	
        return ResponseEntity.ok(new AuthTokenDto(tokenApp));
    }
	
	private String validaGeneraToken(LoginUserDto loginUser) {
		
		if(log.isInfoEnabled()) {
			log.info("AuthenticationController.validaGeneraToken.INI");
		}
		
		UserInfoOauth retorno = apiDminuteDb.userInfoGoogle(loginUser.getToken());
		
		if (retorno.isEmail_verified()){
			
			loginUser.setPassword(Constants.ORIGEN_GOOGLE);
			loginUser.setName(retorno.getName());
			usuarioService.userOauth(loginUser);
			
			final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginUser.getUsername(),
	                        loginUser.getPassword()
	                )
	        );
	    	
	        if(log.isInfoEnabled()) {
				log.info("AuthenticationController.GenerandoToken");
			}
	        
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        final Usuario user = usuarioService.findOne(loginUser.getUsername());
	        final String token = jwtTokenUtil.generateToken(user);
	        if(log.isInfoEnabled()) {
				log.info("AuthenticationController.validaGeneraToken.Token.OK");
			}
	        return token;
			
		}
		else{
			throw new ValidacionesException(Constants.ERROR_PERMISO_GENERICO_COD, Constants.ERROR_USUARIO_INVALIDO, null);
		}	
	}

}
