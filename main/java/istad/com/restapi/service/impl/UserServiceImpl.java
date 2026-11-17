package istad.com.restapi.service.impl;

import istad.com.restapi.dto.CreateUserDto;
import istad.com.restapi.dto.UpdateUserDto;
import istad.com.restapi.dto.UserDto;
import istad.com.restapi.model.User;
import istad.com.restapi.repository.UserRepository;
import istad.com.restapi.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDto updateFullName(UUID id, UpdateUserDto updateUserDto) {
      boolean isUpdated = userRepository.updateFullName(
              id,
              updateUserDto.fullName()
      );
      if(!isUpdated){
          throw  new RuntimeException("User not found");
      }
      return getByid(id);
    }

    @Override

        public void deleteByid(@PathVariable UUID id){
            boolean isFound = userRepository.select()
                    .stream()
                    .anyMatch(user-> user.getId().equals(id));
            IO.println("User with" + id + "is found"+isFound);
            if(isFound)
                userRepository.select().removeIf(user->user.getId().equals(id));
            else throw new RuntimeException("user not found");



        }



    @Override
    public UserDto getByid(UUID id) {
        return userRepository.select()
                .stream()
                .filter(user->user.getId().equals(id))
                .findFirst()
                .map(user->new UserDto(user.getId(), user.getFullNam()))
                .orElseThrow(()-> new RuntimeException("user not found"));
    }
    @Override
    public List<UserDto> getAll(String keyword) {

        return userRepository.select()
                .stream()
                .filter(user -> user.getFullNam().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .map(user -> new UserDto(user.getId(), user.getFullNam()))
                .toList();
    }

    // CREATE NEW USER
    @Override
    public UserDto createUser(CreateUserDto createUserDto) {

        User user = new User(
                UUID.randomUUID(),
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.fullName()
        );

        User savedUser = userRepository.insert(user);

        return new UserDto(
                savedUser.getId(),
                savedUser.getFullNam()
        );
    }
}