package com.example.apprestbasic.config;

import com.example.apprestbasic.entity.Usuario;
import com.example.apprestbasic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class SecurityDatabaseService implements UserDetailsService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        Stream.of(usuario.getRole()).forEach(role ->
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()))
        );
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(usuario.getLogin(),
                usuario.getSenha(),
                authorities);
        return userDetails;
    }
}
