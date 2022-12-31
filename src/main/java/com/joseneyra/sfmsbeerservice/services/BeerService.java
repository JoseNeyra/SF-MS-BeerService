package com.joseneyra.sfmsbeerservice.services;

import com.joseneyra.sfmsbeerservice.web.model.BeerDto;
import com.joseneyra.sfmsbeerservice.web.model.BeerPagedList;
import com.joseneyra.sfmsbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {

    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto getByUpc(String upc);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);
}
