package fr.dta.filrouge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
public class NotDeletableProductException extends RuntimeException {
	private static final long serialVersionUID = -4998921123858922749L;

}
