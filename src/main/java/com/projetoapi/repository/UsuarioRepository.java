package com.projetoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoapi.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
