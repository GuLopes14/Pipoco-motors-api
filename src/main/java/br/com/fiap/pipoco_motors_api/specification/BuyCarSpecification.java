package br.com.fiap.pipoco_motors_api.specification;

import br.com.fiap.pipoco_motors_api.controller.BuyCarController.BuyCarFilter;
import br.com.fiap.pipoco_motors_api.model.BuyCar;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class BuyCarSpecification {

    public static Specification<BuyCar> withFilters(BuyCarFilter filters) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filtro por ano inicial
            if (filters.startYear() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("yearModel"), filters.startYear()));
            }

            // Filtro por ano final
            if (filters.endYear() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("yearModel"), filters.endYear()));
            }

            // Filtro por marca
            if (filters.brand() != null && !filters.brand().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("brand")), "%" + filters.brand().toLowerCase() + "%"));
            }

            
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}