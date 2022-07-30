package com.argentinaprograma.ap.services;

import com.argentinaprograma.ap.Exception.UserNotFoundException;
import com.argentinaprograma.ap.models.Usuario;
import com.argentinaprograma.ap.repository.InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {
    private final InfoRepo infoRepo;

    @Autowired
    public UsuarioService(InfoRepo infoRepo) {
        this.infoRepo = infoRepo;
    }

    public Usuario addUsuario(Usuario usuario){
        return infoRepo.save(usuario);
    }

    public List<Usuario> buscarUsuario(){
        return infoRepo.findAll();
    }

    public Usuario editarUsuario(Usuario usuario){
        return infoRepo.save(usuario);
    }

    public void borrarUsuario(Long id){
        infoRepo.deleteById((id));
    }

    public Usuario buscarUsuarioPorId(Long id){
        return infoRepo.findById(id).orElseThrow(() -> new UserNotFoundException("usuario no encontrado"));
    }
}
