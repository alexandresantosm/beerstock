package com.br.one.digitalinnovation.beerstock.service;

import com.br.one.digitalinnovation.beerstock.dto.BeerDTO;
import com.br.one.digitalinnovation.beerstock.entity.Beer;
import com.br.one.digitalinnovation.beerstock.enums.BeerType;
import com.br.one.digitalinnovation.beerstock.mapper.BeerMapper;
import com.br.one.digitalinnovation.beerstock.repository.BeerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper = BeerMapper.INSTANCE;

    public BeerDTO createBeer(BeerDTO beerDTO) {
        Beer beer = new Beer();
        beer.setId(1L);
        beer.setName("Brahma");
        beer.setBrand("Ambev");
        beer.setMax(50);
        beer.setQuantity(10);
        beer.setType(BeerType.LAGER);

        Optional<Beer> beerEmpty = beerRepository.findByName(beer.getName());

        Beer savedBeer = beerRepository.save(beer);

        return beerMapper.toDTO(savedBeer);
    }
}
