package com.example.laba11111.controller;

import com.example.laba11111.dto.UsersDto;
import com.example.laba11111.exception.ValidationException;
import com.example.laba11111.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor //ломбок аннотация
@Log //чтобы выводить логи
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/save")
    public UsersDto saveUsers(@RequestBody UsersDto usersDto) throws ValidationException {
        log.info("Обработка сохраненных пользователей: " + usersDto);
        return usersService.saveUser(usersDto);
    }

    @GetMapping("/findAll")
    public List<UsersDto> findAllUsers() {
        log.info("Обработка запросов \"Найти всех пользователей\"");
        return usersService.findAll();
    }

    @GetMapping("/findByLogin")
    public UsersDto findByLogin(@RequestParam String login) {
        log.info("Обработка поиска по запросу на login: " + login);
        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        log.info("Обработка запроса пользователя на удаление: " + id);
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
