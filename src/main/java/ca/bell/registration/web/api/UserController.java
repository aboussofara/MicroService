package ca.bell.registration.web.api;

import ca.bell.registration.dto.UserDTO;
import ca.bell.registration.exception.GenericException;
import ca.bell.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO create(@Valid @RequestBody UserDTO userDTO) throws GenericException {
        // TODO: Validation...
        return userService.create(userDTO);
    }

}
