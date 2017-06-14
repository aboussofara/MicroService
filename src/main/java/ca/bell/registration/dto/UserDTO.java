package ca.bell.registration.dto;

import javax.validation.constraints.Size;

public class UserDTO {

//    @Size(min = 5, max = 255, message = "Le username est obligatoire (min 5 max 255)")
    private String username;

    @Size(min = 5, max = 255, message = "TODO:Complet")
    private String password;

    @Size(min = 5, max = 255, message = "TODO:Complet")
    private String firstName;

    @Size(min = 5, max = 255, message = "TODO:Complet")
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
