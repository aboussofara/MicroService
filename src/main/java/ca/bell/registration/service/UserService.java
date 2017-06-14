package ca.bell.registration.service;

import ca.bell.registration.dto.UserDTO;
import ca.bell.registration.exception.GenericException;

public interface UserService {

    UserDTO create(UserDTO user) throws GenericException;
}
