package istad.com.restapi.service;

import istad.com.restapi.dto.CreateUserDto;
import istad.com.restapi.dto.UserDto;
import istad.com.restapi.model.User;
import istad.com.restapi.dto.UpdateUserDto;
import java.util.List;
import java.util.UUID;

public interface UserService {
    //define business logic
    //0. what is your logic?
    // 1. return type
    // 2. Parameter type
    UserDto updateFullName(UUID id, UpdateUserDto updateUserDto);
   void deleteByid(UUID id);
    UserDto getByid(UUID id);
    List<UserDto> getAll(String keyword);
    UserDto createUser(CreateUserDto createUserDto);
}
