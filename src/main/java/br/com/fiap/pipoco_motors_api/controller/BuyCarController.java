package br.com.fiap.pipoco_motors_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pipoco_motors_api.model.BuyCar;
import br.com.fiap.pipoco_motors_api.repository.BuyCarRepository;
import br.com.fiap.pipoco_motors_api.specification.BuyCarSpecification;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/buycars")
@Slf4j
public class BuyCarController {

    public record BuyCarFilter(String startYear, String endYear, String brand) {
    }

    @Autowired
    private BuyCarRepository repository;

    @GetMapping
    public Page<BuyCar> index(BuyCarFilter filters,
            @PageableDefault(size = 10, sort = "yearModel", direction = Direction.DESC) Pageable pageable) {
        var specification = BuyCarSpecification.withFilters(filters);
        return repository.findAll(specification, pageable);
    }
}