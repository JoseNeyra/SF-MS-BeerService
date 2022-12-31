package com.joseneyra.sfmsbeerservice.services.inventory;

import java.util.UUID;

public interface BeerInventoryService {

    Integer getOnHandInventory(UUID beerId);
}
