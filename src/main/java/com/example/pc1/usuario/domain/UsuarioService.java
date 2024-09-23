package com.example.pc1.usuario.domain;


import com.example.pc1.usuario.dtos.UserRequestDto;
import com.example.pc1.usuario.dtos.UserResponseDto;
import com.example.pc1.usuario.infraestructure.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ModelMapper modelMapper;

    public void registroUsuario(Usuario user){
        usuarioRepository.save(user);
    }

    public Usuario buscarUsuario(UserRequestDto userRequestDto){


        Usuario usuario1 = usuarioRepository.findUsuarioByUsername(userRequestDto.getUsername());
        Usuario usuario2 = usuarioRepository.findUsuarioByPassword(userRequestDto.getPassword());
        if(usuario1 == null || usuario2 == null){
            throw new RuntimeException("Error 404");
        }
        if(usuario1.getPassword().equals(usuario2.getPassword())){
            return usuario1;
        }
        return null;
    }



}
