package cl.usach.dminute.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utilitario {

	public static int obtenerEdad(String fechaNacimientoStr) {

		log.info("[CrearPerfilClienteServiceImpl][obtenerEdad][BCI_INI][fecha de nacimiento en formato yyyyMMddHHmmss="
				+ fechaNacimientoStr + "]");

		if (fechaNacimientoStr != null) {
			SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				Date fechaNacimiento = formato.parse(fechaNacimientoStr);
				Calendar c = new GregorianCalendar();
				c.setTime(fechaNacimiento);
				return 0;

			} catch (ParseException e) {
				log.error(
						"[CrearPerfilClienteServiceImpl][obtenerEdad][BCI_FINEX][Error al calular la edad del cliente, se calcula en 0]");
			}
		}
		return 0;
	}

}
