package com.joseneyra.sfmsbeerservice.bootstrap;

import com.joseneyra.sfmsbeerservice.domain.Beer;
import com.joseneyra.sfmsbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

// No longer need this class because were initializing the data using the data.sql file in resources
// and also setting the  spring.datasource.initialization-mode property to EMBEDDED in the properties file.
//@Component
@RequiredArgsConstructor
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234200019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;


    @Override
    public void run(String... args) throws Exception {

        if (beerRepository.count() == 0) {
            loadBeerObjects();
        }
    }

    private void loadBeerObjects() {

        beerRepository.save(Beer.builder()
                  .beerName("Mango Bobs")
                  .beerStyle("IPA")
                  .quantityToBrew(200)
                  .minOnHand(12)
                  .upc(BEER_1_UPC)
                  .price(new BigDecimal("12.95"))
                  .build());

        beerRepository.save(Beer.builder()
                  .beerName("Galaxy Cat")
                  .beerStyle("PALE_ALE")
                  .quantityToBrew(200)
                  .minOnHand(12)
                  .upc(BEER_2_UPC)
                  .price(new BigDecimal("11.95"))
                  .build());

        beerRepository.save(Beer.builder()
                  .beerName("No Hammers On The Bar")
                  .beerStyle("PALE_ALE")
                  .quantityToBrew(200)
                  .minOnHand(12)
                  .upc(BEER_3_UPC)
                  .price(new BigDecimal("11.95"))
                  .build());
    }
}
