package com.example.demo.Repositorio;
import com.example.demo.Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository< Usuario, Integer> { 
		
	Optional<Usuario> findBycorreoElectronico(String correoElectronico);

    // ✅ Validar credenciales (Spring genera query: WHERE email=? AND contrasena=?)
    Optional<Usuario> findBycorreoElectronicoAndContrasena(String correoElectronico, String contrasena);

    // ✅ Buscar por nombre (como filtro, sin distinguir mayúsculas)
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
	    
} 


