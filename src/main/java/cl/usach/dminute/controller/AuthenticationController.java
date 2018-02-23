package cl.usach.dminute.controller;

import cl.usach.dminute.configuration.JwtTokenUtil;
import cl.usach.dminute.dto.AuthToken;
import cl.usach.dminute.dto.LoginUser;
import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

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
        return ResponseEntity.ok(new AuthToken(token));
    }

}
