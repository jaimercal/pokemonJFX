package com.example.pokemonjfx.exceptions;

public class PokemonNotFoundException extends Exception{
    public PokemonNotFoundException(String error){
        super(error);
    }
}
