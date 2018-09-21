package exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.n26.util.IConstants;

@ControllerAdvice("com.n26.controller")
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<CustomException> toResponse(Exception exception) {
		ResponseEntity<CustomException> exceptionResponse = null;

		if (exception instanceof CustomException && ((CustomException) exception).getExceptionBean() != null) {
			CustomException customException = (CustomException) exception;

			if (null != customException.getExceptionBean().getExceptionCode())

			{
				switch (customException.getExceptionBean().getExceptionCode()) {
				case IConstants.VALIDATIONEXCEPTION: {
					exceptionResponse = new ResponseEntity(customException.getExceptionBean(), HttpStatus.NO_CONTENT);
				}

				case IConstants.NODATAFOUNDEXCEPTION: {
					exceptionResponse = new ResponseEntity(customException.getExceptionBean(), HttpStatus.NOT_FOUND);
				}
				
				case IConstants.PARSINGERROR: {
					exceptionResponse = new ResponseEntity(customException.getExceptionBean(), HttpStatus.BAD_REQUEST);
				}

				}
			} 
		}
		else if(exception instanceof MethodArgumentTypeMismatchException)
		{
			exceptionResponse = new ResponseEntity((new ExceptionBean()).setExceptionCode(IConstants.SERVICE_REQUEST_MALFORMED_ERROR_OCCURED)
					.setExceptionMessage(IConstants.SERVICE_REQUEST_MALFORMED_ERROR_OCCURED_DESCR),
					HttpStatus.BAD_REQUEST);
		}
		
		else if(exception instanceof MissingServletRequestParameterException)
		{
			exceptionResponse = new ResponseEntity((new ExceptionBean()).setExceptionCode(IConstants.SERVICE_REQUEST_PARAM_ERROR_OCCURED)
					.setExceptionMessage(IConstants.SERVICE_REQUEST_PARAM_ERROR_OCCURED_DESCR),
					HttpStatus.BAD_REQUEST);
		}
		
		
		else {
			exceptionResponse = new ResponseEntity((new ExceptionBean()).setExceptionCode(IConstants.ERROR_OCCURED)
					.setExceptionMessage(IConstants.ERROR_OCCURED_CONTACT_ADMIN_DESCR),
					HttpStatus.BAD_REQUEST);
		}

		return exceptionResponse;
	}

}
