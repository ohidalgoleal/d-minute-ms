package cl.usach.dminute.exception.type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

/**
 * Clase que maneja los tipos de errores Comunes 
 *
 *
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class ViajeComunErrorType {
    public static final ViajeComunErrorType SISTEMA_ERROR = new ViajeComunErrorType("sistemaexception","Error_Sistema", "Estimado cliente: Se ha producido un error, por favor intente m\u00e1s tarde.", HttpStatus.INTERNAL_SERVER_ERROR.value());

    private String code;
    private String message;
    private String type;
    private int httpStatusCode;

    public ViajeComunErrorType(String type, String code, String message, int httpStatusCode) {
        this.type = type;
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

    public ViajeComunErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ViajeComunErrorType(String type, String code, String message) {
        this.type = type;
        this.code = code;
        this.message = message;
    }

    @JsonProperty("codigo")
    public String getCode() {
        return code;
    }

    public  void setCode(String code) {
         this.code = code;
    }

    @JsonProperty("mensaje")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("info")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public int getHttpStatusCode() {
        return httpStatusCode;
    }


}
