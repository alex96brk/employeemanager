package tech.getarrays.employeemanager.service.exception.impl;

import tech.getarrays.employeemanager.service.exception.ServiceException;

public class UserNotFoundException extends ServiceException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException() {
    }
}
