package com.br.one.digitalinnovation.beerstock.service;

import com.br.one.digitalinnovation.beerstock.builder.BeerDTOBuilder;
import com.br.one.digitalinnovation.beerstock.dto.BeerDTO;
import com.br.one.digitalinnovation.beerstock.entity.Beer;
import com.br.one.digitalinnovation.beerstock.mapper.BeerMapper;
import com.br.one.digitalinnovation.beerstock.repository.BeerRepository;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BeerServiceTest {

    @Mock
    private BeerRepository beerRepository;

    private BeerMapper beerMapper = BeerMapper.INSTANCE;

    @InjectMocks
    private BeerService beerService;

    @Test
    void whenBeerInformedThenItShouldBeCreated() {
        // given
        BeerDTO expectedBeerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
        System.out.println(expectedBeerDTO.getId());
        Beer expectedSaveBeer = beerMapper.toModel(expectedBeerDTO);

        // when
        when(beerRepository.findByName(expectedBeerDTO.getName())).thenReturn(Optional.empty());
        when(beerRepository.save(expectedSaveBeer)).thenReturn(expectedSaveBeer);

        // then
        BeerDTO createdBeerDTO = beerService.createBeer(expectedBeerDTO);

        assertThat(createdBeerDTO.getId(), is(equalTo(expectedBeerDTO.getId())));
        assertThat(createdBeerDTO.getName(), is(equalTo(expectedBeerDTO.getName())));
        assertThat(createdBeerDTO.getQuantity(), is(equalTo(expectedBeerDTO.getQuantity())));
    }
}
