package com.example.pokemonjfx.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String error){
        super(error);
    }
}
