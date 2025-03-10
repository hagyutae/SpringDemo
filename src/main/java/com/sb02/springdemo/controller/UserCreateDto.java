package com.sb02.springdemo.controller;


// DTO: Data Transfer Object
public record UserCreateDto(
        String name
) {
}


//import java.util.Objects;
//
//public class UserCreateDto {
//    private String name;
//
//    public UserCreateDto(String name) {
//        this.name = name;
//    }
//
//    public String name() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof UserCreateDto that)) return false;
//        return Objects.equals(name, that.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(name);
//    }
//}
