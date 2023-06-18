package com.joseneyra.sfmsbeerservice.services.inventory;

import com.joseneyra.brewery.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


// This class is only being used when the InventoryServiceFeignClient Interface has failed to reach the service
// This behavior is setup in the InventoryServiceFeignClient Interface in the "fallback" section
@Slf4j
@RequiredArgsConstructor
@Service
public class InventoryServiceFeignClientFailover implements InventoryServiceFeignClient{

    private final InventoryFailoverFeignClient inventoryFailoverFeignClient;

    @Override
    public ResponseEntity<List<BeerInventoryDto>> getOnHandInventory(UUID beerId) {
        return inventoryFailoverFeignClient.getOnHandInventory();
    }
}
