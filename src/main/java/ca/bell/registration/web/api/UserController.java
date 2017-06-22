package ca.bell.registration.web.api;

import ca.bell.registration.dto.UserDTO;
import ca.bell.registration.exception.GenericException;
import ca.bell.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return userService.create(userDTO);
    }

    @GetMapping (path = "/{username}")
    public UserDTO findByUsername(@PathVariable String username) throws GenericException{
        return userService.findByUsername(username);
    }

}
