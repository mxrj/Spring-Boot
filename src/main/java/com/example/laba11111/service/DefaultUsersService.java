package com.example.laba11111.service;

import com.example.laba11111.dto.UsersDto;
import com.example.laba11111.entity.Users;
import com.example.laba11111.exception.ValidationException;
import com.example.laba11111.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor //для инициализации UserRepository и UsersConverter
public class DefaultUsersService implements UsersService{

    private final UserRepository userRepository;
    private final UsersConverter usersConverter;

    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Логин имеет значение null!");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Логин пуст!");
        }
    }

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        Users savedUser = userRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {
        Users users = userRepository.findByLogin(login);
        if (users != null) {
            return usersConverter.fromUserToUserDto(users);
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return userRepository.findAll()
                             .stream()
                             .map(usersConverter::fromUserToUserDto)
                             .collect(Collectors.toList());
    }
}
