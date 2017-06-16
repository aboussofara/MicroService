package ca.bell.registration.service.implementation;

import ca.bell.registration.dto.UserDTO;
import ca.bell.registration.exception.ErrorException;
import ca.bell.registration.exception.GenericException;
import ca.bell.registration.exception.NotFoundException;
import ca.bell.registration.mapper.UserMapper;
import ca.bell.registration.model.User;
import ca.bell.registration.repository.UserRepository;
import ca.bell.registration.service.UserService;
import ca.bell.registration.validator.UserValidator;
import ca.bell.registration.validator.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserValidator userValidator, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO create(final UserDTO userDTO) throws GenericException {
        Assert.notNull(userDTO, "The userDTO parameter is required.");

        final User user = userMapper.convertToEntity(userDTO, new User())
                .orElseThrow(ErrorException::new);

        validate(user);

        return userRepository.save(user)
                .flatMap(userMapper::convertToDto)
                .orElseThrow(ErrorException::new);
    }

    @Override
    public UserDTO findByUsername(String username) throws GenericException {
        Assert.notNull(username, "The username is required.");

        return userRepository.findByUsername(username)
                .flatMap(userMapper::convertToDto)
                .orElseThrow(NotFoundException::new);
    }


    private void validate(final User user) throws GenericException {
        ValidationUtils.validate(userValidator, user, "user");
    }

}
