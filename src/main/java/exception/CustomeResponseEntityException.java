package exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sumit0733.spring.firstproject.users.UserNotFoundException;

@ControllerAdvice
public class CustomeResponseEntityException extends ResponseEntityExceptionHandler{
	 
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionModel> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionModel model = new ExceptionModel(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionModel>(model, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ExceptionModel> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		System.err.println("Error FOUND!!!");
		ExceptionModel model = new ExceptionModel(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionModel>(model, HttpStatus.NOT_FOUND);
	}
}
