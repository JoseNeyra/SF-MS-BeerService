package com.joseneyra.sfmsbeerservice.web.mappers;

import com.joseneyra.sfmsbeerservice.domain.Beer;
import com.joseneyra.sfmsbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
