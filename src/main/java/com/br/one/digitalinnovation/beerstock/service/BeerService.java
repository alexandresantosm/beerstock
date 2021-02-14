package com.br.one.digitalinnovation.beerstock.service;

import com.br.one.digitalinnovation.beerstock.dto.BeerDTO;
import com.br.one.digitalinnovation.beerstock.entity.Beer;
import com.br.one.digitalinnovation.beerstock.exception.BeerAlreadyRegisteredException;
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

    public BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
        verifyIfIsAlreadyRegistered(beerDTO.getName());

        Beer beer = beerMapper.toModel(beerDTO);
        Beer savedBeer = beerRepository.save(beer);

        return beerMapper.toDTO(savedBeer);
    }

    private void verifyIfIsAlreadyRegistered(String name) throws BeerAlreadyRegisteredException {
        Optional<Beer> optSavedBeer = beerRepository.findByName(name);

        if (optSavedBeer.isPresent()) {
            throw new BeerAlreadyRegisteredException(name);
        }
    }
}
