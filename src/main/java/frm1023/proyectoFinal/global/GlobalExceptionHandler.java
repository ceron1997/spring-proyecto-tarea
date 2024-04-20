package frm1023.proyectoFinal.global;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponses> handlerMethorArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest webRequest){
        ApiResponses apiResponse = new ApiResponses();
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)->{
            String field = ((FieldError) error).getField();
            String reason = error.getDefaultMessage();
            errors.put(field, reason);
        });
        apiResponse.setCodeResponse(500);
        apiResponse.setMessage("Los valores de los campos son incorrectos");
        apiResponse.setReply(errors);
        return new ResponseEntity<ApiResponses>(apiResponse,HttpStatus.NOT_ACCEPTABLE);
    } 
    
}
