package cl.usach.dminute.controller;

import cl.usach.dminute.configuration.JwtTokenUtil;
import cl.usach.dminute.dto.AuthTokenDto;
import cl.usach.dminute.dto.LoginUserDto;
import cl.usach.dminute.dto.SalidaDto;
import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

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

	@PostMapping(value = "/generate-token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody LoginUserDto loginUser) throws AuthenticationException {

    	if(log.isInfoEnabled()) {
			log.info("AuthenticationController.generate-token.INIT");
			log.info("AuthenticationController.generate-token.getUsername:" + loginUser.getUsername());
		}
    	
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        if(log.isInfoEnabled()) {
			log.info("AuthenticationController.generate-token.Validacion.OK");
		}
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final Usuario user = usuarioService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        if(log.isInfoEnabled()) {
			log.info("AuthenticationController.generate-token.Token.OK");
		}
        return ResponseEntity.ok(new AuthTokenDto(token));
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

}
