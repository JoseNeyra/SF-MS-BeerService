package com.joseneyra.sfmsbeerservice.web.mappers;

import com.joseneyra.sfmsbeerservice.domain.Beer;
import com.joseneyra.brewery.model.BeerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    @Mapping(target = "quantityOnHand", ignore = true)
    BeerDto beerToBeerDto (Beer beer);

    @Mapping(target = "quantityOnHand", source = "")
    BeerDto beerToBeerDtoWithInventory(Beer beer);

    @Mapping(target = "quantityToBrew", source = "")
    @Mapping(target = "minOnHand", source = "")
    @Mapping(target = "version", ignore = true)             // Use this when you want to ignore a specific property from being mapped
    Beer beerDtoToBeer (BeerDto dto);                       // In this case the version property of Beer doesnt get mapped to the BeerDto
}
