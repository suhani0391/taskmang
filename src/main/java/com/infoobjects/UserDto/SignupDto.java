package com.infoobjects.UserDto;
import lombok.Data;//generate getter and setter for those objects automaticallly.
@Data
public class SignupDto {       
    private String name;
    private String username;
    private String email;
    private String password;
}

