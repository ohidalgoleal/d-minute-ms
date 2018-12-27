package cl.usach.dminute.component;

import cl.usach.dminute.exception.ApiComunException;
import cl.usach.dminute.exception.type.ViajeComunErrorType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;


@Component("restTemplateApiComun")
public class RestTemplateApiComun extends RestTemplate {
	
    public RestTemplateApiComun() {
        super();
        setErrorHandler(new HttpApiComunErrorHandler());
    }

    public static class HttpApiComunErrorHandler extends DefaultResponseErrorHandler {

        private Logger log = LoggerFactory.getLogger(HttpApiComunErrorHandler.class);

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            logResponse(response);
            switch (response.getStatusCode()) {
                case INTERNAL_SERVER_ERROR:
                    throw new ApiComunException(findError(response));
                case BAD_REQUEST:
                    throw new ApiComunException(findError(response));
                case NOT_FOUND:
                    throw new ApiComunException(findError(response));
                default:
                    throw new ApiComunException();
            }
        }

        private ViajeComunErrorType findError(ClientHttpResponse response) {
            try {
                String errorType = StreamUtils.copyToString(response.getBody(), Charset.forName("UTF-8"));
                JSONObject result = new JSONObject(errorType);
                String code = result.has("codigo") ? result.getString("codigo") : "";
                String message = result.has("mensaje") ? result.getString("mensaje"): "";
                String type = result.getString("info").toLowerCase();
                return new ViajeComunErrorType(type, code, message, response.getStatusCode().value());
            } catch (JSONException | IOException ee) {
                return ViajeComunErrorType.SISTEMA_ERROR;
            }
        }

        private void logResponse(ClientHttpResponse response) throws IOException {
            log.error("API-COMUN:WEB ERROR => {} : {}", response.getRawStatusCode(), response.getStatusText());
        }
    }

}
