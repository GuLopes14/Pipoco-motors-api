package br.com.fiap.pipoco_motors_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.pipoco_motors_api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String username);
    
}
