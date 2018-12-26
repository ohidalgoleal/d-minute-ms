package cl.usach.dminute.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.exception.UsPersonException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("utilitario")
public class Utilitario {
    
    @Autowired
    private HttpServletRequest request;
    
	public static Date formatoFecha(String fechaStr) {

		log.info("[Utilitario][formatoFecha][INI][fecha en formato yyyyMMdd"
				+ fechaStr + "]");

		if (fechaStr != null) {
			
			try {
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
				Date date = formatoDelTexto.parse(fechaStr);
			    log.info("[Utilitario][formatoFecha][fecha:]" + date);
			   return date;
			} catch (ParseException e) {
				log.error(
						"[Utilitario][formatoFecha][FINEX][Error al calular fecha]");
			}
		}
		return null;
	}
	
	public static String formatoFecha(Date fechaStr) {

		log.info("[Utilitario][formatoFecha][INI][fecha en formato yyyyMMdd"
				+ fechaStr + "]");

		if (fechaStr != null) {
			
			try {
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
				String date = formatoDelTexto.format(fechaStr);
			    log.info("[Utilitario][formatoFecha][fecha:]" + date);
			   return date;
			} catch (Exception e) {
				log.error(
						"[Utilitario][formatoFecha][FINEX][Error al calular fecha]");
			}
		}
		return null;
	}
	
	public static Date formatoFechaHora(String fechaStr) {

		log.info("[Utilitario][formatoFecha][INI][fecha en formato yyyyMMdd"
				+ fechaStr + "]");

		if (fechaStr != null) {
			
			try {
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.ENGLISH);
				Date date = formatoDelTexto.parse(fechaStr);
			    log.info("[Utilitario][formatoFecha][fecha:]" + date);
			   return date;
			} catch (ParseException e) {
				log.error(
						"[Utilitario][formatoFecha][FINEX][Error al calular fecha]");
			}
		}
		return null;
	}

	
	public HttpHeaders createHeaderAutorization() throws UsPersonException{
		
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		if (aut.isAuthenticated()) {
			HttpHeaders cabecera = new HttpHeaders();
			cabecera.add(Constants.HEADER_STRING, request.getHeader(Constants.HEADER_STRING));
			cabecera.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
			return cabecera;
		}
		throw new UsPersonException(Constants.ERROR_PERMISO_GENERICO_COD, Constants.ERROR_USUARIO_INVALIDO);
		
	}
}
