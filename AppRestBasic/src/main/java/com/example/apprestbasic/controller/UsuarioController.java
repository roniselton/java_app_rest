package com.example.apprestbasic.controller;

import com.example.apprestbasic.excecoes.BusinessException;
import com.example.apprestbasic.entity.Usuario;
import com.example.apprestbasic.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{idUsuario}")
    public Usuario detalharUsuario(@PathVariable("idUsuario") Integer idUsuario){
        return usuarioService.consultarPorID(idUsuario).orElse( null );
    }

    @DeleteMapping("/{idUsuario}")
    public void excluirUsuario(@PathVariable("idUsuario") Integer idUsuario){
        usuarioService.excluir(idUsuario) ;
    }

    @PostMapping()
    public void incluirUsuario(@RequestBody Usuario usuario){
        try {
            usuarioService.salvar(usuario);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

    @PutMapping()
    public void alterarUsuario(@RequestBody Usuario usuario){
        try {
            usuarioService.alterar(usuario);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

}
