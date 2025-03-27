package br.com.fiap.pipoco_motors_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.pipoco_motors_api.model.Listing;


@Repository
public interface ListingsRepository extends JpaRepository<Listing, Long> {

}
    

