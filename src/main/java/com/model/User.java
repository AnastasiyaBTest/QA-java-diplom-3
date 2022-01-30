package com.model;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class User {

    private String email;
    private String password;
    private String name;

    public User(String name, String password, String email){
        this.name = name;
        this.password = password;
        this.email = email;
    }
    public User(){}


    static Faker faker = new Faker();

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public static User getRandom(){

        final String name = faker.name().firstName();
        final String password = faker.internet().password();
        final String email = faker.internet().emailAddress();
        return new User(name, password, email);
    }

}
