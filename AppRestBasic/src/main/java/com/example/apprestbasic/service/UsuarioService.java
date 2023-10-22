package com.example.apprestbasic.service;

import com.example.apprestbasic.excecoes.BusinessException;
import com.example.apprestbasic.entity.Usuario;
import com.example.apprestbasic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void salvar(Usuario usuario) throws BusinessException {
        validarDadosIncluirUsuario(usuario);
        usuarioRepository.save(usuario);
    }

    private void validarDadosIncluirUsuario(Usuario usuario) throws BusinessException {
        if(usuario == null)
            throw new BusinessException("Dados Inválidos");

        if( usuario.getNome() == null || usuario.getNome().isEmpty())
            throw new BusinessException("Dados Inválidos");
    }

    public void alterar(Usuario usuario) throws BusinessException {
        validarDadosAlterarUsuario(usuario);
        usuarioRepository.save(usuario);
    }

    private void validarDadosAlterarUsuario(Usuario usuario) throws BusinessException {
        if(usuario == null || usuario.getId() == null)
            throw new BusinessException("Dados Inválidos");
        validarDadosIncluirUsuario(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll(Sort.by("nome"));
    }

    public Optional<Usuario> consultarPorID(Integer id){
        return usuarioRepository.findById( id );
    }


    public void excluir(Integer idUsuario) {
        validarExclusaoUsuario();
        usuarioRepository.deleteById( idUsuario );
    }

    private void validarExclusaoUsuario() {
    }
}
