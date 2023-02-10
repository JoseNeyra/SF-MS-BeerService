package com.joseneyra.sfmsbeerservice.services.orders;

import com.joseneyra.brewery.model.events.ValidateBeerOrderRequest;
import com.joseneyra.brewery.model.events.ValidateOrderResult;
import com.joseneyra.sfmsbeerservice.config.JmsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BeerOrderValidationListener {

    private final BeerOrderValidator validator;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listen(ValidateBeerOrderRequest validateBeerOrderRequest) {

        Boolean isValid = validator.validateOrder(validateBeerOrderRequest.getBeerOrderDto());

        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE,
                ValidateOrderResult.builder()
                        .isValid(isValid)
                        .orderId(validateBeerOrderRequest.getBeerOrderDto().getId())
                        .build());
    }
}
