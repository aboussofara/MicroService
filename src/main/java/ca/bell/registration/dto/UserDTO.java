package ca.bell.registration.dto;

import javax.validation.constraints.Size;

public class UserDTO {

    @Size(min = 1, max = 255, message = "Le username est obligatoire (min 1 max 255)")
    private String username;

    @Size(min = 1, max = 255, message = "Password required (min 1 max 255 chars)")
    private String password;

    @Size(max = 255, message = "First name cannot be longer than 255 chars")
    private String firstName;

    @Size(max = 255, message = "Last name cannot be longer than 255 chars")
    private String lastName;

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
