package istad.com.restapi.dto;

public record CreateUserDto(
        String fullName,
        String password,
        String username
) {
}
