package br.com.fiap.pipoco_motors_api.model.dto;

import br.com.fiap.pipoco_motors_api.model.UserRole;

public record UserResponse(Long id, String email, UserRole role) {}
