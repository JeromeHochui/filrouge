package fr.dta.filrouge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.PRECONDITION_FAILED)
public class PreconditionFailedException extends RuntimeException{

	private static final long serialVersionUID = 5875651034808799649L;
	
}
