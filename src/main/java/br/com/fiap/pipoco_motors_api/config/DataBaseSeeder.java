package br.com.fiap.pipoco_motors_api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.pipoco_motors_api.model.Listing;
import br.com.fiap.pipoco_motors_api.repository.ListingsRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DataBaseSeeder {
    @Autowired
    private ListingsRepository listingsRepository;

    @PostConstruct
    public void init() {
        var listings = List.of(
            Listing.builder()
                .brand("Fiat")
                .model("Palio")
                .plate("ABC1234")
                .yearModel("2010")
                .color("Prata")
                .price(20000.0)
                .fipePrice(18000.0)
                .description("Carro em bom estado, com ar-condicionado e direção hidráulica.")
                .quilometers(80000.0)
                .build(),
            Listing.builder()
                .brand("Volkswagen")
                .model("Gol")
                .plate("XYZ5678")
                .yearModel("2015")
                .color("Preto")
                .price(30000.0)
                .fipePrice(28000.0)
                .description("Carro com baixa quilometragem e manual completo.")
                .quilometers(50000.0)
                .build(),
            Listing.builder()
                .brand("Chevrolet")
                .model("Onix")
                .plate("LMN9012")
                .yearModel("2018")
                .color("Branco")
                .price(45000.0)
                .fipePrice(42000.0)
                .description("Carro com garantia de fábrica e revisões em dia.")
                .quilometers(30000.0)
                .build()
        );
        listingsRepository.saveAll(listings);

        
    }
}
