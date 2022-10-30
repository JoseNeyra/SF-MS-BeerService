package com.joseneyra.sfmsbeerservice.repositories;

import com.joseneyra.sfmsbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {


}
