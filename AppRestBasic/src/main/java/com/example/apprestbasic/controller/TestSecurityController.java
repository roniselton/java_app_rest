package com.example.apprestbasic.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TestSecurityController {

    @GetMapping("/todos")
    @PreAuthorize("hasAnyRole('MANAGERS','USERS')")
    public String acessoTodos(){
        return "Todos";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('MANAGERS')")
    public String acessoAdmin(){
        return "Admin";
    }

    @GetMapping("/usuario")
    @PreAuthorize("hasAnyRole('USERS')")
    public String acessoUsuario(){
        return "Usuario";
    }


}
