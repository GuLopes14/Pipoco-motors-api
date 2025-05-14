package br.com.fiap.pipoco_motors_api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.fiap.pipoco_motors_api.model.BuyCar;
import br.com.fiap.pipoco_motors_api.model.Listing;
import br.com.fiap.pipoco_motors_api.model.User;
import br.com.fiap.pipoco_motors_api.model.UserRole;
import br.com.fiap.pipoco_motors_api.repository.BuyCarRepository;
import br.com.fiap.pipoco_motors_api.repository.ListingsRepository;
import br.com.fiap.pipoco_motors_api.repository.UserRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DataBaseSeeder {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    @Autowired
    private ListingsRepository listingsRepository;

    @Autowired
    private BuyCarRepository buyCarRepository;

    DataBaseSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

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
                .build(),
            Listing.builder()
            .brand("Honda")
                .model("Civic")
                .plate("DEF3456")
                .yearModel("2020")
                .color("Azul")
                .price(90000.0)
                .fipePrice(85000.0)
                .description("Carro com motor turbo e interior em couro.")
                .quilometers(15000.0)
                .build(),
            Listing.builder()
                .brand("Toyota")
                .model("Corolla")
                .plate("GHI7890")
                .yearModel("2021")
                .color("Cinza")
                .price(95000.0)
                .fipePrice(90000.0)
                .description("Carro com sistema de entretenimento e assistente de estacionamento.")
                .quilometers(10000.0)
                .build(),
            Listing.builder()
                .brand("Ford")
                .model("Fiesta")
                .plate("JKL2345")
                .yearModel("2016")
                .color("Vermelho")
                .price(35000.0)
                .fipePrice(33000.0)
                .description("Carro compacto com bom consumo de combustível.")
                .quilometers(40000.0)
                .build(),
            Listing.builder()
                .brand("Hyundai")
                .model("HB20")
                .plate("MNO6789")
                .yearModel("2019")
                .color("Verde")
                .price(42000.0)
                .fipePrice(40000.0)
                .description("Carro com design moderno e tecnologia avançada.")
                .quilometers(20000.0)
                .build(),
            Listing.builder()
                .brand("Nissan")
                .model("Kicks")
                .plate("PQR1234")
                .yearModel("2022")
                .color("Amarelo")
                .price(110000.0)
                .fipePrice(105000.0)
                .description("SUV com amplo espaço interno e conectividade.")
                .quilometers(5000.0)
                .build(),
            Listing.builder()
                .brand("Jeep")
                .model("Compass")
                .plate("STU5678")
                .yearModel("2023")
                .color("Marrom")
                .price(150000.0)
                .fipePrice(145000.0)
                .description("SUV com tração 4x4 e tecnologia de ponta.")
                .quilometers(0.0)
                .build()
        );
        listingsRepository.saveAll(listings);

        var buyCar = new ArrayList<BuyCar>();
        for (Listing listing : listings) {
            buyCar.add(BuyCar.builder()
                .brand(listing.getBrand())
                .model(listing.getModel())
                .yearModel(listing.getYearModel())
                .price(listing.getPrice())
                .description(listing.getDescription())
                .build()
            );
        }

        buyCarRepository.saveAll(buyCar);
        
        userRepository.saveAll(List.of(
            User.builder()
                .email("gustavo@gmail.com")
                .password(passwordEncoder.encode("12345"))
                .role(UserRole.ADMIN)
                .build(),
            User.builder()
                .email("renato@gmail.com")
                .password(passwordEncoder.encode("12345"))
                .role(UserRole.USER)
                .build()
        ));
    }
}
