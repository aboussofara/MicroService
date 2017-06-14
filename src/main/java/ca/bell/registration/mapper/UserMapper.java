package ca.bell.registration.mapper;

import ca.bell.registration.dto.UserDTO;
import ca.bell.registration.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDTO> {

    @Override
    public User map(UserDTO userDTO, User user) {
        return user.setFirstName(userDTO.getFirstName())
                .setLastName(userDTO.getLastName())
                .setPassword(userDTO.getPassword())
                .setUsername(userDTO.getUsername());
    }

    @Override
    public UserDTO map(User user) {
        return new UserDTO()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPassword(user.getPassword())
                .setUsername(user.getUsername());
    }
}
