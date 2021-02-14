package com.br.one.digitalinnovation.beerstock.service;

import com.br.one.digitalinnovation.beerstock.mapper.BeerMapper;
import com.br.one.digitalinnovation.beerstock.repository.BeerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper = BeerMapper.INSTANCE;
}
