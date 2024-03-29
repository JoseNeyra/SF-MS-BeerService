package com.joseneyra.sfmsbeerservice.services.inventory;

import com.joseneyra.brewery.model.BeerInventoryDto;
import com.joseneyra.sfmsbeerservice.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient(
        name = "inventory-service",
        fallback = InventoryServiceFeignClientFailover.class,
        configuration = FeignClientConfig.class)        // Bring in the authentication for the server
public interface InventoryServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = BeerInventoryServiceRestTemplateImpl.INVENTORY_PATH)
    ResponseEntity<List<BeerInventoryDto>> getOnHandInventory(@PathVariable UUID beerId);
}
