package br.com.fiap.pipoco_motors_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A marca é obrigatória")
    @Size(min = 2, max = 50, message = "A marca deve ter entre 2 e 50 caracteres")
    private String brand;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String model;

    @NotBlank(message = "A placa é obrigatória")
    @Size(min = 7, max = 7, message = "A placa deve ter exatamente 7 caracteres")
    private String plate;

    @NotBlank(message = "O ano de fabricação é obrigatório")
    @Size(min = 4, max = 4, message = "O ano de fabricação deve ter exatamente 4 dígitos")
    private String yearModel;

    @NotBlank(message = "A cor é obrigatória")
    @Size(min = 3, max = 30, message = "A cor deve ter entre 3 e 30 caracteres")
    private String color;

    @NotNull(message = "O preço é obrigatório")
    @Min(value = 0, message = "O preço deve ser maior ou igual a zero")
    private Double price;

    @NotNull(message = "O preço de FIPE é obrigatório")
    @Min(value = 0, message = "O preço deve ser maior ou igual a zero")
    private Double fipePrice;

    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
    private String description;

    @NotNull(message = "A quilometragem é obrigatória")
    @Min(value = 0, message = "A quilometragem deve ser maior ou igual a zero")
    private Double quilometers;
}