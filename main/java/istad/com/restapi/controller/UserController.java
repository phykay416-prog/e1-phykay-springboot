package istad.com.restapi.controller;

import istad.com.restapi.dto.CreateUserDto;
import istad.com.restapi.dto.UserDto;

import istad.com.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import istad.com.restapi.dto.UpdateUserDto;


@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    // UPDATE USER
    @PatchMapping("/{id}")
    public UserDto updateFullName(
            @PathVariable UUID id,
            @RequestBody UpdateUserDto updateUserDto
    ) {
        return userService.updateFullName(id, updateUserDto);
    }
    @DeleteMapping("/{id}")
    public void deleteByid(@PathVariable UUID id){
         userService.deleteByid(id);

    }

    @GetMapping("/{id}")
   public UserDto getByid(@PathVariable UUID id){
        return userService.getByid(id);
    }
    @GetMapping
    public List<UserDto> getAll(
            @RequestParam(required = false, defaultValue = "") String keyword
    ) {
        return userService.getAll(keyword);
    }
    @ResponseStatus(HttpStatus.CREATED)

    @PostMapping
    public UserDto createUser(@RequestBody CreateUserDto createUserDto){
        return userService.createUser(createUserDto);
    }

}
