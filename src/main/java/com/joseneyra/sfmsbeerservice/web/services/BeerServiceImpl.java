package com.joseneyra.sfmsbeerservice.web.services;

import com.joseneyra.sfmsbeerservice.domain.Beer;
import com.joseneyra.sfmsbeerservice.repositories.BeerRepository;
import com.joseneyra.sfmsbeerservice.web.controller.exceptions.NotFoundException;
import com.joseneyra.sfmsbeerservice.web.mappers.BeerMapper;
import com.joseneyra.sfmsbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService{

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;


    public BeerDto getBeerById(UUID beerId) {
        // This example returns null
//        if (beerRepository.findById(beerId).isPresent()) {
//            return beerMapper.beerToBeerDto(beerRepository.findById(beerId).get());
//        }
//        return null;

        // This example throws a NotFoundException, it's best practice to handle it this way
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );
    }

    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(
                beerRepository.save(beerMapper.beerDtoToBeer(beerDto))
        );
    }

    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
