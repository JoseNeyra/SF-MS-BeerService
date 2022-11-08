package com.joseneyra.sfmsbeerservice.web.services;

import com.joseneyra.sfmsbeerservice.repositories.BeerRepository;
import com.joseneyra.sfmsbeerservice.web.mappers.BeerMapper;
import com.joseneyra.sfmsbeerservice.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    public BeerService(BeerRepository beerRepository, BeerMapper beerMapper) {
        this.beerRepository = beerRepository;
        this.beerMapper = beerMapper;
    }

    public BeerDto getBeerById(UUID beerId) {
        if (beerRepository.findById(beerId).isPresent()) {
            return beerMapper.BeerToBeerDto(beerRepository.findById(beerId).get());
        }
        return null;
    }

    public void saveBeer(BeerDto beerDto) {
        beerRepository.save(beerMapper.BeerDtoToBeer(beerDto));
    }

    public void updateBeerById(UUID beerId, BeerDto beerDto) {
        beerRepository.findById(beerId).ifPresent(beer -> {
            beer.setBeerName(beerDto.getBeerName());
            beer.setBeerStyle(beerDto.getBeerStyle().name());
            beer.setPrice(beerDto.getPrice());
            beer.setUpc(beerDto.getUpc());

            beerRepository.save(beer);
        });
    }
}
