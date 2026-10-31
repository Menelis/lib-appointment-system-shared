package co.appointment.shared.exception;

import co.appointment.shared.dto.ServiceResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceException extends RuntimeException {

    private final HttpStatus status;
    private final ServiceResponseDto response;

    public ServiceException(final HttpStatus httpStatus, final ServiceResponseDto serviceResponse) {
        this.status = httpStatus;
        this.response = serviceResponse;
    }

    public ServiceException(final HttpStatus httpStatus) {
        this(httpStatus, null);
    }
}
