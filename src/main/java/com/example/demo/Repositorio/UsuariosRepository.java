package com.example.demo.Repositorio;
import com.example.demo.Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository< Usuario, Integer> { 
		
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);    
} 


