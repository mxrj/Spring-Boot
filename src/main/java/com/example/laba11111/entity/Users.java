package com.example.laba11111.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users_table") //устанавливает название таблицы в базе данных
@Data //ломбок аннотация: генерирует геттеры, сеттеры
@NoArgsConstructor //ломбок аннотация: конструктор без аргуметов
public class Users {

    @Id //указывает на то что данное поле является ID в таблице
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column //колонки в таблице
    private String name;

    @Column
    private String login;

    @Column
    private String email;
}
