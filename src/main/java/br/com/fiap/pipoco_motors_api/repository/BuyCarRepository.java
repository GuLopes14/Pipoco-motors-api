package br.com.fiap.pipoco_motors_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.fiap.pipoco_motors_api.model.BuyCar;


public interface BuyCarRepository extends JpaRepository<BuyCar, Long>, JpaSpecificationExecutor<BuyCar> {
    // Custom query methods can be defined here if needed
    
}
