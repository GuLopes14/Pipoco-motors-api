package br.com.fiap.pipoco_motors_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Listing {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String name;
    private String plate;
    private String yearModel;
    private String color;
    private Double price;
}
