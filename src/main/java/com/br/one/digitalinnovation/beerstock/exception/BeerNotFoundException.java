package com.br.one.digitalinnovation.beerstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeerNotFoundException extends Exception {

    public BeerNotFoundException(String beerName) {
        super(String.format("Beer with name %s not found in the system.", beerName));
    }

    public BeerNotFoundException(Long beerId) {
        super(String.format("Beer with ID %s not found in the system.", beerId));
    }
}
