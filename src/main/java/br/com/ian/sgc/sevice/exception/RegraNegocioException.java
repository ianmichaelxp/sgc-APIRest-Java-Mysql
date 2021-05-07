package br.com.ian.sgc.sevice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegraNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegraNegocioException(final String message) {
        this(message, null);
    }

    public RegraNegocioException(final String message, final Throwable cause) {
        super(message, cause);
    }
}