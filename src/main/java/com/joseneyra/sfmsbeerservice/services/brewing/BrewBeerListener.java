package com.joseneyra.sfmsbeerservice.services.brewing;

import com.joseneyra.brewery.model.events.BrewBeerEvent;
import com.joseneyra.brewery.model.events.NewInventoryEvent;
import com.joseneyra.sfmsbeerservice.config.JmsConfig;
import com.joseneyra.sfmsbeerservice.domain.Beer;
import com.joseneyra.sfmsbeerservice.repositories.BeerRepository;
import com.joseneyra.brewery.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)     // Allows us to listen to messages
    public void listen(BrewBeerEvent event) {                       // The BrewBeerEvent passes the BeerDto
        BeerDto beerDto = event.getBeerDto();

        Beer beer = beerRepository.getOne(beerDto.getId());

        beerDto.setQuantityOnHand(beer.getQuantityToBrew());        // Make more beer and then send an event that the beer quantity has been updated

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);       // Create and send a new event

        log.debug("Brewed beer " + beer.getMinOnHand() + " : QOH: " + beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }
}
