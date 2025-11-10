/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;
import com.example.demo.Modelo.Usuario;
import com.example.demo.Repositorio.UsuariosRepository;
import com.example.demo.dto.LoginRequestDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/*nuevas*/

import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; 
import org.springframework.security.core.AuthenticationException; 
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Laura
 */
@Service
public class UsuarioService {
	@Autowired
        private UsuariosRepository usuarioRepository;
    
        @Autowired
        private PasswordEncoder passwordEncoder;
        
        @Autowired
        private JwtService jwtService;
        @Autowired
        private AuthenticationManager authenticationManager; 
        @Autowired 
        private UserDetailsServiceImpl userDetailsService;
        
        private final String ADMIN_EMAIL = "admin@gmail.com";
        private final String ADMIN_PASSWORD = "Admin123";

   
     public Usuario guardar(Usuario usuario){
         String passHasheado=passwordEncoder.encode(usuario.getContrasena());
         usuario.setContrasena(passHasheado);
         return usuarioRepository.save(usuario);
     }
     public Optional<Usuario> findById(int id){
         return usuarioRepository.findById(id);
     }
     public List<Usuario> findAll(){
         return usuarioRepository.findAll();
     }
     public void deleteById(int id){
         usuarioRepository.deleteById(id);
     }
    public LoginResponseDTO login(LoginRequestDTO loginRequest) throws AuthenticationException { 
     authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(
                     loginRequest.getCorreoElectronico(),
                     loginRequest.getContrasena()
             ) 
     );
      UserDetails userDetails  = userDetailsService.loadUserByUsername(loginRequest.getCorreoElectronico());
          
      String token = jwtService.generateToken(userDetails);
      Usuario usuario = usuarioRepository.findByCorreoElectronico(loginRequest.getCorreoElectronico())
                        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

      String rol = usuario.getRol();
            
      return new LoginResponseDTO(token,rol);
    }
}