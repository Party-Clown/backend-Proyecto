/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;
import com.example.demo.Modelo.Usuario;
import com.example.demo.Repositorio.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author Laura
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuariosRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correoElectronico) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreoElectronico(correoElectronico) .orElseThrow(() -> new 
        UsernameNotFoundException("Usuario no encontrado con email: " + correoElectronico));
        
        List<SimpleGrantedAuthority> authorities =
                List.of(new SimpleGrantedAuthority(usuario.getRol())); 
        return new User(
                usuario.getCorreoElectronico(),
                usuario.getContrasena(),
                authorities
        );
             }
        
    }
    
    

