package com.br.one.digitalinnovation.beerstock.controller;

import com.br.one.digitalinnovation.beerstock.dto.BeerDTO;
import com.br.one.digitalinnovation.beerstock.exception.BeerAlreadyRegisteredException;
import com.br.one.digitalinnovation.beerstock.exception.BeerNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

@Api("Manages beer stock")
public interface BeerControllerDocs {

    @ApiOperation(value = "Beer creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success beer creation."),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException;

    @ApiOperation(value = "Returns beer found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success beer found in the system."),
            @ApiResponse(code = 404, message = "Beer with given name not found in the system.")
    })
    BeerDTO findByName(@PathVariable String name) throws BeerNotFoundException;
}
