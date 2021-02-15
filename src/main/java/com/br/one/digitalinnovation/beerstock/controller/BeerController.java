package com.br.one.digitalinnovation.beerstock.controller;

import com.br.one.digitalinnovation.beerstock.dto.BeerDTO;
import com.br.one.digitalinnovation.beerstock.exception.BeerAlreadyRegisteredException;
import com.br.one.digitalinnovation.beerstock.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerController implements BeerControllerDocs {

    private final BeerService beerService;

    @Override
    public BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
        return null;
    }
}
